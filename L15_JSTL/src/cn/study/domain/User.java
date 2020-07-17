package cn.study.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Harlan
 * @date 2020/7/17 16:17
 */
public class User {

    private String name;
    private int age;
    private String sex;
    private Date birthday;

    public User() {
    }

    public User(String name, int age, String sex, Date birthday) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
