//EnrollmentService
package airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;

import airtribe.learntrack.entity.Enrollment;
import airtribe.learntrack.enums.EnrollmentStatus;
import airtribe.learntrack.util.IdGenerator;

public class EnrollmentService {
    private List<Enrollment> enrollments = new ArrayList<>();

    public void enrollStudent(int studentId, int courseId) {
        enrollments.add(new Enrollment(
                IdGenerator.getNextEnrollmentId(),
                studentId, courseId
        ));
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }
        return result;
    }

    public void updateStatus(Enrollment e, EnrollmentStatus status) {
        e.setStatus(status);
    }
}
    

