package com.rutmap.Utils;

import com.rutmap.Helper.DBHelper;
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

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2/13/2017.
 */

public class Common {
    static Common instance = null;

    public static Common getInstance() {
        if(instance == null){
            instance = new Common();
        }

        return instance;
    }

    public DBHelper dbHelper;
    public List<ObjPoints> listObjPoints;
    public List<Categories> listCategories;
    public List<CategoriesEvents> listCategoriesEvents;
    public List<Events> listEvents;
    public List<Streets> listStreets;
    public List<StreetPoints> listStreetPoints;
    public List<Gallery> listGallrey;
    public List<ObjPointsInfo> listObjPointsInfo;
    public List<Slider> listSlider;
    public List<Keywords> listKeywords;
    public ArrayList<String> arrayListDates;
    public JSONObject jsonObjectEvents;
    public JSONObject jsonObjectPoint;

}
