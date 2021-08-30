import application.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {
    @BeforeMethod
    public void precondition(){
                if(!app.userHelper().isLogged()){
                app.userHelper().loginUser(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
            }

        }
        @Test(priority = 1,invocationCount = 3)
        public void addContactTestBase(){
            int i = (int)((System.currentTimeMillis())/1000)%3600;

            Contact contact = Contact.builder()
                    .name("Contact")
                    .lastname("Add")
                    .email("add"+i+"@gmail.com")
                    .phone("123456"+i)
                    .address("Haifa")
                    .description("friend").build();
            app.contact().openFormContact();
            app.contact().fillFormContact(contact);
            app.contact().saveContact();
          Assert.assertTrue(app.contact().isContactAdded(contact.getPhone()));
        }

    @Test(priority = 2, dataProvider="dataContactDP",dataProviderClass = MyDataProvider.class)
    public void addContactTestDataProvider(String name,String lastname, String phone,String email, String address, String description){


        Contact contact = Contact.builder()
                .name(name)
                .lastname(lastname)
                .email(email)
                .phone(phone)
                .address(address)
                .description(description)
                .build();

        app.contact().openFormContact();
        app.contact().fillFormContact(contact);
        app.contact().saveContact();
        Assert.assertTrue(app.contact().isContactAdded(contact.getPhone()));
        logger.info("Test passed");
    }
    //dataContactNotValid

  //  @Test(priority = 3, dataProvider="dataContactNotValid",dataProviderClass = MyDataProvider.class)
  /*  public void dataContactNotValid (String name,String lastname, String phone,String email, String address, String description){

        Contact contact = Contact.builder()
                .name(name)
                .lastname(lastname)
                .email(email)
                .phone(phone)
                .address(address)
                .description(description)
                .build();

        app.contact().openFormContact();
        app.contact().fillFormContact(contact);
        app.contact().saveContact();
        Assert.assertFalse(app.contact().isContactAdded(contact.getPhone()));
        logger.info("Test passed");
    }*/

}

