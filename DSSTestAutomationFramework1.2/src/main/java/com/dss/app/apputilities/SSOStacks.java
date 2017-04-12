package com.dss.app.apputilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SSOStacks {
		
	public static Stack loadSSOStack(String Stack_Name) throws IOException {
		Stack stack = new Stack();
		File file = new File(GlobalValues.GLOBAL_STACK_TEST_DATA_SHEET);
		FileInputStream inputstream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet(Stack_Name);
		Iterator<Row> RowIterate = sheet.iterator();
		while (RowIterate.hasNext()) {
			Row nextRow = RowIterate.next();
			Iterator<org.apache.poi.ss.usermodel.Cell> cellIterate = nextRow.iterator();
			List<String> testCredentialFromSheet = new ArrayList<String>();
			while (cellIterate.hasNext()) {
			Cell nextCell = cellIterate.next();
				testCredentialFromSheet.add(nextCell.getStringCellValue());

			}

			stack.push(testCredentialFromSheet);

		}

		return stack;
	}
	
	public static boolean IsStackEmpty(Stack stack){
		
		boolean stackStatus= false;
		
		 if(stack.size()<=1)
			{
			stackStatus= true;
			}
		
		return stackStatus;
	}
	
	
	public static ArrayList<String> getIDFromStack(Stack SSOStack){
		ArrayList<String> temp = null;
		if(!IsStackEmpty(SSOStack)){
		temp= (ArrayList<String>) SSOStack.pop();
		}
		else
		{
			System.out.println("Stack is empty");
		}
			
		return temp;
		
	}
	
		
	public static void addIDToStack(String emailId, String Password, Stack currentStack ) throws IOException{
		
		ArrayList<String> usercredential = new ArrayList<String>();
		usercredential.add(emailId);
		usercredential.add(Password);
		currentStack.push(usercredential);
		
		
	}


}
