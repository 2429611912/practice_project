import java.util.Scanner;

enum PizzaSelection {
    PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
    HAWAIIAN("Hawaiian", "Pineapple, ham, and extra cheese", 22),
    VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
    BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
    EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);

    private final String pizzaName;
    private final String pizzaToppings;
    private final int price;

    PizzaSelection(String pizzaName, String pizzaToppings, int price) {
        this.pizzaName = pizzaName;
        this.pizzaToppings = pizzaToppings;
        this.price = price;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getPizzaToppings() {
        return pizzaToppings;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return pizzaName + " Pizza with " + pizzaToppings + ", for €" + price;
    }
}

enum PizzaToppings {
    HAM("Ham", 2),
    PEPPERONI("Pepperoni", 2),
    BEEF("Beef", 2),
    CHICKEN("Chicken", 2),
    SAUSAGE("Sausage", 2),
    PINEAPPLE("Pineapple", 1),
    ONION("Onion", 0.5),
    TOMATOES("Tomatoes", 0.4),
    GREEN_PEPPER("Green Pepper", 0.5),
    BLACK_OLIVES("Black Olives", 0.5),
    SPINACH("Spinach", 0.5),
    CHEDDAR_CHEESE("Cheddar Cheese", 0.8),
    MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8),
    FETA_CHEESE("Feta Cheese", 1),
    PARMESAN_CHEESE("Parmesan Cheese", 1);

    private final String topping;
    private final double toppingPrice;

    PizzaToppings(String topping, double toppingPrice) {
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }

    public String getTopping() {
        return topping;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    @Override
    public String toString() {
        return topping + " (€" + toppingPrice + ")";
    }
}

enum PizzaSize {
    LARGE("Large", 10),
    MEDIUM("Medium", 5),
    SMALL("Small", 0);

    private final String pizzaSize;
    private final int addToPizzaPrice;

    PizzaSize(String pizzaSize, int addToPizzaPrice) {
        this.pizzaSize = pizzaSize;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public int getAddToPizzaPrice() {
        return addToPizzaPrice;
    }

    @Override
    public String toString() {
        return pizzaSize + " (€" + addToPizzaPrice + ")";
    }
}

enum SideDish {
    CALZONE("Calzone", 15),
    CHICKEN_PUFF("Chicken Puff", 20),
    MUFFIN("Muffin", 12),
    NOTHING("No side dish", 0);

    private final String sideDishName;
    private final int addToPizzaPrice;

    SideDish(String sideDishName, int addToPizzaPrice) {
        this.sideDishName = sideDishName;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getSideDishName() {
        return sideDishName;
    }

    public int getAddToPizzaPrice() {
        return addToPizzaPrice;
    }

    @Override
    public String toString() {
        return sideDishName + " (€" + addToPizzaPrice + ")";
    }
}

enum Drinks {
    COCA_COLA("Coca Cola", 8),
    COCOA_DRINK("Cocoa Drink", 10),
    NOTHING("No drinks", 0);

    private final String drinkName;
    private final int addToPizzaPrice;

    Drinks(String drinkName, int addToPizzaPrice) {
        this.drinkName = drinkName;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getAddToPizzaPrice() {
        return addToPizzaPrice;
    }

    @Override
    public String toString() {
        return drinkName + " (€" + addToPizzaPrice + ")";
    }
}

public class PizzaOrderSystem {
    private static final double PIZZA_BASE_PRICE = 10.0;
    private static final String[] pizzasOrdered = new String[10];
    private static final String[] pizzaSizesOrdered = new String[10];
    private static final String[] sideDishesOrdered = new String[20];
    private static final String[] drinksOrdered = new String[20];
    private static int pizzaIndex = 0;
    private static int sideDishIndex = 0;
    private static int drinkIndex = 0;
    private static double totalOrderPrice = 0;

    public static void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here’s what we serve:");
            PizzaSelection[] pizzaSelections = PizzaSelection.values();
            for (int i = 0; i < pizzaSelections.length; i++) {
                System.out.println((i + 1) + ". " + pizzaSelections[i]);
            }
            System.out.println((pizzaSelections.length + 1) + ". Custom Pizza with a maximum of 10 toppings that you choose");
            System.out.print("Please enter your choice (1 - " + (pizzaSelections.length + 1) + "): ");
            int pizzaChoice = scanner.nextInt();

