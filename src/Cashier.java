public class Cashier extends Employee {
    static int numCustomers;
    static int numCashiers;
    private int served;

    Cashier(String name){
        this.name = name;
        job = "Cashier";
        isAvailable = true;
        wage = 45;
        numCashiers ++;
    }

    @Override
    public int work(int customers) {
        numCustomers = customers;
        if (customers == 0) {
            this.served = 0;
            return 0;
        }
        int raised = 0;
        this.served = (int) (Math.random() * 8) + 1;
        numCustomers -= this.served;
        if (numCustomers < 0) {
            this.served += numCustomers;
            numCustomers = 0;
        }
        for (int i = this.served; i > 0; i--) {
            raised += (int) (Math.random() * 30) + 1;
        }
        return raised;
    }

    @Override
    public void plus() {
        numCashiers++;
        numEmployees++;
    }

    public int getServed() {
        return this.served;
    }
}