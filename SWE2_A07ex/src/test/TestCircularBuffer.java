package test;

public class TestCircularBuffer {

	public static void main(String[] args) {
		TestCircularBuffer t = new TestCircularBuffer();
	  }

	  public TestCircularBuffer() {
	    CircularBuffer c = new CircularBuffer(3);

	    System.out.println("Storing: 1");
	    c.store(1);
	    System.out.println("Reading: " + c.read());
	    System.out.println("Storing: 2");
	    c.store(2);
	    System.out.println("Storing: 3");
	    c.store(3);
	    System.out.println("Storing: 4");
	    c.store(4);
	    System.out.println("Reading: " + c.read());
	    System.out.println("Reading: " + c.read());
	    System.out.println("Storing: 8");
	    c.store(8);
	    System.out.println("Storing: 9");
	    c.store(9);
	    System.out.println("Storing: 10");
	    c.store(10);
	    System.out.println("Storing: 11");
	    c.store(11);
	    System.out.println("Storing: 12");
	    c.store(12);
	    System.out.println("Reading: " + c.read());
	    System.out.println("Reading: " + c.read());
	    System.out.println("Reading: " + c.read());
	    System.out.println("Reading: " + c.read());
	    System.out.println("Reading: " + c.read());
	    System.out.println("Reading: " + c.read());
	    System.out.println("Reading: " + c.read());
	    System.out.println("Reading: " + c.read());
	  }
	}

	class CircularBuffer {
	  private Integer data[];
	  private int nextFull;
	  private int nextFree;

	  public CircularBuffer(Integer number) { //size
	    data = new Integer[number];
	    nextFull = 0;
	    nextFree = 0;
	  }

	  public boolean store(Integer value) { // s
	    if (!bufferFull()) {
	      data[nextFree++] = value;
	      if (nextFree == data.length) {
	        nextFree = 0;
	      }
	      return true;
	    } else {
	      return false;
	    }
	  }

	  public Integer read() {
	    if (nextFull != nextFree) {
	      int value = data[nextFull++];
	      if (nextFull == data.length) {
	        nextFull = 0;
	      }
	      return value;
	    } else {
	      return null;
	    }
	  }

	  private boolean bufferFull() {
	    if (nextFree + 1 == nextFull) {
	      return true;
	    }
	    if (nextFree == (data.length - 1) && nextFull == 0) {
	      return true;
	    }
	    return false;
	  }
	}