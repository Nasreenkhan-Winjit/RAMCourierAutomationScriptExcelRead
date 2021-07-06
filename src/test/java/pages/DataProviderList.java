package pages;

import com.codoid.products.exception.FilloException;
import org.testng.annotations.DataProvider;
import utilities.filereading.files.csv.CSVRead;
import utilities.filereading.files.excel.FilloExcelRead;
import utilities.filereading.files.properties.ReadProperties;

public class DataProviderList {

    private ReadProperties readProperties = new ReadProperties();
    private String filePath;

    public DataProviderList() {
        filePath = readProperties.getPropertyValue("DATA_FILES_DEFAULT_DIRECTORY");
    }

    @DataProvider(name = "ValidLogin")
    public Object[][] validLoginCredentials() throws FilloException {
        FilloExcelRead reader = new FilloExcelRead(filePath + "\\excel\\Login\\LoginDetails.xlsx");
        return reader.getDataFromSheet("Valid_Login");
    }

    @DataProvider(name = "consignment")
    public Object[][] consignment() throws FilloException {
        FilloExcelRead reader = new FilloExcelRead(filePath + "\\excel\\Login\\ConsignmentDetails.xlsx");
        return reader.getDataFromSheet(" ConsignmentID");
    }
    @DataProvider(name = "consignmentInbound")
    public Object[][] consignmentInbound() throws FilloException {
        FilloExcelRead reader = new FilloExcelRead(filePath + "\\excel\\Login\\ConsignmentDetails.xlsx");
        return reader.getDataFromSheet(" consignmentInbound");
    }

    @DataProvider(name = "ConsignmentInbound2")
    public Object[][] consignmentInbound2() throws FilloException {
        FilloExcelRead reader = new FilloExcelRead(filePath + "\\excel\\Login\\ConsignmentDetails.xlsx");
        return reader.getDataFromSheet(" ConsignmentInbound2");
    }

    @DataProvider(name = "ConsignmentProd")
    public Object[][] ConsignmentProd() throws FilloException {
        FilloExcelRead reader = new FilloExcelRead(filePath + "\\excel\\Login\\ConsignmentDetails.xlsx");
        return reader.getDataFromSheet(" ConsignmentProd");
    }

    @DataProvider(name = "ConsignmentInbound1Prod")
    public Object[][] ConsignmentInbound1Prod() throws FilloException {
        FilloExcelRead reader = new FilloExcelRead(filePath + "\\excel\\Login\\ConsignmentDetails.xlsx");
        return reader.getDataFromSheet(" ConsignmentInbound1Prod");
    }
    @DataProvider(name = "ConsignmentInbound2Prod")
    public Object[][] ConsignmentInbound2Prod() throws FilloException {
        FilloExcelRead reader = new FilloExcelRead(filePath + "\\excel\\Login\\ConsignmentDetails.xlsx");
        return reader.getDataFromSheet(" ConsignmentInbound2Prod");
    }
    @DataProvider(name = "EditConsignmentUAT")
    public Object[][] EditConsignmentUAT() throws FilloException {
        FilloExcelRead reader = new FilloExcelRead(filePath + "\\excel\\Login\\ConsignmentDetails.xlsx");
        return reader.getDataFromSheet(" EditConsignmentUAT");
    }

//    ConsignmentInbound1Prod

//    ConsignmentInbound2Prod


//    @DataProvider(name = "CSVFile")
//    public Object[][] CSV() throws SQLException {
//        CSVRead csvRead = new CSVRead();
//        return csvRead.getDataFromCSVFile(filePath + "\\csv\\", "LoginCredentialsOpt");
//    }
}
