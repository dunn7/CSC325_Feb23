package com.example.csc325_feb23;

public class Information {
    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private String major;
    private String email;
    private String imageURL;

    public Information(int id, String firstName, String lastName, String department, String major, String email, String imageURL) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.major = major;
        this.email = email;
        this.imageURL = imageURL;
    }

    public String getImageUrl() {
        return imageURL;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getMajor() {
        return major;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public void setDepartment(String department) {
        this.department=department;
    }

    public void setMajor(String major) {
        this.major=major;
    }

    public void setEmail(String email) {
        this.email=email;
    }


    public void setImageUrl(String imageURL) {
        this.imageURL=imageURL;
    }
}

