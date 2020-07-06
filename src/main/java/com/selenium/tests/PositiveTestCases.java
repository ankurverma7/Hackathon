package com.selenium.tests;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.selenium.pages.BasePage;


public class PositiveTestCases extends BasePage {

	
	Workbook workbook=null;
	@Test
	public void test1() throws IOException {

		invokeBrowser("Chrome");
		openURL("websiteURL");
		System.out.println("driver=" +Driver);
		String file= System.getProperty("user.dir") + "\\data.xlsx";
		FileInputStream fis= new FileInputStream(file);
		try {
			new WorkbookFactory();
			workbook = WorkbookFactory.create(new FileInputStream(new File(file)));
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheet= workbook.getSheet("data");
		Driver.findElement(By.xpath("//*[@id=\'search\']")).sendKeys(sheet.getRow(0).getCell(0).getStringCellValue() + Keys.ENTER);
		String searchitem = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(searchitem);
		
		//quitBrowser();

	}
}