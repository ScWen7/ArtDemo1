package io.scwen7.artdemo.data.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by 解晓辉  on 2017/9/10 10:23 *
 * QQ  ：811733738
 * 作用:
 */

public class  FindMultiItem <T> implements MultiItemEntity {
    public static final int BANNER = 1;
    public static final int SESSION = 2;
    public static final int TODAY = 3;
    public static final int ARTIST = 4;
    public static final int RENT = 5;

    private int itemType;

    private T t;

    public FindMultiItem(int itemType,T t) {
        this.itemType = itemType;
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
