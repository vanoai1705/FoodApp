package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

public class TopOrderItem {
   private int imgFood;
   private String title;
   private String subtitle;

    public TopOrderItem(int imgFood, String title, String subtitle) {
        this.imgFood = imgFood;
        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    public String toString() {
        return "TopOrderItem{" +
                "imgFood='" + imgFood + '\'' +
                ", title='" + title + '\'' +
                ", Subtitle='" + subtitle + '\'' +
                '}';
    }

    public int getImgFood() {
        return imgFood;
    }

    public void setImgFood(int imgFood) {
        this.imgFood = imgFood;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
