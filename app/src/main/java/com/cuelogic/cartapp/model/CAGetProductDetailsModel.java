package com.cuelogic.cartapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Reena on 07-03-2016.
 */
public class CAGetProductDetailsModel implements Parcelable {

    String mPName;
    String mPPRice;
    String mPImgUrl;
    String mPVendorName;
    String mPVendorAddress;
    String mVendorPhone;
    boolean mIsAddedToCart;

    public CAGetProductDetailsModel(String pname, String pprice, String imgUrl, String vendorname, String vendoraddress, String vendorphone, boolean isAddedToCart) {
        this.mPName = pname;
        this.mPPRice = pprice;
        this.mPImgUrl = imgUrl;
        this.mPVendorName = vendorname;
        this.mPVendorAddress = vendoraddress;
        this.mVendorPhone = vendorphone;
        this.mIsAddedToCart = isAddedToCart;
    }

    public CAGetProductDetailsModel() {
    }

    public CAGetProductDetailsModel(Parcel in) {
        this.mPName = in.readString();
        this.mPPRice = in.readString();
        this.mPImgUrl = in.readString();
        this.mPVendorName = in.readString();
        this.mPVendorAddress = in.readString();
        this.mVendorPhone = in.readString();
        this.mIsAddedToCart = in.readByte() != 0;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mPName);
        dest.writeString(mPPRice);
        dest.writeString(mPImgUrl);
        dest.writeString(mPVendorName);
        dest.writeString(mPVendorAddress);
        dest.writeString(mVendorPhone);
        dest.writeByte((byte) (mIsAddedToCart ? 1 : 0));
    }


    public static final Parcelable.Creator<CAGetProductDetailsModel> CREATOR = new Parcelable.Creator<CAGetProductDetailsModel>() {

        @Override
        public CAGetProductDetailsModel createFromParcel(Parcel source) {
            return new CAGetProductDetailsModel(source);
        }

        @Override
        public CAGetProductDetailsModel[] newArray(int size) {
            return new CAGetProductDetailsModel[size];
        }
    };

    public String getmPName() {
        return mPName;
    }

    public void setmPName(String mPName) {
        this.mPName = mPName;
    }

    public String getmPImgUrl() {
        return mPImgUrl;
    }

    public void setmPImgUrl(String mPImgUrl) {
        this.mPImgUrl = mPImgUrl;
    }

    public String getmPPRice() {
        return mPPRice;
    }

    public void setmPPRice(String mPPRice) {
        this.mPPRice = mPPRice;
    }

    public String getmPVendorAddress() {
        return mPVendorAddress;
    }

    public void setmPVendorAddress(String mPVendorAddress) {
        this.mPVendorAddress = mPVendorAddress;
    }

    public String getmPVendorName() {
        return mPVendorName;
    }

    public void setmPVendorName(String mPVendorName) {
        this.mPVendorName = mPVendorName;
    }

    public String getmVendorPhone() {
        return mVendorPhone;
    }

    public void setmVendorPhone(String mVendorPhone) {
        this.mVendorPhone = mVendorPhone;
    }

    public boolean getIsmIsAddedToCart() {
        return mIsAddedToCart;
    }

    public void setmIsAddedToCart(boolean mIsAddedToCart) {
        this.mIsAddedToCart = mIsAddedToCart;
    }
}
