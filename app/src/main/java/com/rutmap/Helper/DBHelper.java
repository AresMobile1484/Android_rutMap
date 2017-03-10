package com.rutmap.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.rutmap.Model.Categories;
import com.rutmap.Model.CategoriesEvents;
import com.rutmap.Model.Events;
import com.rutmap.Model.Gallery;
import com.rutmap.Model.Keywords;
import com.rutmap.Model.ObjPoints;
import com.rutmap.Model.ObjPointsInfo;
import com.rutmap.Model.Slider;
import com.rutmap.Model.StreetPoints;
import com.rutmap.Model.Streets;
import com.rutmap.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 5465465465 on 2/9/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    private Context context;

    // Logcat tag
    private static final String LOG = "DatabaseHelper";
    // Database Version
    private static final int DATABASE_VERSION = 6;
    //Database Name
    private static final String DATABASE_NAME = "rbazam";

        //table names
    private static final String TBL_OBJ_POINTS = "obj_points";
    private static final String TBL_CATEGORIES_EVENTS = "categories_events";
    private static final String TBL_CATEGORIES = "categories";
    private static final String TBL_EVENTS = "events";
    private static final String TBL_KEYWORDS = "keywords";
    private static final String TBL_GALLERY = "gallery";
    private static final String TBL_OBJ_POINTS_INFO = "obj_points_info";
    private static final String TBL_SLIDER = "slider";
    private static final String TBL_STREET_POINTS = "street_points";
    private static final String TBL_STREETS = "streets";

        //events table keys
    private static final String KEY_OBJECT_ID = "object_id";
    private static final String KEY_DETAILS = "details";
    private static final String KEY_DETAILS_EN = "detailsEn";
    private static final String KEY_MAIN_PIC = "mainPic";
    private static final String KEY_TEL = "tel";
    private static final String KEY_EVENTTIME = "eventtime";
    private static final String KEY_CATEGORY_ID = "category_id";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PUBLISHED = "published";
    private static final String KEY_SFF = "sff";
    private static final String KEY_SPECIAL = "special";


    //categories table keys
    private static final String KEY_CLASSNAME = "classname";
    private static final String KEY_NAME = "name";
    private static final String KEY_PARAMS = "params";
    private static final String KEY_HTML = "html";
    private static final String KEY_LANG_DEL = "lang_del";
    private static final String KEY_NAME_LATIN = "nameLatin";
    private static final String KEY_NAME_EN = "nameEn";
    private static final String KEY_NAME_LATIN_EN = "nameLatinEn";

    //categories_events table keys
    private static final String KEY_ID = "id";
    private static final String KEY_CLASSES = "class";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TITLE_EN = "titleEn";
    //************ OBJ_POINTS ***************//
    // obj_points table key

    private static final String KEY_NAZIV = "naziv";
    private static final String KEY_ALIAS = "alias";
    private static final String KEY_CAT_ID = "cat_id";
    private static final String KEY_STREET_ID = "street_id";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LON = "lon";
    private static final String KEY_OBJ_INFO = "obj_info";
    private static final String KEY_STV = "stv";
    private static final String KEY_KRPANO = "krpano";
    private static final String KEY_STATUS = "status";
    private static final String KEY_SEARCHKEYWORDS = "searchkeywords";
    private static final String KEY_COUNTER = "counter";
    private static final String KEY_MINZOOM = "minzoom";
    private static final String KEY_STREETNUMBER = "streetnumber";
    private static final String KEY_INBUILDINGLAVEL = "inbuildinglevel";
    private static final String KEY_VRSTA = "vrsta";
    private static final String KEY_PARENT_ID = "parent_id";
    private static final String KEY_PACKAGE = "package";
    private static final String KEY_SHOW_ON_SEARCH = "showOnSearch";
    private static final String KEY_NAZIV_LAITN = "nazivLatin";
    private static final String KEY_SEARCHKEYWORDS_LATIN = "searchkeywordsLatin";
    private static final String KEY_OBJ_INFO_LATIN = "obj_infoLatin";
    private static final String KEY_USR = "usr";
    private static final String KEY_NAZIV_EN = "nazivEn";
    private static final String KEY_ALIAS_EN = "aliasEn";
    private static final String KEY_DESCRIPTION_EN = "descriptionEn";
    private static final String KEY_OBJ_INFO_EN = "obj_infoEn";
    private static final String KEY_NAZIV_LATIN_EN = "nazivLatinEn";
    private static final String KEY_OBJ_INFO_LATIN_EN = "obj_infoLatinEn";
    private static final String KEY_CREATED = "created";
    private static final String KEY_STATUS_TRUE = "status_true";
    private static final String KEY_STATUS_UPDATE = "status_update";
    //************************** END **************************//

    //Keywords table keys
    private static final String KEY_KEYWORD = "keyword";
    private static final String KEY_KEYWOD_EN = "keywordEn";

    //Gallery table keys
    private static final String KEY_IMAGE = "image";
    private static final String KEY_SORT = "sort";

    //Obj_Points_Info table keys
    private static final String KEY_OBJ_ID = "obj_id";
    private static final String KEY_TELEFON = "telefon";
    private static final String KEY_FAX = "fax";
    private static final String KEY_MAIL = "mail";
    private static final String KEY_WEB = "web";
    private static final String KEY_SLIKA = "slika";
    private static final String KEY_IMGURL = "imgurl";
    private static final String KEY_IMGURL2 = "imgurl2";
    private static final String KEY_IMGURL3 = "imgurl3";
    private static final String KEY_CLASSIMG = "classImg";
    private static final String KEY_CENTAR1 = "centar1";
    private static final String KEY_CENTAR2 = "centar2";
    private static final String KEY_CENTAR3 = "centar3";
    private static final String KEY_CENTAR4 = "centar4";
    private static final String KEY_WORKTIME = "worktime";
    private static final String KEY_WORKTIME_EN = "worktimeEn";

    //Streets table keys
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_FULL_NAME_LATIN = "full_nameLatin";
    private static final String KEY_COORDS = "coords";
    private static final String KEY_STARTEND = "startend";
    private static final String KEY_POLILINES = "polilines";
    private static final String KEY_MUNICIPALITY_ID = "municipality_id";
    private static final String KEY_RESORTED = "resorted";

    //Street_points table keys
    private static final String KEY_STREET = "street";
    private static final String KEY_LNG = "lng";
    private static final String KEY_SUBNUMBER = "subnumber";
    private static final String KEY_DONE = "done";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        this.db = db;
