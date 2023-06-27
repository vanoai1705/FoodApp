package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model;

public class RestaurantModel {
    private int Resd;
    private String ResName;
    private  byte[] ResImg;
    private int phoneNum;
    private String ResAdrs;
    private int openTime;
    private int closeTime;

    public RestaurantModel(int resd, String resName, byte[] resImg, int phoneNum, String resAdrs, int openTime, int closeTime) {
        Resd = resd;
        ResName = resName;
        ResImg = resImg;
        this.phoneNum = phoneNum;
        ResAdrs = resAdrs;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public int getResd() {
        return Resd;
    }

    public void setResd(int resd) {
        Resd = resd;
    }

    public String getResName() {
        return ResName;
    }

    public void setResName(String resName) {
        ResName = resName;
    }

    public byte[] getResImg() {
        return ResImg;
    }

    public void setResImg(byte[] resImg) {
        ResImg = resImg;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getResAdrs() {
        return ResAdrs;
    }

    public void setResAdrs(String resAdrs) {
        ResAdrs = resAdrs;
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }
}
