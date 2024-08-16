package DAO;

import Model.Student;

import java.util.List;

public interface IStudentDAO {
    List<Student> findALl();
    List<Student> findById(int id);
}
