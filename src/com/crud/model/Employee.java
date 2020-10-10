package com.crud.model;

public class Employee {

    private int id;
    private String name;
    private int grade;
    private String address;
    private String mobile;
    private String bankacc;

    public Employee() {

    }

//    public Employee(int id, String name, int grade, String address, String mobile, String bankacc) {
//        this.id = id;
//        this.name = name;
//        this.grade = grade;
//        this.address = address;
//        this.mobile = mobile;
//        this.bankacc = bankacc;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBankacc() {
        return bankacc;
    }

    public void setBankacc(String bankacc) {
        this.bankacc = bankacc;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", bankacc='" + bankacc + '\'' +
                '}';
    }
}
