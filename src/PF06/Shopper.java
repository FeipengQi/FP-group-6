package PF06;

public class Shopper {
	private GroceryStore store;
    private int startTime;
    private int endTime;
    private boolean occupied;
    private boolean delivered;
    private int timeLeft;
    private Customer customer;

    public Shopper(GroceryStore store, int startTime, int endTime) {
      this.store = store;
      this.startTime = startTime;
      this.endTime = endTime;
      this.timeLeft = 1;
      this.occupied = false;
      this.delivered = false;
    }

    public int getStartTime(){
      return this.startTime;
    }

    public int getEndTime(){
      return this.endTime;
    }

    public boolean isOccupied(){
      return this.occupied;
    }

    public void startDelivery(Customer customer) {
      this.occupied = true;
      this.customer = customer;
    }

    public int getTimeLeft(){
        return this.timeLeft;
    }
    public boolean isDelivered(){
        if (this.timeLeft >= 0){
            return false;
        } else {
            return true;
        }
    }
    public void delivered(){
        this.occupied = false;
        this.timeLeft = 1;
    }


    public Customer getCustomer() {
        return this.customer;
    }

    public void approaching(){
        this.timeLeft--;
    }

    public GroceryStore getGroceryStore() {
        return this.store;
    }
}

