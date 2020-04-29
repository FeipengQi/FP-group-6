package PF06;

/**
 *
 * Traced CVS class to its parent class
 */
public class CVS extends GroceryStore {

    /**
     * constructor
     */
    public CVS() {
        super();
        fillItemMap();
    }

    /**
     * fill into the itemMap
     */
    public void fillItemMap(){
        this.itemMap.put("Allergy-relief-tablets", new Node(4.49, 10));
        this.itemMap.put("First-Aid-Tape", new Node(1.99, 10));
        this.itemMap.put("Toothbrush", new Node(0.99, 10));
        this.itemMap.put("Toothpaste", new Node(4.99, 10));
        this.itemMap.put("Vitamin-D", new Node(7.99, 10));
        this.itemMap.put("Dry-Eye-Relief", new Node(5.49, 10));
        this.itemMap.put("Clear-bandages", new Node(3.99, 10));
        this.itemMap.put("Flosser-Picks", new Node(2.99, 10));
        this.itemMap.put("Muscle-rub", new Node(6.99, 10));
        this.itemMap.put("Hand-sanitizer", new Node(0.99, 10));
    }

    /**
     *calculate the total price
     * @return
     */
    @Override
    public double receiveOrder() {
        double total_price = super.receiveOrder();
        return total_price;
    }
}
