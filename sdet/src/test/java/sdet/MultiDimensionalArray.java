package sdet;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excel.ExcelUtlities;

public class MultiDimensionalArray {
	
	@Test(dataProvider="testdata")
public void test(String s1,String s2,String s3){
		System.out.println(s1+"****"+s2+"***"+s3);
	}
	
		@DataProvider
		public Object[][] testdata() throws Throwable{
		Object[][] arr=new Object[3][3];
		
		ExcelUtlities ex=new ExcelUtlities();
		
		int row = ex.getrowcount("./Test/testdata.xlsx", "sheet");
		
		
		
		for(int i=0;i<=row;i++){
			for(int j=0;j<=2;j++){
				
				arr[i][j]=ex.excel("./Test/testdata.xlsx", "sheet", i, j);	
				
				}
		}
		return arr;
		//webelements
		}
	}

