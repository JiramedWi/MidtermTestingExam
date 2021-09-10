package Problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.mock;

class StudentTest {
    List<Student> students = new ArrayList<>();


    @BeforeEach
    void init(){

        students.add(new Student(null,"Jiramed", "Withun", "6421150003"));
        students.add(new Student(002,"Krittawit", "Kong", "6421150001"));
        students.add(new Student(null,"Jumma", "Jara", "64211150003"));
        students.add(new Student(null,"Jack", "Slow", "642115004"));
        students.add(new Student(null,"Jim", "Sleep", "6021150001"));


    }

    @Test
    void addStudentPerfectCase() {
        Student student = new Student();
        assertThat(student.addStudent(students.get(0)),is(
                new Student(001,"Jiramed", "Withun", "6421150003")
        ));
    }

    @Test
    void addStudentFailCaseIdIsNotNull(){
        Student student = new Student();
        assertThat(student.addStudent(students.get(1)),is(null));
    }

    @Test
    void addStudentFailCaseStudentIdMoreThanTenDigits(){
        Student student = new Student();
        assertThat(student.addStudent(students.get(2)),is(null));
    }

    @Test
    void addStudentFailCaseStudentIdLessThanTenDigits(){
        Student student = new Student();
        assertThat(student.addStudent(students.get(3)),is(null));
    }

    @Test
    void addStudentFailCaseStudentIdIsOlderThanCurrentYear(){
        Student student = new Student();
        assertThat(student.addStudent(students.get(4)),is(null));
    }


}