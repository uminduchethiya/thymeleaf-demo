package lk.nibm.ead2.web.controller;

import lk.nibm.ead2.web.domain.Student;
import lk.nibm.ead2.web.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    IStudentService service;
    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Student student)
    {
        service.save(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student-data");
        modelAndView.addObject("user", student);
        return modelAndView;
    }
}

