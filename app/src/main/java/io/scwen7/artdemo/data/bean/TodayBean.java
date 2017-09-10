package io.scwen7.artdemo.data.bean;

/**
 * Created by 解晓辉  on 2017/9/10 11:10 *
 * QQ  ：811733738
 * 作用:
 */

public class TodayBean {
    private String proImage;
    private String artAvoter;
    private String proName;
    private String price;
    private String artName;


    public TodayBean(String proImage, String artAvoter, String proName, String price, String artName) {
        this.proImage = proImage;
        this.artAvoter = artAvoter;
        this.proName = proName;
        this.price = price;
        this.artName = artName;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public String getArtAvoter() {
        return artAvoter;
    }

    public void setArtAvoter(String artAvoter) {
        this.artAvoter = artAvoter;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }
}
