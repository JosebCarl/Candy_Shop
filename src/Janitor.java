public class Janitor extends Employee {
    static int numJanitors;
    static int numSpills;
    static int janCost;

    Janitor(String name) {
        this.name = name;
        job = "Janitor";
        isAvailable = true;
        wage = 35;
    }

    @Override
    public int work(int numSpills) {
        numSpills -= 2;
        return numSpills;
    }

    @Override
    public void plus() {
        numJanitors++;
        numEmployees++;
    }

    public void check() {
        if (Janitor.numSpills >= 0) {
            System.out.println(this.name + " cleaned 2 spills!");
        }
        if (Janitor.numSpills == -1) {
            System.out.println(this.name + " cleaned 1 spill!");
            Janitor.numSpills = 0;
        }
        if (Janitor.numSpills == -2) {
            System.out.println(this.name + " had no spills to clean! " + this.name + " stare into a blank wall thinking about foolish your actions...");
            Janitor.numSpills = 0;
        }
    }

    public static void main(String[] args) {
        Janitor Phillip = new Janitor("Phillip");
        numSpills = 15;
        System.out.println(numSpills);
        numSpills = Phillip.work(numSpills);
        System.out.println(numSpills);
        numSpills = Phillip.work(numSpills);
        System.out.println(numSpills);
        numSpills = Phillip.work(numSpills);
        System.out.println(numSpills);
    }
}
