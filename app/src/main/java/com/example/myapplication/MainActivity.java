package com.example.myapplication;




import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.model.Place;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

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
        Intent intent = new Intent(this, CheckInActivity.class);
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

        intent.putExtra("cin",inputCin.getText().toString());
        startActivity(intent);
    }
}
