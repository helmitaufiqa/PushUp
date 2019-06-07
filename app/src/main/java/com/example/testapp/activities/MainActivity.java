package com.example.testapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.testapp.R;
import com.example.testapp.api.RegisterAPI;
import com.example.testapp.model.ModelValue;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "http://192.168.64.2/api/";
    private RadioButton radioJkButton;
    private ProgressDialog progressDialog;
    String nim;
    String nama;
    String jurusan;

    @BindView(R.id.etNim)
    EditText etNim;
    @BindView(R.id.etNama)
    EditText etNama;
    @BindView(R.id.etJurusan)
    EditText etJurusan;
    @BindView(R.id.radioJk)
    RadioGroup radioGroup;

    @OnClick(R.id.btnLihat)
    void lihat(){
        Intent intent = new Intent(MainActivity.this,ViewActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.btnDaftar)
    void daftar(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        nim = etNim.getText().toString().trim();
        nama = etNama.getText().toString().trim();
        jurusan = etJurusan.getText().toString().trim();

        int selectedKelamin = radioGroup.getCheckedRadioButtonId();
        radioJkButton = (RadioButton) findViewById(selectedKelamin);
        String jk = radioJkButton.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<ModelValue> call = api.daftar(nim,nama,jurusan,jk);

        call.enqueue(new Callback<ModelValue>() {
            @Override
            public void onResponse(Call<ModelValue> call, Response<ModelValue> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progressDialog.dismiss();

                if(value.equals("1")){
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelValue> call, Throwable t) {
                t.printStackTrace();
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Jaringan anda error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }



}
