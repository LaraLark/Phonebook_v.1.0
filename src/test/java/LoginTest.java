import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginTestPositive(){

        click(By.xpath("//a[.='LOGIN']"));
        type(By.xpath("//input[@placeholder='Email']"),"noa@gmail.com");
        type(By.xpath("//input[@placeholder='Password']"),"Nnoa12345$");
        click(By.xpath("//button[.=' Login']"));
        pause(2000);
        String logOut = getText(By.xpath("//button[normalize-space()='Sign Out']"));
        Assert.assertTrue(logOut.contains("Sign Out"));

            }
         @Test
    public void loginTestPositiveNewContact(){
        click(By.xpath("//a[.='LOGIN']"));
        type(By.xpath("//input[@placeholder='Email']"),"mariam@gmail.com");
        type(By.xpath("//input[@placeholder='Password']"),"Mm123456$");
        click(By.xpath("//button[.=' Login']"));
        pause(2000);
        String loginNC=getText(By.xpath("//div//h1[.=' No Contacts here!']"));
        Assert.assertEquals(loginNC,"No Contacts here!");

    }
}
