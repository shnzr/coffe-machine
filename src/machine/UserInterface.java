package machine;

import java.util.Scanner;

public class UserInterface {
    private CoffeeMachine machine;
    private Scanner scanner;
    private Coffee espresso;
    private Coffee latte;
    private Coffee cappuccino;

    public UserInterface() {
        this.machine = new CoffeeMachine(400, 540, 120, 9, 550);
        this.scanner = new Scanner(System.in);
        espresso = new Coffee(250,0,16,4);
        latte = new Coffee(350,75,20,7);
        cappuccino = new Coffee(200,100,12,6);
    }

    public void start() {
        inputLoop: while(true) {
            System.out.print("\nWrite action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();

            switch (action) {
                case "buy" -> buy();
                case "fill" -> fill();
                case "take" -> take();
                case "remaining" -> System.out.println("\n" + machine + "\n");
                case "exit" -> {
                    break inputLoop;
                }
            }
        }
    }

    private int ask(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private void buy() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String option = scanner.nextLine();

        switch (option) {
            case "back" -> {
                return;
            }
            case "1" -> machine.sell(espresso);
            case "2" -> machine.sell(latte);
            case "3" -> machine.sell(cappuccino);
        }
    }

    private void fill() {
        int water = ask("Write how many ml of water you want to add: ");
        int milk = ask("Write how many ml of milk you want to add: ");
        int beans = ask("Write how many grams of coffee beans you want to add: ");
        int cups = ask("Write how many disposable cups you want to add: ");

        machine.addIngredients(water, milk, beans, cups);
    }

    private void take() {
        machine.checkout();
    }
}
