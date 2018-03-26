import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

public class Team {
    private Vector<User> members;
    private Map<String, Task> tasks;
    private String       name;


    public Team(String name) {
        this.name = name;
        tasks = new HashMap<String, Task>();
        members = new Vector<User>();
    }

    void addTask(Task task) {
        // TODO: if this task already exists: raise valueError ???
        tasks.put(task.getName(), task);
        for (User member: members) {
            member.addTask(task);
        }
    }

    void addMember(User user) {
        this.members.add(user);
        user.addTeam(this);
    }

    void removeMember(User user) {
        // TODO: implement this
        for (String name: tasks.keySet()) {
            user.removeTask(name);
        }
    }

    Vector<User> GetMembers() {
        return this.members;
    }

}