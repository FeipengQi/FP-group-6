package PF06;

import java.util.*;
public class FakestaCart {
    public static final int START_HOUR = 9;
    public static final int END_HOUR = 18;

    public static void main(String[] args) throws IllegalAccessException {
        GroceryStore marketBasket = new MarketBasket();
        GroceryStore cvs = new CVS();
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to FakestaCart. Our store opens from 9:00 to 18:00");
        System.out.println("Our shoppers would accept orders from 9:00 until 16:00.");
        //receive shoppers' registration
        System.out.println("How many shoppers are available today?");
        Shopper[] shoppers = new Shopper[console.nextInt()];
        shopperRegister(shoppers, marketBasket, cvs, console);

        //receive orders from customers
        ArrayList<Customer> customers = new ArrayList<>();
        customerShopping(customers, marketBasket, cvs, console);

        startDelivery(customers, shoppers);

        marketBasket.restock();
        cvs.restock();
    }

    /**
     * record shopper's info
     *
     * @param shoppers     shoppers's list
     * @param marketBasket Market Basket
     * @param cvs          CVS
     * @param console      scanner instance
     */
    public static void shopperRegister(Shopper[] shoppers, GroceryStore marketBasket, GroceryStore cvs, Scanner console) {
        for (int i = 0; i < shoppers.length; i++) {
            System.out.println("Please enter shopper " + (i + 1) +
                    "'s available store (MarketBasket/CVS), starting time, and ending time, with space in b/w: ");
            String store = console.next().trim();
            if (store.equalsIgnoreCase("MarketBasket")) {
                shoppers[i] = new Shopper(marketBasket, console.nextInt(), console.nextInt());
            } else if (store.equalsIgnoreCase("CVS")) {
                shoppers[i] = new Shopper(cvs, console.nextInt(), console.nextInt());
            } else throw new NoSuchElementException();
        }
    }

    /**
     * record customers' info
     * @param customers empty list that will hold every customers' info
     * @param marketBasket Market Basket
     * @param cvs CVS
     * @param console
     */
    public static void customerShopping(ArrayList<Customer> customers, GroceryStore marketBasket, GroceryStore cvs, Scanner console) {
        System.out.println("How many customers are in queue? ");
        int numOfCustomers = console.nextInt();
        System.out.println("Receiving customers order...");
        for (int i = 0; i < numOfCustomers; i++) {
            while (true) {
                System.out.println("Hi, please enter your name, store, and when do you want to start your delivery (9 to 18): ");
                String name = console.next();
                String store = console.next();
                int time_slot = console.nextInt();
                Customer customer;
                double total_price;
                if (store.equalsIgnoreCase("MarketBasket")) {
                    total_price = marketBasket.receiveOrder();
                    customer = new Customer(name, marketBasket, time_slot);
                    customers.add(customer);
                    System.out.printf("total price is : %.2f \n", total_price);
                    System.out.println("Please wait for your delivery.");
                    System.out.println();
                    break;
                } else if (store.equalsIgnoreCase("CVS")) {
                    total_price = cvs.receiveOrder();
                    customer = new Customer(name, cvs, time_slot);
                    customers.add(customer);
                    System.out.printf("total price is : %.2f \n", total_price);
                    System.out.println("Please wait for your delivery.");
                    System.out.println();
                    break;
                } else {
                    System.out.println("Sorry, we only provide service at CVS or MarketBasktet... Please select one of them");
                }
            }
        }
    }

    /**
     * start the delivery of the day
     * @param customers every customers waiting for delivery
     * @param shoppers shoppers in response
     */
    public static void startDelivery(ArrayList<Customer> customers, Shopper[] shoppers) {
        for (int time = START_HOUR; time <= END_HOUR; time++) {
            System.out.println(time + ":00");
            if (customers.size() > 0) {
                for (int i = 0; i < shoppers.length; i++) {
                    Shopper curr_shopper = shoppers[i];
                    // if the shopper is not occupied
                    if (!curr_shopper.isOccupied()) {
                        for (int k = 0; k < customers.size(); k++) {
                            Customer curr_customer = customers.get(k);
                            // if shopper and customer match
                            if (curr_shopper.getGroceryStore().equals(curr_customer.getGroceryStore())) {
                                // within time frame
                                if (curr_customer.getTimeSlot() <= time) {
                                    if (curr_shopper.getStartTime() <= time && curr_customer.getTimeSlot() <= curr_shopper.getEndTime()) {
                                        System.out.println("Shopper" + (i + 1) + " starts delivering the order of " + curr_customer.getName());
                                        curr_shopper.startDelivery(curr_customer);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    // occupied and is delivering
                    else if (curr_shopper.isOccupied() && curr_shopper.getTimeLeft() > 0) {
                        curr_shopper.approaching();
                        System.out.println(curr_shopper.getCustomer().getName() + "'s order is on the way!");
                    }
                    // delivered
                    else if (curr_shopper.isOccupied() && curr_shopper.getTimeLeft() == 0) {
                        Customer current_customer = curr_shopper.getCustomer();
                        System.out.println("Customer " + current_customer.getName().toString() + "'s order is delivered!");
                        if (time == END_HOUR) {
                            System.out.println();
                        } else {
                            System.out.println("Shopper " + (i + 1) + " is available again!");
                        }
                        curr_shopper.delivered();
                        int index = customers.indexOf(current_customer);
                        // remove customer
                        customers.remove(index);
                    }
                }
            }
        }
    }
}