package de.diskostu.demo.springboottutorial.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;


    public StudentService(final StudentRepository repository) {
        this.repository = repository;
    }


    public List<Student> getStudents() {
        return repository.findAll();
    }


    public void addNewStudent(Student student) {
        System.out.println(student);
    }
}
