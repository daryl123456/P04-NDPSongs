package sg.edu.rp.c346.id19042545.p04_ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {
    private int _id;
    private String title;
    private String singers;
    private int years;
    private int stars;

    public Song(String title, String singers, int years, int stars) {
        this.title = title;
        this.singers = singers;
        this.years = years;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYears() {
        return years;
    }

    public int getStars() {
        return stars;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
