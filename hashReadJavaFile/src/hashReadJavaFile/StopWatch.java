package hashReadJavaFile;

import java.text.DecimalFormat;

/**
 * 
 * @author Matthew Fischer
 * 
 */
public class StopWatch {

	
	private long startTime;
	private long stopTime;
	private boolean running;
	
	/**
	 * StopWatch class creates object to stores and gets time that elapsed.
	 * @param startTime long time started in milliseconds
	 * @param stopTime long time stopped in milliseconds
	 * @param running boolean is object running
	 */
	public StopWatch() {
		startTime = 0;
		stopTime = 0;
		running = false;
	}
	
	/**
	 * start function stores the time in milliseconds in startTime long variable while time still running
	 */
	public void start() {
	    this.startTime = System.currentTimeMillis();
	    this.running = true;
	}
	
	/**
	 * stop function stores the time in milliseconds in startTime long variable while time stops running
	 */
	public void stop() {
		this.stopTime = System.currentTimeMillis();
	    this.running = false;
	}
	
	
	/**
	 * getElapsedTime funcion returns the time in milliseconds from the start
	 * @return String time in milliseconds from start
	 */
	public Long getElapsedTime() {
		  long elapsed;
		  if (running) {
			  elapsed = (System.currentTimeMillis() - startTime);
		  } 
		  else {
			  elapsed = (stopTime - startTime);
		  }
		  return elapsed;
	  }
	
	/**
	 * toString function returns elapsed time from start to stop in Seconds in String  
	 * return String seconds
	 */
	public String toString() {
		return ("" + this.getElapsedTime() / 1000.0);		
	}
	
	
	 
}