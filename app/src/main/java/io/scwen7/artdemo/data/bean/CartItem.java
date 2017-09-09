package io.scwen7.artdemo.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 解晓辉  on 2017/9/9 20:44 *
 * QQ  ：811733738
 * 作用:
 */

public class CartItem implements Parcelable {

    private int  imageId;
    private String productId;
    private String price;
    private String model;
    private String name;


    private boolean isCheck = false;

    public CartItem(int imageId, String productId, String price, String model, String name) {
        this.imageId = imageId;
        this.productId = productId;
        this.price = price;
        this.model = model;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int  getImage() {
        return imageId;
    }

    public void setImage(int  image) {
        this.imageId = image;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imageId);
        dest.writeString(this.productId);
        dest.writeString(this.price);
        dest.writeString(this.model);
        dest.writeString(this.name);
        dest.writeByte(this.isCheck ? (byte) 1 : (byte) 0);
    }

    protected CartItem(Parcel in) {
        this.imageId = in.readInt();
        this.productId = in.readString();
        this.price = in.readString();
        this.model = in.readString();
        this.name = in.readString();
        this.isCheck = in.readByte() != 0;
    }

    public static final Creator<CartItem> CREATOR = new Creator<CartItem>() {
        @Override
        public CartItem createFromParcel(Parcel source) {
            return new CartItem(source);
        }

        @Override
        public CartItem[] newArray(int size) {
            return new CartItem[size];
        }
    };
}
