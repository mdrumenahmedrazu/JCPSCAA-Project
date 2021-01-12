package com.rumenahmedrazu.jcpscaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void btnAbout(View view) {
        Intent intent =new Intent(this, Aboutus.class);
        startActivity(intent);
    }
    public void btnMembers(View view) {
        Intent intent =new Intent(this, Members.class);
        startActivity(intent);
    }
    public void btnCommittee(View view) {
        Intent intent =new Intent(this, Committee.class);
        startActivity(intent);
    }
    public void btnEvents(View view) {
        Intent intent =new Intent(this, Events.class);
        startActivity(intent);
    }
    public void btnStories(View view) {
        Intent intent =new Intent(this, Stories.class);
        startActivity(intent);
    }
    public void btnRegistration(View view) {
        Intent intent =new Intent(this, Registration.class);
        startActivity(intent);
    }
}