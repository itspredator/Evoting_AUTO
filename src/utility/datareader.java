package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import shr.Evencreation;

public class datareader {


	public static java.util.List<Evencreation> readExcel(String filePath, String fileName) throws IOException 
	{
		
		java.util.List<Evencreation> list = new ArrayList<>();
		
		Evencreation evencreation = null;
		FileInputStream file = new FileInputStream(new File(filePath + "//" + fileName));
		Workbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows() - 1;

		System.out.println(rowCount);
		DataFormatter df=new DataFormatter();
		for (int i = 1; i <= rowCount; i++) 
		{
			evencreation =  new Evencreation();
		
			XSSFRow row = sheet.getRow(i);
			if (row != null) 
			{
				int cellCount = row.getPhysicalNumberOfCells();
				System.out.println(cellCount);
				for (int j = 0; j < cellCount; j++) 
				{
					XSSFCell cell = row.getCell(j);

					if (cell != null)
					{
//						
						df.formatCellValue(cell);
						//System.out.println(value);
						
						switch (j) 
						{
						case 0:
							evencreation.setISIN(df.formatCellValue(cell));
							break;
						case 1:
							evencreation.setVoting_Start_Date(df.formatCellValue(cell));
							break;
						case 2:
							evencreation.setGeneral_Meeting_Date(df.formatCellValue(cell));
							break;
						case 3:
							evencreation.setLast_date_dispatch(df.formatCellValue(cell));
							break;
						case 4:
							evencreation.setVoting_End_Date(df.formatCellValue(cell));
							break;
						case 5:
							evencreation.setVoting_Result_Date(df.formatCellValue(cell));
							break;
						case 6:
							evencreation.setCut_Off_Date(df.formatCellValue(cell));
							break;
						case 7:
							evencreation.setEvoting_Start_Time(df.formatCellValue(cell));
							break;
						case 8:
							evencreation.setGeneral_Meeting_Start_Time(df.formatCellValue(cell));
							break;
						case 9:
							evencreation.setEvoting_End_Time(df.formatCellValue(cell));
							break;
						default:
							System.out.println("datatype not specified");
							
							
						}
					}

				}

			}
			
			list.add(evencreation);

		}
		
		System.out.println(evencreation.toString());
		workbook.close();	
		file.close();
		return list;
		

	}

}
	

	
