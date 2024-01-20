package com.example.demo.controller;

//import com.example.demo.service.PeoService;
import com.example.demo.bean.UserVO;
import com.example.demo.bean.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/hancheng")
public class HanchengController {

    private ThreadLocal<Integer> count = new ThreadLocal<>();

//    @Autowired
//    private PeoService peoService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/hello")
    public String hello(@RequestBody @Valid UserVO userVO) {
//        peoService.queryList();
        return "welcome!!!";
    }

    @RequestMapping("/countVal")
    public int countVal() {
        count.set(1);
        return count.get();
    }

    @RequestMapping("countVal1")
    public int countVal1() {
        return count.get();
    }

    @RequestMapping("/course/list")
    public List<Course> listCourse() {
        return courseService.listCourse();
    }

    @RequestMapping("/course/add")
    public void add() {
        courseService.addCourse();
    }
}
