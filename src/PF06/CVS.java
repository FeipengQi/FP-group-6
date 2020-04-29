package FinalProject;

/**
 * 同market basket
 * 有时间可以增加feature比如 multibuy打折
 */
public class CVS extends GroceryStore {


    public CVS() {
        super();
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
     *
     * @return
     */
    @Override
    public double receiveOrder() {
        double total_price = super.receiveOrder();
        if (total_price > PRICE_THRESHOLD) {
            total_price -= 5;
            System.out.println("You received $5 off!");
        }
        return total_price;
    }
}
