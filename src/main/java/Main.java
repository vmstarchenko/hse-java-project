import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        (new Interface()).run();

        Schedule sch = new Schedule();

        User usr1 = new User("User 1");
        User usr2 = new User("User 2");
        User usr3 = new User("User 3");
        User usr4 = new User("User 4");

        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");

        team1.addMember(usr1);
        team1.addMember(usr2);
        team1.addMember(usr3);

        team2.addMember(usr2);
        team2.addMember(usr3);

        Task task1 = new Task("task 1", "some task 1", "28.12.2123");
        Task task2 = new Task("task 2", "some task 2", "18.12.2103");
        Task task4 = new Task("task 4", "some task 4", "28.1.2123");

        AutoTask task3 = new AutoTask("task 3", "some task 3", "28.2.2123");
        AutoTask task5 = new AutoTask("task 5", "some task 5", "28.2.2123");
        AutoTask task6 = new AutoTask("task 6", "some task 6", "28.2.2123");


        task3.addTask(task5);
        task3.addTask(task6);

        Task subtask1 = new Task("sub_task 1", "some sub_task 1", "28.2.2123");
        Task subtask2 = new Task("sub_task 2", "some sub_task 2", "28.2.2123");
        Task subtask3 = new Task("sub_task 3", "some sub_task 3", "28.2.2123");

        subtask1.addTask(subtask2);

        task1.addTask(subtask1);
        task2.addTask(subtask3);

        team1.addTask(task1);

        usr2.addTask(task3);

        team2.addTask(task2);

        usr4.addTask(task4);


        sch.ShowSchedule(usr2);
        sch.ShowSchedule(team1);

    }
}