//        this.db.execSQL(CREATE_TABLE_EVENT);
        try {
            insertFromFile(R.raw.events);
            insertFromFile(R.raw.categories_events);
            insertFromFile(R.raw.obj_points);
            insertFromFile(R.raw.categories);
            insertFromFile(R.raw.obj_points_info);
            insertFromFile(R.raw.keywords);
            insertFromFile(R.raw.gallery);
            insertFromFile(R.raw.streets);
            insertFromFile(R.raw.street_points);
            insertFromFile(R.raw.slider);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void insertFromFile(int resourceId) throws IOException {
        // Reseting Counter
        //-----------------//
        //int result = 0;
        //-----------------//
        // Open the resource
        InputStream insertsStream = context.getResources().openRawResource(resourceId);
        BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

        String s            = new String();
        StringBuffer sb = new StringBuffer();

            // be sure to not have line starting with "--" or "/*" or any other non aplhabetical character

            while((s = insertReader.readLine()) != null)
            {
                sb.append(s);
            }
            insertReader.close();

            // here is our splitter ! We use ";" as a delimiter for each request
            // then we are sure to have well formed statements
            String[] inst = sb.toString().split(" ;");

            for(int i = 0; i<inst.length; i++)
            {
                // we ensure that there is no spaces before or after the request string
                // in order to not execute empty statements
                if(!inst[i].trim().equals(""))
                {
                    db.execSQL(inst[i]);
                    System.out.println(">>"+inst[i]);
                }
            }

        // returning number of inserted rows
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        //-----------------------------------------//
        //db.execSQL("DROP TABLE IF EXISTS " + TBL_EVENT);
        //----------------------------------------//
        db.execSQL("DROP TABLE IF EXISTS " + TBL_OBJ_POINTS);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_CATEGORIES_EVENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_CATEGORIES);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_EVENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_OBJ_POINTS_INFO);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_KEYWORDS);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_SLIDER);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_GALLERY);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_STREETS);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_STREET_POINTS);
        // create new tables
        onCreate(db);
    }

    // ------------------------ "event" table methods ----------------//

         /*
	 * Creating a events
	 */

    public int createEvent(StreetPoints streetPoints) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STREETNUMBER, streetPoints.get_streetnumber());
        values.put(KEY_STREET, streetPoints.get_street());
        values.put(KEY_LAT, streetPoints.get_lat());
        values.put(KEY_LNG, streetPoints.get_lng());
        values.put(KEY_SUBNUMBER,streetPoints.get_subnumber());
        values.put(KEY_STREET_ID, streetPoints.get_street_id());
        values.put(KEY_DONE, streetPoints.get_done());

        // insert row
        long streetPoints_id = db.insert(TBL_STREET_POINTS, null, values);

        return (int)streetPoints_id;
    }


    /*
     * get single Street_points
     */

    public StreetPoints getStreetPoints(int streetPoints_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TBL_STREET_POINTS + " WHERE "
                + KEY_ID + " = " + streetPoints_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        StreetPoints streetPoints = new StreetPoints();
        streetPoints.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
        streetPoints.set_streetnumber(c.getString(c.getColumnIndex(KEY_STREETNUMBER)));
        streetPoints.set_street(c.getString(c.getColumnIndex(KEY_STREET)));
        streetPoints.set_lat(c.getString(c.getColumnIndex(KEY_LAT)));
        streetPoints.set_lng(c.getString(c.getColumnIndex(KEY_LNG)));
        streetPoints.set_subnumber(c.getString(c.getColumnIndex(KEY_SUBNUMBER)));
        streetPoints.set_street_id(c.getInt(c.getColumnIndex(KEY_STREET_ID)));
        streetPoints.set_done(c.getInt(c.getColumnIndex(KEY_DONE)));

        return streetPoints;
    }

    /**
     * getting all StreetPoints
     * */
    public List<StreetPoints> getAllStreetPoints() {
        List<StreetPoints> streetPointses_list = new ArrayList<StreetPoints>();
        String selectQuery = "SELECT  * FROM " + TBL_STREET_POINTS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                StreetPoints streetPoints = new StreetPoints();
                streetPoints.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                streetPoints.set_streetnumber(c.getString(c.getColumnIndex(KEY_STREETNUMBER)));
                streetPoints.set_street(c.getString(c.getColumnIndex(KEY_STREET)));
                streetPoints.set_lat(c.getString(c.getColumnIndex(KEY_LAT)));
                streetPoints.set_lng(c.getString(c.getColumnIndex(KEY_LNG)));
                streetPoints.set_subnumber(c.getString(c.getColumnIndex(KEY_SUBNUMBER)));
                streetPoints.set_street_id(c.getInt(c.getColumnIndex(KEY_STREET_ID)));
                streetPoints.set_done(c.getInt(c.getColumnIndex(KEY_DONE)));
                // adding to transaction list
                streetPointses_list.add(streetPoints);
            } while (c.moveToNext());
        }
        return streetPointses_list;
    }


    /*
     * getting StreetPoints count
     */
    public int getStreetPoints() {
        String countQuery = "SELECT  * FROM " + TBL_STREET_POINTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a StreetPoints
     */
    public int updateStreetPoints(StreetPoints streetPoints) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STREETNUMBER, streetPoints.get_streetnumber());
        values.put(KEY_STREET, streetPoints.get_street());
        values.put(KEY_LAT, streetPoints.get_lat());
        values.put(KEY_LNG, streetPoints.get_lng());
        values.put(KEY_SUBNUMBER,streetPoints.get_subnumber());
        values.put(KEY_STREET_ID, streetPoints.get_street_id());
        values.put(KEY_DONE, streetPoints.get_done());

        // updating row
        return db.update(TBL_STREET_POINTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(streetPoints.get_id()) });
    }

    /*
     * Deleting a StreetPoints
     */
    public void deleteStreetPoints(int streetPoints_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_STREET_POINTS, KEY_ID + " = ?",
                new String[] { String.valueOf(streetPoints_id) });
    }



     /*
	 * Creating a events
	 */

    public int createEvent(Streets streets) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, streets.get_name());
        values.put(KEY_FULL_NAME, streets.get_full_name());
        values.put(KEY_ALIAS, streets.get_alias());
        values.put(KEY_COORDS, streets.get_coord());
        values.put(KEY_STARTEND,streets.get_startend());
        values.put(KEY_POLILINES, streets.get_polilines());
        values.put(KEY_MUNICIPALITY_ID, streets.get_municipality());
        values.put(KEY_STATUS, streets.get_status());
        values.put(KEY_RESORTED, streets.get_resorted());
        values.put(KEY_SEARCHKEYWORDS, streets.get_searchkeywords());
        values.put(KEY_COUNTER, streets.get_counter());
        values.put(KEY_NAME_LATIN, streets.get_nameLatin());
        values.put(KEY_FULL_NAME_LATIN, streets.get_full_nameLatin());
        values.put(KEY_SEARCHKEYWORDS_LATIN, streets.get_searchkeywordsLatin());
        values.put(KEY_ALIAS_EN, streets.get_aliasEn());

        // insert row
        long streets_id = db.insert(TBL_STREETS, null, values);

        return (int)streets_id;
    }


    /*
     * get single Streets
     */

    public Streets getStreets(int streets_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TBL_STREETS + " WHERE "
                + KEY_ID + " = " + streets_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Streets streets = new Streets();
        streets.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
        streets.set_name(c.getString(c.getColumnIndex(KEY_NAME)));
        streets.set_full_name(c.getString(c.getColumnIndex(KEY_FULL_NAME)));
        streets.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
        streets.set_coord(c.getString(c.getColumnIndex(KEY_COORDS)));
        streets.set_startend(c.getString(c.getColumnIndex(KEY_STARTEND)));
        streets.set_polilines(c.getString(c.getColumnIndex(KEY_POLILINES)));
        streets.set_municipality(c.getString(c.getColumnIndex(KEY_MUNICIPALITY_ID)));
        streets.set_status(c.getInt(c.getColumnIndex(KEY_STATUS)));
        streets.set_resorted(c.getString(c.getColumnIndex(KEY_RESORTED)));
        streets.set_searchkeywords(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS)));
        streets.set_counter(c.getInt(c.getColumnIndex(KEY_COUNTER)));
        streets.set_nameLatin(c.getString(c.getColumnIndex(KEY_NAME_LATIN)));
        streets.set_full_nameLatin(c.getString(c.getColumnIndex(KEY_FULL_NAME_LATIN)));
        streets.set_searchkeywordsLatin(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS_LATIN)));
        streets.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));

        return streets;
    }

    /**
     * getting all Streets
     * */
    public List<Streets> getAllStreets() {
        List<Streets> streets_list = new ArrayList<Streets>();
        String selectQuery = "SELECT  * FROM " + TBL_STREETS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Streets streets = new Streets();
                streets.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                streets.set_name(c.getString(c.getColumnIndex(KEY_NAME)));
                streets.set_full_name(c.getString(c.getColumnIndex(KEY_FULL_NAME)));
                streets.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
                streets.set_coord(c.getString(c.getColumnIndex(KEY_COORDS)));
                streets.set_startend(c.getString(c.getColumnIndex(KEY_STARTEND)));
                streets.set_polilines(c.getString(c.getColumnIndex(KEY_POLILINES)));
                streets.set_municipality(c.getString(c.getColumnIndex(KEY_MUNICIPALITY_ID)));
                streets.set_status(c.getInt(c.getColumnIndex(KEY_STATUS)));
                streets.set_resorted(c.getString(c.getColumnIndex(KEY_RESORTED)));
                streets.set_searchkeywords(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS)));
                streets.set_counter(c.getInt(c.getColumnIndex(KEY_COUNTER)));
                streets.set_nameLatin(c.getString(c.getColumnIndex(KEY_NAME_LATIN)));
                streets.set_full_nameLatin(c.getString(c.getColumnIndex(KEY_FULL_NAME_LATIN)));
                streets.set_searchkeywordsLatin(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS_LATIN)));
                streets.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));

                // adding to transaction list
                streets_list.add(streets);
            } while (c.moveToNext());
        }
        return streets_list;
    }


    /*
     * getting Streets count
     */
    public int getStreets() {
        String countQuery = "SELECT  * FROM " + TBL_STREETS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a Streets
     */
    public int updateStreets(Streets streets) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, streets.get_name());
        values.put(KEY_FULL_NAME, streets.get_full_name());
        values.put(KEY_ALIAS, streets.get_alias());
        values.put(KEY_COORDS, streets.get_coord());
        values.put(KEY_STARTEND,streets.get_startend());
        values.put(KEY_POLILINES, streets.get_polilines());
        values.put(KEY_MUNICIPALITY_ID, streets.get_municipality());
        values.put(KEY_STATUS, streets.get_status());
        values.put(KEY_RESORTED, streets.get_resorted());
        values.put(KEY_SEARCHKEYWORDS, streets.get_searchkeywords());
        values.put(KEY_COUNTER, streets.get_counter());
        values.put(KEY_NAME_LATIN, streets.get_nameLatin());
        values.put(KEY_FULL_NAME_LATIN, streets.get_full_nameLatin());
        values.put(KEY_SEARCHKEYWORDS_LATIN, streets.get_searchkeywordsLatin());
        values.put(KEY_ALIAS_EN, streets.get_aliasEn());

        // updating row
        return db.update(TBL_STREETS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(streets.get_id()) });
    }

    /*
     * Deleting a Streets
     */
    public void deleteStreets(int streets_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_STREETS, KEY_ID + " = ?",
                new String[] { String.valueOf(streets_id) });
    }


    // *************************  Gallery **************************//
   	/*
	 * Creating a events
	 */

    public int createEvent(ObjPointsInfo objPointsInfo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_OBJ_ID, objPointsInfo.get_obj_id());
        values.put(KEY_TELEFON, objPointsInfo.get_telefon());
        values.put(KEY_FAX, objPointsInfo.get_fax());
        values.put(KEY_MAIL, objPointsInfo.get_mail());
        values.put(KEY_WEB,objPointsInfo.get_web());
        values.put(KEY_SLIKA, objPointsInfo.get_slika());
        values.put(KEY_IMGURL, objPointsInfo.get_imgurl());
        values.put(KEY_IMGURL2, objPointsInfo.get_imgurl2());
        values.put(KEY_IMGURL3, objPointsInfo.get_imgurl3());
        values.put(KEY_CLASSIMG, objPointsInfo.get_classImg());
        values.put(KEY_CENTAR1, objPointsInfo.get_centar1());
        values.put(KEY_CENTAR2, objPointsInfo.get_centar2());
        values.put(KEY_CENTAR3, objPointsInfo.get_centar3());
        values.put(KEY_CENTAR4, objPointsInfo.get_centar4());
        values.put(KEY_WORKTIME, objPointsInfo.get_worktime());
        values.put(KEY_WORKTIME_EN, objPointsInfo.get_worktimeEn());

        // insert row
        long obj_points_info_id = db.insert(TBL_OBJ_POINTS_INFO, null, values);

        return (int)obj_points_info_id;
    }


    /*
     * get single Obj_points_info
     */

    public ObjPointsInfo getObjPointsInfo(int obj_points_info_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TBL_OBJ_POINTS_INFO + " WHERE "
                + KEY_ID + " = " + obj_points_info_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        ObjPointsInfo objPointsInfo = new ObjPointsInfo();
        objPointsInfo.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
        objPointsInfo.set_obj_id(c.getInt(c.getColumnIndex(KEY_OBJ_ID)));
        objPointsInfo.set_telefon(c.getString(c.getColumnIndex(KEY_TELEFON)));
        objPointsInfo.set_fax(c.getString(c.getColumnIndex(KEY_FAX)));
        objPointsInfo.set_mail(c.getString(c.getColumnIndex(KEY_MAIL)));
        objPointsInfo.set_web(c.getString(c.getColumnIndex(KEY_WEB)));
        objPointsInfo.set_slika(c.getString(c.getColumnIndex(KEY_SLIKA)));
        objPointsInfo.set_imgurl(c.getString(c.getColumnIndex(KEY_IMGURL)));
        objPointsInfo.set_imgurl2(c.getString(c.getColumnIndex(KEY_IMGURL2)));
        objPointsInfo.set_imgurl3(c.getString(c.getColumnIndex(KEY_IMGURL3)));
        objPointsInfo.set_classImg(c.getString(c.getColumnIndex(KEY_CLASSIMG)));
        objPointsInfo.set_centar1(c.getString(c.getColumnIndex(KEY_CENTAR1)));
        objPointsInfo.set_centar2(c.getString(c.getColumnIndex(KEY_CENTAR2)));
        objPointsInfo.set_centar3(c.getString(c.getColumnIndex(KEY_CENTAR3)));
        objPointsInfo.set_centar4(c.getString(c.getColumnIndex(KEY_CENTAR4)));
        objPointsInfo.set_worktime(c.getString(c.getColumnIndex(KEY_WORKTIME)));
        objPointsInfo.set_worktimeEn(c.getString(c.getColumnIndex(KEY_WORKTIME_EN)));

        return objPointsInfo;
    }

    /**
     * getting all Obj_points_info
     * */
    public List<ObjPointsInfo> getAllObjPointsInfo() {
        List<ObjPointsInfo> objPointsInfo_list = new ArrayList<ObjPointsInfo>();
        String selectQuery = "SELECT  * FROM " + TBL_OBJ_POINTS_INFO;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                ObjPointsInfo objPointsInfo = new ObjPointsInfo();
                objPointsInfo.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                objPointsInfo.set_obj_id(c.getInt(c.getColumnIndex(KEY_OBJ_ID)));
                objPointsInfo.set_telefon(c.getString(c.getColumnIndex(KEY_TELEFON)));
                objPointsInfo.set_fax(c.getString(c.getColumnIndex(KEY_FAX)));
                objPointsInfo.set_mail(c.getString(c.getColumnIndex(KEY_MAIL)));
                objPointsInfo.set_web(c.getString(c.getColumnIndex(KEY_WEB)));
                objPointsInfo.set_slika(c.getString(c.getColumnIndex(KEY_SLIKA)));
                objPointsInfo.set_imgurl(c.getString(c.getColumnIndex(KEY_IMGURL)));
                objPointsInfo.set_imgurl2(c.getString(c.getColumnIndex(KEY_IMGURL2)));
                objPointsInfo.set_imgurl3(c.getString(c.getColumnIndex(KEY_IMGURL3)));
                objPointsInfo.set_classImg(c.getString(c.getColumnIndex(KEY_CLASSIMG)));
                objPointsInfo.set_centar1(c.getString(c.getColumnIndex(KEY_CENTAR1)));
                objPointsInfo.set_centar2(c.getString(c.getColumnIndex(KEY_CENTAR2)));
                objPointsInfo.set_centar3(c.getString(c.getColumnIndex(KEY_CENTAR3)));
                objPointsInfo.set_centar4(c.getString(c.getColumnIndex(KEY_CENTAR4)));
                objPointsInfo.set_worktime(c.getString(c.getColumnIndex(KEY_WORKTIME)));
                objPointsInfo.set_worktimeEn(c.getString(c.getColumnIndex(KEY_WORKTIME_EN)));

                // adding to transaction list
                objPointsInfo_list.add(objPointsInfo);
            } while (c.moveToNext());
        }
        return objPointsInfo_list;
    }


    /*
     * getting Obj_points_info count
     */
    public int getObjPointsInfo() {
        String countQuery = "SELECT  * FROM " + TBL_OBJ_POINTS_INFO;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a Obj_points_info
     */
    public int updateObjPointsInfo(ObjPointsInfo objPointsInfo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_OBJ_ID, objPointsInfo.get_obj_id());
        values.put(KEY_TELEFON, objPointsInfo.get_telefon());
        values.put(KEY_FAX, objPointsInfo.get_fax());
        values.put(KEY_MAIL, objPointsInfo.get_mail());
        values.put(KEY_WEB, objPointsInfo.get_web());
        values.put(KEY_SLIKA, objPointsInfo.get_slika());
        values.put(KEY_IMGURL, objPointsInfo.get_imgurl());
        values.put(KEY_IMGURL2, objPointsInfo.get_imgurl2());
        values.put(KEY_IMGURL3, objPointsInfo.get_imgurl3());
        values.put(KEY_CLASSIMG, objPointsInfo.get_classImg());
        values.put(KEY_CENTAR1, objPointsInfo.get_centar1());
        values.put(KEY_CENTAR2, objPointsInfo.get_centar2());
        values.put(KEY_CENTAR3, objPointsInfo.get_centar3());
        values.put(KEY_CENTAR4, objPointsInfo.get_centar4());
        values.put(KEY_WORKTIME, objPointsInfo.get_worktime());
        values.put(KEY_WORKTIME_EN, objPointsInfo.get_worktimeEn());

        // updating row
        return db.update(TBL_OBJ_POINTS_INFO, values, KEY_ID + " = ?",
                new String[] { String.valueOf(objPointsInfo.get_id()) });
    }

    /*
     * Deleting a Obj_points_info
     */
    public void deleteObjPointsInfo(int objPointsInfo_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_OBJ_POINTS_INFO, KEY_ID + " = ?",
                new String[] { String.valueOf(objPointsInfo_id) });
    }


    // *************************  Slider **************************//
   	/*
	 * Creating a events
	 */

    public int createEvent(Slider slider) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ALIAS, slider.get_image());
        values.put(KEY_ALIAS_EN, slider.get_object_id());
        values.put(KEY_CLASSNAME, slider.get_sort());

        // insert row
        long slider_id = db.insert(TBL_SLIDER, null, values);

        return (int)slider_id;
    }


    /*
     * get single Slider
     */

    public Slider getSlider(int slider_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TBL_SLIDER + " WHERE "
                + KEY_ID + " = " + slider_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Slider slider = new Slider();
        slider.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
        slider.set_image(c.getString(c.getColumnIndex(KEY_IMAGE)));
        slider.set_object_id(c.getInt(c.getColumnIndex(KEY_OBJECT_ID)));
        slider.set_sort(c.getInt(c.getColumnIndex(KEY_SORT)));

        return slider;
    }

    /**
     * getting all Slider
     * */
    public List<Slider> getAllSlider() {
        List<Slider> sliders_list = new ArrayList<Slider>();
        String selectQuery = "SELECT  * FROM " + TBL_SLIDER;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Slider slider = new Slider();
                slider.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                slider.set_image(c.getString(c.getColumnIndex(KEY_IMAGE)));
                slider.set_object_id(c.getInt(c.getColumnIndex(KEY_OBJECT_ID)));
                slider.set_sort(c.getInt(c.getColumnIndex(KEY_SORT)));

                // adding to transaction list
                sliders_list.add(slider);
            } while (c.moveToNext());
        }
        return sliders_list;
    }


    /*
     * getting Slider count
     */
    public int getSlider() {
        String countQuery = "SELECT  * FROM " + TBL_SLIDER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a Slider
     */
    public int updateSlider(Slider slider) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ALIAS, slider.get_image());
        values.put(KEY_ALIAS_EN, slider.get_object_id());
        values.put(KEY_CLASSNAME, slider.get_sort());
        // updating row
        return db.update(TBL_SLIDER, values, KEY_ID + " = ?",
                new String[] { String.valueOf(slider.get_id()) });
    }

    /*
     * Deleting a Gallery
     */
    public void deleteSlider(int sliders_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_SLIDER, KEY_ID + " = ?",
                new String[] { String.valueOf(sliders_id) });
    }

    // *************************  Gallery **************************//
   	/*
	 * Creating a events
	 */

    public int createEvent(Gallery gallery) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ALIAS, gallery.get_image());
        values.put(KEY_ALIAS_EN, gallery.get_object_id());
        values.put(KEY_CLASSNAME, gallery.get_sort());

        // insert row
        long gallery_id = db.insert(TBL_GALLERY, null, values);

        return (int)gallery_id;
    }


    /*
     * get single Gallery
     */

    public Gallery getGallery(int gallery_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TBL_GALLERY + " WHERE "
                + KEY_ID + " = " + gallery_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Gallery gallery = new Gallery();
        gallery.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
        gallery.set_image(c.getString(c.getColumnIndex(KEY_IMAGE)));
        gallery.set_object_id(c.getInt(c.getColumnIndex(KEY_OBJ_ID)));
        gallery.set_sort(c.getInt(c.getColumnIndex(KEY_SORT)));

        return gallery;
    }

    /**
     * getting all keywords
     * */
    public List<Gallery> getAllGallery() {
        List<Gallery> gallery_list = new ArrayList<Gallery>();
        String selectQuery = "SELECT  * FROM " + TBL_GALLERY;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Gallery gallery = new Gallery();
                gallery.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                gallery.set_image(c.getString(c.getColumnIndex(KEY_IMAGE)));
                gallery.set_object_id(c.getInt(c.getColumnIndex(KEY_OBJECT_ID)));
                gallery.set_sort(c.getInt(c.getColumnIndex(KEY_SORT)));

                // adding to transaction list
                gallery_list.add(gallery);
            } while (c.moveToNext());
        }
        return gallery_list;
    }


    /*
     * getting Gallery count
     */
    public int getGallery() {
        String countQuery = "SELECT  * FROM " + TBL_GALLERY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a Gallery
     */
    public int updateGallery(Gallery gallery) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ALIAS, gallery.get_image());
        values.put(KEY_ALIAS_EN, gallery.get_object_id());
        values.put(KEY_CLASSNAME, gallery.get_sort());

        // updating row
        return db.update(TBL_GALLERY, values, KEY_ID + " = ?",
                new String[] { String.valueOf(gallery.get_id()) });
    }

    /*
     * Deleting a Gallery
     */
    public void deleteGallery(int gallery_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_GALLERY, KEY_ID + " = ?",
                new String[] { String.valueOf(gallery_id) });
    }



    // *************************  Keywords **************************//
   	/*
	 * Creating a events
	 */

    public int createEvent(Keywords keywords) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ALIAS, keywords.get_alias());
        values.put(KEY_ALIAS_EN, keywords.get_aliasEn());
        values.put(KEY_CLASSNAME, keywords.get_classname());
        values.put(KEY_KEYWORD, keywords.get_keyword());
        values.put(KEY_KEYWOD_EN, keywords.get_keywordEn());

        // insert row
        long keywords_id = db.insert(TBL_KEYWORDS, null, values);

        return (int)keywords_id;
    }


    /*
     * get single categories
     */

    public Keywords getKeywords(int keyword_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TBL_KEYWORDS + " WHERE "
                + KEY_ID + " = " + keyword_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Keywords keywords = new Keywords();
        keywords.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
        keywords.set_keyword(c.getString(c.getColumnIndex(KEY_KEYWORD)));
        keywords.set_keywordEn(c.getString(c.getColumnIndex(KEY_KEYWOD_EN)));
        keywords.set_classname(c.getString(c.getColumnIndex(KEY_CLASSNAME)));
        keywords.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
        keywords.set_aliasEn(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));

        return keywords;
    }

    /**
     * getting all keywords
     * */
    public List<Keywords> getAllKeywords() {
        List<Keywords> keywords_list = new ArrayList<Keywords>();
        String selectQuery = "SELECT  * FROM " + TBL_KEYWORDS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Keywords keywords = new Keywords();
                keywords.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                keywords.set_keyword(c.getString(c.getColumnIndex(KEY_KEYWORD)));
                keywords.set_keywordEn(c.getString(c.getColumnIndex(KEY_KEYWOD_EN)));
                keywords.set_classname(c.getString(c.getColumnIndex(KEY_CLASSNAME)));
                keywords.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
                keywords.set_aliasEn(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));

                // adding to transaction list
                keywords_list.add(keywords);
            } while (c.moveToNext());
        }

        return keywords_list;
    }


    /*
     * getting Keywords count
     */
    public int getKeywords() {
        String countQuery = "SELECT  * FROM " + TBL_KEYWORDS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a Keywords
     */
    public int updateKeywords(Keywords keywords) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ALIAS, keywords.get_alias());
        values.put(KEY_ALIAS_EN, keywords.get_aliasEn());
        values.put(KEY_CLASSNAME, keywords.get_classname());
        values.put(KEY_KEYWORD, keywords.get_keyword());
        values.put(KEY_KEYWOD_EN, keywords.get_keywordEn());

        // updating row
        return db.update(TBL_KEYWORDS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(keywords.get_id()) });
    }

    /*
     * Deleting a Keywords
     */
    public void deleteKeywords(int keywords_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_KEYWORDS, KEY_ID + " = ?",
                new String[] { String.valueOf(keywords_id) });
    }


    // ************************  events **************************** //
   	/*
	 * Creating a events
	 */

    public int createEvent(Events events) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, events.get_title());
        values.put(KEY_TITLE_EN, events.get_titleEn());
        values.put(KEY_OBJECT_ID, events.get_object_id());
        values.put(KEY_ALIAS, events.get_alias());
        values.put(KEY_ALIAS_EN, events.get_aliasEn());
        values.put(KEY_DETAILS, events.get_details());
        values.put(KEY_DETAILS_EN, events.get_detailsEn());
        values.put(KEY_MAIN_PIC, events.get_mainPic());
        values.put(KEY_TEL, events.get_tel());
        values.put(KEY_EVENTTIME, String.valueOf(events.get_eventtime()));
        values.put(KEY_CATEGORY_ID, events.get_category_id());
        values.put(KEY_EMAIL, events.get_email());
        values.put(KEY_PUBLISHED, events.get_published());
        values.put(KEY_SFF, events.get_sff());
        values.put(KEY_SPECIAL, events.get_special());

        // insert row
        long events_id = db.insert(TBL_EVENTS, null, values);

        return (int)events_id;
    }


    /*
     * get single Events
     */

    public Events getEvents(int events_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TBL_EVENTS + " WHERE "
                + KEY_ID + " = " + events_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Events events = new Events();
        events.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
        events.set_title(c.getString(c.getColumnIndex(KEY_TITLE)));
        events.set_titleEn(c.getString(c.getColumnIndex(KEY_TITLE)));
        events.set_object_id(c.getInt(c.getColumnIndex(KEY_OBJECT_ID)));
        events.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
        events.set_aliasEn(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));
        events.set_details(c.getString(c.getColumnIndex(KEY_DETAILS)));
        events.set_detailsEn(c.getString(c.getColumnIndex(KEY_DETAILS_EN)));
        events.set_mainPic(c.getString(c.getColumnIndex(KEY_MAIN_PIC)));
        events.set_tel(c.getString(c.getColumnIndex(KEY_TEL)));
        events.set_eventtime(c.getString(c.getColumnIndex(KEY_EVENTTIME)));
        events.set_category_id(c.getInt(c.getColumnIndex(KEY_CATEGORY_ID)));
        events.set_email(c.getString(c.getColumnIndex(KEY_EMAIL)));
        events.set_published(c.getInt(c.getColumnIndex(KEY_PUBLISHED)));
        events.set_sff(c.getInt(c.getColumnIndex(KEY_SFF)));
        events.set_special(c.getInt(c.getColumnIndex(KEY_SPECIAL)));

        return events;
    }

    /**
     * getting all Events
     * */
    public List<Events> getAllEvents() {
        List<Events> events_list = new ArrayList<Events>();
        String selectQuery = "SELECT  * FROM " + TBL_EVENTS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Events events = new Events();
                events.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                events.set_title(c.getString(c.getColumnIndex(KEY_TITLE)));
                events.set_titleEn(c.getString(c.getColumnIndex(KEY_TITLE_EN)));
                events.set_object_id(c.getInt(c.getColumnIndex(KEY_OBJECT_ID)));
                events.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
                events.set_aliasEn(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));
                events.set_details(c.getString(c.getColumnIndex(KEY_DETAILS)));
                events.set_detailsEn(c.getString(c.getColumnIndex(KEY_DETAILS_EN)));
                events.set_mainPic(c.getString(c.getColumnIndex(KEY_MAIN_PIC)));
                events.set_tel(c.getString(c.getColumnIndex(KEY_TEL)));
                events.set_eventtime(c.getString(c.getColumnIndex(KEY_EVENTTIME)));
                events.set_category_id(c.getInt(c.getColumnIndex(KEY_CATEGORY_ID)));
                events.set_email(c.getString(c.getColumnIndex(KEY_EMAIL)));
                events.set_published(c.getInt(c.getColumnIndex(KEY_PUBLISHED)));
                events.set_sff(c.getInt(c.getColumnIndex(KEY_SFF)));
                events.set_special(c.getInt(c.getColumnIndex(KEY_SPECIAL)));

                // adding to transaction list
                events_list.add(events);
            } while (c.moveToNext());
        }

        return events_list;
    }


    /*
     * getting events count
     */
    public int getEvents() {
        String countQuery = "SELECT  * FROM " + TBL_EVENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a events
     */
    public int updateEvents(Events events) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, events.get_title());
        values.put(KEY_TITLE_EN, events.get_titleEn());
        values.put(KEY_OBJECT_ID, events.get_object_id());
        values.put(KEY_ALIAS, events.get_alias());
        values.put(KEY_ALIAS_EN, events.get_aliasEn());
        values.put(KEY_DETAILS, events.get_details());
        values.put(KEY_DETAILS_EN, events.get_detailsEn());
        values.put(KEY_MAIN_PIC, events.get_mainPic());
        values.put(KEY_TEL, events.get_tel());
        values.put(KEY_EVENTTIME, String.valueOf(events.get_eventtime()));
        values.put(KEY_CATEGORY_ID, events.get_category_id());
        values.put(KEY_EMAIL, events.get_email());
        values.put(KEY_PUBLISHED, events.get_published());
        values.put(KEY_SFF, events.get_sff());
        values.put(KEY_SPECIAL, events.get_special());

        // updating row
        return db.update(TBL_EVENTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(events.get_id()) });
    }

    /*
     * Deleting a Events
     */
    public void deleteEvents(int events_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_EVENTS, KEY_ID + " = ?",
                new String[] { String.valueOf(events_id) });
    }



    // ************************  CATEGORIES  ************************ //
   	/*
	 * Creating a categories
	 */

    public int createEvent(Categories categories) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, categories.get_name());
        values.put(KEY_NAME_EN, categories.get_nameEn());
        values.put(KEY_NAME_LATIN, categories.get_nameLatin());
        values.put(KEY_NAME_LATIN_EN, categories.get_nameLatinEn());
        values.put(KEY_ALIAS, categories.get_alias());
        values.put(KEY_ALIAS_EN, categories.get_aliasEn());
        values.put(KEY_CLASSNAME, categories.get_classname());
        values.put(KEY_PARAMS, categories.get_params());
        values.put(KEY_HTML, categories.get_html());
        values.put(KEY_PARENT_ID, categories.get_parent_id());
        values.put(KEY_LANG_DEL, categories.get_lang_del());
        values.put(KEY_STATUS, categories.get_status());

        // insert row
        long categories_id = db.insert(TBL_CATEGORIES, null, values);

        return (int)categories_id;
    }


    /*
     * get single categories
     */

    public Categories getCategories(int categories_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TBL_CATEGORIES + " WHERE "
                + KEY_ID + " = " + categories_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Categories categories = new Categories();
        categories.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
        categories.set_classname(c.getString(c.getColumnIndex(KEY_CLASSNAME)));
        categories.set_name(c.getString(c.getColumnIndex(KEY_NAME)));
        categories.set_nameEn(c.getString(c.getColumnIndex(KEY_NAME_EN)));
        categories.set_nameLatin(c.getString(c.getColumnIndex(KEY_NAME_LATIN)));
        categories.set_nameLatinEn(c.getString(c.getColumnIndex(KEY_NAME_LATIN_EN)));
        categories.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
        categories.set_aliasEn(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));
        categories.set_params(c.getString(c.getColumnIndex(KEY_PARAMS)));
        categories.set_html(c.getString(c.getColumnIndex(KEY_HTML)));
        categories.set_parent_id(c.getInt(c.getColumnIndex(KEY_PARENT_ID)));
        categories.set_status(c.getInt(c.getColumnIndex(KEY_STATUS)));
        categories.set_lang_del(c.getInt(c.getColumnIndex(KEY_LANG_DEL)));

        return categories;
    }

    /**
     * getting all categories
     * */
    public List<Categories> getAllCategories() {
        List<Categories> categories_list = new ArrayList<Categories>();
        String selectQuery = "SELECT  * FROM " + TBL_CATEGORIES;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Categories categories = new Categories();
                categories.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                categories.set_classname(c.getString(c.getColumnIndex(KEY_CLASSNAME)));
                categories.set_name(c.getString(c.getColumnIndex(KEY_NAME)));
                categories.set_nameEn(c.getString(c.getColumnIndex(KEY_NAME_EN)));
                categories.set_nameLatin(c.getString(c.getColumnIndex(KEY_NAME_LATIN)));
                categories.set_nameLatinEn(c.getString(c.getColumnIndex(KEY_NAME_LATIN_EN)));
                categories.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
                categories.set_aliasEn(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));
                categories.set_params(c.getString(c.getColumnIndex(KEY_PARAMS)));
                categories.set_html(c.getString(c.getColumnIndex(KEY_HTML)));
                categories.set_parent_id(c.getInt(c.getColumnIndex(KEY_PARENT_ID)));
                categories.set_status(c.getInt(c.getColumnIndex(KEY_STATUS)));
                categories.set_lang_del(c.getInt(c.getColumnIndex(KEY_LANG_DEL)));

                // adding to transaction list
                categories_list.add(categories);
            } while (c.moveToNext());
        }

        return categories_list;
    }


    /*
     * getting categories count
     */
    public int getCategoriesCount() {
        String countQuery = "SELECT  * FROM " + TBL_CATEGORIES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a categories
     */
    public int updateCategories(Categories categories) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, categories.get_name());
        values.put(KEY_NAME_EN, categories.get_nameEn());
        values.put(KEY_NAME_LATIN, categories.get_nameLatin());
        values.put(KEY_NAME_LATIN_EN, categories.get_nameLatinEn());
        values.put(KEY_ALIAS, categories.get_alias());
        values.put(KEY_ALIAS_EN, categories.get_aliasEn());
        values.put(KEY_CLASSNAME, categories.get_classname());
        values.put(KEY_PARAMS, categories.get_params());
        values.put(KEY_HTML, categories.get_html());
        values.put(KEY_PARENT_ID, categories.get_parent_id());
        values.put(KEY_LANG_DEL, categories.get_lang_del());
        values.put(KEY_STATUS, categories.get_status());

        // updating row
        return db.update(TBL_CATEGORIES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(categories.get_id()) });
    }

    /*
     * Deleting a categories
     */
    public void deleteCategories(int categories_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_CATEGORIES, KEY_ID + " = ?",
                new String[] { String.valueOf(categories_id) });
    }
