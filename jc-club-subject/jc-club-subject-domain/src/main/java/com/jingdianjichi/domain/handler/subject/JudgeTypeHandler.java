package com.jingdianjichi.domain.handler.subject;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jingdianjichi.domain.convert.JudgeConvert;
import com.jingdianjichi.domain.entity.AnswerBo;
import com.jingdianjichi.domain.entity.InfoBo;
import com.jingdianjichi.domain.entity.JudgeBo;
import com.jingdianjichi.domain.entity.SubjectOptionBo;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.infa.basic.entity.Judge;
import com.jingdianjichi.subject.infa.basic.mapper.JudgeMapper;
import com.jingdianjichi.subject.infa.basic.service.IJudgeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 判断题目的策略类
 *
 * @author: ChickenWing
 * @date: 2023/10/5
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler {

    @Resource
    private JudgeMapper judgeMapper;
    @Resource
    private IJudgeService iJudgeService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(InfoBo infoBo) {
        //判断题目的插入
        Judge judge = new Judge();
        AnswerBo answerBo = infoBo.getOptionList().get(0);
        judge.setSubjectId(infoBo.getId());
        judge.setIsCorrect(answerBo.getIsCorrect());
        judge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        judgeMapper.insert(judge);
    }

    @Override
    public SubjectOptionBo query(int subjectId) {
        LambdaQueryWrapper<Judge> judgeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        judgeLambdaQueryWrapper.eq(Judge::getSubjectId,subjectId);
        List<Judge> judges = judgeMapper.selectList(judgeLambdaQueryWrapper);
        List<AnswerBo> answerBoList = JudgeConvert.INSTANCE.convertEntityToBoList(judges);
        SubjectOptionBo subjectOptionBO = new SubjectOptionBo();
        subjectOptionBO.setOptionList(answerBoList);
        return subjectOptionBO;
    }

}
