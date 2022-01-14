package com.inchub.bookinpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Gobots extends AppCompatActivity {

    EditText profilefullName, profileEmail, profilePhone;
    public static final String TAG = "TAG";
    Button saveBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gobots);

        Intent data = getIntent();
        String fullName = data.getStringExtra("fullname");
        String email = data.getStringExtra("email");
        String phone = data.getStringExtra("phone");

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        profilefullName = findViewById(R.id.editsname);
        profileEmail = findViewById(R.id.editprofileemail);
        profilePhone = findViewById(R.id.editprofilePhone);
        saveBtn = findViewById(R.id.saveprof);


        profileEmail.setText(email);
        profilefullName.setText(fullName);
        profilePhone.setText(phone);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (profilefullName.getText().toString().isEmpty() || profileEmail.getText().toString().isEmpty() || profilePhone.getText().toString().isEmpty())

                    Toast.makeText(Gobots.this, "One of Many fields are empty", Toast.LENGTH_SHORT).show();
                return;
            }

        });

    }
}