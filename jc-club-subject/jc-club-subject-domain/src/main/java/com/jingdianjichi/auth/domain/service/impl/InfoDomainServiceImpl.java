package com.jingdianjichi.auth.domain.service.impl;

import com.alibaba.fastjson2.JSON;
import com.jingdianjichi.auth.domain.convert.InfoConvert;
import com.jingdianjichi.auth.domain.entity.InfoBo;
import com.jingdianjichi.auth.domain.entity.SubjectOptionBo;
import com.jingdianjichi.auth.domain.handler.subject.SubjectTypeHandler;
import com.jingdianjichi.auth.domain.handler.subject.SubjectTypeHandlerFactory;
import com.jingdianjichi.auth.domain.service.InfoDomainService;
import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.infa.basic.entity.Info;
import com.jingdianjichi.subject.infa.basic.entity.Label;
import com.jingdianjichi.subject.infa.basic.entity.Mapping;
import com.jingdianjichi.subject.infa.basic.mapper.InfoMapper;
import com.jingdianjichi.subject.infa.basic.mapper.LabelMapper;
import com.jingdianjichi.subject.infa.basic.service.IInfoService;
import com.jingdianjichi.subject.infa.basic.service.ILabelService;
import com.jingdianjichi.subject.infa.basic.service.IMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InfoDomainServiceImpl implements InfoDomainService {
    @Resource
    private InfoMapper infoMapper;
    @Resource
    private IInfoService iInfoService;
    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;
    @Resource
    private IMappingService iMappingService;
    @Resource
    private ILabelService labelService;
    @Resource
    private LabelMapper labelMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addInfo(InfoBo infoBo) {
        if (log.isInfoEnabled()) {
            log.info("InfoDomainServiceImpl.addInfo.bo:{}", JSON.toJSONString(infoBo));
        }
        Info info = InfoConvert.INSTANCE.convertBoToInfo(infoBo);
        int insert = infoMapper.insert(info);
        Long id = info.getId();
        infoBo.setId(id);
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(info.getSubjectType());
        handler.add(infoBo);
        List<Integer> categoryIds = infoBo.getCategoryIds();
        List<Integer> labelIds = infoBo.getLabelIds();
        LinkedList<Mapping> mappings = new LinkedList<>();
        categoryIds.forEach(categoryId->{
            labelIds.forEach(labelId->{
                Mapping mapping = new Mapping();
                mapping.setSubjectId(info.getId());
                mapping.setCategoryId(Long.valueOf(categoryId));
                mapping.setLabelId(Long.valueOf(labelId));
                mappings.add(mapping);
            });
        });
        iMappingService.saveBatch(mappings);

    }

    @Override
    public PageResult<InfoBo> getSubjectPage(InfoBo infoBo) {
        PageResult<InfoBo> pageResult = new PageResult<>();
        pageResult.setPageNo(infoBo.getPageNo());
        pageResult.setPageSize(infoBo.getPageSize());
        int start =(infoBo.getPageNo()-1)*infoBo.getPageSize();
        Info info = InfoConvert.INSTANCE.convertBoToInfo(infoBo);
        int count = iInfoService.countByCondition(info,infoBo.getCategoryId(),infoBo.getLabelId());
        if (count == 0){
            return pageResult;
        }
        List<Info> infoList = iInfoService.queryPage(info,infoBo.getCategoryId(),infoBo.getLabelId(),start,infoBo.getPageSize());
        List<InfoBo> infoBos = InfoConvert.INSTANCE.convertEntityToBo(infoList);
        pageResult.setRecords(infoBos);
        pageResult.setTotal(count);
        return pageResult;
    }

    @Override
    public InfoBo querySubjectInfo(InfoBo infoBo) {
        Info info = iInfoService.getById(infoBo.getId());
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(info.getSubjectType());
        SubjectOptionBo optionBo = handler.query(info.getId().intValue());
        InfoBo infoBo1 = InfoConvert.INSTANCE.convertOptionAndInfoToBo(optionBo,info);
        Mapping subjectMapping = new Mapping();
        subjectMapping.setSubjectId(info.getId());
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        List<Mapping> mappingList = iMappingService.queryLabelId(subjectMapping);
        List<Long> labelIdList = mappingList.stream().map(Mapping::getLabelId).collect(Collectors.toList());
        List<Label> labelList = labelMapper.selectBatchIds(labelIdList);
        List<String> labelNameList = labelList.stream().map(Label::getLabelName).collect(Collectors.toList());
        infoBo1.setLabelName(labelNameList);
//        infoBo1.setLiked(subjectLikedDomainService.isLiked(subjectInfoBO.getId().toString(), LoginUtil.getLoginId()));
//        infoBo1.setLikedCount(subjectLikedDomainService.getLikedCount(subjectInfoBO.getId().toString()));
//        assembleSubjectCursor(subjectInfoBO, bo);
//        return bo;
//        List<String> labelNameList = new ArrayList<>();
//        //转换
//        infoBo1.setLabelName(labelNameList);
        return infoBo1;
    }
}
