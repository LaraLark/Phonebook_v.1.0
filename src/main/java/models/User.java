package models;

public class User {
    String name;
    String lastName;
    String phone;
    String email;
    String address;
    String description;
    String password;

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withAddress(String address) {
        this.address = address;
        return this;
    }

    public User withDescription(String description) {
        this.description = description;
        return this;
    }
    public User withPassword(String password){
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
    public String getPassword(){
        return password;
    }
}
