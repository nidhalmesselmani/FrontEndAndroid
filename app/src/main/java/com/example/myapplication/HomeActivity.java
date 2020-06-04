package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.User;
import com.example.myapplication.remote.APIUtils;
import com.example.myapplication.remote.UserService;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {


    UserService userService;
    int cin;
    String d;
    TextView first_name_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        first_name_txt = (TextView) findViewById(R.id.first_name);

        userService = APIUtils.getUserService();

        this.d = getIntent().getExtras().getString("cin");

        this.cin = Integer.valueOf(d);
        getUserInfo(this.cin);
    }


    public void getUserInfo(int cin){


        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, String.valueOf(cin), duration);
        toast.show();
        Call<User> call = userService.user_by_cin(cin);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    first_name_txt.setText("Hello " + response.body().get_first_name());

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
