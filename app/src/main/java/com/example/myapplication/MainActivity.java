package com.example.myapplication;




import android.os.Bundle;

import com.example.myapplication.model.Place;
import com.example.myapplication.remote.APIUtils;
import com.example.myapplication.remote.PlaceService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Button btnGePlacesList;
    PlaceService placeService;

    List<Place> list = new ArrayList<Place>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnGePlacesList = (Button) findViewById(R.id.btnGetPlacesList);
        placeService = APIUtils.getPlaceService();
        listView = (ListView) findViewById(R.id.listView);

        btnGePlacesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get places list
                getPlacesList();
                Toast toast=Toast.makeText(getApplicationContext(),"btn clicked",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
            }
        });
    }

    public void getPlacesList(){
        Call<List<Place>> call = placeService.getPlaces();
        call.enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    listView.setAdapter(new PlaceAdapter(MainActivity.this, R.layout.list_place, list));


                }
            }

            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());


            }
        });
    }




    public void submit(View view) {

        Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
    }
}
