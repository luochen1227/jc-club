package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson2.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.domain.entity.AnswerBo;
import com.jingdianjichi.auth.domain.entity.InfoBo;
import com.jingdianjichi.auth.domain.service.InfoDomainService;
import com.jingdianjichi.subject.application.convert.AnswerDtoConvert;
import com.jingdianjichi.subject.application.convert.InfoDtoConvert;
import com.jingdianjichi.subject.application.dto.InfoDto;
import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 坤
 * @description刷题controller
 * @date 2024/3/28 16:48
 */

@RestController
@Slf4j
@RequestMapping("/subject")
public class SubjectController {

    @Resource
    private InfoDomainService infoDomainService;

    @PostMapping("/add")
    public Result<Boolean> addInfo(@RequestBody InfoDto infoDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.addInfo.dto:{}", JSON.toJSONString(infoDto));
            }
            Preconditions.checkNotNull(infoDto.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(infoDto.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(infoDto.getSubjectName()), "题目名字不能为空");
            Preconditions.checkNotNull(infoDto.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(infoDto.getCategoryIds()), "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(infoDto.getLabelIds()), "标签id不能为空");
//            CategoryBo categoryBo = CategoryDtoConvert.INSTANCE.convertDtoToCategoryBo(categoryDto);
            InfoBo infoBo = InfoDtoConvert.INSTANCE.convertDtoToInfoBo(infoDto);
            List<AnswerBo> answerBos = AnswerDtoConvert.INSTANCE.convertDtoToAnswerBoList(infoDto.getOptionList());
            infoBo.setOptionList(answerBos);
            infoDomainService.addInfo(infoBo);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("CategoryController.add.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/getSubjectPage")
    public Result<PageResult<InfoDto>> getSubjectPage(@RequestBody InfoDto infoDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.getSubjectPage.dto:{}", JSON.toJSONString(infoDto));
            }
            Preconditions.checkNotNull(infoDto.getCategoryId(), "分类id不能为空");
            Preconditions.checkNotNull(infoDto.getLabelId(), "标签id不能为空");
            InfoBo infoBo = InfoDtoConvert.INSTANCE.convertDtoToInfoBo(infoDto);
            PageResult<InfoBo> infoBoPageResult =  infoDomainService.getSubjectPage(infoBo);
            return Result.ok(infoBoPageResult);
        }catch (Exception e){
            log.error("CategoryController.getSubjectPage.err:{}", e.getMessage());
            return Result.fail("false");
        }

    }

    @PostMapping("/querySubjectInfo")
    public Result<InfoDto> querySubjectInfo(@RequestBody InfoDto infoDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.querySubjectInfo.dto:{}", JSON.toJSONString(infoDto));
            }
            Preconditions.checkNotNull(infoDto.getId(), "题目id不能为空");
            InfoBo infoBo = InfoDtoConvert.INSTANCE.convertDtoToInfoBo(infoDto);
            InfoBo infoBo1 =  infoDomainService.querySubjectInfo(infoBo);
            InfoDto infoDto1 = InfoDtoConvert.INSTANCE.convertBoToInfoDto(infoBo1);
            return Result.ok(infoDto1);
        }catch (Exception e){
            log.error("CategoryController.querySubjectInfo.err:{}", e.getMessage());
            return Result.fail("false");
        }
    }
//    @PostMapping("/getContributeList")
//    public Result<InfoDto> getContributeList(@RequestBody InfoDto infoDto) {
//        try {
//            if (log.isInfoEnabled()) {
//                log.info("SubjectController.querySubjectInfo.dto:{}", JSON.toJSONString(infoDto));
//            }
//            Preconditions.checkNotNull(infoDto.getId(), "题目id不能为空");
//            InfoBo infoBo = InfoDtoConvert.INSTANCE.convertDtoToInfoBo(infoDto);
//            InfoBo infoBo1 =  infoDomainService.querySubjectInfo(infoBo);
//            InfoDto infoDto1 = InfoDtoConvert.INSTANCE.convertBoToInfoDto(infoBo1);
//            return Result.ok(infoDto1);
//        }catch (Exception e){
//            log.error("CategoryController.querySubjectInfo.err:{}", e.getMessage());
//            return Result.fail("false");
//        }
//    }
//    @PostMapping("/category/queryPrimaryCategory")
//    public Result<InfoDto> queryPrimaryCategory(@RequestBody InfoDto infoDto) {
//        try {
//            if (log.isInfoEnabled()) {
//                log.info("SubjectController.querySubjectInfo.dto:{}", JSON.toJSONString(infoDto));
//            }
//            Preconditions.checkNotNull(infoDto.getId(), "题目id不能为空");
//            InfoBo infoBo = InfoDtoConvert.INSTANCE.convertDtoToInfoBo(infoDto);
//            InfoBo infoBo1 =  infoDomainService.querySubjectInfo(infoBo);
//            InfoDto infoDto1 = InfoDtoConvert.INSTANCE.convertBoToInfoDto(infoBo1);
//            return Result.ok(infoDto1);
//        }catch (Exception e){
//            log.error("CategoryController.querySubjectInfo.err:{}", e.getMessage());
//            return Result.fail("false");
//        }
//    }
}
