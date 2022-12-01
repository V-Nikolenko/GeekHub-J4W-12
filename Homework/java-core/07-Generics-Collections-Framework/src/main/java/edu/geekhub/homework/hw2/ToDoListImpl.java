package edu.geekhub.homework.hw2;

import edu.geekhub.homework.hw2.entity.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ToDoListImpl<E extends Task> implements ToDoList<E> {
    private List<E> tasksStorage = new ArrayList<>();

    @Override
    public E getTopPriorityTask() {
        return null;
    }

    @Override
    public E getTaskByIndex(int index) {
        return null;
    }

    @Override
    public List<E> getAllTasks() {
        return tasksStorage;
    }

    @Override
    public List<E> getSortedPriorityTasks() {
        List<E> priorityTasks = tasksStorage;

        priorityTasks.sort(new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                //write your comparator logic here
                return 0;
            }
        });
        return priorityTasks;
    }

    @Override
    public List<E> getSortedByAlphabetTasks() {
        return null;
    }

    @Override
    public boolean addTaskToTheEnd(E task) {
        return false;
    }

    @Override
    public boolean addTaskToTheStart(E task) {
        return false;
    }

    @Override
    public boolean deleteTaskByIndex(E task) {
        int index = tasksStorage.indexOf(task);
        try {
            tasksStorage.remove(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
}
