package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    static WebDriver driver;
    static WebDriver fdriver;
    static WebElement element;
    
    public static void main(String[] args) {
        driver = new HtmlUnitDriver();
        fdriver = new FirefoxDriver();
        
        //successfullLogin();
        wrongPassword();
        userNotExcisting();
        createNewUser();
        continueAfterRegister();
        logout();
    }
    
    public static void successfullLogin() {
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        printEnd();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
    }
    
    public static void wrongPassword() {
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        printEnd();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("huihai");
        element = driver.findElement(By.name("login"));
        element.submit();
    }
    
    public static void userNotExcisting() {
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        printEnd();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("huihai");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
    }
    
    public static void createNewUser() {
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("register new user"));       
        element.click(); 

        element = driver.findElement(By.name("username"));
        element.sendKeys("riehuisa");
        element = driver.findElement(By.name("password"));
        element.sendKeys("lepakko");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("lepakko");
        
        element = driver.findElement(By.name("add"));
        element.submit();

    }
    
    public static void continueAfterRegister() {
        element = driver.findElement(By.name("continue to application mainpage"));
        element.click();
        
    }
    
    public static void logout() {
        element = driver.findElement(By.name("logout"));
        element.click();
        
        printEnd();
    }
    
    public static void printEnd()  {
        System.out.println("==");
        System.out.println( driver.getPageSource() );
    }
}
