import java.util.Map;
import java.util.Vector;

public class Schedule {
    private int taskIndentation = 2;

    void ShowSchedule(ScheduleObject scheduleObject) { // TODO: rewrite as interface
        ShowSchedule(scheduleObject, true);
    }

    void ShowSchedule(ScheduleObject scheduleObject, boolean recursive) {
        System.out.println(scheduleObject.getName() + ":");
        printTasks(recursive, scheduleObject.getTasks());
    }

    void printTasks(boolean recursive, Vector<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task.asString(recursive, taskIndentation));
        }
    }
}
