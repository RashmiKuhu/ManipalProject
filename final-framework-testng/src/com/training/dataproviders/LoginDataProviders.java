package com.training.dataproviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

private  Properties properties;


 	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData() throws IOException{

		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		 properties.load(inStream);
		String xlsFile =properties.getProperty("excelfile1");
		String  xlssheet =properties.getProperty("sheet");
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData(xlsFile, xlssheet); 
	}
	@DataProvider(name = "xls-newuser")
	public Object[][] getXLSDataNewUser() throws IOException{

		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		String xlsFile =properties.getProperty("excelfile1");
		String  xlssheet =properties.getProperty("sheet2");
		// ensure you will have the title as first line in the file 

		return new ReadExcel().getExcelData(xlsFile, xlssheet); 
	}
	@DataProvider(name = "xls-Login")
	public Object[][] getXLSDataLogin() throws IOException{

		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		// ensure you will have the title as first line in the file 
		
		return new ReadExcel().getExcelData(properties.getProperty("excelfile1"), properties.getProperty("sheet1")); 
	}
	
	@DataProvider(name = "addCategory")
	public  Object[][] getXLSDataLogintest() throws IOException{

		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData(properties.getProperty("excelfile1"), properties.getProperty("sheet3")); 
	}
	
	@DataProvider(name = "invalidUser")
	public  Object[][] getXLSDataInvalidUser() throws IOException{

		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData(properties.getProperty("excelfile1"), properties.getProperty("sheet4")); 
	}
	
	
}
