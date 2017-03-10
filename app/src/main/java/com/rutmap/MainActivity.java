package com.rutmap;

import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.rutmap.Adapter.LeftNavAdapter;

import com.rutmap.Fragment.EventDetailPageFragment;
import com.rutmap.Fragment.EventPageFragment;
import com.rutmap.Fragment.MainPageFragment;
import com.rutmap.Utils.Constant;

public class MainActivity extends FragmentActivity {

    private DrawerLayout drawerLayout;

    /** ListView for left side drawer. */
//    private ListView drawerLeft;
    private RelativeLayout drawerLeft;
    /** The left navigation list adapter. */
    private LeftNavAdapter adapterLeft;
    private boolean isMenuOpened;
    /*
        ---  Menu Options ---
     */
    RelativeLayout menuHome, menuInfo, menuCall, menuEmail, menuSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        setupDrawer();

        controlMenuOptions();

        launchFragment(0);


    }

    void setupDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
//                GravityCompat.START);

        drawerLayout.closeDrawers();
        isMenuOpened = false;

//        drawerLeft = (RelativeLayout) findViewById(R.id.left_drawer);  /////  new
        setupLeftNavDrawer();

        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                isMenuOpened = true;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                isMenuOpened = false;
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        Intent intent = getIntent();
        String message = intent.getStringExtra("imgURL");

//        getSupportFragmentManager().addOnBackStackChangedListener(
//                new FragmentManager.OnBackStackChangedListener() {
//
//                    @Override
//                    public void onBackStackChanged() {
//
//                        FragmentManager manager = getSupportFragmentManager();
//                        Fragment currFrag = manager.findFragmentById(R.id.content_frame);
//                        if(currFrag == null) return;
////                        currFrag.onResume();
//                    }
//                });
    }

    @Override
    public void onBackPressed() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment currFrag = manager.findFragmentById(R.id.content_frame);

        if(currFrag == null) return;

        if(currFrag instanceof MainPageFragment) {
            MainActivity.this.finish();
            return;
        }


        manager.popBackStackImmediate();
    }

    void controlMenuOptions() {
        menuHome = (RelativeLayout) this.findViewById(R.id.relLayoutMenuHome);
        menuInfo = (RelativeLayout) this.findViewById(R.id.relLayoutMenuInfo);
        menuCall = (RelativeLayout) this.findViewById(R.id.relLayoutMenuPhone);
        menuEmail = (RelativeLayout) this.findViewById(R.id.relLayoutMenuEmail);
        menuSettings = (RelativeLayout) this.findViewById(R.id.relLayoutMenuSettings);

        // Menu Home
        menuHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMenuOpened = true;
                drawerLayout.closeDrawers();
                launchFragment(0);
            }
        });

        // Menu Info
        menuInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleMenu();

                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        // Menu Call
        menuCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleMenu();

                onPhoneCall();
            }
        });

        // Menu Email
        menuEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleMenu();

                onPhoneCall();
            }
        });

        // Menu Settings
        menuSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleMenu();

                Intent intent = new Intent(MainActivity.this, SettinsActivity.class);
                startActivity(intent);
            }
        });
    }

    void onPhoneCall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:+387 33 640 300"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    void sendEmail() {
        Intent intentEmail = new Intent(Intent.ACTION_SEND_MULTIPLE);
        intentEmail.setType("text/html");

        intentEmail.putExtra(Intent.EXTRA_SUBJECT, "RutMap!");
        intentEmail.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(""));
        intentEmail.putExtra(Intent.EXTRA_EMAIL,
                new String[] { "info@rutmap.ba" });
        intentEmail.setType("text/html");

        startActivity(intentEmail);
    }
   void setupLeftNavDrawer() {
       drawerLeft = (RelativeLayout) findViewById(R.id.left_drawer);

//        drawerLeft.removeAllViews();

//        View header = getLayoutInflater().inflate(R.layout.left_nav_header, null);
//
//        ImageView imgRutMaps = (ImageView)header.findViewById(R.id.imgRutMapS);
//        imgRutMaps.setImageResource(R.drawable.rut_map_city_guide);

            View header1 = getLayoutInflater().inflate(R.layout.cell_langu_bosni, null);

            header1.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {

                launchFragment(0);

            }
        });

//       RelativeLayout layout1=(RelativeLayout)findViewById(R.id.activity_first);
//
//       layout1.setOnClickListener(new View.OnClickListener()
//       {
//           @Override
//           public void onClick(View v)
//           {
//               launchFragment(0);
//
//           }
//       });

       adapterLeft = new LeftNavAdapter(this); // home, my chat,, location, setting, invite frind

    }

    public void toggleMenu() {
        isMenuOpened = !isMenuOpened;

        if(isMenuOpened)
            drawerLayout.openDrawer(drawerLeft);
        else
            drawerLayout.closeDrawers();
    }

    public void launchFragment(int pos){
        Fragment f = null;
        String title = null;

        switch (pos){
            case 0:
                f = new MainPageFragment();
                title = Constant.FRAGMENT_MAIN;
                break;

            case 1:
                f = new EventPageFragment();
                title = Constant.FRAGMENT_EVENT;
                break;

            case 2:
                f = new EventDetailPageFragment();
                title = Constant.FRAGMENT_EVENT_DETAIL;
                break;

        }

        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,f,title).addToBackStack(title).commit();

    }
//
//    public void replaceFragment(Fragment fragment) {
//        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment,"").commit();
//    }
}


