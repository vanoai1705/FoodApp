package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

public class HomeFoodItem {
    private String imgFoodName;
    private String title;
    private  String subTitle;

    public HomeFoodItem(String imgFoodName, String title, String subTitle) {
        this.imgFoodName = imgFoodName;
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getImgFoodName() {
        return imgFoodName;
    }

    public void setImgFoodName(String imgFoodName) {
        this.imgFoodName = imgFoodName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return "HomeFoodItem{" +
                "imgFoodName='" + imgFoodName + '\'' +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }

}
