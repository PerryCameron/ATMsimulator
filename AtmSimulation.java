// written by parrish cameron
// this simulation is sped up so that 60 seconds simulates 60 minutes

package atmsimulator;
public class AtmSimulation {
	static int totalNumberOfCustomers;
	static int finishedNumberOfCustomers;
	
	
    public static void main(String args[]) {   // launch point
	System.out.println("Starting ATM simulation.");
        new AtmTimer();
    }

}


