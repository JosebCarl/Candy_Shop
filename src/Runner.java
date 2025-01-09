import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Welcome to the candy shop!\nTry to earn as much money as possible by serving customers!\nYou can do tasks yourself, or hire employees to help you!\nSpills decrease the amount of customers stopping by, so make sure to clean them up!\nSets of customers enter the store everyday; serve them to earn money!\nEvery action you do takes time away from the day.\nMake enough money to be able to pay your bills at the end of the day!\n");
        Scanner user = new Scanner(System.in);
        int money = 300;
        int customers = 0;
        int day = 0;
        int bill = 150;
        int cashCost = 100;
        int janCost = 80;
        Janitor.numSpills = 0;
        Double time = 10.0;
        Cashier you = new Cashier("You");
        Cashier cashier = new Cashier("npc1");
        Cashier.numCashiers = 0;
        Janitor you2 = new Janitor("You");
        Janitor janitor = new Janitor("Your employees");
        Janitor.numJanitors = 0;


        while (money >= 0) {
            day += 1;
            time = 10.0;
            customers = (int) ((10 + 10 * day) / (Janitor.numSpills + 1) + ((int) (Math.random() * (15 + 4 * day)) + 1 + 4 * day));
            bill += 150;
            Janitor.numSpills = (int) (Math.random() * (3 * day)) + (1 + 2 * day);

            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("It is day " + day + "!");
            System.out.println("What would you like to do?");
            System.out.println("Type 1 to serve customers");
            System.out.println("Type 2 to clean up spills");
            System.out.println("Type 3 to inspect candy");
            System.out.println("Type 4 to manage employees");
            System.out.println("Type 5 to wait out the rest of the time");
            System.out.println("There are currently " + customers + " customers, " + Janitor.numSpills + " spills, and you have $" + money + ". Today's bill is $" + bill + ".\n");

            while (time > 0) {
                System.out.println("Time remaining: " + time + " hours.");
                int userResponse = user.nextInt();
                time -= (Math.round(0.1 * 10) / 10.0);
                time = (Math.round(time * 10) / 10.0);

                if (userResponse == 0) {
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("What would you like to do?");
                    System.out.println("Type 1 to serve customers");
                    System.out.println("Type 2 to clean up spills");
                    System.out.println("Type 3 to inspect candy");
                    System.out.println("Type 4 to manage employees");
                    System.out.println("Type 5 to wait out the rest of the time");
                    System.out.println("There are currently " + customers + " customers, " + Janitor.numSpills + " spills, and you have $" + money + ". Today's bill is $" + bill + ".\n");
                }

                if (userResponse == 1) {
                    System.out.println("-------------------------------------------------------------------------\n");
                    int raised = you.work(customers);
                    if (customers != 0) {
                        customers -= you.getServed();
                    }
                    money += raised;
                    time -= (Math.round(1.0 * 10) / 10.0);
                    time = (Math.round(time * 10) / 10.0);
                    System.out.println("You successfully served " + you.getServed() + " customers and earned " + raised + " dollars.");
                    if (Cashier.numCashiers != 0) {
                        int empRaised = 0;
                        int served = 0;
                        for (int i = Cashier.numCashiers; i > 0; i--) {
                            empRaised += cashier.work(customers);
                            if (customers != 0) {
                                customers -= cashier.getServed();
                            }
                            served += cashier.getServed();
                        }
                        money += empRaised;
                        System.out.println("Your employees successfully served " + served + " customers and earned " + empRaised + " dollars.");
                    }
                    System.out.println("Customers left: " + customers + "\nCurrent money: " + money);
                    System.out.println("\nType 0 to go back to the menu");
                    System.out.println("Type 1 to continue serving customers\n");
                }

                if (userResponse == 2) {
                    System.out.println("-------------------------------------------------------------------------\n");
                    time -= (Math.round(1.0 * 10) / 10.0);
                    time = (Math.round(time * 10) / 10.0);
                    Janitor.numSpills = you2.work(Janitor.numSpills);
                    you2.check();
                    if (Janitor.numJanitors != 0) {
                        Janitor.numSpills = janitor.work(Janitor.numSpills);
                        janitor.check();
                    }
                    if (Janitor.numSpills == 1) {
                        System.out.println("There is 1 spill remaining!");
                    } else {
                        System.out.println("There are " + Janitor.numSpills + " spills remaining!");
                    }
                    System.out.println("\nType 0 to go back to the menu");
                    System.out.println("Type 2 to continue cleaning\n");
                }

                if (userResponse == 3) {
                    System.out.println("-------------------------------------------------------------------------\n");
                    System.out.println("Which candy would you like to test?\n");
                    System.out.println("Type 1, 2, or 3 to test a random candy");
                    System.out.println("Type 0 to go back to the menu");
                    System.out.println("\nTime remaining: " + time + " hours.");
                    int candyResponse = user.nextInt();
                    if (candyResponse == 0) {
                        System.out.println("You changed your mind");
                    } else if (candyResponse == 1) {
                        CandyCane cane = new CandyCane();
                        System.out.println(cane.inspect());
                    } else if (candyResponse == 2) {
                        CandyHeart heart = new CandyHeart();
                        System.out.println(heart.inspect());
                    } else if (candyResponse == 3) {
                        Pizza pizza = new Pizza();
                        System.out.println(pizza.inspect());
                    }
                    time -= (Math.round(0.4 * 10) / 10.0);
                    time = (Math.round(time * 10) / 10.0);
                    System.out.println("Type 0 to return to the menu");
                }

                if (userResponse == 4) {
                    int choice = 1;
                    while (choice == 1) {
                        System.out.println("-------------------------------------------------------------------------\n");
                        System.out.println("Would you like to hire an employee?");
                        System.out.println("Type 0 to go back to the menu");
                        System.out.println("Type 1 to hire a new employee\n");
                        System.out.println("You currently have " + Employee.numEmployees + " employees: " + Cashier.numCashiers + " cashiers and " + Janitor.numJanitors + " janitors.");
                        System.out.println("\nTime remaining: " + time + " hours.");
                        int userResponse1 = user.nextInt();
                        if (userResponse1 == 0) {
                            choice = 0;
                        } else if (userResponse1 == 1) {
                            System.out.println("-------------------------------------------------------------------------\n");
                            System.out.println("Hiring a cashier will add $" + cashCost + " to the bill.");
                            System.out.println("Hiring a janitor will add $" + janCost + " to the bill.\n");
                            System.out.println("Type 0 to go back to the menu");
                            System.out.println("Type 1 to hire a new cashier");
                            System.out.println("Type 2 to hire a new janitor\n");
                            int userResponse2 = user.nextInt();
                            if (userResponse2 == 0) {
                                System.out.println("-------------------------------------------------------------------------\n");
                                System.out.println("You changed your mind.");
                                choice = 0;
                            } else if (userResponse2 == 1) {
                                System.out.println("-------------------------------------------------------------------------\n");
                                System.out.println("What will their name be?\n");
                                String name = user.next();
                                bill += cashCost;
                                cashCost += 50;
                                cashier.plus();
                                System.out.println("You have successfully hired " + name + "!\n");
                            } else if (userResponse2 == 2) {
                                System.out.println("What will their name be?");
                                String name = user.next();
                                bill += janCost;
                                janCost += 80;
                                janitor.plus();
                                System.out.println("You have successfully hired " + name + "!\n");
                            }

                            time -= (Math.round(0.8 * 10) / 10.0);
                            time = (Math.round(time * 10) / 10.0);
                        }
                    }
                    System.out.println("-------------------------------------------------------------------------\n");
                    System.out.println("What would you like to do?");
                    System.out.println("Type 1 to serve customers");
                    System.out.println("Type 2 to clean up spills");
                    System.out.println("Type 3 to inspect candy");
                    System.out.println("Type 4 to manage employees");
                    System.out.println("Type 5 to wait out the rest of the time");
                    System.out.println("There are currently " + customers + " customers, " + Janitor.numSpills + " spills, and you have $" + money + ". Today's bill is $" + bill + ".\n");
                }

                if (userResponse == 5) {
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("You skipped the rest of the day...\n");
                    time = 0.0;
                }
            }
            money -= bill;
        }
        money += bill;
        System.out.println("-------------------------------------------------------------------------\n");
        System.out.println("\nGame over!");
        System.out.println("You couldn't pay the bill of $" + bill + " with $" + money + "...");
        System.out.println("You survived " + day + " days!");
    }
}
