package com.rumenahmedrazu.jcpscaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    EditText txtName, txtEmail, txtMobile, txtBatch, txtOccupation;
    Button btn_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txtName     =findViewById(R.id.Name);
        txtEmail    =findViewById(R.id.Email);
        txtMobile   =findViewById(R.id.Mobile);
        txtBatch    =findViewById(R.id.Batch);
        txtOccupation = findViewById(R.id.Occupation);
        btn_insert = findViewById(R.id.btnInsert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData() {

        final String name =txtName.getText().toString().trim();
        final String email =txtEmail.getText().toString().trim();
        final String mobile =txtMobile.getText().toString().trim();
        final String batch =txtBatch.getText().toString().trim();
        final String occupation =txtOccupation.getText().toString().trim();

        if(name.isEmpty()){
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(email.isEmpty()){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(mobile.isEmpty()){
            Toast.makeText(this, "Enter Mobile", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(batch.isEmpty()){
            Toast.makeText(this, "Enter Batch", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(occupation.isEmpty()){
            Toast.makeText(this, "Enter Occupation", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            StringRequest request = new StringRequest(Request.Method.POST, "https://registration.jcpscaa.org/insert.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Successfully Registered")){
                        Toast.makeText(Registration.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Registration.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Registration.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String,String>();
                    params.put("name",name);
                    params.put("email",email);
                    params.put("mobile",mobile);
                    params.put("batch",batch);
                    params.put("occupation",occupation);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Registration.this);
            requestQueue.add(request);
        }
    }
}