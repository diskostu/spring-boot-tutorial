package de.diskostu.demo.springboottutorial.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }


    @PostMapping
    public void registerNewStudent(@RequestBody final Student student) {
        studentService.addNewStudent(student);
    }
}
