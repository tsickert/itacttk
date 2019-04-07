package com.nygard.itookacharttotheknee;

import android.graphics.drawable.Drawable;

/**
 * Created by thoma on 7/13/2016.
 */
public class Item {
    private String name;
    private Drawable image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
