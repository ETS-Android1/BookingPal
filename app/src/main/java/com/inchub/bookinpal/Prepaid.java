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

public class Prepaid extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText prepaidID,prepaidSub,prepaidMes,prepaidDat, prepaidInv,prepaidAdd, prepaidMode;
    Button mSub;

    CollectionReference ref = db.collection("Prepaid");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepaid);

        prepaidID = findViewById(R.id.prepaidID);
        prepaidSub = findViewById(R.id.prepaidSub);
        prepaidMes = findViewById(R.id.prepaidSubstop);
        prepaidDat = findViewById(R.id.prepaidSubstopDate);
        prepaidInv = findViewById(R.id.prepaidSubstopMems);
        prepaidAdd = findViewById(R.id.prepaidMes);
        prepaidMode = findViewById(R.id.prepaidSubstopMode);



        mSub = (Button) findViewById(R.id.buttoncons);

        mSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ids = (prepaidID.getText().toString());
                String province = prepaidSub.getText().toString();
                String location = prepaidMes.getText().toString();
                String calender = prepaidDat.getText().toString();
                String invite = prepaidInv.getText().toString();
                String info = prepaidAdd.getText().toString();
                String mode = prepaidMode.getText().toString();

                if (TextUtils.isEmpty(ids)) {
                    prepaidMode.setError("ID is needed");
                    return;
                }

                //Prepaids prepaids = new Prepaids(ids,province,location,calender,invite,info,mode);
                Prepaids prepaids = new Prepaids(ids,province,location,calender,invite,info,mode);

                ref.add(prepaids).
                        addOnSuccessListener(new OnSuccessListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                Toast.makeText(Prepaid.this, "Data Saved", Toast.LENGTH_SHORT).show();
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