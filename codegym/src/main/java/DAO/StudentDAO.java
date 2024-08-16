package DAO;

import JDBIConnector.JDBIConnector;
import Model.Student;
import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.stream.Collectors;

public class StudentDAO implements IStudentDAO{
    @Override
    public List<Student> findALl() {
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Student> Students = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM student";
            return handle.createQuery(sql).mapToBean(Student.class).stream().collect(Collectors.toList());

        });
        return Students;
    }

    @Override
    public List<Student> findById(int id) {
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Student> Students = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM student where id=?";
            return handle.createQuery(sql).bind(1,id).mapToBean(Student.class).stream().collect(Collectors.toList());

        });
        return Students;
    }
}
