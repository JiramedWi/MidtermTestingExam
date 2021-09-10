package Problem1;

import java.util.List;

public class Student {
    Integer id;
    String name;
    String surname;
    String studentId;

    public Student(Integer id, String name, String surname, String studentId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.studentId = studentId;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<Student> getAllStudent(){
        return null;

    }
    public Student addStudent(Student student){
        return null;
    }
}
