package com.nygard.itookacharttotheknee;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ChartsActivity extends AppCompatActivity {

    private static final String[] EXISTING_ASSET_DIRECTORIES = {"images", "sound", "webkit"};
    private String[] folders = new String[] {
        "China",
        "Japan",
        "North Korea",
        "Russia",
        "South Korea"
    };
    private ListView listView;

    Map<String, ArrayList<String>> paths;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String path = "";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.Title, folders);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Clicked: " + folders[i], Toast.LENGTH_SHORT).show();
                if (folders[i] != "South Korea"){
                    listAssetsInSelection(folders[i]);
                    Intent intent = new Intent(getApplicationContext(), ImageGridActivity.class);
                    intent.putExtra("com.nygard.itookacharttotheknee.path", folders[i]);
                    startActivity(intent);
                }
                else {
                    Intent southKoreaIntent = new Intent(getApplicationContext(), SouthKoreanChartsActivity.class);
                    startActivity(southKoreaIntent);
                }
            }
        });

    }
//        AssetManager assetManager = getAssets();
//        try {
//            String[] files = assetManager.list(path);
//            if(files.length > 0) {
//
//            }
//            for (String file : files) {
//                Log.d("Files", file);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
