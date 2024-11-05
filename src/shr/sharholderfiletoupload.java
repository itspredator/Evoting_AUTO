package shr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.ibm.db2.jcc.am.el;

import service.DatabaseServiceImpl;
import service.Details;

public class sharholderfiletoupload extends DatabaseServiceImpl {

	static String header, even;
	static Details details;
	static List<String> dataHolder = new ArrayList<>();

	public sharholderfiletoupload() throws ClassNotFoundException, SQLException {
		super();
	}

	public static void filereadutility(String evenNo) throws IOException, ClassNotFoundException, SQLException {

		int batchId = 0;
		boolean status = true;
		DatabaseServiceImpl databaseServiceImpl = new DatabaseServiceImpl();
		details = databaseServiceImpl.getDetails(evenNo);
		
		
		System.out.println(sharholderfiletoupload.class);
		
		
		if (new File("D:\\filetoupload\\output.zip").exists()){
			new File("D:\\filetoupload\\output.zip").delete();
		}

		File[] files = new File("D:\\filetoupload\\").listFiles();


		while (status) {
			batchId = generateBatchId();
			if (databaseServiceImpl.isExists(String.valueOf(batchId)) == 0) {
				status = false;
			}
		}

		try {
			// read File
			readFile(files[0].getAbsolutePath());

			header = batchId + "^" + "11" + "^" + details.getEDT_ENTITY_ID() + "^" + details.getEDT_EV_ISIN() + "^"
					+ details.getEDT_RECORD_DT().replaceAll("-", "") + "^"
					+ String.valueOf(Math.abs(dataHolder.size() - 1)) + "^" + details.getEDT_EV_ID();

			// write File
			writeFile(files[0].getAbsolutePath(), header, batchId);

			// zip file
			zipFile(files);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void zipFile(File[] files) throws IOException {
			System.out.print("zipFile");
			String sourceFile = files[0].getPath();
	        FileOutputStream fos = new FileOutputStream("D:\\filetoupload\\output.zip");
	        ZipOutputStream zipOut = new ZipOutputStream(fos);

	        File fileToZip = new File(sourceFile);
	        FileInputStream fis = new FileInputStream(fileToZip);
	        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
	        zipOut.putNextEntry(zipEntry);

	        byte[] bytes = new byte[1024];
	        int length;
	        while((length = fis.read(bytes)) >= 0) {
	            zipOut.write(bytes, 0, length);
	        }

	        zipOut.close();
	        fis.close();
	        fos.close();
		
	}

	private static void writeFile(String file, String hearder, int batchId) throws IOException {
		BufferedWriter br = new BufferedWriter(new FileWriter(new File(file)));
		System.out.print("writeFile");
		br.write("{}");
		br.write(System.lineSeparator());
		br.write(header);
		br.write(System.lineSeparator());

		System.out.println(dataHolder.toString());
		System.out.println(dataHolder.size());

		for (int i = 0; i < dataHolder.size(); i++) {

			if (i < dataHolder.size() - 1) {
				br.write(batchId + dataHolder.get(i));
				br.write(System.lineSeparator());
			} else {
				br.write(dataHolder.get(i));
			}
		}

		br.close();
		dataHolder.clear();

	}

	private static void readFile(String file) throws IOException {

		String line, header;
		System.out.print("readFile");
		// Step 1: Open the file
		BufferedReader reader = new BufferedReader(new FileReader(new File(file)));

		// Step 2: Read the file line by line
		line = reader.readLine();
		line = reader.readLine();

		while ((line = reader.readLine()) != null) {

			if (line.length() > 2) {
				dataHolder.add(line.substring(7, line.length()));
			} else {
				dataHolder.add(line);
			}

		}

		reader.close();

	}

	private static int generateBatchId() {

		Random random = new Random();
		return 1000000 + random.nextInt(9000000);
	}



}
