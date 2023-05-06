package machine;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public void sell(Coffee coffee) {
        water -= coffee.getWater();
        if (water < 0) {
            System.out.println("Sorry, not enough water!\n");
            water += coffee.getWater();
            return;
        }

        milk -= coffee.getMilk();
        if (milk < 0) {
            System.out.println("Sorry, not enough milk!\n");
            milk += coffee.getMilk();
            return;
        }

        beans -= coffee.getBeans();
        if (beans < 0) {
            System.out.println("Sorry, not enough coffee beans!\n");
            beans += coffee.getBeans();
            return;
        }

        cups--;
        if (cups < 0) {
            System.out.println("Sorry, not enough disposable cups\n");
            cups++;
            return;
        }

        money += coffee.getPrice();
        System.out.println("I have enough resources, making you a coffee!\n");
    }

    public void addIngredients(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    public void checkout() {
        System.out.printf("I gave you $%d\n", this.money);
        this.money = 0;
    }

    @Override
    public String toString() {
        return String.format("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money""", water, milk, beans, cups, money);
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}
