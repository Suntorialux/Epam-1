package by.gsu.epamlab.bll;

public class ThreadLoader implements Runnable {

	private Buffer bufer;
	private IResultDAO reader;

	
	
	public ThreadLoader(Buffer bufer, IResultDAO reader) {
		this.bufer = bufer;
		this.reader = reader;
	}


	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		while(bufer.hasResult() && bufer.getProcess()) { 	
			
		reader.nextResult(); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
}
