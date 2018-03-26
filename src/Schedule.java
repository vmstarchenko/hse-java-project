public class Schedule {
    void ShowSchedule(Team team) {
        for (User member: team.GetMembers()) {
            System.out.println(member.GetName()+" :\n");
            this.ShowSchedule(member);
        }

    }

    void ShowSchedule(User user) {
        user.GetTasks();
    }
}