//

    //******************** CATEGORIES_EVENTS ********************** //
   	/*
	 * Creating a categories_events
	 */

    public int createEvent(CategoriesEvents categoriesEvents) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CLASSES, categoriesEvents.get_classes());
        values.put(KEY_TITLE, categoriesEvents.get_title());
        values.put(KEY_TITLE_EN, categoriesEvents.get_titleEn());
        // insert row
        long categoriesEvents_id = db.insert(TBL_CATEGORIES_EVENTS, null, values);

        return (int)categoriesEvents_id;
    }


    /*
     * get single categories_events
     */

    public CategoriesEvents getCategoriesEvents(int categories_events_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TBL_CATEGORIES_EVENTS + " WHERE "
                + KEY_ID + " = " + categories_events_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        CategoriesEvents categoriesEvents = new CategoriesEvents();
        categoriesEvents.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
        categoriesEvents.set_classes(c.getString(c.getColumnIndex(KEY_CLASSES)));
        categoriesEvents.set_title(c.getString(c.getColumnIndex(KEY_TITLE)));
        categoriesEvents.set_titleEn(c.getString(c.getColumnIndex(KEY_TITLE_EN)));

        return categoriesEvents;
    }

    /**
     * getting all categories_events
     * */
    public List<CategoriesEvents> getAllCategoriesEvents() {
        List<CategoriesEvents> categories_eventses = new ArrayList<CategoriesEvents>();
        String selectQuery = "SELECT  * FROM " + TBL_CATEGORIES_EVENTS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                CategoriesEvents categoriesEvents = new CategoriesEvents();
                categoriesEvents.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                categoriesEvents.set_classes(c.getString(c.getColumnIndex(KEY_CLASSES)));
                categoriesEvents.set_title(c.getString(c.getColumnIndex(KEY_TITLE)));
                categoriesEvents.set_titleEn(c.getString(c.getColumnIndex(KEY_TITLE_EN)));

                // adding to transaction list
                categories_eventses.add(categoriesEvents);
            } while (c.moveToNext());
        }

        return categories_eventses;
    }


    /*
     * getting categoriesEvents count
     */
    public int getCategoriesEventsCount() {
        String countQuery = "SELECT  * FROM " + TBL_CATEGORIES_EVENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a categoriesEvents
     */
    public int updateCategoriesEvennts(CategoriesEvents categoriesEvents) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CLASSES, categoriesEvents.get_classes());
        values.put(KEY_TITLE, categoriesEvents.get_title());
        values.put(KEY_TITLE_EN, categoriesEvents.get_titleEn());

        // updating row
        return db.update(TBL_CATEGORIES_EVENTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(categoriesEvents.get_id()) });
    }

    /*
     * Deleting a categoriesEvents
     */
    public void deleteCategoriesEvents(int categories_events_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_CATEGORIES_EVENTS, KEY_ID + " = ?",
                new String[] { String.valueOf(categories_events_id) });
    }

