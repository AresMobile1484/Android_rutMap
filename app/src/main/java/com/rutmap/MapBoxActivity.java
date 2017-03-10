package com.rutmap;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Switch;

import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.mapboxsdk.annotations.BaseMarkerOptions;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.annotations.MarkerViewOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.offline.OfflineManager;
import com.mapbox.mapboxsdk.offline.OfflineRegion;
import com.mapbox.mapboxsdk.offline.OfflineRegionError;
import com.mapbox.mapboxsdk.offline.OfflineRegionStatus;
import com.mapbox.mapboxsdk.offline.OfflineTilePyramidRegionDefinition;
import com.rutmap.Model.GlobData;
import com.rutmap.Model.ObjPoints;
import com.rutmap.Utils.Common;

import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MapBoxActivity extends AppCompatActivity {

    private MapView mapView;

    public static final String JSON_CHARSET = "UTF-8";
    public static final String JSON_FIELD_REGION_NAME = "FIELD_REGION_NAME";
    private static final String TAG = "MapBoxActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MapboxAccountManager.start(this, getString(R.string.access_token));
        setContentView(R.layout.activity_map_box);
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

//
//                OfflineManager offlineManager = OfflineManager.getInstance(MapBoxActivity.this);
//
//                // Create a bounding box for the offline region
//                LatLngBounds latLngBounds = new LatLngBounds.Builder()
//                        .include(new LatLng(37.7897, -119.5073)) // Northeast
//                        .include(new LatLng(37.6744, -119.6815)) // Southwest
//                        .build();
//
//                // Define the offline region
//                OfflineTilePyramidRegionDefinition definition = new OfflineTilePyramidRegionDefinition(
//                        mapView.getStyleUrl(),
//                        latLngBounds,
//                        10,
//                        20,
//                        MapBoxActivity.this.getResources().getDisplayMetrics().density);
//
//                // Set the metadata
//                byte[] metadata;
//                try {
//                    JSONObject jsonObject = new JSONObject();
//                    jsonObject.put(JSON_FIELD_REGION_NAME, "Sarajevo");
//                    String json = jsonObject.toString();
//                    metadata = json.getBytes(JSON_CHARSET);
//                } catch (Exception exception) {
//                    Log.e(TAG, "Failed to encode metadata: " + exception.getMessage());
//                    metadata = null;
//                }
//
//                // Create the region asynchronously
//                offlineManager.createOfflineRegion(
//                        definition,
//                        metadata,
//                        new OfflineManager.CreateOfflineRegionCallback() {
//                            @Override
//                            public void onCreate(OfflineRegion offlineRegion) {
//                                offlineRegion.setDownloadState(OfflineRegion.STATE_ACTIVE);
//
//                                // Display the download progress bar
//
//                                // Monitor the download progress using setObserver
//                                offlineRegion.setObserver(new OfflineRegion.OfflineRegionObserver() {
//                                    @Override
//                                    public void onStatusChanged(OfflineRegionStatus status) {
//
//                                        // Calculate the download percentage and update the progress bar
//                                        double percentage = status.getRequiredResourceCount() >= 0
//                                                ? (100.0 * status.getCompletedResourceCount() / status.getRequiredResourceCount()) :
//                                                0.0;
//
//                                        if (status.isComplete()) {
//                                            // Download complete
//                                        } else if (status.isRequiredResourceCountPrecise()) {
//                                            // Switch to determinate state
//                                        }
//                                    }
//
//                                    @Override
//                                    public void onError(OfflineRegionError error) {
//                                        // If an error occurs, print to logcat
//                                        Log.e(TAG, "onError reason: " + error.getReason());
//                                        Log.e(TAG, "onError message: " + error.getMessage());
//                                    }
//
//                                    @Override
//                                    public void mapboxTileCountLimitExceeded(long limit) {
//                                        // Notify if offline region exceeds maximum tile count
//                                        Log.e(TAG, "Mapbox tile count limit exceeded: " + limit);
//                                    }
//                                });
//                            }
//
//                            @Override
//                            public void onError(String error) {
//                                Log.e(TAG, "Error: " + error);
//                            }
//                        });

                // Customize map with markers, polylines, etc.
                List<ObjPoints> points = GlobData.points;
                List <MarkerOptions> marks  = new ArrayList<>();

                for (int i = 0; i < points.size(); i++) {
                    try {
                        ObjPoints obj_point = points.get(i);
                        float lat = Float.parseFloat(obj_point.get_lat());
                        float lon = Float.parseFloat(obj_point.get_lon());
                        Drawable iconDrawable;
                        IconFactory iconFactory = IconFactory.getInstance(MapBoxActivity.this);
                        switch(obj_point.get_cat_id()){
                            case 2:
                                iconDrawable = ContextCompat.getDrawable(MapBoxActivity.this, R.drawable.ic_map_1);
                                break;
                            case 5:
                                iconDrawable = ContextCompat.getDrawable(MapBoxActivity.this, R.drawable.ic_map_2);
                                break;
                            case 17:
                               iconDrawable = ContextCompat.getDrawable(MapBoxActivity.this, R.drawable.ic_map_3);
                                break;
                            case 38:
                                iconDrawable = ContextCompat.getDrawable(MapBoxActivity.this, R.drawable.ic_map_4);
                                break;
                            case 27:
                                iconDrawable = ContextCompat.getDrawable(MapBoxActivity.this, R.drawable.ic_map_5);
                                break;
                            case 51:
                                iconDrawable = ContextCompat.getDrawable(MapBoxActivity.this, R.drawable.ic_map_6);
                                break;
                            case 22:
                                iconDrawable = ContextCompat.getDrawable(MapBoxActivity.this, R.drawable.ic_map_7);
                                break;
                            default:
                                iconDrawable = ContextCompat.getDrawable(MapBoxActivity.this, R.drawable.ic_map_8);
                                break;

                        }
                         Icon icon = iconFactory.fromDrawable(iconDrawable);
                        MarkerOptions markerViewOptions = new MarkerOptions()
                                .position(new LatLng(lat, lon)).icon(icon);
                        marks.add(markerViewOptions);
                    }
                    catch (NumberFormatException exception)
                    {

                    }
                }
                mapboxMap.addMarkers(marks);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
