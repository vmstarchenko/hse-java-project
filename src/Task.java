import java.util.Vector;


public class Task {
    private String description;
    private Vector<Task> subtasks;
    private int status = 0; // 0 - todo; 1 - done; 2 - canseled

    public Task(String description) {
        this.description = description;
        this.subtasks = new Vector<Task>();
    }

    void addTask(Task task) {
        this.subtasks.add(task);
    }

    void canсel() {
        status = 2;
    }

    void done() {
        status = 1;
    }

    void todo() {
        status = 0;
    }
}
