package com.inchub.bookinpal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class EveryWhereWeGo extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText SwapMails, ConfirmMails;
    Button mSub;

    CollectionReference ref = db.collection("House Swapping");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_every_where_we_go);

        SwapMails = findViewById(R.id.lawMail);
        ConfirmMails = findViewById(R.id.lawName);



        mSub = (Button) findViewById(R.id.butcon);

        mSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String HouseMails = (SwapMails.getText().toString());
                String ConfirmHouseMails = ConfirmMails.getText().toString();

                if (TextUtils.isEmpty(HouseMails)) {
                    SwapMails.setError("Email is Required");
                    return;
                }

                Swapping swapping = new Swapping(HouseMails,ConfirmHouseMails);

                ref.add(swapping).
                        addOnSuccessListener(new OnSuccessListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                Toast.makeText(EveryWhereWeGo.this, "Data Saved", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {



                    }
                });



            }


        });

    }
}