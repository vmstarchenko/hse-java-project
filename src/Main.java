public class Main {
    public static void main(String[] args) {
        Schedule sch = new Schedule();
        User usr = new User("qwe");
        Team tm = new Team("asd");
        sch.ShowSchedule(usr);
        sch.ShowSchedule(tm);
    }
}
