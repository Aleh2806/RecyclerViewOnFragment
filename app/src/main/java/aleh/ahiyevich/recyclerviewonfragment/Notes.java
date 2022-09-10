package aleh.ahiyevich.recyclerviewonfragment;

import android.annotation.SuppressLint;

import java.util.ArrayList;

public class Notes {

    String tittle;
    int image;
    String description;

    public Notes(String tittle, int image, String description) {
        this.tittle = tittle;
        this.image = image;
        this.description = description;
    }


    public String getTittle() {

        return tittle;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
