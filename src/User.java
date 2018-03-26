import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class User {
    private Vector<Team> teams;
    private Map<String, Task> tasks;
    private String       name;


    public User(String name) {
        this.name = name;
        teams = new Vector<Team>();
        tasks = new HashMap<String, Task>();
    }

    void addTask(Task task) {
        tasks.put(task.getName(), task);
    }

    void removeTask(String name) {
        tasks.remove(name);
    }

    void addTeam(Team team) {
        this.teams.add(team);
    }

    String GetName() {
        return this.name;
    }

    Map<String, Task> GetTasks() {
        return tasks;
    }
}
