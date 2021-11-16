package com.zy.usercenter.entity;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.usercenter.entity
 * @ClassName: TestUserEntity
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/15 14:38
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/15 14:38
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserEntity {

    public UserEntity() {
    }

    public UserEntity(int id, String username, String pwd, String sex, String birthday) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.sex = sex;
        this.birthday = birthday;
    }

    /**
     * id : 1
     * username : sample string 2
     * pwd : sample string 3
     * sex : sample string 4
     * birthday : sample string 5
     */

    private int id;
    private String username;
    private String pwd;
    private String sex;
    private String birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "TestUserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
