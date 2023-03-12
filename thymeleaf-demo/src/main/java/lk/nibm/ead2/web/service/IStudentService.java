package lk.nibm.ead2.web.service;

import lk.nibm.ead2.web.domain.Student;

import java.util.List;

public interface IStudentService {
    Student save(Student student);
    List<Student>findAll();
}
