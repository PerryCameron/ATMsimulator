// written by parrish cameron
package atmsimulator;
public class CustomerQ {  // this is the q

	static int Qcapacity = 20;
	static Customer queue[] = new Customer[Qcapacity];
	static int size;
	static int front;
	static int rear;
	
	
	static public void enQueue(Customer data) {  // add customer to queue
		if(isFull()) {
			expand();
		}
		queue[rear] = data;
		rear = (rear + 1);  
		size = size + 1;
	}

	static public Customer deQueue() {  // remove customer from queue
		Customer data = queue[0]; // this is always the front
		Customer[] newQueue = new Customer[Qcapacity];
		for (int i = 0; i < size - 1; i++) {
			newQueue[i] = queue[i + 1];
		}
		rear = rear - 1;
		size = size - 1;
		queue = newQueue;
		return data;
	}
	
	static public void expand() {  // expands queue if need be
		int length = size;
		Qcapacity = Qcapacity * 2;
		// System.out.println("Qcapacity changed to = " + Qcapacity);
		Customer[] newQueue = new Customer[Qcapacity];
		System.arraycopy(queue, 0, newQueue, 0, length);
		queue = newQueue;
	}

	static public void show() {  // shows what is in the queue
		System.out.print("Elements: " );
		for(int i=0;i<size;i++) {
			System.out.print(queue[(front + i)%Qcapacity] + " ");
		}
	}
	
	static public Customer getFront() {  // returns customer at front of list
		return queue[0];
	}
	
	static public Customer getRear() {  // returns the last customer
		return queue[size - 1];
	}
	
	static public int getSize() {  // get size of queue
		return size;
	}
	
	static public boolean isEmpty() {  // is the queue empty?
		return getSize()==0;
	}
	
	static public boolean isNotEmpty() {  // is the queue not empty?
		return getSize()!=0;
	}
	
	static public boolean isFull() {
		return size==Qcapacity;
	}
	
	static public int countElements() {
		int counter = 0;
		for (int i = 0; i < queue.length; i ++)
		    if (queue[i] != null)
		        counter ++;
		return counter;
	}
}
