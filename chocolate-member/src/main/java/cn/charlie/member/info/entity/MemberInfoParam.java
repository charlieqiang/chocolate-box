package cn.charlie.member.info.entity;

import java.io.Serializable;

/**
 * @author charlie
 * @date 3/13/2023 10:06 AM
 **/
public class MemberInfoParam implements Serializable {

    private static final long serialVersionUID = -2029732051027322045L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
