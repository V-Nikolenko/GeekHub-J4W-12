package com.geekhub;

import java.util.List;

public class StudentService {

    private final StudentRepository repository = new StudentRepository();

    public void addStudent(Student student) {
        repository.addStudent(student);
    }

    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }

    public List<Student> getStudents() {
        return repository.getStudents();
    }
}
