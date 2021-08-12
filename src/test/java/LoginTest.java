import application.MyDataProvider;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        app.userHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        app.userHelper().pause(3000);
        String loginS = app.userHelper().getText(By.xpath("//a[.='ADD']"));
        Assert.assertEquals(loginS,"ADD");
        logger.info("Logged with email : noa@gmail.com  and  with password: Nnoa12345$" );

            }
            @Test
    public void loginTestPositiveDto(){
                User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
                app.userHelper().openLoginForm();
                app.userHelper().fillLoginForm(user);
                app.userHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
                app.userHelper().pause(3000);
                String loginS = app.userHelper().getText(By.xpath("//a[.='ADD']"));
                Assert.assertEquals(loginS,"ADD");
                logger.info("Logged with email--->" + user.getEmail()+ "and with password--->" + user.getPassword());

            }
    @Test
    public void loginTestWithWrongPassword(){
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
     //   app.userHelper().pause(3000);
        app.userHelper().asseptAlert();
        Assert.assertFalse(app.userHelper().isLogged());
        logger.info("Wrong password : Nnoa12345");

    }
    @DataProvider
    public Iterator <Object[]> validDataLogin(){
       List<Object[]> list = new ArrayList<>();
       list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
       list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
       list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
       return list.iterator();

    }

 @Test(dataProvider = "validDataLogin")
    public void loginTestDataProvider(String email,String password){
        User user = new User().withEmail(email).withPassword(password);
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        app.userHelper().pause(3000);
        String loginS = app.userHelper().getText(By.xpath("//a[.='ADD']"));
        Assert.assertEquals(loginS,"ADD");
        logger.info("Logged with email--->" + user.getEmail()+ "and with password--->" + user.getPassword());

    }
    @Test(dataProvider = "validLoginDataClass",dataProviderClass = MyDataProvider.class)
    public void loginTestDataProviderClass(String email,String password){
        User user = new User().withEmail(email).withPassword(password);
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        app.userHelper().pause(3000);
        String loginS = app.userHelper().getText(By.xpath("//a[.='ADD']"));
        Assert.assertEquals(loginS,"ADD");
        logger.info("Logged with email--->" + user.getEmail()+ "and with password--->" + user.getPassword());

    }

    //dataFileCSV
    @Test(dataProvider = "dataFileCSV",dataProviderClass = MyDataProvider.class)
    public void loginTestDP_CSV(User user){

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        app.userHelper().pause(3000);
        String loginS = app.userHelper().getText(By.xpath("//a[.='ADD']"));
        Assert.assertEquals(loginS,"ADD");

    }

}
