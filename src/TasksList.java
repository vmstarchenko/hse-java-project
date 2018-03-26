import java.util.Vector;

public class TasksList {
    private Vector<Task> tasks;

    public TasksList (Vector<Task> tasks) {
        this.tasks = tasks;
    }

    public String asString() {
        return asString(true);
    }

    public String asString(boolean recursive) {
        String out = "";
        for (Task task : tasks) {
            out += task.asString(recursive) + "\n";
        }
        return out;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
