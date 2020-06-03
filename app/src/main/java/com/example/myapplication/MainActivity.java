package com.example.myapplication;




import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText inputCin;
    // Button btnGePlacesList;
    // PlaceService placeService;

    List<Place> list = new ArrayList<Place>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // btnGePlacesList = (Button) findViewById(R.id.btnGetPlacesList);
        // placeService = APIUtils.getPlaceService();
        // listView = (ListView) findViewById(R.id.listView);
        inputCin = (EditText) findViewById(R.id.input_cin);



    }

    public void openASetVisitedPlacesActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
  /*
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
    }*/


    public void onSubmit(View view) {

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra("cin",Integer.valueOf(inputCin.getText().toString()));
        startActivity(intent);
    }
}
