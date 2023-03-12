package lk.nibm.ead2.web.service.impl;

import lk.nibm.ead2.web.domain.Student;
import lk.nibm.ead2.web.repository.StudentRepository;
import lk.nibm.ead2.web.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student save(Student student) {
        lk.nibm.ead2.web.entity.Student dao = new lk.nibm.ead2.web.entity.Student();
        BeanUtils.copyProperties(student,dao);
        studentRepository.save(dao);

        return student;
    }
    @Override
    public List<Student>findAll(){
        List<lk.nibm.ead2.web.entity.Student> students=studentRepository.findAll();
        return  students.stream().map(s ->{
            Student dto =new Student();
            BeanUtils.copyProperties(s,dto);
            return dto;

        }).collect(Collectors.toList());
    }
}
