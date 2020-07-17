package cn.study.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Harlan
 * @date 2020/7/17 13:44
 */
public class  User {

    private String name;
    private int age;
    private Date birthday;

    public User() {
    }

    public User(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 逻辑视图
     * @return 格式化的日期
     */
    public String getBirthdayStr(){
        return new SimpleDateFormat("yyyy年MM月dd日").format(birthday);
    }
}
