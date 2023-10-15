package com.example.studikasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MapActivity extends AppCompatActivity {

    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        setContentView(R.layout.activity_map);
        MapView map = (MapView) findViewById(R.id.map);
        map.setMultiTouchControls(true);
        map.getController().setZoom(11);
        Geocoder geocoder = new Geocoder(MapActivity.this);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MapActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });

        GeoPoint g = new GeoPoint(-6.9150656, 107.5932621);
        map.getController().setCenter(g);

        GeoPoint outletA = new GeoPoint(-6.915845285206341, 107.58613438261567);
        GeoPoint outletB = new GeoPoint(-6.916319633556482, 107.59370478791487);
        GeoPoint outletC = new GeoPoint(-6.912804868628957, 107.59174141113208);

        Marker markerA = new Marker(map);
        markerA.setPosition(outletA);
        map.getOverlays().add(markerA);
        markerA.setIcon(getResources().getDrawable(R.drawable.baseline_location_on_24));

        try {
            List<Address> addresses = geocoder.getFromLocation(outletA.getLatitude(), outletA.getLongitude(), 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                String streetAddress = address.getAddressLine(0);
                markerA.setTitle("Outlet A");
                markerA.setSnippet(streetAddress);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Marker markerB = new Marker(map);
        markerB.setPosition(outletB);
        map.getOverlays().add(markerB);
        markerB.setIcon(getResources().getDrawable(R.drawable.baseline_location_on_24));

        try {
            List<Address> addressesB = geocoder.getFromLocation(outletB.getLatitude(), outletB.getLongitude(), 1);
            if (addressesB.size() > 0) {
                Address addressB = addressesB.get(0);
                String streetAddressB = addressB.getAddressLine(0);
                markerB.setTitle("Outlet B");
                markerB.setSnippet(streetAddressB);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Marker markerC = new Marker(map);
        markerC.setPosition(outletC);
        map.getOverlays().add(markerC);
        markerC.setIcon(getResources().getDrawable(R.drawable.baseline_location_on_24));

        try {
            List<Address> addressesC = geocoder.getFromLocation(outletC.getLatitude(), outletC.getLongitude(), 1);
            if (addressesC.size() > 0) {
                Address addressC = addressesC.get(0);
                String streetAddressC = addressC.getAddressLine(0);
                markerC.setTitle("Outlet C");
                markerC.setSnippet(streetAddressC);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        map.invalidate();
    }
}