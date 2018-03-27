import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.Date;


/**
 * Класс служит для хранения и исполнения данных о данном задании.
 * @autor Starchenko Vladimir
 * @version 1.0
 */
public class Task {
    private String name;
    private String description;
    /** Подзадания. Образуют структуру дерева. */
    private Vector<Task> subtasks;
    /** Статус выполнения задания
     *  0 - запланировано
     *  1 - сделано
     *  2 - отменено
     */
    private int status = 0;

    /** Дата дедлайна задания */
    private Date date = new Date();
    /** Формат ввода/вывода дедлайна задания */
    private SimpleDateFormat date_format;

    /** Количество отступов, используемое при отображении подзаданий */
    private int indentationWidth = 4;

    public Task(String name, String description, String deadline) {
        this.name = name;
        this.description = description;
        subtasks = new Vector<Task>();
        date_format = new SimpleDateFormat("dd.MM.yyyy");

        try {
            this.date = date_format.parse(deadline);
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

    /**
     * Вернуть текстовое представление задания.
     * @param recursive рекурсивно отобразить подзадания
     * @param level текущий отступа
     */
    public String asString(boolean recursive, int level) {
        String indentation = new String(new char[level]).replace("\0", " ");
        String out = indentation + "Task " + name + " [" + date_format.format(date) + "]";
        if (!recursive || subtasks.isEmpty()) {
            return out;
        }

        for (Task subtask : subtasks) {
            out += "\n" + subtask.asString(recursive, level + indentationWidth);
        }
        return out;
    }

    void addSubtask(Task task) {
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

    /**
     * Пометить задание как отмененное
     */
    void canсel() {
        this.updateTaskStatus(2);
    }

    /**
     * Пометить задание как сделанное
     */
    void done() {
        this.updateTaskStatus(1);
    }

    /**
     * Пометить задание как отмененное
     */
    void todo() {
        this.updateTaskStatus(0);
    }

    /**
     * Обновить статус задания, основываясь на его подзаданиях.
     * Если все подзадания помечены как сделанные или отмененные,
     * отмечает  данное задание как сделанное.
     */
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