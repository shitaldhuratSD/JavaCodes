package com.tyss.JavaFileHandling;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> list = ExcelRead.readExcelFile();
		ExcelRead.writeExcel(list);
	}

	
}
