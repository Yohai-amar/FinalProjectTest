import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FifteenTest {



    public static void main(String[] args) {

    }

    @BeforeClass
    public static void setupFirst (){
        WebDriverManager.chromedriver().setup();

    }

    @Test
    public void openBrowser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void signUp(){
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement signUpBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Help.SIGNUPID)));
        signUpBTN.click();
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(Help.DEMOBLAZE,newUrl);
        driver.quit();
    }

    @Test
    public void loginBTN(){
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginBTN = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.LOGINBTNCSSSELECTOR)));
        loginBTN.click();
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(Help.DEMOBLAZE,newUrl);
        driver.quit();
    }

    @Test
    public void userLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginBTN = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.LOGINBTNCSSSELECTOR)));
        WebElement logUserField = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.LOGINFIELDCSS)));
        WebElement logUserPass = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.id(Help.LOGINFIELDPASSFIELDID)));
        WebElement insideLogBTN = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(Help.LOGINBTNINSIDEXPATH)));
        loginBTN.click();
        Thread.sleep(5000);
        logUserField.sendKeys(Help.DEMOBLAZEUSERNAME);
        logUserPass.sendKeys(Help.DEMOBLAZEPASSWORD);
        insideLogBTN.click();
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(Help.DEMOBLAZE,newUrl);
//        driver.quit();
    }

    @Test
    public void logOut() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginBTN = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.LOGINBTNCSSSELECTOR)));
        WebElement logUserField = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.LOGINFIELDCSS)));
        WebElement logUserPass = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.id(Help.LOGINFIELDPASSFIELDID)));
        WebElement insideLogBTN = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(Help.LOGINBTNINSIDEXPATH)));
        loginBTN.click();
        Thread.sleep(5000);
        logUserField.sendKeys(Help.DEMOBLAZEUSERNAME);
        logUserPass.sendKeys(Help.DEMOBLAZEPASSWORD);
        insideLogBTN.click();
        Thread.sleep(3000);
        WebElement logOutBTN = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(Help.LOGOUTBTNPARTIALLINK)));
        logOutBTN.click();
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(Help.DEMOBLAZE,newUrl);
        driver.quit();
    }

    @Test
    public void contactBtn(){
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement contactBTN = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(Help.CONTACTBTNPARTLINKTXT)));
        contactBTN.click();
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(Help.DEMOBLAZE,newUrl);
        driver.quit();
    }

    @Test
    public void logInFail() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginBTN = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.LOGINBTNCSSSELECTOR)));
        WebElement logUserField = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.LOGINFIELDCSS)));
        WebElement logUserPass = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.id(Help.LOGINFIELDPASSFIELDID)));
        WebElement insideLogBTN = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(Help.LOGINBTNINSIDEXPATH)));
        loginBTN.click();
        Thread.sleep(3000);
        logUserField.sendKeys(Help.FAILUSERLOGIN);
        logUserPass.sendKeys(Help.FAILUSERPASS);
        insideLogBTN.click();
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(Help.DEMOBLAZE,newUrl);
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void loginFailArr() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        for (int i = 0; i < Help.USERLOGFAILARR.length ; i++) {
            driver.get(Help.DEMOBLAZE);
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement loginBTN = wait.
                    until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.LOGINBTNCSSSELECTOR)));
            WebElement logUserField = wait.
                    until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.LOGINFIELDCSS)));
            WebElement logUserPass = wait.
                    until(ExpectedConditions.presenceOfElementLocated(By.id(Help.LOGINFIELDPASSFIELDID)));
            WebElement insideLogBTN = wait.
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath(Help.LOGINBTNINSIDEXPATH)));
            loginBTN.click();
            Thread.sleep(3000);
            logUserField.sendKeys(Help.USERLOGFAILARR[i]);
            logUserPass.sendKeys(Help.FAILUSERPASS);
            insideLogBTN.click();
            Thread.sleep(3000);
        }
//        driver.quit();
    }

    @Test
    public void aboutUs(){
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement aboutUsBTN = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(Help.ABOUTUSBTNXPATH)));
        aboutUsBTN.click();
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(Help.DEMOBLAZE,newUrl);
        driver.quit();
    }

    @Test
    public void aboutUsVid() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement aboutUsBTN = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(Help.ABOUTUSBTNXPATH)));
        aboutUsBTN.click();
        Thread.sleep(3000);
        WebElement aboutUsVid = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.className(Help.ABOUTUSVIDCLASS)));
        aboutUsVid.click();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void switchPic() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement switchPic = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.SWITCHPICARROWCSS)));
        for (int i = 0; i < 5; i++) {
            switchPic.click();
            Thread.sleep(3000);
        }
        driver.quit();
    }

    @Test
    public void buySamsung6() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement samsung6Page = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.linkText(Help.SAMSUNG6PAGETXTLINK)));
        samsung6Page.click();
        Thread.sleep(3000);
        WebElement addToCartBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(Help.ADDTOCARTBTNTXTLINK)));
        addToCartBTN.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(Help.BOUGHTSAMSUNG6LINK,newUrl);
        driver.quit();
    }

    @Test
    public void compareText(){
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement paragraph = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.ABOUTUSTXTCSS)));
        String newTXT = paragraph.getText();
        Assert.assertEquals(Help.ABOUTUSTXTBELOW,newTXT);
        driver.quit();
    }

    @Test
    public void deleteFromCart() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement samsung6Page = wait.
                until(ExpectedConditions.presenceOfElementLocated(By.linkText(Help.SAMSUNG6PAGETXTLINK)));
        samsung6Page.click();
        Thread.sleep(3000);
        WebElement addToCartBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(Help.ADDTOCARTBTNTXTLINK)));
        addToCartBTN.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        WebElement cartBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Help.CARTPAGEID)));
        cartBTN.click();
        WebElement deleteBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Help.CARTDELETEBTNXPATH)));
        deleteBTN.click();
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(Help.DELETEDFROMCARTLINK,newUrl);
        driver.quit();
    }

    @Test
    public void contactMsg() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Help.DEMOBLAZE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement contactBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Help.CONTACTBTNXPATH)));
        contactBTN.click();
        Thread.sleep(2000);
        WebElement contactEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Help.CONTACTEMAILFIELDID)));
        WebElement contactName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Help.CONTACTNAMEFIELDCSS)));
        WebElement contactMsgField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Help.CONTACTMSGFIELDID)));
        contactEmail.sendKeys("Example@gmail.com");
        contactName.sendKeys("yohai");
        contactMsgField.sendKeys("hey nice website");
        WebElement sendMsgBTN = driver.findElement(By.cssSelector(Help.SENDMSGBTNCSS));
        sendMsgBTN.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();



    }

}
