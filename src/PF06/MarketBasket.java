package PF06;

/**
 *Traced MarketBasket class to its parent class
 */
public class MarketBasket extends GroceryStore {
    /**
     * ..
     */
    final int PRICE_THRESHOLD = 30;

    /**
     * constructor
     */
    public MarketBasket(){
        super();
        fillItemMap();
    }

    /**
     * fill into the itemMap
     */
    private void fillItemMap() {
        this.itemMap.put("tomato", new Node(0.60, 10));
        this.itemMap.put("potato", new Node(0.50, 10));
        this.itemMap.put("onion", new Node(0.50, 10));
        this.itemMap.put("coke(6)", new Node(5.99, 10));
        this.itemMap.put("bottled-water(12)", new Node(4.99, 10));
        this.itemMap.put("oil", new Node(3.99, 10));
        this.itemMap.put("apple", new Node(0.60, 10));
        this.itemMap.put("chocolate", new Node(4.99, 10));
        this.itemMap.put("milk", new Node(3.90, 10));
        this.itemMap.put("egg(dozen)", new Node(4.99, 10));
    }

    /**
     *calculate the total price
     * @return
     */
    @Override
    public double receiveOrder() {
        double total_price = super.receiveOrder();
        if (total_price > PRICE_THRESHOLD) {
            total_price *= 0.9;
            System.out.println(("You received 10% discount!"));
        }
        return total_price;
    }
}
