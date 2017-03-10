package com.rutmap;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.rutmap.Helper.DBHelper;
import com.rutmap.Model.Events;
import com.rutmap.Model.ObjPoints;
import com.rutmap.Preference.UserPreference;
import com.rutmap.Utils.Common;
import com.rutmap.Utils.Constant;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //-----------------------------------------//
//        DBHelper dbHelper = new DBHelper(this);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.close();
//        dbHelper.close();
        //-----------------------------------------//
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

/**
        ImageView imgFavorite = (ImageView) findViewById(R.id.imageView6);
        imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

         * Progress dialog
         */
        RelativeLayout layout1=(RelativeLayout)findViewById(R.id.activity_first);

        layout1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        initSetting();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    void initSetting() {
        Common.getInstance().dbHelper = new DBHelper(getApplicationContext());

        Common.getInstance().listObjPoints = Common.getInstance().dbHelper.getAllObjPoints();
        Log.d("debug", Common.getInstance().listObjPoints.size() + "");

        Common.getInstance().listCategoriesEvents = Common.getInstance().dbHelper.getAllCategoriesEvents();
        Log.d("debug", Common.getInstance().listCategoriesEvents.size() + "");

        Common.getInstance().listCategories = Common.getInstance().dbHelper.getAllCategories();
        Log.d("debug", Common.getInstance().listCategories.size() + "");

        Common.getInstance().listEvents = Common.getInstance().dbHelper.getAllEvents();
        Log.d("debug", Common.getInstance().listEvents.size() + "");

        Common.getInstance().listObjPointsInfo = Common.getInstance().dbHelper.getAllObjPointsInfo();
        Log.d("debug", Common.getInstance().listObjPointsInfo.size() + "");

        Common.getInstance().listKeywords = Common.getInstance().dbHelper.getAllKeywords();
        Log.d("debug", Common.getInstance().listKeywords.size() + "");

        Common.getInstance().listStreets = Common.getInstance().dbHelper.getAllStreets();
        Log.d("debug", Common.getInstance().listStreets.size() + "");

        Common.getInstance().listStreetPoints = Common.getInstance().dbHelper.getAllStreetPoints();
        Log.d("debug", Common.getInstance().listStreetPoints.size() + "");

        Common.getInstance().listGallrey = Common.getInstance().dbHelper.getAllGallery();
        Log.d("debug", Common.getInstance().listGallrey.size() + "");

        Common.getInstance().listSlider = Common.getInstance().dbHelper.getAllSlider();
        Log.d("debug", Common.getInstance().listSlider.size() + "");

        initEventsData();
        initSettingImage();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    void initEventsData() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH,10);

        Common.getInstance().arrayListDates = new ArrayList<>();
        ArrayList<String> arrayListTmp = new ArrayList<>();

        for(int i = 0; i < 20; i++) {
            if(i > 0) {
                calendar.add(Calendar.DAY_OF_YEAR, -1);
            }

            int nYear = calendar.get(Calendar.YEAR);
            int nMonth = calendar.get(Calendar.MONTH) + 1;
            int nDay = calendar.get(Calendar.DAY_OF_MONTH);

            String strDate = String.format("%d-%02d-%02d", nYear, nMonth, nDay);

            arrayListTmp.add(strDate);
        }

        for(int i = arrayListTmp.size() - 1; i >= 0; i -- ) {
            Common.getInstance().arrayListDates.add(arrayListTmp.get(i));
        }

        Common.getInstance().jsonObjectEvents = new JSONObject();

        for(int i = 0;i < Common.getInstance().arrayListDates.size(); i ++) {
            String strDate = Common.getInstance().arrayListDates.get(i);

            ArrayList<Events> arrayListItem = new ArrayList<>();
            for(int j = 0; j < Common.getInstance().listEvents.size(); j ++) {
                Events event = Common.getInstance().listEvents.get(j);
                String strEventTime = event.get_eventtime();

                if(strEventTime.contains(strDate)) {
                    arrayListItem.add(event);
                }
            }

            try {
                Common.getInstance().jsonObjectEvents.put(strDate, arrayListItem);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    void initSettingImage() {
        UserPreference.getInstance().pref = getSharedPreferences(Constant.prefName, Context.MODE_PRIVATE);

        ImageLoaderConfiguration defaultConfiguration
                = new ImageLoaderConfiguration.Builder(this)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .build();

        ImageLoader.getInstance().init(defaultConfiguration);

     //   APIManager.getInstance().isProduction = getResources().getBoolean(R.bool.is_production);
    }
}
