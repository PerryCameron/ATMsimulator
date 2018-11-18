// written by parrish cameron
package atmsimulator;
public class Customer {
	int customerNumber; // the number representing the order the customer came in
	int arrivalTime; // time interval customer arrived
	int serviceTime;  // how long customer stayed at atm
	
	
	public Customer(int customerNumber, int arrivalTime) {
		super();
		this.customerNumber = customerNumber;
		this.arrivalTime = arrivalTime;
		setServiceTime();
	}
	
	@Override
	public String toString() {
		return "[ Cust# = " +customerNumber + " Arrival time = " + arrivalTime + " Service Time = "
				+ serviceTime + " ]";
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime() {
		this.serviceTime = (int )(Math.random() * 3 + 1);
	}
	
	public void resetServiceTime(int newTime) {
		serviceTime = newTime;
	}
}
