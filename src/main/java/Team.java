import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

public class Team implements ScheduleObject {
    private Vector<User> members;
    private Map<String, Task> tasks;
    private String       name;


    public Team(String name) {
        this.name = name;
        tasks = new HashMap<String, Task>();
        members = new Vector<User>();
    }

    void addTask(Task task) {
        tasks.put(task.getName(), task);
        for (User member: members) {
            member.addTask(task);
        }
    }    Vector<User> GetMembers() {
        return this.members;
    }

    void addMember(User user) {
        this.members.add(user);
        user.addTeam(this);
    }

    void removeMember(User user) {
        for (String name: tasks.keySet()) {
            user.removeTask(name);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Vector<Task> getTasks() {
        return new Vector<Task>(tasks.values());
    }

    Vector<User> getMembers() {
        return members;
    }

}