import by.gsu.epamlab.bll.factories.DecimalResultFactory;
import by.gsu.epamlab.bll.factories.ResultFactory;

public class RunnerDecimal {
	public static void main(String[] args) {
	
		final String FILE_NAME = "results";
				
		ResultFactory resultFactory = new DecimalResultFactory();
		RunnerLogic.logic(resultFactory, FILE_NAME);
	} 
}
