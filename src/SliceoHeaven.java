public class SliceoHeaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public String storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public double pizzaPrice;
    public String sides;
    public String drinks;
    public String orderID;
    public double orderTotal;
    public void takeOrder(String id, String ingredients, double total) {
        orderID = id;
        pizzaIngredients = ingredients;
        orderTotal = total;
        System.out.println("Order accepted!");
        System.out.println("Pizza is being prepared");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Pizza is ready for pickup!");
        }
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
}