package de.diskostu.demo.springboottutorial.student;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Log4j2
public class StudentService {

    private final StudentRepository repository;


    public StudentService(final StudentRepository repository) {
        this.repository = repository;
    }


    public List<Student> getStudents() {
        return repository.findAll();
    }


    public void addNewStudent(final Student student) {
        if (repository.existsById(student.getId())) {
            throw new IllegalStateException("email already taken: %s".formatted(student.getEmail()));
        } else {
            repository.save(student);
        }
    }


    public void deleteStudent(final Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            log.info("entry with id %d deleted.".formatted(id));
        } else {
            throw new IllegalStateException("student with id %d does not exist.".formatted(id));
        }
    }


    @Transactional
    public void updateStudent(final Student updatedStudent) {
        final var id = updatedStudent.getId();

        final var studentById = repository.findById(id);

        if (studentById.isPresent()) {
            final var student = studentById.get();
            log.info("previous data: %s".formatted(student));
            repository.save(updatedStudent);
            // field "student" will be updated after save.
            // in fact, the return value of save() is the same field as "student" (see the IDs in the debugger)
            log.info("updated data:  %s".formatted(student));
            log.info("student with id %d updated.".formatted(id));
        } else {
            throw new IllegalStateException("student with id %d does not exist.".formatted(id));
        }
    }
}
