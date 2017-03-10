package com.rutmap.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rutmap.MainActivity;
import com.rutmap.MapBoxActivity;
import com.rutmap.Model.GlobData;
import com.rutmap.Model.ObjPoints;
import com.rutmap.R;
import com.rutmap.Utils.Common;

import java.util.ArrayList;

/**
 * Created by Administrator on 2/26/2017.
 */

public class EventDetailPageFragment extends Fragment {

    public EventDetailPageFragment() {
        // Required empty public constructor
    }

    LayoutInflater mInflater;
    MainActivity mContext;
    LinearLayout lyMain;
    public Bitmap bitmap, obj_point;
    public String strStreet, strEventTime, strTitle;
    int strEventId , mObject_id;
    public String strEmail;
    public String strWeb, strEvent_detsile, strTelephone;
    LinearLayout  mLyContainerEvent;
    LayoutInflater mInflater1;
    View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_eventdetail, container, false);
        mContext = (MainActivity)getActivity();
        mInflater = LayoutInflater.from(getActivity());

        setUI(mView);
//        initData();
        presentData();

        return mView;
    }

    void setUI(View mView) {
//        lyMain = (LinearLayout)mView.findViewById(R.id.lyMain);
//        mView.findViewById(R.id.imgSideMenu).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mContext.toggleMenu();
//            }
//        });
        //       mLyContainerEvent.removeAllViews();

        View cell = null;
        //= mInflater.inflate(R.layout.cell_event_top, null);
//        View cell = mInflater.inflate(R.layout.cell_event_top, null);
       mLyContainerEvent = (LinearLayout) mView.findViewById(R.id.lyEventTopView);


//        mLyContainerEvent.removeAllViews();

        ImageView imgvProduct;

          switch (strEventId) {
            case 1:
                cell = mInflater.inflate(R.layout.cell_event_film, null);
                imgvProduct = (ImageView) cell.findViewById(R.id.imgvProduct);
                imgvProduct.setImageResource(R.drawable.background_film1);
                imgvProduct.setImageBitmap(bitmap);
                break;

            case 2:

                cell = mInflater.inflate(R.layout.cell_event_sport, null);
                imgvProduct = (ImageView) cell.findViewById(R.id.imgvProduct);
                imgvProduct.setImageResource(R.drawable.sport_background);
                imgvProduct.setImageBitmap(bitmap);
                break;

            case 3:

                cell = mInflater.inflate(R.layout.cell_event_theatre, null);
                imgvProduct = (ImageView) cell.findViewById(R.id.imgvProduct);
                imgvProduct.setImageResource(R.drawable.img_theatre);
                imgvProduct.setImageBitmap(bitmap);
                break;

            case 4:

                cell = mInflater.inflate(R.layout.cell_event_music, null);
                imgvProduct = (ImageView) cell.findViewById(R.id.imgvProduct);
                imgvProduct.setImageResource(R.drawable.img_music);
                imgvProduct.setImageBitmap(bitmap);
                break;

            case 5:

                cell = mInflater.inflate(R.layout.cell_event_other, null);
                imgvProduct = (ImageView) cell.findViewById(R.id.imgvProduct);
                imgvProduct.setImageResource(R.drawable.img_other);
                imgvProduct.setImageBitmap(bitmap);
                break;

            default:
                break;
        }

        ((TextView) cell.findViewById(R.id.tvTitle)).setText(strTitle);
        ((TextView) cell.findViewById(R.id.tvEvenTime)).setText(strEventTime);

        ((TextView) mView.findViewById(R.id.tvTelephone)).setText(strTelephone);
        ((TextView) mView.findViewById(R.id.tvEmail)).setText(strEmail);
        ((TextView) mView.findViewById(R.id.tvEventDetails)).setText(strEvent_detsile);


        mLyContainerEvent.addView(cell);

    }

    void presentData(){
//        mLyContainerEvent = (LinearLayout) mView.findViewById(R.id.lyNavigation);
        LinearLayout cell = (LinearLayout) mView.findViewById(R.id.lyNavigation);
        cell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for( int i = 0 ; i <  Common.getInstance().listObjPoints.size() ; i ++ ){

                    ObjPoints obj_point = Common.getInstance().listObjPoints.get(i);
                    if ( obj_point.get_id() == mObject_id ) {

                        ArrayList <ObjPoints> points = new ArrayList<ObjPoints>();
                        points.add(obj_point);
                        GlobData.points = points;

                        Intent intent = new Intent(mContext, MapBoxActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

}
