package com.inchub.bookinpal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Fibre extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText Mails,Locays,Cellphone,Confirm;
    Button mSub;

    CollectionReference ref = db.collection("House Swap");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibre);

        Mails = findViewById(R.id.contractID);
        Locays = findViewById(R.id.contractSub);
        Cellphone = findViewById(R.id.contractSubs);
        Confirm = findViewById(R.id.contractSubss);


        mSub = (Button) findViewById(R.id.buttonconsss);

        mSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mails = (Mails.getText().toString());
                String locays = Locays.getText().toString();
                String cellphone = Cellphone.getText().toString();
                String confirm = Confirm.getText().toString();

                if (TextUtils.isEmpty(mails)) {
                    Mails.setError("Email is Required");
                    return;
                }


                Swap swap = new Swap(mails,locays,cellphone,confirm);

                ref.add(swap).
                        addOnSuccessListener(new OnSuccessListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                Toast.makeText(Fibre.this, "Data Saved", Toast.LENGTH_SHORT).show();
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

