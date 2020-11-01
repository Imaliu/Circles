package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;


public class DataProviders {

    @DataProvider(name = "dt_ValidateUserCanNavigateToLeafCategoryPageAndSeeTheproductsListedInThePage")
   // @Parameters({"dataFilePath"})
    public Object[][] dpTC01() throws IOException {
        Xls_Reader xls_reader = new Xls_Reader();
        //return new Object[][] {{"Electronic Devices", "Laptops" , "2-in-1s","2 In 1 Laptops"}};
        Object[][] data = xls_reader.readCellData("TC01");
        return data;
    }


    @DataProvider(name = "dt_ValidateIfChildCategoriesDisplayedExpected")

    public Object[][] dpTC02() throws IOException {
        Xls_Reader xls_reader = new Xls_Reader();
        Object[][] data = xls_reader.readCellData("TC02");
        return data;
    }

}
