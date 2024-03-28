package com.jingdianjichi.subject.application.controller;

import com.jingdianjichi.subject.infa.basic.entity.Category;
import com.jingdianjichi.subject.infa.basic.service.ICategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description刷题controller
 * @date 2024/3/28 16:48
 * @author 坤
 */

@RestController
public class SubjectController {
    @Resource
    private ICategoryService categoryService;
    @RequestMapping("/test")
    public List test(){
        List<Category> list = categoryService.list();
        return list;
    }
}
