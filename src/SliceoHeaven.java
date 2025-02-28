public class SliceoHeaven {
    public String storeName, storeAddress, storeEmail, storePhone, storeMenu; 
    public String pizzaIngredients;
    public double pizzaPrice;
    public String sides, drinks;
    private String orderID;
    private double orderTotal;
    private static final String DEF_ORDER_ID = "DEF - SOH - 099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;

    public SliceoHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    public SliceoHeaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
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
        } catch (InterruptedException e) {
            System.out.println("Pizza is ready for pickup!");
        }
        System.out.println("Your order is ready!");
        printReceipt();
    }

    public void makePizza() {
        System.out.println("Making pizza with ingredients: " + pizzaIngredients);
    }

    private void printReceipt() {
        System.out.println("********RECEIPT********");
        System.out.println("Order ID: " + orderID);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Order Total: " + orderTotal);
    }
}
  