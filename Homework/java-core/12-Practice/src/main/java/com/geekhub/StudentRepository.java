package com.geekhub;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(int id) {
        students.removeIf(student ->
            student.getId() == id
        );
    }

    public List<Student> getStudents() {
        return students;
    }
}
