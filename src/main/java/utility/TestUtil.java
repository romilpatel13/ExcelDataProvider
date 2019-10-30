package utility;

import java.util.ArrayList;

import JavaSessions.Xls_Reader;

public class TestUtil {

	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getData(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try{
			
			reader = new Xls_Reader("C:/Users/Shiv/Desktop/QA Test/DataDriven/src/main/java/com/data/Data.xlsx");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int rowNo = 2; rowNo<=reader.getRowCount("Data");rowNo++){
			
			String email = reader.getCellData("Data", "email", rowNo);
			String pass = reader.getCellData("Data", "pass", rowNo);
			
			Object ob[] = {email, pass};
			myData.add(ob);
			
		}
		return myData;
		
		
	}
}
