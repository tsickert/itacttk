package com.nygard.itookacharttotheknee;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView imageView = (ImageView)findViewById(R.id.imageView2);

        Bundle b = getIntent().getExtras();
        String path = b.getString("com.nygard.itookacharttotheknee.path");

        try
        {
            // get input stream
            InputStream ims = getAssets().open(path);
            Log.d("Filename", path);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView.setImageDrawable(d);
        }
        catch(IOException ex)
        {
            return;
        }
    }

}
