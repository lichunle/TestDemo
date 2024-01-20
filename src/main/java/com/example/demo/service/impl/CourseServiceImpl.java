package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.bean.model.Course;
import com.example.demo.service.CourseService;
import com.example.demo.dao.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{


    @Override
    public List<Course> listCourse() {
        return baseMapper.listCourse();
    }

    @Override
    public void addCourse() {
        Course course = new Course();
        course.setType("1");
        save(course);
    }
}




