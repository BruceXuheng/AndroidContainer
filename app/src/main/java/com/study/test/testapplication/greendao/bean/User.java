package com.study.test.testapplication.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * 基础属性注解
 @Id :主键 Long型，可以通过@Id(autoincrement = true)设置自增长
 @Property：设置一个非默认关系映射所对应的列名，默认是的使用字段名 举例：@Property (nameInDb="name")
 @NotNul：设置数据库表当前列不能为空
 @Transient ：添加次标记之后不会生成数据库表的列

 索引注解
 @Index：使用@Index作为一个属性来创建一个索引，通过name设置索引别名，也可以通过unique给索引添加约束
 @Unique：向数据库列添加了一个唯一的约束

 关系注解
 @ToOne：定义与另一个实体（一个实体对象）的关系
 @ToMany：定义与多个实体对象的关系
 */

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String name;
    private String sex;
    private String age;
    private String email;
    private String des;
    private String hight;

    @Generated(hash = 1093552816)
    public User(Long id, @NotNull String name, String sex, String age, String email,
            String des, String hight) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.des = des;
        this.hight = hight;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", des='" + des + '\'' +
                ", hight='" + hight + '\'' +
                '}';
    }

    public String getDes() {
        return this.des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public String getHight() {
        return this.hight;
    }
    public void setHight(String hight) {
        this.hight = hight;
    }
}
