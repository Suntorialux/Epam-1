import by.gsu.epamlab.bll.factories.ResultFactory;

public class RunnerInt {

	public static void main(String[] args) {
		final String FILE_NAME = "results";	
		
		ResultFactory resultFactory = new ResultFactory();
		RunnerLogic.logic(resultFactory, FILE_NAME);

	}

}
