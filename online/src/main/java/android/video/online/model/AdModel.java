package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/7/22.
 */

/**
 *
 "pic": "2015-12-22/56796e4f89544.jpg",
 "place": "3"
 */
public class AdModel implements BasicModel{
    private String pic;
    private String place;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
