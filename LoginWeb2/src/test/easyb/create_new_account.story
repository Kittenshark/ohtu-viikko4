import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can create a new account with valid and not already in use username'

scenario "user can create account with valid username/password", {
    given 'login selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    when 'a valid username and password are given', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("hauki");
        element = driver.findElement(By.name("password"));
        element.sendKeys("onkala1kala");
        element = driver.findElement(By.name("passwordConfirmationssword"));
        element.sendKeys("onkala1kala");
        element = driver.findElement(By.name("login"));
        element.submit();
    }
 
    then 'user will be logged in to system', {
        driver.getPageSource().contains("Welcome to Ohtu Application!").shouldBe true
    }

}

scenario "user can login with a succeffully created account", {
    given 'login selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("login"));       
        element.click();       
    }

    when 'a valid username and password are given', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("hauki");
        element = driver.findElement(By.name("password"));
        element.sendKeys("onkala1kala");
        element = driver.findElement(By.name("login"));
        element.submit();
    }
 
    then 'user will be logged in to system', {
        driver.getPageSource().contains("Welcome to Ohtu Application!").shouldBe true
    }
}

scenario "user can't create an account with already taken username", {
    given 'login selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    when 'an already in use username is given', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("onkala1kala");
        element = driver.findElement(By.name("passwordConfirmationssword"));
        element.sendKeys("onkala1kala");
        element = driver.findElement(By.name("login"));
        element.submit();
    }
 
    then 'user will not be logged in to system', {
        driver.getPageSource().contains("username or password invalid").shouldBe true
    }

}

scenario "user can't create an account with too short password", {
    given 'login selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    when 'the password is too short', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("piikkikala");
        element = driver.findElement(By.name("password"));
        element.sendKeys("kala");
        element = driver.findElement(By.name("passwordConfirmationssword"));
        element.sendKeys("kala");
        element = driver.findElement(By.name("add"));
        element.submit();
    }
 
    then 'user will not be logged in to system', {
        driver.getPageSource().contains("length greater or equal to 8").shouldBe true
    }
}

scenario "user can't create an account with a password without any numbers", {
    given 'login selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    when 'the password has no numbers in it', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("piikkikala");
        element = driver.findElement(By.name("password"));
        element.sendKeys("kalakalakala");
        element = driver.findElement(By.name("passwordConfirmationssword"));
        element.sendKeys("kalakalakala");
        element = driver.findElement(By.name("add"));
        element.submit();
    }
 
    then 'user will not be logged in to system', {
        driver.getPageSource().contains("must contain one character that is not a letter").shouldBe true
    }
}

scenario "user can't create an account with a too short username", {
    given 'login selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    when 'username is too short', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("ab");
        element = driver.findElement(By.name("password"));
        element.sendKeys("1kalakalakala");
        element = driver.findElement(By.name("passwordConfirmationssword"));
        element.sendKeys("1kalakalakala");
        element = driver.findElement(By.name("add"));
        element.submit();
    }
 
    then 'user will not be logged in to system', {
        driver.getPageSource().contains("length 5-10").shouldBe true
    }
}

scenario "user can't create an account with a too long username", {
    given 'login selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    when 'username is too long', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("piikkikalapiikkikala");
        element = driver.findElement(By.name("password"));
        element.sendKeys("1kalakalakala");
        element = driver.findElement(By.name("passwordConfirmationssword"));
        element.sendKeys("1kalakalakala");
        element = driver.findElement(By.name("add"));
        element.submit();
    }
 
    then 'user will not be logged in to system', {
        driver.getPageSource().contains("length 5-10").shouldBe true
    }
}

scenario "user can't loging with a nonexistant account", {
    given 'login selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("login"));       
        element.click();
    }

    when 'username is too long', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("piikkikalapiikkikala");
        element = driver.findElement(By.name("password"));
        element.sendKeys("1kalakalakala");
        element = driver.findElement(By.name("login"));
        element.submit();
    }
 
    then 'user will not be logged in to system', {
        driver.getPageSource().contains("wrong username or password").shouldBe true
    }
}
