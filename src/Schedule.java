import java.util.Map;

public class Schedule {
    void ShowSchedule(Team team) {
        for (User member: team.GetMembers()) {
            System.out.println(member.GetName()+" :\n");
            this.ShowSchedule(member);
        }

    }

    void ShowSchedule(User user) {
        Map<String, Task> tasks = user.GetTasks();
        System.out.println(tasks.keySet());
    }
}
