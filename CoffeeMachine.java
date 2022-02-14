import java.util.Scanner;

public class CoffeeMachine {

    int water;
    int milk;
    int coffee;
    int cups;
    int money;

    public CoffeeMachine(int water, int milk, int coffee, int cups, int money){
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.money = money;
    }
    public void status(){
        System.out.format("The coffee machine has:\n%d ml of water\n%d ml of milk\n%d g of coffee" +
                " beans\n%d disposable cups\n$%d of money\n\n", water, milk, coffee, cups, money);
        actions();
    }

    private void actions() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        Scanner scr = new Scanner(System.in);
        String action = scr.next();

        switch (action){
            case "buy":
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                Scanner scr1 = new Scanner(System.in);
                String act = scr1.next();
                Buy(act);
                break;
            case  "fill":
                System.out.println();
                myFill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                System.out.println();
                status();
                break;
            case "exit":
                scr.close();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    private void take() {
        System.out.println("\nI gave you $" + money + "\n");
        money = 0;
        actions();
    }

    private void myFill() {
        System.out.println("Write how many ml of water you want to add:");
        Scanner scr = new Scanner(System.in);
        int act = scr.nextInt();
        water += act;
        System.out.println("Write how many ml of milk you want to add:");
        act = scr.nextInt();
        milk += act;
        System.out.println("Write how many grams of coffee beans you want to add:");
        act = scr.nextInt();
        coffee += act;
        System.out.println("Write how many disposable cups of coffee you want to add");
        act = scr.nextInt();
        cups += act;
        System.out.println();
        actions();
    }

    private void Buy(String act) {
        switch (act){
            case "1":
                if( water >= 250) {
                    if(cups > 0) {
                        if(coffee >= 16) {
                            water -= 250;
                            cups--;
                            coffee -= 16;
                            money += 4;
                            System.out.println("I have enough resources, making you a coffee!\n");
                        } else System.out.println("Sorry, not enough coffee beans!");
                    } else System.out.println("Sorry, not enough cups!");
                } else System.out.println("Sorry, not enough water!");
                actions();
                break;
            case "2":
                if( water >= 350) {
                    if(cups > 0) {
                        if(coffee >= 20) {
                            if(milk >= 75) {
                                water -= 350;
                                cups--;
                                coffee -= 20;
                                money += 7;
                                milk -= 75;
                                System.out.println("I have enough resources, making you a coffee!\n");
                            } else System.out.println("Sorry, not enough milk!");
                        } else System.out.println("Sorry, not enough coffee beans!");
                    } else System.out.println("Sorry, not enough cups!");
                } else System.out.println("Sorry, not enough water!");
                actions();
                break;
            case "3":
                if( water >= 200) {
                    if(cups > 0) {
                        if(coffee >= 12) {
                            if(milk >= 100) {
                                water -= 200;
                                cups--;
                                coffee -= 12;
                                money += 6;
                                milk -= 100;
                                System.out.println("I have enough resources, making you a coffee!\n");
                            } else System.out.println("Sorry, not enough milk!");
                        } else System.out.println("Sorry, not enough coffee beans!");
                    } else System.out.println("Sorry, not enough cups!");
                } else System.out.println("Sorry, not enough water!");
                actions();
                break;
            case "back":
                actions();
                break;
        }


    }

    public static void main(String[] args) {

        CoffeeMachine ekspres = new CoffeeMachine(400, 540, 120, 9, 550);
        ekspres.actions();

    }
}
