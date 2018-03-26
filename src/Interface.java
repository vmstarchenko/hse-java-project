import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Scanner;

public class Interface {
    private Map<String, Team> teams = new HashMap();
    private Map<String, User> users = new HashMap();
    private Map<String, Task> tasks = new HashMap();

    void run() {
        Scanner reader = new Scanner(System.in);
        while (true) {
             // Reading from System.in
            System.out.print("Enter command (\\h for help): ");
            String input = reader.next();

            switch (input) {
                case "\\at":
                    addTeam();
                    break;
                case "\\au":
                    addUser();
                    break;
                case "\\q":
                    reader.close();
                    return;
                case "\\h":
                    showHelp();
                    break;
                default:
                    System.out.println("unknown command");
                    showHelp();

            }

        }

    }

    void showHelp() {
        System.out.println((
                "Help:\n" +
                        " \\au - add user\n" +
                        " \\at - add team\n" +
                        " \\h  - show this message\n" +
                        " \\nt - create task\n"));
    }

    void addTeam() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter team name: ");
        String name = reader.next();
        teams.put(name, new Team(name));
    }

    void addUser() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter user name: ");
        String name = reader.next();
        users.put(name, new User(name));
    }

    void addTask(String name, String description, String date) {
        tasks.put(name, new Task(name, description, date));
    }

    void addTaskToTeam(String team_name, String task_name) {
        teams.get(team_name).addTask(tasks.get(task_name));
    }

    void addTaskToUser(String user_name, String task_name) {
        users.get(user_name).addTask(tasks.get(task_name));
    }

    void addSubtask(String task_name, String subtask_name) {
        tasks.get(task_name).addTask(tasks.get(subtask_name));
    }

    void addUserToTeam(String user_name, String team_name) {
        teams.get(team_name).addMember(users.get(user_name));
    }

}
