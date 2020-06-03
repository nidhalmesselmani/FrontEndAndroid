package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.User;
import com.example.myapplication.remote.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {


    UserService userService;
    int cin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        // this.cin = getIntent().getExtras().getInt("cin").;


       // getUserInfo();

        Context context = getApplicationContext();

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,  getIntent().getExtras().getInt("cin"), duration);
        toast.show();
    }

    public void getUserInfo(){
        Call<User> call = userService.user_by_cin(this.cin);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
               /*     list = response.body();
                    listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));*/
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}
