import java.util.Vector;


public class Task {
    private String name;
    private String description;
    private Vector<Task> subtasks;
    private int status = 0; // 0 - todo; 1 - done; 2 - canseled

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        subtasks = new Vector<Task>();
    }

    void addTask(Task task) {
        subtasks.add(task);
    }

    public String getName() {
        return name;
    }

    void changeDescription(String description) {
        this.description = description;
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
