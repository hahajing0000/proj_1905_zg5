package com.zy.usercenter.entity;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.usercenter.entity
 * @ClassName: UserEntity
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/12 13:21
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/12 13:21
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserEntity {
    private int id;
    private String phoneNumber;
    private String  pwd;
    private int age;
    private String address;

    public UserEntity(){}

    public UserEntity(int id, String phoneNumber, String pwd, int age, String address) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.pwd = pwd;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
