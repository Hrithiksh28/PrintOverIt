package com.example.printoverit2.Model;

public class User {
    private String Name;
    private String EmailId;
    private String Password;

    public User(){

    }

    public User(String name, String emailId, String password){
        Name = name;
        EmailId = emailId;
        Password = password;
    }

    public String getName() { return Name;}
    public void setName(String name){ Name = name;}

    public String getEmailId() { return EmailId;}
    public void setEmailId(String emailId){ EmailId = emailId;}

    public String getPassword() { return Password;}
    public void setPassword(String password){ Password = password;}
}