//*******************************************************************//
//	/*
//	 * Creating a obj_points
//	 */
//
    public int createEvent(ObjPoints objPoints) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAZIV, objPoints.get_naziv());
        values.put(KEY_ALIAS, objPoints.get_alias());
        values.put(KEY_CAT_ID, objPoints.get_cat_id());
        values.put(KEY_STREET_ID, objPoints.get_street_id());
        values.put(KEY_DESCRIPTION, objPoints.get_description());
        values.put(KEY_LAT, objPoints.get_lat());
        values.put(KEY_LON, objPoints.get_lon());
        values.put(KEY_OBJ_INFO, objPoints.get_obj_info());
        values.put(KEY_STV, objPoints.get_stv());
        values.put(KEY_KRPANO, objPoints.get_krpano());
        values.put(KEY_STATUS, objPoints.get_status());
        values.put(KEY_SEARCHKEYWORDS, objPoints.get_searchkeywords());
        values.put(KEY_COUNTER, objPoints.get_counter());
        values.put(KEY_MINZOOM, objPoints.get_minzoom());
        values.put(KEY_STREETNUMBER, objPoints.get_streetnumber());
        values.put(KEY_INBUILDINGLAVEL, objPoints.get_inbuildinglevel());
        values.put(KEY_VRSTA, objPoints.get_vrsta());
        values.put(KEY_PARENT_ID, objPoints.get_parent_id());
        values.put(KEY_PACKAGE, objPoints.get_packages());
        values.put(KEY_SHOW_ON_SEARCH, objPoints.get_showOnSearch());
        values.put(KEY_NAZIV_LAITN, objPoints.get_nazivLatin());
        values.put(KEY_SEARCHKEYWORDS_LATIN, objPoints.get_searchkeywordsLatin());
        values.put(KEY_OBJ_INFO_LATIN, objPoints.get_obj_infoLatin());
        values.put(KEY_USR, objPoints.get_usr());
        values.put(KEY_NAZIV_EN, objPoints.get_nazivEn());
        values.put(KEY_ALIAS_EN, objPoints.get_aliasEn());
        values.put(KEY_DESCRIPTION_EN, objPoints.get_descriptionEn());
        values.put(KEY_OBJ_INFO_EN, objPoints.get_obj_infoEn());
        values.put(KEY_NAZIV_LATIN_EN, objPoints.get_nazivLatinEn());
        values.put(KEY_OBJ_INFO_LATIN_EN, objPoints.get_obj_infoLatinEn());
        values.put(KEY_CREATED, objPoints.get_created());
        values.put(KEY_STATUS_TRUE, objPoints.get_status_true());
        values.put(KEY_STATUS_UPDATE, objPoints.get_status_update());

        // insert row
        long objPoints_id = db.insert(TBL_OBJ_POINTS, null, values);

        return (int)objPoints_id;
    }


    /*
     * get single obj_points
     */

    public ObjPoints getObjPoints(int objPoints_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TBL_OBJ_POINTS + " WHERE "
                + KEY_ID + " = " + objPoints_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        ObjPoints objPoints = new ObjPoints();
        objPoints.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
        objPoints.set_naziv(c.getString(c.getColumnIndex(KEY_NAZIV)));
        objPoints.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
        objPoints.set_street_id(c.getInt(c.getColumnIndex(KEY_STREET_ID)));
        objPoints.set_description(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
        objPoints.set_lat(c.getString(c.getColumnIndex(KEY_LAT)));
        objPoints.set_lon(c.getString(c.getColumnIndex(KEY_LON)));
        objPoints.set_obj_info(c.getString(c.getColumnIndex(KEY_OBJ_INFO)));
        objPoints.set_stv(c.getInt(c.getColumnIndex(KEY_STV)));
        objPoints.set_krpano(c.getString(c.getColumnIndex(KEY_KRPANO)));
        objPoints.set_status(c.getInt(c.getColumnIndex(KEY_STATUS)));
        objPoints.set_searchkeywords(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS)));
        objPoints.set_counter(c.getInt(c.getColumnIndex(KEY_COUNTER)));
        objPoints.set_minzoom(c.getInt(c.getColumnIndex(KEY_MINZOOM)));
        objPoints.set_streetnumber(c.getString(c.getColumnIndex(KEY_STREETNUMBER)));
        objPoints.set_inbuildinglevel(c.getString(c.getColumnIndex(KEY_INBUILDINGLAVEL)));
        objPoints.set_vrsta(c.getInt(c.getColumnIndex(KEY_VRSTA)));
        objPoints.set_parent_id(c.getInt(c.getColumnIndex(KEY_PARENT_ID)));
        objPoints.set_packages(c.getInt(c.getColumnIndex(KEY_PACKAGE)));
        objPoints.set_showOnSearch(c.getInt(c.getColumnIndex(KEY_SHOW_ON_SEARCH)));
        objPoints.set_nazivLatin(c.getString(c.getColumnIndex(KEY_NAZIV_LAITN)));
        objPoints.set_searchkeywordsLatin(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS_LATIN)));
        objPoints.set_obj_infoLatin(c.getString(c.getColumnIndex(KEY_OBJ_INFO_LATIN)));
        objPoints.set_usr(c.getInt(c.getColumnIndex(KEY_USR)));
        objPoints.set_nazivEn(c.getString(c.getColumnIndex(KEY_NAZIV_EN)));
        objPoints.set_aliasEn(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));
        objPoints.set_descriptionEn(c.getString(c.getColumnIndex(KEY_DESCRIPTION_EN)));
        objPoints.set_obj_infoEn(c.getString(c.getColumnIndex(KEY_OBJ_INFO_EN)));
        objPoints.set_nazivLatinEn(c.getString(c.getColumnIndex(KEY_NAZIV_LATIN_EN)));
        objPoints.set_obj_infoLatinEn(c.getString(c.getColumnIndex(KEY_OBJ_INFO_LATIN_EN)));
        objPoints.set_created(c.getString(c.getColumnIndex(KEY_CREATED)));
        objPoints.set_status_true(c.getString(c.getColumnIndex(KEY_STATUS_TRUE)));
        objPoints.set_status_update(c.getString(c.getColumnIndex(KEY_STATUS_UPDATE)));

        return objPoints;
    }

    /**
     * getting all obj_points
     * */
    public List<ObjPoints> getAllObjPoints() {
        List<ObjPoints> objpointses = new ArrayList<ObjPoints>();
        String selectQuery = "SELECT  * FROM " + TBL_OBJ_POINTS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                ObjPoints objPoints = new ObjPoints();
                objPoints.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                objPoints.set_naziv(c.getString(c.getColumnIndex(KEY_NAZIV)));
                objPoints.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
                objPoints.set_street_id(c.getInt(c.getColumnIndex(KEY_STREET_ID)));
                objPoints.set_description(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
                objPoints.set_lat(c.getString(c.getColumnIndex(KEY_LAT)));
                objPoints.set_lon(c.getString(c.getColumnIndex(KEY_LON)));
                objPoints.set_obj_info(c.getString(c.getColumnIndex(KEY_OBJ_INFO)));
                objPoints.set_stv(c.getInt(c.getColumnIndex(KEY_STV)));
                objPoints.set_krpano(c.getString(c.getColumnIndex(KEY_KRPANO)));
                objPoints.set_status(c.getInt(c.getColumnIndex(KEY_STATUS)));
                objPoints.set_searchkeywords(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS)));
                objPoints.set_counter(c.getInt(c.getColumnIndex(KEY_COUNTER)));
                objPoints.set_minzoom(c.getInt(c.getColumnIndex(KEY_MINZOOM)));
                objPoints.set_streetnumber(c.getString(c.getColumnIndex(KEY_STREETNUMBER)));
                objPoints.set_inbuildinglevel(c.getString(c.getColumnIndex(KEY_INBUILDINGLAVEL)));
                objPoints.set_vrsta(c.getInt(c.getColumnIndex(KEY_VRSTA)));
                objPoints.set_parent_id(c.getInt(c.getColumnIndex(KEY_PARENT_ID)));
                objPoints.set_packages(c.getInt(c.getColumnIndex(KEY_PACKAGE)));
                objPoints.set_showOnSearch(c.getInt(c.getColumnIndex(KEY_SHOW_ON_SEARCH)));
                objPoints.set_nazivLatin(c.getString(c.getColumnIndex(KEY_NAZIV_LAITN)));
                objPoints.set_searchkeywordsLatin(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS_LATIN)));
                objPoints.set_obj_infoLatin(c.getString(c.getColumnIndex(KEY_OBJ_INFO_LATIN)));
                objPoints.set_usr(c.getInt(c.getColumnIndex(KEY_USR)));
                objPoints.set_nazivEn(c.getString(c.getColumnIndex(KEY_NAZIV_EN)));
                objPoints.set_aliasEn(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));
                objPoints.set_descriptionEn(c.getString(c.getColumnIndex(KEY_DESCRIPTION_EN)));
                objPoints.set_obj_infoEn(c.getString(c.getColumnIndex(KEY_OBJ_INFO_EN)));
                objPoints.set_nazivLatinEn(c.getString(c.getColumnIndex(KEY_NAZIV_LATIN_EN)));
                objPoints.set_obj_infoLatinEn(c.getString(c.getColumnIndex(KEY_OBJ_INFO_LATIN_EN)));
                objPoints.set_created(c.getString(c.getColumnIndex(KEY_CREATED)));
                objPoints.set_status_true(c.getString(c.getColumnIndex(KEY_STATUS_TRUE)));
                objPoints.set_status_update(c.getString(c.getColumnIndex(KEY_STATUS_UPDATE)));

                // adding to transaction list
                objpointses.add(objPoints);
            } while (c.moveToNext());
        }

        return objpointses;
    }

    public List<ObjPoints> getObjPointsByCat(int cat_id) {

        List<ObjPoints> objpointses = new ArrayList<ObjPoints>();
        String selectQuery = "SELECT  * FROM " + TBL_OBJ_POINTS  + " WHERE " +  KEY_CAT_ID + " = " + cat_id;
        Log.e(LOG, selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                ObjPoints objPoints = new ObjPoints();
                objPoints.set_cat_id(c.getInt(c.getColumnIndex(KEY_CAT_ID)));
                objPoints.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                objPoints.set_naziv(c.getString(c.getColumnIndex(KEY_NAZIV)));
                objPoints.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
                objPoints.set_street_id(c.getInt(c.getColumnIndex(KEY_STREET_ID)));
                objPoints.set_description(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
                objPoints.set_lat(c.getString(c.getColumnIndex(KEY_LAT)));
                objPoints.set_lon(c.getString(c.getColumnIndex(KEY_LON)));
                objPoints.set_obj_info(c.getString(c.getColumnIndex(KEY_OBJ_INFO)));
                objPoints.set_stv(c.getInt(c.getColumnIndex(KEY_STV)));
                objPoints.set_krpano(c.getString(c.getColumnIndex(KEY_KRPANO)));
                objPoints.set_status(c.getInt(c.getColumnIndex(KEY_STATUS)));
                objPoints.set_searchkeywords(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS)));
                objPoints.set_counter(c.getInt(c.getColumnIndex(KEY_COUNTER)));
                objPoints.set_minzoom(c.getInt(c.getColumnIndex(KEY_MINZOOM)));
                objPoints.set_streetnumber(c.getString(c.getColumnIndex(KEY_STREETNUMBER)));
                objPoints.set_inbuildinglevel(c.getString(c.getColumnIndex(KEY_INBUILDINGLAVEL)));
                objPoints.set_vrsta(c.getInt(c.getColumnIndex(KEY_VRSTA)));
                objPoints.set_parent_id(c.getInt(c.getColumnIndex(KEY_PARENT_ID)));
                objPoints.set_packages(c.getInt(c.getColumnIndex(KEY_PACKAGE)));
                objPoints.set_showOnSearch(c.getInt(c.getColumnIndex(KEY_SHOW_ON_SEARCH)));
                objPoints.set_nazivLatin(c.getString(c.getColumnIndex(KEY_NAZIV_LAITN)));
                objPoints.set_searchkeywordsLatin(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS_LATIN)));
                objPoints.set_obj_infoLatin(c.getString(c.getColumnIndex(KEY_OBJ_INFO_LATIN)));
                objPoints.set_usr(c.getInt(c.getColumnIndex(KEY_USR)));
                objPoints.set_nazivEn(c.getString(c.getColumnIndex(KEY_NAZIV_EN)));
                objPoints.set_aliasEn(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));
                objPoints.set_descriptionEn(c.getString(c.getColumnIndex(KEY_DESCRIPTION_EN)));
                objPoints.set_obj_infoEn(c.getString(c.getColumnIndex(KEY_OBJ_INFO_EN)));
                objPoints.set_nazivLatinEn(c.getString(c.getColumnIndex(KEY_NAZIV_LATIN_EN)));
                objPoints.set_obj_infoLatinEn(c.getString(c.getColumnIndex(KEY_OBJ_INFO_LATIN_EN)));
                objPoints.set_created(c.getString(c.getColumnIndex(KEY_CREATED)));
                objPoints.set_status_true(c.getString(c.getColumnIndex(KEY_STATUS_TRUE)));
                objPoints.set_status_update(c.getString(c.getColumnIndex(KEY_STATUS_UPDATE)));

                // adding to transaction list
                objpointses.add(objPoints);
            } while (c.moveToNext());
        }

        return objpointses;
    }

    public List<ObjPoints> getObjPointsByAllCat() {

        List<ObjPoints> objpointses = new ArrayList<ObjPoints>();
        String selectQuery = "SELECT  * FROM " + TBL_OBJ_POINTS  + " WHERE " +  KEY_CAT_ID + " = " + "5 OR 2 OR 17 OR 38 OR 27 OR 51 OR 22";
        Log.e(LOG, selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                ObjPoints objPoints = new ObjPoints();
                objPoints.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                objPoints.set_cat_id(c.getInt(c.getColumnIndex(KEY_CAT_ID)));
                objPoints.set_naziv(c.getString(c.getColumnIndex(KEY_NAZIV)));
                objPoints.set_alias(c.getString(c.getColumnIndex(KEY_ALIAS)));
                objPoints.set_street_id(c.getInt(c.getColumnIndex(KEY_STREET_ID)));
                objPoints.set_description(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
                objPoints.set_lat(c.getString(c.getColumnIndex(KEY_LAT)));
                objPoints.set_lon(c.getString(c.getColumnIndex(KEY_LON)));
                objPoints.set_obj_info(c.getString(c.getColumnIndex(KEY_OBJ_INFO)));
                objPoints.set_stv(c.getInt(c.getColumnIndex(KEY_STV)));
                objPoints.set_krpano(c.getString(c.getColumnIndex(KEY_KRPANO)));
                objPoints.set_status(c.getInt(c.getColumnIndex(KEY_STATUS)));
                objPoints.set_searchkeywords(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS)));
                objPoints.set_counter(c.getInt(c.getColumnIndex(KEY_COUNTER)));
                objPoints.set_minzoom(c.getInt(c.getColumnIndex(KEY_MINZOOM)));
                objPoints.set_streetnumber(c.getString(c.getColumnIndex(KEY_STREETNUMBER)));
                objPoints.set_inbuildinglevel(c.getString(c.getColumnIndex(KEY_INBUILDINGLAVEL)));
                objPoints.set_vrsta(c.getInt(c.getColumnIndex(KEY_VRSTA)));
                objPoints.set_parent_id(c.getInt(c.getColumnIndex(KEY_PARENT_ID)));
                objPoints.set_packages(c.getInt(c.getColumnIndex(KEY_PACKAGE)));
                objPoints.set_showOnSearch(c.getInt(c.getColumnIndex(KEY_SHOW_ON_SEARCH)));
                objPoints.set_nazivLatin(c.getString(c.getColumnIndex(KEY_NAZIV_LAITN)));
                objPoints.set_searchkeywordsLatin(c.getString(c.getColumnIndex(KEY_SEARCHKEYWORDS_LATIN)));
                objPoints.set_obj_infoLatin(c.getString(c.getColumnIndex(KEY_OBJ_INFO_LATIN)));
                objPoints.set_usr(c.getInt(c.getColumnIndex(KEY_USR)));
                objPoints.set_nazivEn(c.getString(c.getColumnIndex(KEY_NAZIV_EN)));
                objPoints.set_aliasEn(c.getString(c.getColumnIndex(KEY_ALIAS_EN)));
                objPoints.set_descriptionEn(c.getString(c.getColumnIndex(KEY_DESCRIPTION_EN)));
                objPoints.set_obj_infoEn(c.getString(c.getColumnIndex(KEY_OBJ_INFO_EN)));
                objPoints.set_nazivLatinEn(c.getString(c.getColumnIndex(KEY_NAZIV_LATIN_EN)));
                objPoints.set_obj_infoLatinEn(c.getString(c.getColumnIndex(KEY_OBJ_INFO_LATIN_EN)));
                objPoints.set_created(c.getString(c.getColumnIndex(KEY_CREATED)));
                objPoints.set_status_true(c.getString(c.getColumnIndex(KEY_STATUS_TRUE)));
                objPoints.set_status_update(c.getString(c.getColumnIndex(KEY_STATUS_UPDATE)));

                // adding to transaction list
                objpointses.add(objPoints);
            } while (c.moveToNext());
        }

        return objpointses;
    }

    /*
     * getting city count
     */
    public int getObjPointsCount() {
        String countQuery = "SELECT  * FROM " + TBL_OBJ_POINTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a obj_points
     */
    public int updateCity(ObjPoints objPoints) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAZIV, objPoints.get_naziv());
        values.put(KEY_ALIAS, objPoints.get_alias());
        values.put(KEY_CAT_ID, objPoints.get_cat_id());
        values.put(KEY_STREET_ID, objPoints.get_street_id());
        values.put(KEY_DESCRIPTION, objPoints.get_description());
        values.put(KEY_LAT, objPoints.get_lat());
        values.put(KEY_LON, objPoints.get_lon());
        values.put(KEY_OBJ_INFO, objPoints.get_obj_info());
        values.put(KEY_STV, objPoints.get_stv());
        values.put(KEY_KRPANO, objPoints.get_krpano());
        values.put(KEY_STATUS, objPoints.get_status());
        values.put(KEY_SEARCHKEYWORDS, objPoints.get_searchkeywords());
        values.put(KEY_COUNTER, objPoints.get_counter());
        values.put(KEY_MINZOOM, objPoints.get_minzoom());
        values.put(KEY_STREETNUMBER, objPoints.get_streetnumber());
        values.put(KEY_INBUILDINGLAVEL, objPoints.get_inbuildinglevel());
        values.put(KEY_VRSTA, objPoints.get_vrsta());
        values.put(KEY_PARENT_ID, objPoints.get_parent_id());
        values.put(KEY_PACKAGE, objPoints.get_packages());
        values.put(KEY_SHOW_ON_SEARCH, objPoints.get_showOnSearch());
        values.put(KEY_NAZIV_LAITN, objPoints.get_nazivLatin());
        values.put(KEY_SEARCHKEYWORDS_LATIN, objPoints.get_searchkeywordsLatin());
        values.put(KEY_OBJ_INFO_LATIN, objPoints.get_obj_infoLatin());
        values.put(KEY_USR, objPoints.get_usr());
        values.put(KEY_NAZIV_EN, objPoints.get_nazivEn());
        values.put(KEY_ALIAS_EN, objPoints.get_aliasEn());
        values.put(KEY_DESCRIPTION_EN, objPoints.get_descriptionEn());
        values.put(KEY_OBJ_INFO_EN, objPoints.get_obj_infoEn());
        values.put(KEY_NAZIV_LATIN_EN, objPoints.get_nazivLatinEn());
        values.put(KEY_OBJ_INFO_LATIN_EN, objPoints.get_obj_infoLatinEn());
        values.put(KEY_CREATED, objPoints.get_created());
        values.put(KEY_STATUS_TRUE, objPoints.get_status_true());
        values.put(KEY_STATUS_UPDATE, objPoints.get_status_update());

        // updating row
        return db.update(TBL_OBJ_POINTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(objPoints.get_id()) });
    }

    /*
     * Deleting a obj_points
     */
    public void deleteObjPoints(int objpoints_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_OBJ_POINTS, KEY_ID + " = ?",
                new String[] { String.valueOf(objpoints_id) });
    }
//*******************************************************************//



}
