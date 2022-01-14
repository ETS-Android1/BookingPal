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


public class Contracts extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText contractID,contractSub,contractMes,contractDat, contractInv,contractAdd;
    Button mSub;

    CollectionReference ref = db.collection("Travel Booking");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contracts);

        contractID = findViewById(R.id.contractID);
        contractSub = findViewById(R.id.contractSub);
        contractMes = findViewById(R.id.contractSubstop);
        contractDat = findViewById(R.id.contractSubstopDate);
        contractInv = findViewById(R.id.contractSubstopMems);
        contractAdd = findViewById(R.id.contractMes);



        mSub = (Button) findViewById(R.id.buttoncon);

        mSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usermail = (contractID.getText().toString());
                String travelprovince = contractSub.getText().toString();
                String travellocation = contractMes.getText().toString();
                String traveldate = contractDat.getText().toString();
                String travelfam = contractInv.getText().toString();
                String travelinfo = contractAdd.getText().toString();

                if (TextUtils.isEmpty(usermail)) {
                    contractID.setError("Email is Required");
                    return;
                }

                Travel travel = new Travel(usermail,travelprovince,travellocation,traveldate,travelfam,travelinfo);

//Contract contract = new Contract(ids,province,location,calender,invite,info);

                ref.add(travel).
                        addOnSuccessListener(new OnSuccessListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                Toast.makeText(Contracts.this, "Data Saved", Toast.LENGTH_SHORT).show();
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