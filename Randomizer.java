// written by parrish cameron
package atmsimulator;
//During any minute:


public class Randomizer {
	static int randomNumber;
	
	static public void getRandomNumber() {
		randomNumber = (int )(Math.random() * 10 + 1);
	}
	
	static public int getNumberOfNewCustomers() {	// for easy readablity	
	getRandomNumber();
	int numberOfCustomers = 0;
		switch (randomNumber) {   
        case 1:  numberOfCustomers = 0;  //    No customer arrive (50% chance)
                 break;
        case 2:  numberOfCustomers = 0;  //    No customer arrive (50% chance)
                 break;
        case 3:  numberOfCustomers = 0;  //    No customer arrive (50% chance)
                 break;
        case 4:  numberOfCustomers = 0;  //    No customer arrive (50% chance)
                 break;
        case 5:  numberOfCustomers = 0;  //    No customer arrive (50% chance)
                 break;
        case 6:  numberOfCustomers = 1;  //   one customer arrives (40% chance)
                 break;
        case 7:  numberOfCustomers = 1;  //   one customer arrives (40% chance)
                 break;
        case 8:  numberOfCustomers = 1;  //   one customer arrives (40% chance)
                 break;
        case 9:  numberOfCustomers = 1;  //   one customer arrives (40% chance)
                 break;
        case 10: numberOfCustomers = 2;  //   two customers arrive (10% chance)
                 break;
		}	
		return numberOfCustomers;
	}

}
