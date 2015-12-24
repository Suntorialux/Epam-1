package by.gsu.epamlab.bll;

import by.gsu.epamlab.model.Result;

public class Buffer {
	
	private Result result;
	private volatile boolean empty = true;
	private volatile boolean process = true;
			
	public synchronized Result getResult() {
       
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        empty = true;
        
        notifyAll();
        System.out.println("get - > "+ result);
        return result;
    }
	
	public synchronized void setResult (Result result) {
       
        while (!empty) {
            try { 
                wait();
            } catch (InterruptedException e) {}
        }
        
        empty = false;
       
        this.result = result;
        System.out.println("SET -> " + result);
        
        notifyAll();
    }
	
	public void setProcess(Boolean process){
		this.process = process; 
	}
	
	
	
	public boolean getProcess() {
		return process;
	}

	public synchronized boolean hasResult () {
		return empty;
	}
	
	

}
