package PF06;
	/*
	 * this class represents different features of a customer.. 
	 */
public class Customer {

	    private String name;
	    private int timeSlot;
	    private GroceryStore store;
	    /*
	     * constructor for customer.. 
	     */
	    public Customer(String name, GroceryStore store, int timeSlot){
	        this.name = name;
	        this.store = store;
	        this.timeSlot = timeSlot;
	    }
	    /*
	     * when does customer want the shopper to deliver his or her product..
	     */
	    public int getTimeSlot(){
	        return this.timeSlot;
	    }
	    /*
	     * which store does the customer want to buy from..
	     */
	    public GroceryStore getGroceryStore(){
	        return this.store;
	    }
	    /*
	     * customer's name..
	     */
	    public String getName(){
	        return this.name;
	    }
	    /*
	     * use equals to remove customer from the customer arraylist when he or she has been served.. 
	     */
	    public boolean equals(Object o) {
	        if (o instanceof Customer) {
	            return ((Customer) o).getName().equals(this.name);
	        }
	        return false;
	    }
}

