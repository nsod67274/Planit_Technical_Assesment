package reportgenerator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import util.DateUtil;
import util.ReadConfigProperties;



public class ExtentManager {

    public static ExtentSparkReporter sparkReporter;
    
    public static ExtentReports extentReports;

    public static ExtentReports getExtentReport() throws Exception {

        String reportName = System.getProperty("user.dir")+
                "/ExtentReports/ExecutionReport_"+ DateUtil.getTimeStamp()+".html";

        sparkReporter = new ExtentSparkReporter(reportName);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("DocumentTitle");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("ReportName");

        extentReports.setSystemInfo("Executed on Environment: ", ReadConfigProperties.getPropertyValueByKey("url"));
        //extentReports.setSystemInfo("Executed on Browser: ",ReadConfigProperties.getPropertyValueByKey("browser"));
        //extentReports.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        //extentReports.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

        return extentReports;
    }


}
