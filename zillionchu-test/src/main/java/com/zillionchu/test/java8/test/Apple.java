package com.zillionchu.test.java8.test;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/4/12 10:23
 * @Description:
 */
public class Apple {

    private String color;
    private long weight;

    public Apple(String color, long weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }
}
