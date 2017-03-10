package com.rutmap.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.opengl.GLDebugHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rutmap.FirstActivity;
import com.rutmap.InfoActivity;
import com.rutmap.MainActivity;
import com.rutmap.MapBoxActivity;
import com.rutmap.Model.Events;
import com.rutmap.Model.GlobData;
import com.rutmap.Model.ObjPoints;
import com.rutmap.R;
import com.rutmap.SwipeGestureListener.OnSwipeTouchListener;
import com.rutmap.Utils.Common;
import com.rutmap.Utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class MainPageFragment extends Fragment {


    public MainPageFragment() {
        // Required empty public constructor
    }

    LayoutInflater mInflater;
    View mView;
    MainActivity mContext;
    LinearLayout lyMain;
    RelativeLayout reLayoutAllContainer, relLayoutFood, relLayoutArts, relLayoutShopsAndServices, relLayoutEducation,
                    rellayoutNightLife,relLayoutParks, relLayoutTourism, rellayoutAccommodation;

    // for mockup
    LinearLayout linLayoutEvents, linLayoutCategories, linLayoutMapbox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_mainpage, container, false);
        mContext = (MainActivity)getActivity();
        mInflater = inflater;

        setUI();
        return mView;
    }

    void setUI() {
        lyMain = (LinearLayout)mView.findViewById(R.id.lyMain);
        mView.findViewById(R.id.imgSideMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.toggleMenu();
            }
        });

        lyMain.setOnTouchListener(new OnSwipeTouchListener(mContext) {
            public void onSwipeRight() {
            }
            public void onSwipeLeft() {
                mContext.launchFragment(2);
            }
        });

        // Events List
        linLayoutEvents = (LinearLayout)mView.findViewById(R.id.linLayoutEvents);
        linLayoutEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ((MainActivity)mContext).launchFragment(2);
                EventPageFragment f = new EventPageFragment();

                String title = Constant.FRAGMENT_EVENT;
                FragmentTransaction transaction = mContext.getSupportFragmentManager()
                        .beginTransaction();
                transaction.add(R.id.content_frame, f, title).addToBackStack(title).commit();
            }
        });

//        linLayoutCategories = (LinearLayout)mView.findViewById(R.id.linLayoutCategories);
//        linLayoutCategories.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(mContext, MapBoxActivity.class);
//                startActivity(intent);
//            }
//        });

        linLayoutMapbox = (LinearLayout) mView.findViewById(R.id.linLayoutMapbox);
        linLayoutMapbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

 //               ArrayList<ObjPoints> arrayListObjPoints = (ArrayList<ObjPoints>) Common.getInstance().jsonObjectPoint.get(strDate);
                Intent intent = new Intent(mContext, MapBoxActivity.class);
                startActivity(intent);
            }
        });

        relLayoutFood = (RelativeLayout) mView.findViewById(R.id.lyCtgrFood);
        relLayoutFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobData.mMapIcon = 1;
                GlobData.points = Common.getInstance().dbHelper.getObjPointsByCat(2);
                Intent intent = new Intent(mContext, MapBoxActivity.class);
                startActivity(intent);
            }
        });
        relLayoutEducation = (RelativeLayout) mView.findViewById(R.id.lyCtgrEducation);
        relLayoutEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobData.mMapIcon = 2;
                GlobData.points = Common.getInstance().dbHelper.getObjPointsByCat(5);
                Intent intent = new Intent(mContext, MapBoxActivity.class);
                startActivity(intent);
            }
        });
        rellayoutNightLife = (RelativeLayout) mView.findViewById(R.id.lyCtgrNightLife);
        rellayoutNightLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobData.mMapIcon = 3;
                GlobData.points = Common.getInstance().dbHelper.getObjPointsByCat(17);
                Intent intent = new Intent(mContext, MapBoxActivity.class);
                startActivity(intent);
            }
        });
        rellayoutAccommodation = (RelativeLayout) mView.findViewById(R.id.lyCtgrAccommodation);
        rellayoutAccommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobData.mMapIcon = 4;
                GlobData.points = Common.getInstance().dbHelper.getObjPointsByCat(38);
                Intent intent = new Intent(mContext, MapBoxActivity.class);
                startActivity(intent);
            }
        });
        relLayoutTourism = (RelativeLayout) mView.findViewById(R.id.lyCtgrTourism);
        relLayoutTourism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobData.mMapIcon = 5;
                GlobData.points = Common.getInstance().dbHelper.getObjPointsByCat(27);
                Intent intent = new Intent(mContext, MapBoxActivity.class);
                startActivity(intent);
            }
        });
        relLayoutShopsAndServices = (RelativeLayout) mView.findViewById(R.id.lyCtgrShops);
        relLayoutShopsAndServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobData.mMapIcon = 6;
                GlobData.points = Common.getInstance().dbHelper.getObjPointsByCat(51);
                Intent intent = new Intent(mContext, MapBoxActivity.class);
                startActivity(intent);
            }
        });
        relLayoutArts = (RelativeLayout) mView.findViewById(R.id.lyCtgrArts);
        relLayoutArts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobData.mMapIcon = 7;
                GlobData.points = Common.getInstance().dbHelper.getObjPointsByCat(22);
                Intent intent = new Intent(mContext, MapBoxActivity.class);
                startActivity(intent);
            }
        });
        relLayoutParks = (RelativeLayout) mView.findViewById(R.id.lyCtgrParks);
        relLayoutParks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobData.mMapIcon = 8;
                GlobData.points = Common.getInstance().dbHelper.getObjPointsByCat(0);
                Intent intent = new Intent(mContext, MapBoxActivity.class);
                startActivity(intent);
            }
        });

        reLayoutAllContainer = (RelativeLayout) mView.findViewById(R.id.lyAllCategory);
        reLayoutAllContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobData.points = Common.getInstance().dbHelper.getObjPointsByAllCat();
                Intent intent = new Intent(mContext, MapBoxActivity.class);
                startActivity(intent);
            }
        });

    }



}
