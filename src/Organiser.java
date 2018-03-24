import java.util.Vector;

public class Organiser {
    private Vector<Task> tasks;

    public Organiser() {
        this.tasks = new Vector<Task>();
    }

    void addTask(Task task) {
        this.tasks.add(task);
    }
}
