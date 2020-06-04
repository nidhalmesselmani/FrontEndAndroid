package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.User;
import com.example.myapplication.remote.APIUtils;
import com.example.myapplication.remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeActivity  extends AppCompatActivity {
    int  cin;
    UserService userService;
    User current_user;
    TextView first_name_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        first_name_txt = (TextView) findViewById(R.id.first_name);
        this.cin = Integer.valueOf(getIntent().getExtras().getString("cin"));
        userService = APIUtils.getUserService();
        getUserInfo(this.cin);




    }


    private void getUserInfo(int cin){

        Call<User> call = userService.user_by_cin(cin);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    current_user = response.body();
                    first_name_txt.setText("Hello " + response.body().get_first_name());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }


    public void GoCheckin_(View view) {

        Intent intent = new Intent(HomeActivity.this, CheckInActivity.class);
        intent.putExtra("cin",this.current_user.get_cin());
        startActivity(intent);
    }


    public void GoReport(View view) {

        Intent intent = new Intent(HomeActivity.this, CheckInActivity.class);
        intent.putExtra("cin",this.current_user.get_cin());
        startActivity(intent);
    }
}
