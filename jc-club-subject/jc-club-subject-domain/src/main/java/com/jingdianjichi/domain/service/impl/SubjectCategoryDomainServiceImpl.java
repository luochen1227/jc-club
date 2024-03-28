package com.jingdianjichi.domain.service.impl;

import com.jingdianjichi.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.subject.infa.basic.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {
    @Resource
    private ICategoryService categoryService;
}
