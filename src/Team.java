import java.util.Vector;

public class Team {
    private Vector<User> members;
    private Vector<Task> tasks;
    private String       name;


    public Team(String name) {
        this.name = name;
        this.members = new Vector<User>();
        this.tasks = new Vector<Task>();
    }
    void addTask(Task task) {
        this.tasks.add(task);
        for (User member: members) {
            member.addTask(task);
        }
    }
    void addMember(User user) {
        this.members.add(user);
        user.addTeam(this);
    }
}