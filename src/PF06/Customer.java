package PF06;

public class Customer {

	    private String name;
	    private int timeSlot;
	    private GroceryStore store;

	    public Customer(String name, GroceryStore store, int timeSlot){
	        this.name = name;
	        this.store = store;
	        this.timeSlot = timeSlot;
	    }

	    public int getTimeSlot(){
	        return this.timeSlot;
	    }

	    public GroceryStore getGroceryStore(){
	        return this.store;
	    }

	    public String getName(){
	        return this.name;
	    }

	    public boolean equals(Object o) {
	        if (o instanceof Customer) {
	            return ((Customer) o).getName().equals(this.name);
	        }
	        return false;
	    }
}

