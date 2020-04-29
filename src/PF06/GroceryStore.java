package PF06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 */
public class GroceryStore {

    /**
     *  items in the store
     */
    Map<String, Node> itemMap;
    final int defaultQuantity = 10;

    /**
     * constructor
     */
    public GroceryStore() {
        this.itemMap = new HashMap<>();
    }

    /**
     * receives order from customer
     * @return total price
     */
    public double receiveOrder() {
        double total_price = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Here are the products in our store: \n" + getItems());
        System.out.println("Please enter the items's name and quantity to add to the order. "
                + "Enter \"quit\" to stop adding items to the list");
        while (in.hasNext()) {
            String itemName = in.next();
            //construct items and add them to the list
            if (!itemName.equals("quit")) {
                int quantity = in.nextInt();
                // if the store has this item
                if (itemMap.containsKey(itemName)) {
                    // the quantity is sufficient to fulfill the customer
                    Node node = itemMap.get(itemName);
                    if (quantity <= node.quantity) {
                        System.out.println("order success");
                        // add to total price
                        total_price += quantity * node.price;
                        node.quantity -= quantity;
                    } else {
                        System.out.println("sorry, the item is insufficient.");
                    }
                } else {
                    System.out.println("Sorry, the item is not available.");
                }
            } else {
                return total_price;
            }
        }
        return total_price;
    }

    /**
     * restock
     */
    public void restock() {
        for (Node node : itemMap.values()) {
            node.quantity = defaultQuantity;
        }
    }

    /**
     * return all the items' name in the store
     */
    public String getItems(){
        String result = "";
        for(String key: itemMap.keySet()){
            result += key.toString() + " " + itemMap.get(key).price + "\n";
        }
        return result;
    }
}

/**
 * quantity/price wrapper class
 */
class Node {
    double price;
    int quantity;

    public Node(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }
}