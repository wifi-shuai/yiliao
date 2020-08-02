package com.yiliao.health.bean;

/**
 * ClassName:Health
 * Package:com.yiliao.health.bean
 * Description:
 *
 * @Date:2020/5/2 11:36
 * @Author:liangshuai@shuaige.com
 */
public class Health {
    private double age;
    private double height;//cm
    private double weight;//kg
    private double sBp; //收缩压
    private double dBp; //舒张压
    private double vision;//(0.1~2.0)

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getsBp() {
        return sBp;
    }

    public void setsBp(double sBp) {
        this.sBp = sBp;
    }

    public double getdBp() {
        return dBp;
    }

    public void setdBp(double dBp) {
        this.dBp = dBp;
    }

    public double getVision() {
        return vision;
    }

    public void setVision(double vision) {
        this.vision = vision;
    }
}



