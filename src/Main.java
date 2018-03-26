import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
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

        Task task1 = new Task("task 1", "some task 1", "28/12/2123");
        Task task2 = new Task("task 2", "some task 2", "18/12/2103");
        Task task3 = new Task("task 3", "some task 3", "28/1/2123");
        Task task4 = new Task("task 4", "some task 4", "28/2/2123");

        team1.addTask(task1);

        usr2.addTask(task3);

        team2.addTask(task2);

        usr4.addTask(task4);


        sch.ShowSchedule(usr1);
        sch.ShowSchedule(team1);
    }
}
