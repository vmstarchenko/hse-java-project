import java.util.Vector;

public class User {
    private Vector<Team> teams;
    private Vector<Task> tasks;
    private String       name;


    public User(String name) {
        this.name = name;
        this.teams = new Vector<Team>();
        this.tasks = new Vector<Task>();
    }
    void addTask(Task task) {
        this.tasks.add(task);
    }
    void addTeam(Team team) {
        this.teams.add(team);
    }
}
