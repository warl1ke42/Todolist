package model;

public class Task {
    private static int nextId = 1;
    private int id;
    private String title;
    private boolean done;

    public Task(int id, String title, boolean done) {
        this.id = nextId++;
        this.title = title;
        this.done = done;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public static void setNextId(int nextId) {
        Task.nextId = nextId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        String status = done ? "[x]" : "[ ]";
        return status + " " + title;
    }
}
