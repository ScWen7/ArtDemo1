package io.scwen7.artdemo.data.bean;

/**
 * Created by 解晓辉  on 2017/9/10 10:35 *
 * QQ  ：811733738
 * 作用:
 */

public class FindBannerBean {
    private String images ;
    private String link;

    public FindBannerBean(String images, String link) {
        this.images = images;
        this.link = link;
    }

    public FindBannerBean(String images) {
        this.images = images;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
