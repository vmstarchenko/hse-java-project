import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Interface {
    private Map<String, Team> teams = new HashMap();
    private Map<String, User> users = new HashMap();
    private Map<String, Task> tasks = new HashMap();

    void run() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input;
        while (true) {
             // Reading from System.in
            System.out.print("Enter command (\\h for help): ");
            input = "\\q";
            try{
                input = br.readLine();
            } catch(Exception e) {
                e.printStackTrace();
            }

            switch (input) {
                case "\\at":
                    addTeam();
                    break;
                case "\\au":
                    addUser();
                    break;
                case "\\atask":
                    addTask();
                    break;
                case "\\addtask2team":
                    addTaskToTeam();
                    break;
                case "\\addtask2user":
                    addTaskToUser();
                    break;
                case "\\addsubtask":
                    addSubtask();
                    break;
                case "\\adduser2team":
                    addUserToTeam();
                    break;
                case "\\showusers":
                    showUsers();
                    break;
                case "\\showteams":
                    showTeams();
                    break;
                case "\\showtasks":
                    showTasks();
                    break;
                case "\\sts":
                    showTeamSchedule();
                    break;
                case "\\sus":
                    showUserSchedule();
                    break;
                case "\\q":
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
                        " \\atask - add task\n" +
                        " \\addtask2team - add task\n" +
                        " \\addtask2user - add task\n" +
                        " \\addsubtask - add subtask\n" +
                        " \\adduser2team - add user to team\n" +
                        " \\showusers  - show user list\n" +
                        " \\showteams  - show team list\n" +
                        " \\showtasks  - show task list\n" +
                        " \\sts  - show team schedule\n" +
                        " \\sus  - show user schedule\n" +
                        " \\nt - create task\n" +
                        " \\h  - show this message\n" +
                        " \\q  - close"));
    }

    void addTeam() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String name = "";

        try {
            System.out.print("Enter team name: ");
            name = br.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }


        teams.put(name, new Team(name));
    }

    void addUser() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String name = "";

        try {
            System.out.print("Enter user name: ");
            name = br.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }

        users.put(name, new User(name));
    }

    void addTask() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String name = "";
        String description = "";
        String date = "";

        try {
            System.out.print("Enter task name: ");
            name = br.readLine();
            System.out.print("Enter task description: ");
            description = br.readLine();
            System.out.print("Enter deadline: ");
            date = br.readLine();

        } catch(Exception e) {
            e.printStackTrace();
        }

        tasks.put(name, new Task(name, description, date));
    }

    void addTaskToTeam() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String team_name = "";
        String task_name = "";

        try {
            System.out.print("Enter team name: ");
            team_name = br.readLine();
            System.out.print("Enter task name: ");
            task_name = br.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            teams.get(team_name).addTask(tasks.get(task_name));
        } catch(Exception e) {
            System.out.print("Wrong task or team name\n");
        }
    }

    void addTaskToUser() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String user_name = "";
        String task_name = "";

        try {
            System.out.print("Enter user name: ");
            user_name = br.readLine();
            System.out.print("Enter task name: ");
            task_name = br.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            users.get(user_name).addTask(tasks.get(task_name));
        } catch(Exception e) {
            System.out.print("Wrong name or task\n");
        }
    }

    void addSubtask() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String subtask_name = "";
        String task_name = "";

        try {
            System.out.print("Enter task name: ");
            task_name = br.readLine();
            System.out.print("Enter subtask name: ");
            subtask_name = br.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }
        try{
            tasks.get(task_name).addSubtask(tasks.get(subtask_name));
        } catch(Exception e) {
           System.out.print("Wrong task or subtask name\n");
        }
    }

    void addUserToTeam() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String user_name = "";
        String team_name = "";

        try {
            System.out.print("Enter user name: ");
            user_name = br.readLine();
            System.out.print("Enter team name: ");
            team_name = br.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            teams.get(team_name).addMember(users.get(user_name));
        } catch(Exception e) {
            System.out.print("Wrong name or team_name\n");
        }
    }

    void showTasks() {
        System.out.print(tasks.keySet() + "\n");
    }

    void showUsers() {
        System.out.print(users.keySet() + "\n");
    }

    void showTeams() {
        System.out.print(teams.keySet() + "\n");
    }
    void showTeamSchedule() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Schedule sch = new Schedule();

        String team_name = "";

        try {
            System.out.print("Enter user name: ");
            team_name = br.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            sch.ShowSchedule(teams.get(team_name));
        } catch(Exception e) {
            System.out.print("Wrong team_name\n");
        }
    }
    void showUserSchedule() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Schedule sch = new Schedule();

        String user_name = "";

        try {
            System.out.print("Enter user name: ");
            user_name = br.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            sch.ShowSchedule(users.get(user_name));
        } catch(Exception e) {
            System.out.print("Wrong user_name\n");
        }
    }

}
