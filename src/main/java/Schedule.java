import java.util.Map;
import java.util.Vector;

public class Schedule {
    private int taskIndentation = 2;

    void ShowSchedule(Team team) { // TODO: rewrite as interface
        ShowSchedule(team, true);
    }

    void ShowSchedule(Team team, boolean recursive) {
        System.out.println(team.getName() + ":");
        printTasks(recursive, team.getTasks());
    }

    void ShowSchedule(User user) {
        ShowSchedule(user, true);
    }

    void ShowSchedule(User user, boolean recursive) {
        System.out.println(user.getName() + ":");
        printTasks(recursive, user.getTasks());
    }

    void printTasks(boolean recursive, Vector<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task.asString(recursive, taskIndentation));
        }
    }
}
