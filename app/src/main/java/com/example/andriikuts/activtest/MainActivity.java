package com.example.andriikuts.activtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncher;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncherOptions;
import com.mapbox.services.android.navigation.v5.navigation.MapboxNavigation;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;



public class MainActivity extends AppCompatActivity {
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, "pk.eyJ1IjoiZWxuZW1vIiwiYSI6ImNqaHcyMmV6djA5bmIzdnFyZ2NhanZlbWoifQ.XNxbXIcRvrnYiG-HpL6Kzg");
        MapboxNavigation navigation = new MapboxNavigation(this, "pk.eyJ1IjoiZWxuZW1vIiwiYSI6ImNqaHcyMmV6djA5bmIzdnFyZ2NhanZlbWoifQ.XNxbXIcRvrnYiG-HpL6Kzg");
        setContentView(R.layout.activity_main);
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);


        Point origin = Point.fromLngLat(-77.03613, 38.90992);
        Point destination = Point.fromLngLat(-77.0365, 38.8977);

        NavigationRoute route = NavigationRoute.builder(this)
                .accessToken(Mapbox.getAccessToken())
                .origin(origin)
                .destination(destination)
                .build();
//                .getRoute(new Callback<DirectionsResponse>() {
//                    @Override
//                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<DirectionsResponse> call, Throwable t) {
//
//                    }
//                });
        boolean simulateRoute = true;

        NavigationLauncherOptions options = NavigationLauncherOptions.builder()
                .directionsRoute(route) // Fetched from NavigationRoute
                .shouldSimulateRoute(simulateRoute)
                .build();

        NavigationLauncher.startNavigation(this, options);
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
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
    public void onStop() {
        super.onStop();
        mapView.onStop();
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}

