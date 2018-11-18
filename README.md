# ATMsimulator
A C211 project that simulates customers coming to and from an ATM.  Uses Timer() to be turnbased.
Purpose
-------------------------------------------------------------------------------------
This assignment will allow you to practice the implementation of data structure.
Tasks

For this assignment, you will consider a Queue. During the lunch hour, the ATM machine in a large office complex is in heavy demand. Customers complain that the waiting time is much too long. The local bank considering the addition of a second ATM machine. But first, the bank needs a few statistics to justify the cost of adding a second ATM machine. Using a Queue, simulate a waiting line at the ATM machine for a period of one hour. Make the following assumptions:

    With equal probability, a customer spends;
        one minute, two minutes, or three minutes at the ATM machine
    During any minute:
        No customer arrive (50% chance)
        one customer arrives (40% chance)
        two customers arrive (10% chance)

At the end of an hour; display the following summary statistics;

    the number of customers served, that is the number of people who accessed the ATM machine
    the average time that a customer waits in the line before being served, and
    the number of customers that remain in the waiting line at the end of the simulation

Assume that the ATM is available when the simulation begins and that no customers are waiting.

Design a class that models an ATM customer

    A customer knows arrival time and how much time he/she spend making an ATM transaction
        Customer class should have the following methods
            setArrivalTime()
            setServiceTime()

The algorithm that simulates an ATM waiting line uses a loop that ticks through a 60min simulation

    Determine the number of new customers 0,1,2, for each customer
        place the customer in a queue
    If there are customers waiting and the ATM is available
        remove a customer from the queue
        increment the number of customers served
        add to the total waiting time of the customer
        update the time the ATM is next available
    Print the summary statistics
