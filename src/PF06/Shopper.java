package PF06;

/*
 * Shopper class represents the different feature of a given shopper. 
 */
public class Shopper {

    private GroceryStore store;
    private int startTime;
    private int endTime;
    private boolean occupied;
    private int timeLeft;
    private Customer customer;

    /*
     * constructor for shopper
     */
    public Shopper(GroceryStore store, int startTime, int endTime) {
      this.store = store;
      this.startTime = startTime;
      this.endTime = endTime;
      this.timeLeft = 1;
      this.occupied = false;
//      this.delivered = false;
    }
    /*
     * shopper's earliest available time for delivering..
     */
    public int getStartTime(){
      return this.startTime;
    }
    /*
     * shopper's latest available time for delivering..
     */
    public int getEndTime(){
      return this.endTime;
    }
    /*
     * shopper's status(if he is in a delivery process)
     */
    public boolean isOccupied(){
      return this.occupied;
    }
    /*
     * change shopper's status when starting the delivery..
     */
    public void startDelivery(Customer customer) {
      this.occupied = true;
      this.customer = customer;
    }
    /*
     * time left for delivery..
     */
    public int getTimeLeft(){
        return this.timeLeft;
    }
    /*
     * customer's products have been delivered..
     */
    public void delivered(){
        this.occupied = false;
        this.timeLeft = 1;
    }

    /*
     * which customer the shopper is serving.. 
     */
    public Customer getCustomer() {
        return this.customer;
    }
    /*
     * the shopper is on the way and will take 2 hours for delivering.. 
     */
    public void approaching(){
        this.timeLeft--;
    }
    /*
     * which store does the shopper represent.. 
     */
    public GroceryStore getGroceryStore() {
        return this.store;
    }
}

