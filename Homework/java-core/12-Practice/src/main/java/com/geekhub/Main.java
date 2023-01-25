package com.geekhub;

import java.util.Scanner;

public class Main {

    private static final StudentService studentService = new StudentService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ", 2);

            switch (parts[0]) {
                case "exit" -> {
                    return;
                }
                case "add-student" -> addStudent(parts);
                case "delete-student" -> deleteStudent(parts);
                case "list-students" -> listStudents();
                default -> System.err.println("Invalid command");
            }
        }
    }

    private static void listStudents() {
        for (Student student : studentService.getStudents()) {
            System.out.println(student);
        }
    }

    private static void deleteStudent(String[] parts) {
        int id = Integer.parseInt(parts[1]);
        studentService.deleteStudent(id);
    }

    private static void addStudent(String[] parts) {
        final Student student = StudentConsoleParser.fromConsoleInput(parts[1]);
        studentService.addStudent(student);
        System.out.println("Student created with id " + student.getId());
    }

}
