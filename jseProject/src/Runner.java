import java.io.FileNotFoundException;

import by.gsu.epamlab.bll.IResultDAO;
import by.gsu.epamlab.bll.ResultCsvReader;

public class Runner {

	public static void main(String[] args) {
		IResultDAO ir = null;
		try {
			ir = new ResultCsvReader("src/in.csv");
			while (ir.hasResult()){
				System.out.println(ir.nextResult());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ir.closeReader();
		}

	}

}
