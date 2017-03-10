package com.rutmap.Fragment;


import android.app.usage.UsageEvents;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.rutmap.MainActivity;
import com.rutmap.Model.Events;
import com.rutmap.R;
import com.rutmap.SwipeGestureListener.OnSwipeTouchListener;
import com.rutmap.Utils.Common;
import com.rutmap.Utils.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventPageFragment extends Fragment {


    public EventPageFragment() {
        // Required empty public constructor
    }

    LayoutInflater mInflater,mInflaterFilm;
    View mView;
    MainActivity mContext;
    LinearLayout lyMain;
    LinearLayout mLyContainer,mLyContainerEvent;
    JSONObject jsonObjectBitMapWithUrl;
    int nIndexSelectedDate = -1;
    int intSelectedDateIndex = -1;

    private String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String weekdays[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
//    RelativeLayout mapbox;
//    JSONArray jsonArrayIdentify;
//    private int icons[] = { R.drawable.ic_tab_1, R.drawable.ic_tab_2, R.drawable.ic_tab_3};

    LinearLayout linLayoutScrollView;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_eventpage, container, false);
        mContext = (MainActivity)getActivity();
        mInflater = inflater;

        nIndexSelectedDate = -1;

        setUI();
        presentData();

        return mView;
    }


    void setUI() {
        //     lyMain = (LinearLayout)mView.findViewById(R.id.lyMain);
        mLyContainer = (LinearLayout)mView.findViewById(R.id.lyContainerSetDate);
        mView.findViewById(R.id.imgSideMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.toggleMenu();
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    void presentData() {
        mLyContainer.removeAllViews();
         intSelectedDateIndex = -1;

        for(int i = 0; i < 20; i ++) {

            View cell = mInflater.inflate(R.layout.cell_event_date, null);

            // ((TextView)cell.findViewById(R.id.txtvDate)).setText(String.format("%d", getString(i)));

            TextView tvDate = (TextView)cell.findViewById(R.id.txtvDate);
            TextView tvWeek = (TextView)cell.findViewById(R.id.txtvWeek);
            TextView tvMonth = (TextView)cell.findViewById(R.id.txtvMonth);

            final ImageView imgvSetBtn = (ImageView)cell.findViewById(R.id.imgvSetBtn);
            imgvSetBtn.setImageResource(R.drawable.btn_set);
            imgvSetBtn.setVisibility(View.INVISIBLE);

            final String strDate = Common.getInstance().arrayListDates.get(i);
            final int nIndex = i;

            String[] strElements = strDate.split("-");

            int nYear = Integer.parseInt(strElements[0]);
            int nMonth = Integer.parseInt(strElements[1]) - 1;
            int nDay = Integer.parseInt(strElements[2]);

            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.YEAR, nYear);
            calendar.set(Calendar.MONTH, nMonth);
            calendar.set(Calendar.DAY_OF_MONTH, nDay);

            int nWeekday = calendar.get(Calendar.DAY_OF_WEEK);

            tvDate.setText(nDay + "");
            tvWeek.setText(weekdays[nWeekday - 1]);
            tvMonth.setText(months[nMonth]);

            cell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mLyContainerEvent.removeAllViews();
                    if (nIndexSelectedDate != -1) {
                        View viewItem = mLyContainer.getChildAt(nIndexSelectedDate);
                        viewItem.findViewById(R.id.imgvSetBtn).setVisibility(View.INVISIBLE);
                    }

                    nIndexSelectedDate = nIndex;
                    imgvSetBtn.setVisibility(View.VISIBLE);
                    eventView(strDate);
                }
            });
            eventView(strDate);

            mLyContainer.addView(cell);
        }
    }

    int strEventId = 0;

