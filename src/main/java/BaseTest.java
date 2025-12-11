package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utilities.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest logger;
    protected static ExtentSparkReporter spark;

    // -------------------------------
    // 1. BeforeSuite → Setup Extent
    // -------------------------------
    @BeforeSuite
    public void setupExtent() {

        // Create reports folder if missing
        String reportsDir = System.getProperty("user.dir") + File.separator + "reports";
        new File(reportsDir).mkdirs();

        // Timestamp-based report file
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = reportsDir + File.separator + "AutomationReport_" + timestamp + ".html";

        spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Automation Test Results");

        extent.setSystemInfo("Host", "Localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Debangana");
    }

    // ----------------------------------------------------
    // 2. BeforeMethod → Start Test & Launch Browser
    // ----------------------------------------------------
    @Parameters("browser")
    @BeforeMethod
    public void launchBrowser(@Optional("chrome") String browser, Method method) {

        logger = extent.createTest(method.getName());
        browser = browser == null || browser.isBlank() ? "chrome" : browser;

        setupDriver(browser);

        driver.manage().window().maximize();
        driver.get(Constants.url);
    }

    // -------------------------------
    // 3. AfterMethod → Logs + Quit
    // -------------------------------
    @AfterMethod
    public void tearDown(ITestResult result) {

        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                logger.log(Status.FAIL, "Test Failed: " + result.getThrowable());

                // Screenshot on failure
                String screenshotPath = takeScreenshot(result.getName());
                logger.addScreenCaptureFromPath(screenshotPath);

            } else if (result.getStatus() == ITestResult.SKIP) {
                logger.log(Status.SKIP, "Test Skipped");

            } else if (result.getStatus() == ITestResult.SUCCESS) {
                logger.log(Status.PASS, "Test Passed");
            }

        } catch (Exception e) {
            logger.log(Status.WARNING, "Error in tearDown: " + e.getMessage());
        }

        if (driver != null) {
            driver.quit();
        }
    }

    // -------------------------------
    // 4. AfterSuite → Flush Extent
    // -------------------------------
    @AfterSuite
    public void tearDownExtent() {
        if (extent != null) {
            extent.flush();
        }
    }

    // ---------------------------------
    // Browser Setup
    // ---------------------------------
    public void setupDriver(String browser) {

        switch (browser.toLowerCase()) {

        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;

        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;

        case "edge":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;

        default:
            throw new RuntimeException("Invalid browser passed: " + browser);
        }
    }

    // ---------------------------------
    // Screenshot Capture (Failure only)
    // ---------------------------------
    public String takeScreenshot(String testName) throws IOException {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + File.separator + "reports"
                + File.separator + "screenshots";

        new File(screenshotPath).mkdirs();

        String fullPath = screenshotPath + File.separator + testName + "_" + timestamp + ".png";

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(fullPath);
        source.renameTo(destination);

        return fullPath;
    }
}
