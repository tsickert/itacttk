package com.nygard.itookacharttotheknee;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class ImageGridActivity extends AppCompatActivity {

    private static final String[] EXISTING_ASSET_DIRECTORIES = {"images", "sound", "webkit"};
    private String[] folders = new String[] {
            "China",
            "Japan",
            "North Korea",
            "Russia",
            "South Korea"
    };
    private ListView listView;

    private ArrayList<Item> items = new ArrayList<>();

    Map<String, ArrayList<String>> paths;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = this.getIntent();
        final String path = intent.getStringExtra("com.nygard.itookacharttotheknee.path");

        Log.i("Path", path);

        AssetManager assetManager = getAssets();
        try {
            String[] files = assetManager.list(path);
            if(files.length > 0) {

            }
            for (String file : files) {
                Item newItem = new Item();
                newItem.setName(file);
                try
                {
                    // get input stream
                    InputStream ims = getAssets().open(path + "/" + file);
                    Log.d("Filename", path + "/" + file);
                    // load image as Drawable
                    Drawable d = Drawable.createFromStream(ims, null);
                    // set image to ImageView
                    newItem.setImage(d);
                    items.add(newItem);
                }
                catch(IOException ex)
                {
                    return;
                }
                Log.d("Files", file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        listView = (ListView) findViewById(R.id.listView2);

        ListAdapter adapter = new ListAdapter(this, items);

        Log.i("Got", "Here");
        if(adapter == null)
            Log.i("Adapter", "Null");
        else
            Log.i("Adapter", "Not NULL");

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Clicked: " + items.get(i).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                intent.putExtra("com.nygard.itookacharttotheknee.path", path + "/" + items.get(i).getName());
                startActivity(intent);
//                if(folders[i] != "South Korea")
//                    listAssetsInSelection(folders[i]);
//                else {
//                    Intent southKoreaIntent = new Intent(getApplicationContext(), SouthKoreanChartsActivity.class);
//                    startActivity(southKoreaIntent);
//                }
            }
        });

    }

    public static void start(Context context, String path) {
        Intent intent = new Intent(context, ImageGridActivity.class);
        intent.putExtra("com.nygard.itookacharttotheknee.path", path);
        context.startActivity(intent);
    }

    private void listAssetsInSelection(String path) {
        AssetManager assetManager = getAssets();
        try {
            String[] files = assetManager.list(path);
            if(files.length > 0) {

            }
            for (String file : files) {
                Log.d("Files", file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //private boolean extractFiles;

//    try
//    {
//        // get input stream
//        InputStream ims = getAssets().open("avatar.jpg");
//        // load image as Drawable
//        Drawable d = Drawable.createFromStream(ims, null);
//        // set image to ImageView
//        mImage.setImageDrawable(d);
//    }
//    catch(IOException ex)
//    {
//        return;
//    }

}
