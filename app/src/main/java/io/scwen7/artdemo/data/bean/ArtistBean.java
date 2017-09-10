package io.scwen7.artdemo.data.bean;

/**
 * Created by 解晓辉  on 2017/9/10 11:00 *
 * QQ  ：811733738
 * 作用:
 */

public class ArtistBean  {
    private String avoter;
    private String description;

    public ArtistBean(String avoter, String description) {
        this.avoter = avoter;
        this.description = description;
    }

    public String getAvoter() {
        return avoter;
    }

    public void setAvoter(String avoter) {
        this.avoter = avoter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
