package lk.nibm.ead2.web.controller;

import lk.nibm.ead2.web.domain.Student;
import lk.nibm.ead2.web.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {
    @Autowired
    IStudentService service;
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getStudent(){
        return service.findAll();
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    @ResponseBody
    public Student createStudent(@RequestBody Student student) {
        return service.save(student);
    }
}
