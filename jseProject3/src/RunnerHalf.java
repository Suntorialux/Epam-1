import by.gsu.epamlab.bll.factories.HalfResultFactoty;
import by.gsu.epamlab.bll.factories.ResultFactory;

public class RunnerHalf {

	public static void main(String[] args) {
		final String FILE_NAME = "results";
		
		ResultFactory resultFactory = new HalfResultFactoty();
		RunnerLogic.logic(resultFactory, FILE_NAME);

	}

}
