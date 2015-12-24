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
		
		while(bufer.hasResult() && bufer.getProcess()) { 	
				
		reader.nextResult(); 

		
		}
		
	}
}
