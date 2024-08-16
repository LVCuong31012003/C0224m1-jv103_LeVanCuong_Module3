package Services;

import Model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findALl();
    Student findById(int id);
}
