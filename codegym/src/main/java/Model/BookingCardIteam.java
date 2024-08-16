package Model;

public class BookingCardIteam {
    private Student student;
    private int quanlity;

    public BookingCardIteam(Student student, int quanlity) {
        this.student = student;
        this.quanlity = quanlity;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public boolean addQuanlity(int quanlity){
        this.quanlity+=quanlity;
        return true;
    }
    public double getTotalPrice(){
        return this.quanlity*this.student.getPrice();
    }
}
