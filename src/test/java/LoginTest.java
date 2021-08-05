import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.userHelper().isLogged()){
            app.userHelper().logOut();
        }
    }

    @Test
    public void loginTestPositive(){

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.userHelper().login();
        app.userHelper().pause(3000);
        String loginS = app.userHelper().getText(By.xpath("//a[.='ADD']"));
        Assert.assertEquals(loginS,"ADD");
        logger.info("Logged with email : noa@gmail.com and with password: Nnoa12345$" );

            }
            @Test
    public void loginTestPositiveDto(){
                User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
                app.userHelper().openLoginForm();
                app.userHelper().fillLoginForm(user);
                app.userHelper().login();
                app.userHelper().pause(3000);
                String loginS = app.userHelper().getText(By.xpath("//a[.='ADD']"));
                Assert.assertEquals(loginS,"ADD");
                logger.info("Logged with email" + user.getEmail()+ "and with password" + user.getPassword());

            }
    @Test
    public void loginTestWithWrongPassword(){
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().login();
     //   app.userHelper().pause(3000);
        app.userHelper().asseptAlert();
        Assert.assertFalse(app.userHelper().isLogged());
        logger.info("Wrong password : Nnoa12345");

    }

}
