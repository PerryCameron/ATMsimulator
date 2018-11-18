// written by parrish cameron
package atmsimulator;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Schedule a task that executes once every second.
 */

public class AtmTimer {
	Timer timer;
	int time; // holds the time intrval for the simulation (in this case seconds, that represent minutes)
	int customerNumber; // each customer is numbered as they arrive
	int numberOfNewCustomers; // number of customers that arrived
	int numberOfCustomersRemoved; // total number of customers who used the atm
	double waitMinutes = 0;  // total number of minutes people waited
	int minutes;  // used for printing header on statistics
	int atmEmpty;  // holds amount of time atm was empty

	public AtmTimer() {
		timer = new Timer();
		time = 0;
		timer.schedule(new RemindTask(),
				0,        //initial delay
				1*1000);  //subsequent rate
	}

	class RemindTask extends TimerTask {
		int simulationSeconds = 60;  /// this is really a simulation of minutes but who has that time?

		public void run() {
			if (simulationSeconds > 0) {  // do stuff here every second
				System.out.print("--");
				numberOfNewCustomers = Randomizer.getNumberOfNewCustomers();
				time++;  // turn based heart beat
				// add new customers to the Q or not
				for(int i=0; i < numberOfNewCustomers;i++) {
					customerNumber++;
					CustomerQ.enQueue(new Customer(customerNumber, time));
				}
				
				if (CustomerQ.isNotEmpty()) {  // remove a customer or not
					removeCustomer();
				} else {
					atmEmpty += 1;
				}
				
				if(time%10 == 0) {  // give update every 10 "minutes"
					printStatistics();
				}
				simulationSeconds--;
			} else { 
				System.out.println("Time's up!");
				System.exit(0);   //Stops the AWT thread (and everything else)
			}
		}
	}
	
	public void printStatistics() {  // print statistics
		minutes += 10;
		System.out.println(" " + minutes + " minutes ----------------");
		System.out.println("There have been " + customerNumber + " customers that have arrived");
		System.out.println("There have been " + numberOfCustomersRemoved + " customers that have used the ATM");
	    System.out.println("There is " + CustomerQ.countElements() + " customers in line");
	    System.out.println("The ATM has had no line for a total of " + atmEmpty + " minutes");
	    System.out.println("The ATM has had a line for a total of " + (time-atmEmpty) + " minutes");
	    System.out.printf("The average wait time is %.2f minutes \n", (waitMinutes/(double)numberOfCustomersRemoved));
	}
	
	public void removeCustomer() { // remove customer from queue if time is up
		Customer topCustomer = CustomerQ.queue[0];
		int timeLeft = topCustomer.getServiceTime();
		if(timeLeft == 1) {
			CustomerQ.deQueue();
			numberOfCustomersRemoved++;
		} else {
			topCustomer.resetServiceTime(timeLeft-1);
			waitMinutes++;
		}
	}
}