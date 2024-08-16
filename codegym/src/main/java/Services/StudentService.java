package Services;

import DAO.IStudentDAO;
import DAO.StudentDAO;
import Model.Student;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentDAO studentDAO = new StudentDAO();
    @Override
    public List<Student> findALl() {
       return studentDAO.findALl();
    }

    @Override
    public static Student findById(int id) {
        return StudentDAO.findById(id).stream().findFirst().get();
    }


}
