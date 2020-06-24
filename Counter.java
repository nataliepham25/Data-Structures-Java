/*
 * Natalie Pham 
 * Counter Class
 * This class implements a counter that will roll over to 
 * the initial value when it hits the max value
 */
public class Counter {
	 // private data fields
    private int minValue;
    private int maxValue;
    private int counter;
    private boolean rolledOver;
	
	/*the default constructor
	 * min is 0 and max is largest
	 * possible integer
	 */
    
    public Counter(){
        // ADD CODE FOR THE CONSTRUCTOR
        minValue = 0;
        maxValue = Integer.MAX_VALUE;
        counter = 0;
        rolledOver = false;
    }
    /*
     * the alternate constructor for objects of class Counter. 
     * the minimum and maximum values are given as parameters.
     * the counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     */

    public Counter(int min, int max){
        // ADD CODE FOR THE ALTERNATE CONSTRUCTOR
        if(min >= max){
            throw new CounterInitializationException("Min value must be less than max value");
        minValue = min;
        maxValue = max;
        counter = min;
        rolledOver = false;
        }
    }
    /*
     * determine if two counters are in the same state
     * @param otherObject the object to test against for equality
     * @return true if the objects are in the same state
     */

    public boolean equals(Object otherObject) {
        boolean result = false;
        if (otherObject instanceof Counter){
            Counter other = (Counter) otherObject;
            if(other.rolledOver == this.rolledOver && this.counter == other.counter
                    && this.minValue == other.minValue && this.maxValue == other.maxValue){
                result = true;
            }
        }
        return result;
    }
    
    /*
     * This function increases the counter by one
     */

    public void increase(){
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER
        if(counter +1 > this.maxValue){
            counter = this.minValue;
            this.rolledOver = true;
        }
        else{
            counter += 1;
            this.rolledOver = false;
        }
    }

    /*
     * Decreases the counter by one
     */
    public void decrease(){
        // ADD CODE TO DECREASE THE VALUE OF THE COUNTER
        if(counter - 1 < this.minValue){
            counter = this.maxValue;
            this.rolledOver = true;
        }
        else{
            counter -= 1;
            this.rolledOver = false;
        }
    }

    /*
     * Get the value of the counter
     * @return the current value of the counter
     */

    public int value(){
        // CHANGE THE RETURN TO GIVE THE CURRENT VALUE OF THE COUNTER
        return counter;
    }

    /*
     * The accessor that allows the client to determine if the counter
     * rolled over on the last count
     * @return true if the counter rolled over
     */

    public boolean rolledOver() {
        // CHANGE THE RETURN TO THE ROLLOVER STATUS OF THE COUNTER
        return this.rolledOver;
    }

    /*
     * Override the toString method to provide a more informative
     * description of the counter
     * @return a descriptive string about the object
     */

    public String toString(){
        // CHANGE THE RETURN TO A DESCRIPTION OF THE COUNTER
        return "Counter Value: " + counter + "\n" + 
                "Min Value: " + this.minValue + "\n" +
                "Max Value: " + this.maxValue + "\n" +
                "Rolled Over: " + this.rolledOver;
    }
}
