package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.City;
import com.example.myapplication.model.Governorate;
import com.example.myapplication.model.Place;
import com.example.myapplication.model.PlaceCheckins;
import com.example.myapplication.model.User;
import com.example.myapplication.remote.APIUtils;
import com.example.myapplication.remote.CityService;
import com.example.myapplication.remote.GovernorateService;
import com.example.myapplication.remote.PlaceCheckinsService;
import com.example.myapplication.remote.PlaceService;
import com.example.myapplication.remote.UserService;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckInActivity extends AppCompatActivity {


    UserService userService;
    GovernorateService governorateService;
    CityService cityService;
    PlaceService placeService;
    PlaceCheckinsService placeCheckinsService;

    int cin;
    TextView first_name_txt;

    Spinner governates_spinner;
    Spinner cities_spinner;
    Spinner places_spinner;

    List<Integer> governorates_ids = new ArrayList<Integer>();
    List<Governorate> listGovernorates = new ArrayList<Governorate>();

    List<Integer> cities_ids = new ArrayList<Integer>();

    List<Integer> places_ids = new ArrayList<Integer>();

    List<City> listCities = new ArrayList<City>();

    TextView contanimated;
    User current_user;
    Place current_place;

    TimePicker checkinTimePicker;
    TimePicker checkoutTimePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);

        governates_spinner = (Spinner) findViewById(R.id.governates_spinner);
        cities_spinner = (Spinner) findViewById(R.id.cities_spinner);
        places_spinner = (Spinner) findViewById(R.id.places_spinner);

        userService = APIUtils.getUserService();
        governorateService = APIUtils.getGovernorateService();
        cityService = APIUtils.getCityService();
        placeService = APIUtils.getPlaceService();
        placeCheckinsService = APIUtils.getPlaceCheckinService();
        checkinTimePicker = (TimePicker)  findViewById(R.id.checkinTimePicker);
        checkoutTimePicker = (TimePicker)  findViewById(R.id.checkoutTimePicker);


        this.cin = Integer.valueOf(getIntent().getExtras().getString("cin"));

        getUserInfo(this.cin);
        getGovernorates();
        governates_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (parent.getItemAtPosition(position).equals("Choose Governorate"))
                {
                    //do nothing.
                }
                else
                {


                    get_cities_by_governorate_id(governorates_ids.get(position - 1));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        cities_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (parent.getItemAtPosition(position).equals("Choose City"))
                {

                }
                else
                {
                    get_places_by_city_id(cities_ids.get(position - 1));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        places_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (parent.getItemAtPosition(position).equals("Choose Place"))
                {


                }
                else
                {


                    get_place(places_ids.get(position - 1));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

   private void get_place(int place_id) {


       final Call<Place> call = placeService.getPlace(place_id);

       call.enqueue(new Callback<Place>() {
           @Override
           public void onResponse(Call<Place> call, Response<Place> response) {
               if(response.isSuccessful()){
                   View view =  getWindow().getDecorView().findViewById(android.R.id.content);
                   if(response.body().getContaminated().equals('Y')) {
                       // contanimated.setText("this place is contaminated");
                       Snackbar mySnackbar = Snackbar.make(view, "this place is contaminated", 7000);
                       mySnackbar.show();
                   }
                       else if (response.body().getContaminated().equals('S')) {
                      // contanimated.setText("this place is probably contaminated");
                       Snackbar mySnackbar = Snackbar.make(view, "this place is probably contaminated", 7000);
                       mySnackbar.show();
                   } else {
                     //  contanimated.setText("this place is not contaminated");
                       Snackbar mySnackbar = Snackbar.make(view, "this place is not contaminated", 7000);
                       mySnackbar.show();
                   }
                       current_place = response.body();
                      // contanimated.setVisibility(View.VISIBLE);

               }
           }

           @Override
           public void onFailure(Call<Place> call, Throwable t) {
               Log.e("ERROR: ", t.getMessage());
           }
       });

   }

    private  void get_places_by_city_id(int city_id) {

        places_spinner.setVisibility(View.VISIBLE);
        final Call<List<Place>> call = placeService.getPlacesByCityId(city_id);
        final ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Choose Place");
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        places_spinner.setAdapter(arrayAdapter);

        call.enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                if(response.isSuccessful()){
                    places_ids.clear();
                    List<Place> listPlaces = response.body();
                    // ArrayList<String> arrayList = new ArrayList<>();
                    for(Place p : listPlaces){
                        arrayList.add(p.getName());
                        places_ids.add(p.getId());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }


    private  void get_cities_by_governorate_id(int governate_id) {
        cities_spinner.setVisibility(View.VISIBLE);
        final Call<List<City>> call = cityService.getCityByGovernorateId(governate_id);
        final ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Choose City");
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Now apply the adapter to spinner
        cities_spinner.setAdapter(arrayAdapter);
        call.enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                if(response.isSuccessful()){
                    cities_ids.clear();
                    listCities = response.body();
                    // ArrayList<String> arrayList = new ArrayList<>();
                    for(City c : listCities){
                        arrayList.add(c.getName());
                        cities_ids.add(c.getId());
                    }



                }
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });


    }

    private void getGovernorates() {

        final Call<List<Governorate>> call = governorateService.getGovernorates();
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Choose Governorate");
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Now apply the adapter to spinner
        governates_spinner.setAdapter(arrayAdapter);
        call.enqueue(new Callback<List<Governorate>>() {
            @Override
            public void onResponse(Call<List<Governorate>> call, Response<List<Governorate>> response) {
                if(response.isSuccessful()){
                    listGovernorates = response.body();
                   // ArrayList<String> arrayList = new ArrayList<>();
                    for(Governorate g : listGovernorates){
                        arrayList.add(g.getName());
                        governorates_ids.add(g.getId());
                    }



                }
            }

            @Override
            public void onFailure(Call<List<Governorate>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }

    private void getUserInfo(int cin){

        Call<User> call = userService.user_by_cin(cin);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    current_user = response.body();

               }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onSubmitTime(View view) {


        String startTime =   String.valueOf(checkinTimePicker.getHour()) + ':' + checkinTimePicker.getMinute();
        String endtTime =   String.valueOf(checkoutTimePicker.getHour()) + ':' + checkoutTimePicker.getMinute();
        Call<PlaceCheckins> call =   placeCheckinsService.addPlaceCheckins(current_place.getId(),current_user.getId(),startTime,endtTime);


        call.enqueue(new Callback<PlaceCheckins>() {
            @Override
            public void onResponse(Call<PlaceCheckins> call, Response<PlaceCheckins> response) {
                if(response.isSuccessful()){

                    get_place(current_place.getId());





                }
            }

            @Override
            public void onFailure(Call<PlaceCheckins> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }
}