//    int intSelectedDateIndex = -1;
    int intSelectedCategoryIndex = -1;

    String  currentSelectedDate = "";

    void eventView(String strDate){

        currentSelectedDate = strDate;

        try {
            ArrayList<Events> arrayListEvents = (ArrayList<Events>) Common.getInstance().jsonObjectEvents.get(strDate);
            jsonObjectBitMapWithUrl = new JSONObject();
            LinearLayout item;View child = null;
            ImageView imgvProduct;

            for(int j = 0; j < arrayListEvents.size(); j ++) {
                Events event = arrayListEvents.get(j);
                strEventId = event.get_category_id();

                if (intSelectedCategoryIndex != -1) {
                    if (strEventId != intSelectedCategoryIndex) continue;
                }

                mLyContainerEvent = (LinearLayout) mView.findViewById(R.id.linLayoutScrollView);
                RelativeLayout cell_film = (RelativeLayout)mView.findViewById(R.id.cell_ctgr_film_c);
                cell_film.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intSelectedCategoryIndex = 1;
                        mLyContainerEvent.removeAllViews();

                        if (intSelectedDateIndex == -1) {
                            for(int i = 0; i < 20; i ++) {
                                String strDate = Common.getInstance().arrayListDates.get(i);

                                eventView(strDate);
                            }
                        } else {
                            eventView(currentSelectedDate);
                        }

                    }
                });
                RelativeLayout cell_music = (RelativeLayout)mView.findViewById(R.id.cell_ctgr_music_c);
                cell_music.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intSelectedCategoryIndex = 4;
                        mLyContainerEvent.removeAllViews();

                        if (intSelectedDateIndex == -1) {
                            for(int i = 0; i < 20; i ++) {
                                String strDate = Common.getInstance().arrayListDates.get(i);

                                eventView(strDate);
                            }
                        } else {
                            eventView(currentSelectedDate);
                        }
                    }
                });
                View cell_other = (RelativeLayout)mView.findViewById(R.id.cell_ctgr_other_c);
                cell_other.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intSelectedCategoryIndex = 5;
                        mLyContainerEvent.removeAllViews();

                        if (intSelectedDateIndex == -1) {
                            for(int i = 0; i < 20; i ++) {
                                String strDate = Common.getInstance().arrayListDates.get(i);

                                eventView(strDate);
                            }
                        } else {
                            eventView(currentSelectedDate);
                        }
                    }
                });
                View cell_sport = (RelativeLayout)mView.findViewById(R.id.cell_ctgr_sport_c);
                cell_sport.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intSelectedCategoryIndex = 2;
                        mLyContainerEvent.removeAllViews();

                        if (intSelectedDateIndex == -1) {
                            for(int i = 0; i < 20; i ++) {
                                String strDate = Common.getInstance().arrayListDates.get(i);

                                eventView(strDate);
                            }
                        } else {
                            eventView(currentSelectedDate);
                        }
                    }
                });
                View cell_theatre = (RelativeLayout)mView.findViewById(R.id.cell_ctgr_theatre_c);
                cell_theatre.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intSelectedCategoryIndex = 3;
                        mLyContainerEvent.removeAllViews();

                        if (intSelectedDateIndex == -1) {
                            for(int i = 0; i < 20; i ++) {
                                String strDate = Common.getInstance().arrayListDates.get(i);

                                eventView(strDate);
                            }
                        } else {
                            eventView(currentSelectedDate);
                        }
                    }
                });

                switch (strEventId) {
                   case 1:
                        child = mInflater.inflate(R.layout.cell_event_film, null);
                        imgvProduct = (ImageView) child.findViewById(R.id.imgvProduct);
                        imgvProduct.setImageResource(R.drawable.event_img2);
                        imageLord(child, event,mLyContainerEvent,imgvProduct);
                        break;

                    case 2:

                        child = mInflater.inflate(R.layout.cell_event_sport, null);
                        imgvProduct = (ImageView) child.findViewById(R.id.imgvProduct);
                        imgvProduct.setImageResource(R.drawable.sport_background);
                        imageLord(child, event,mLyContainerEvent,imgvProduct);
                        break;

                    case 3:

                        child = mInflater.inflate(R.layout.cell_event_theatre, null);
                        imgvProduct = (ImageView) child.findViewById(R.id.imgvProduct);
                        imgvProduct.setImageResource(R.drawable.img_theatre);
                        imageLord(child, event,mLyContainerEvent,imgvProduct);
                        break;

                    case 4:

                        child = mInflater.inflate(R.layout.cell_event_music, null);
                        imgvProduct = (ImageView) child.findViewById(R.id.imgvProduct);
                        imgvProduct.setImageResource(R.drawable.img_music);
                        imageLord(child, event,mLyContainerEvent,imgvProduct);
                        break;

                    case 5:

                        child = mInflater.inflate(R.layout.cell_event_other, null);
                        imgvProduct = (ImageView) child.findViewById(R.id.imgvProduct);
                        imgvProduct.setImageResource(R.drawable.img_other);
                        imageLord(child, event,mLyContainerEvent,imgvProduct);
                        break;

                    default:
                        break;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    void imageLord(View child1, final Events event, LinearLayout lyEmpty, final ImageView imgvProduct){

        imgvProduct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EventDetailPageFragment f = new EventDetailPageFragment();
                f.strEventId = event.get_category_id();
                f.strEmail = event.get_email();
                f.strEvent_detsile =event.get_detailsEn();
                f.strTitle=event.get_title();
                f.strEventTime = event.get_eventtime();
                f.strTelephone = event.get_tel();
                f.strEvent_detsile = event.get_detailsEn();
                f.mObject_id = event.get_object_id();

                String title = Constant.FRAGMENT_EVENT_DETAIL;
                FragmentTransaction transaction = mContext.getSupportFragmentManager()
                        .beginTransaction();
                transaction.add(R.id.content_frame, f, title).addToBackStack(title).commit();
            }
        });

        ((TextView) child1.findViewById(R.id.tvTitle)).setText(event.get_title());
        ((TextView) child1.findViewById(R.id.tvEvenTime)).setText(event.get_eventtime());
        String strImageUrl =  event.get_mainPic();

        if (strImageUrl.length() > 0) {

            strImageUrl= "http://rutmap.ba"+event.get_mainPic();
            ImageLoader.getInstance().loadImage(strImageUrl, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {
//                    imgvSpinner.setVisibility(View.VISIBLE);
                    try {
                        final Bitmap bitmap = (Bitmap) jsonObjectBitMapWithUrl.get(imageUri);
//                        onLoadingComplete( imageUri,  view,  bitmap);
                        if(bitmap != null) {

//                            imgvSpinner.setVisibility(View.INVISIBLE);
                            imgvProduct.setImageBitmap(bitmap);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    try {
                        final Bitmap bitmap = (Bitmap) jsonObjectBitMapWithUrl.get(imageUri);
//                        onLoadingComplete( imageUri,  view,  bitmap);
//                        imgvSpinner.setVisibility(View.VISIBLE);
                        if(bitmap != null) {
//                            imgvSpinner.setVisibility(View.INVISIBLE);
                            imgvProduct.setImageBitmap(bitmap);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onLoadingComplete(final String imageUri, View view, final Bitmap loadedImage) {
//                    imgvSpinner.setVisibility(View.INVISIBLE);
                    try {
                        jsonObjectBitMapWithUrl.put(imageUri, loadedImage);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    imgvProduct.setImageBitmap(loadedImage);

                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    try {
                        final Bitmap bitmap = (Bitmap) jsonObjectBitMapWithUrl.get(imageUri);
//                        onLoadingComplete( imageUri,  view,  bitmap);
//                        imgvSpinner.setVisibility(View.VISIBLE);
                        if(bitmap != null) {
//                            imgvSpinner.setVisibility(View.INVISIBLE);
                            imgvProduct.setImageBitmap(bitmap);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        lyEmpty.addView(child1);
    }
}
