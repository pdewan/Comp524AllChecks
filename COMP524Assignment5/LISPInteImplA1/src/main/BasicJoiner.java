package main;

import java.util.List;

import main.util.parallel.Joiner;

public class BasicJoiner implements Joiner{
	private int counter;
	private int finished=0;
	private boolean start = false;
	public BasicJoiner(int count) {
		this.counter = count;
	}
	
	public synchronized void finished()
	{
		// "Working" code
		if (checkSandF(false))
		{
			notify();
		}
		
	}
	
	private synchronized boolean checkSandF(boolean isJoiner)
	{
		if (!isJoiner) {
			this.finished++;
			if (start&&finished==counter) {
				return true;
			}
		} else {
			start=true;
			if(finished!=counter) {
				return true;
			}
		}
		return false;
	}
	
	public synchronized void join() {
		// "Working" code
		if (checkSandF(true)) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
