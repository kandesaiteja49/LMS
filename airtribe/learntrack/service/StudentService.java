//StudentService
package airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;

import airtribe.learntrack.entity.Student;
import airtribe.learntrack.exception.EntityNotFoundException;
import airtribe.learntrack.util.IdGenerator;

public class StudentService {
     private List<Student> students = new ArrayList<>();

    public void addStudent(String fn, String ln, String email, String batch) {
        students.add(new Student(
                IdGenerator.getNextStudentId(),
                fn, ln, email, batch
        ));
    }

    public List<Student> listStudents() {
        return students;
    }

    public Student findStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new EntityNotFoundException("Student not found"));
    }

    public void deactivateStudent(int id) {
        findStudentById(id).setActive(false);
    }
}