            if (pizzaChoice >= 1 && pizzaChoice <= pizzaSelections.length) {
                PizzaSelection selectedPizza = pizzaSelections[pizzaChoice - 1];
                pizzasOrdered[pizzaIndex] = selectedPizza.toString();
                totalOrderPrice += selectedPizza.getPrice();
            } else if (pizzaChoice == pizzaSelections.length + 1) {
                System.out.println("Available toppings:");
                PizzaToppings[] toppings = PizzaToppings.values();
                for (int i = 0; i < toppings.length; i++) {
                    System.out.println((i + 1) + ". " + toppings[i]);
                }
                double customPizzaPrice = PIZZA_BASE_PRICE;
                StringBuilder customPizzaToppings = new StringBuilder();
                System.out.print("Enter the number of toppings you want (max 10): ");
                int numToppings = scanner.nextInt();
                if (numToppings > 10 || numToppings < 1) {
                    System.out.println("Invalid number of toppings.");
                    continue;
                }
                for (int i = 0; i < numToppings; i++) {
                    System.out.print("Enter topping choice (1 - " + toppings.length + "): ");
                    int toppingChoice = scanner.nextInt();
                    PizzaToppings selectedTopping = toppings[toppingChoice - 1];
                    customPizzaToppings.append(selectedTopping.getTopping()).append(", ");
                    customPizzaPrice += selectedTopping.getToppingPrice();
                }
                customPizzaToppings.setLength(customPizzaToppings.length() - 2);
                String customPizzaDescription = "Custom Pizza with " + customPizzaToppings + ", for €" + customPizzaPrice;
                pizzasOrdered[pizzaIndex] = customPizzaDescription;
                totalOrderPrice += customPizzaPrice;
            } else {
                System.out.println("Invalid pizza choice.");
                continue;
            }
            pizzaIndex++;

            System.out.println("Choose a pizza size:");
            PizzaSize[] sizes = PizzaSize.values();
            for (int i = 0; i < sizes.length; i++) {
                System.out.println((i + 1) + ". " + sizes[i]);
            }
            System.out.print("Enter your size choice (1 - " + sizes.length + "): ");
            int sizeChoice = scanner.nextInt();
            PizzaSize selectedSize = sizes[sizeChoice - 1];
            pizzaSizesOrdered[pizzaIndex - 1] = selectedSize.getPizzaSize();
            totalOrderPrice += selectedSize.getAddToPizzaPrice();

            System.out.println("Choose a side dish:");
            SideDish[] sideDishes = SideDish.values();
            for (int i = 0; i < sideDishes.length; i++) {
                System.out.println((i + 1) + ". " + sideDishes[i]);
            }
            System.out.print("Enter your side dish choice (1 - " + sideDishes.length + "): ");
            int sideDishChoice = scanner.nextInt();
            SideDish selectedSideDish = sideDishes[sideDishChoice - 1];
            sideDishesOrdered[sideDishIndex] = selectedSideDish.getSideDishName();
            totalOrderPrice += selectedSideDish.getAddToPizzaPrice();
            sideDishIndex++;

            System.out.println("Choose a drink:");
            Drinks[] drinks = Drinks.values();
            for (int i = 0; i < drinks.length; i++) {
                System.out.println((i + 1) + ". " + drinks[i]);
            }
            System.out.print("Enter your drink choice (1 - " + drinks.length + "): ");
            int drinkChoice = scanner.nextInt();
            Drinks selectedDrink = drinks[drinkChoice - 1];
            drinksOrdered[drinkIndex] = selectedDrink.getDrinkName();
            totalOrderPrice += selectedDrink.getAddToPizzaPrice();
            drinkIndex++;

            System.out.print("Do you want to order more? (yes/no): ");
            String continueOrder = scanner.next();
            if (!continueOrder.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Thank you for dining with Slice-o-Heaven Pizzeria. Your order details are as follows:\n");
        for (int i = 0; i < pizzaIndex; i++) {
            orderDetails.append((i + 1)).append(". ").append(pizzasOrdered[i]).append("\n");
            if (i < pizzaSizesOrdered.length && pizzaSizesOrdered[i] != null) {
                orderDetails.append("   ").append(pizzaSizesOrdered[i]).append(": €").append(PizzaSize.valueOf(pizzaSizesOrdered[i]).getAddToPizzaPrice()).append("\n");
            }
            if (i < sideDishesOrdered.length && sideDishesOrdered[i] != null) {
                orderDetails.append("   ").append(sideDishesOrdered[i]).append(": €").append(SideDish.valueOf(sideDishesOrdered[i]).getAddToPizzaPrice()).append("\n");
            }
            if (i < drinksOrdered.length && drinksOrdered[i] != null) {
                orderDetails.append("   ").append(drinksOrdered[i]).append(": €").append(Drinks.valueOf(drinksOrdered[i]).getAddToPizzaPrice()).append("\n");
            }
        }
        orderDetails.append("ORDER TOTAL: €").append(totalOrderPrice);
        return orderDetails.toString();
    }

    public static void main(String[] args) {
        takeOrder();
        PizzaOrderSystem orderSystem = new PizzaOrderSystem();
        System.out.println(orderSystem);
    }
}    