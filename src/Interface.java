import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Interface {
    private Map<String, Team> teams = new HashMap();
    private Map<String, User> users = new HashMap();
    private Map<String, Task> tasks = new HashMap();

    void parseCommand(String command) {


    }

    void showHelp() {
        System.out.println("Help");
    }

    void addTeam(String name) {
        teams.put(name, new Team(name));
    }

    void addUser(String name) {
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
