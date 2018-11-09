package com.study.test.testapplication.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;

    private String name;
    private String sex;
    private String age;
    private String email;

    @Generated(hash = 653092866)
    public User(Long id, String name, String sex, String age, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
