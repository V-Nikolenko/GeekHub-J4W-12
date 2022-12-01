package edu.geekhub.homework.hw2;

import edu.geekhub.homework.hw2.entity.Task;

import java.util.List;

public interface ToDoList<E extends Task> {
    E getTopPriorityTask();

    E getTaskByIndex(int index);

    List<E> getAllTasks();

    List<E> getSortedPriorityTasks();

    List<E> getSortedByAlphabetTasks();

    boolean addTaskToTheEnd(E task);

    boolean addTaskToTheStart(E task);

    boolean deleteTaskByIndex(E task);

}
