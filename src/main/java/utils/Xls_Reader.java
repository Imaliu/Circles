package utils;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Xls_Reader {


       public Object[][] readCellData(String sheetName) throws IOException {

            Object[][] celldata = null;
            int startRow= 1;
            int endRow=0;

            String testDataURL= System.getProperty("user.dir")+"/src/main/java/utils/TestData.xlsx";
            FileInputStream fis = new FileInputStream(testDataURL);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetName);
            int noOfRows = sheet.getLastRowNum();
            int noCols=sheet.getRow(1).getLastCellNum();
            celldata= new Object[noOfRows][noCols];
            int row=0;
                for(int i=startRow;i<=noOfRows;i++,row++){
                   int col=0;
                   for (int j=0;j<noCols;j++,col++){

                       celldata[row][col]= sheet.getRow(i).getCell(j).toString();
                   }
               }

        return celldata;
       }

}
