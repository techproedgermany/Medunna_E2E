package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtils {

        private static ExtentReports extent;

    // Method for generating dynamic report name
        public static ExtentReports getExtentReportInstance() {
            if (extent == null) {
                // Adding timestamp dynamically to the file name
                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                String reportPath = "test-output/SparkReport/Spark_" + timestamp + ".html";

                // Setting up the ExtentSparkReporter
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
                sparkReporter.config().setReportName("Automation Test Report");

                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);

                // Adding system information to the report
                extent.setSystemInfo("OS", System.getProperty("os.name"));
                extent.setSystemInfo("User", System.getProperty("user.name"));
            }
            return extent;
        }

    // Other utility methods can be added here
        public static void flush() {
            if (extent != null) {
                extent.flush();
            }
        }
}
