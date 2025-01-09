public class Employee {
    static int numEmployees;

    protected String name;
    protected String job;
    protected boolean isAvailable;
    protected int wage;

    public Employee() {}

    public Employee(String name, String job, int wage) {
        this.name = name;
        this.job = job;
        this.wage = wage;
        this.isAvailable = true;
        numEmployees++;
    }

    public int work(int customers) {
        return customers + 2;
    }

    public void plus() {
        numEmployees++;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void available() {
        isAvailable = true;
    }

    public void notAvailable() {
        isAvailable = false;
    }
}