package com.example.demo.service;

import com.example.demo.bean.model.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface CourseService extends IService<Course> {


    List<Course> listCourse();

    void addCourse();
}
