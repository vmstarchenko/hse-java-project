import java.util.Vector;

public class AutoTask  extends Task {
    private Task parentTask;

    public AutoTask(String name, String description) {
        super(name, description);
    }

    void addTask(AutoTask task) {
        super.addTask(task);
        task.parentTask = this;
    }

    void updateTaskStatus(int status) {
        super.updateTaskStatus(status);

        parentTask.recalcStatus();
    }
}
