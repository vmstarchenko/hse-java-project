import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.Date;


public class Task {
    private String name;
    private String description;
    private Vector<Task> subtasks;
    private Date date = new Date();
    private int status = 0; // 0 - todo; 1 - done; 2 - canseled
    private SimpleDateFormat date_format;

    public Task(String name, String description, String task_date) {
        this.name = name;
        this.description = description;
        subtasks = new Vector<Task>();
        date_format = new SimpleDateFormat("dd.MM.yyyy");

        try {
            this.date = date_format.parse(task_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public String asString() {
        return asString(true);
    }

    public String asString(boolean recursive) {
        return asString(recursive, 0);
    }

    public String asString(boolean recursive, int level) {
        String indentation = new String(new char[level]).replace("\0", " ");
        String out = indentation + "<Task " + name + " [" + date_format.format(date) + "]";
        if (!recursive || subtasks.isEmpty()) {
            return out + ">";
        }

        for (Task subtask : subtasks) {
            out += "\n" + subtask.asString(recursive, level + 1);
        }
        return out + ">";
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

    void updateTaskStatus(int status) {
        this.status = status;
    }

    void canсel() {
        this.updateTaskStatus(2);
    }

    void done() {
        this.updateTaskStatus(1);
    }

    void todo() {
        this.updateTaskStatus(0);
    }

    void recalcStatus() {
        boolean isDone = true;
        for (Task task : this.subtasks) {
            if (task.status == 0) {
                isDone = false;
                break;
            }
        }
        if (isDone) {
            done();
        }
    }
}