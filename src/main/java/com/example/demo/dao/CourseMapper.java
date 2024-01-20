package com.example.demo.dao;

import com.example.demo.bean.model.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Entity com.example.demo.bean.model.Course
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> listCourse();
}




