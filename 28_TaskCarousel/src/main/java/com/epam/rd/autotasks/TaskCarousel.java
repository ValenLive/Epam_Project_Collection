package com.epam.rd.autotasks;

public class TaskCarousel {
    private final int capacity;

    private final Task[] taskArr;

    private int index;

    private int i;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        taskArr = new Task[capacity];
        index = 0;
        i = 0;
    }

    public boolean addTask(Task task) {
        if (task == null) return false;
        if (isFull()) return false;
        if (task.isFinished()) return false;

        while (true) {
            if (index >= capacity) {
                index = 0;
                continue;
            }
            if (taskArr[index] != null) {
                index++;
                continue;
            }
            break;
        }

        taskArr[index] = task;
        index++;

        return true;
    }

    public boolean execute() {
        if (isEmpty()) return false;

        while (true) {
            if (i >= capacity) {
                i = 0;
                continue;
            }
            if (taskArr[i] == null) {
                i++;
                continue;
            }
            break;
        }

        taskArr[i].execute();
        if (taskArr[i].isFinished()) taskArr[i] = null;
        i++;

        return true;
    }

    public boolean isFull() {
        for (Task task : taskArr) {
            if (task == null) return false;
        }
        return true;
    }

    public boolean isEmpty() {
        for (Task task : taskArr) {
            if (task != null) return false;
        }
        return true;
    }

}
