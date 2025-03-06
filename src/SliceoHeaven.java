import java.util.Scanner;
public class SliceoHeaven {
    public String storeName, storeAddress, storeEmail, storePhone, storeMenu;
    public String pizzaIngredients;
    public double pizzaPrice;
    public String sides, drinks;
    public String orderID;
    public double orderTotal;

    public String defOrderID = "DEF - SOH - 099";
    public String defPizzaIngredients = "Mozzarella Cheese";
    public double defOrderTotal = 15.00;

    public SliceoHeaven() {
        this.orderID = defOrderID;
        this.pizzaIngredients = defPizzaIngredients;
        this.orderTotal = defOrderTotal;
        this.sides = "";
        this.drinks = "";
    }

    public SliceoHeaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
    }

    public void takeOrder(String id, String ingredients, double total) {
        orderID = id;
        pizzaIngredients = ingredients;
        orderTotal = total;
        System.out.println("Order accepted!");
        System.out.println("Pizza is being prepared");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Something went wrong while making pizza.");
        }
        System.out.println("Pizza is ready for pickup!");
        System.out.println("Your order is ready!");
        printReceipt();
    }

    public void makePizza() {
        System.out.println("Making pizza with ingredients: " + pizzaIngredients);
    }

    public void printReceipt() {
        System.out.println("********RECEIPT********");
        System.out.println("Order ID: " + orderID);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Order Total: " + orderTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SliceoHeaven pizzaShop = new SliceoHeaven();

        System.out.print("Enter order ID: ");
        String orderID = scanner.nextLine();
        System.out.print("Enter pizza ingredients: ");
        String ingredients = scanner.nextLine();
        System.out.print("Enter order total: ");
        double total = scanner.nextDouble();
        scanner.nextLine();

        pizzaShop.takeOrder(orderID, ingredients, total);
        scanner.close();
    }
}