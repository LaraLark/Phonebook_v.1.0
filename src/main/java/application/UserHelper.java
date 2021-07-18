package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{


    public UserHelper(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        click(By.xpath("//a[.='LOGIN']"));
    }
    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@placeholder='Email']"),email);
        type(By.xpath("//input[@placeholder='Password']"),password);
    }
    public void fillLoginForm(User user){
        type(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }


    public void logOut(){
            click(By.xpath("//button[.='Sign Out']"));
        }

    public boolean isLogged() {
            return wd.findElements(By.xpath("//button[.=' Login']")).size() > 0;
        }

    public void login() {
        click(By.xpath("//button[.=' Login']"));
    }
}
