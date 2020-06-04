package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Place;
import com.example.myapplication.model.User;
import com.example.myapplication.remote.APIUtils;
import com.example.myapplication.remote.PlaceService;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OverviewActivity extends AppCompatActivity {

    PlaceService placeService;

    List<Place> list = new ArrayList<Place>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        placeService  = APIUtils.getPlaceService();
        listView = (ListView) findViewById(R.id.listView);
        Call<List<Place>> call = placeService.getPlaces();

        call.enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                if(response.isSuccessful()){
                    List<Place> list_temp = new ArrayList<Place>();

                    list_temp = response.body();
                    for (Place p : list_temp) {
                        // do something with object
                        if(p.getContaminated() == 'Y' || p.getContaminated() == 'S') {
                            list.add(p);
                        }
                    }
                    listView.setAdapter(new PlaceAdapter(OverviewActivity.this, R.layout.list_place, list));


                }
            }

            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }
}
