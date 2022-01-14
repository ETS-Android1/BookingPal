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

public class CustomerComplaints extends AppCompatActivity {


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText InvoiceNum, InvoiceMail, InvoiceName, InvoiceProv;
    Button mSub;

    CollectionReference ref = db.collection("Inhouse packages Booking");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_complaints);

        InvoiceNum = findViewById(R.id.InvNum);
        InvoiceMail = findViewById(R.id.InvAdd);
        InvoiceName = findViewById(R.id.InvNam);
        InvoiceProv = findViewById(R.id.InvSub);

        mSub = (Button) findViewById(R.id.buttcon);

        mSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String InvNumber = (InvoiceNum.getText().toString());
                String InvName = InvoiceName.getText().toString();
                String InvEmail = InvoiceMail.getText().toString();
                String InvTour = InvoiceProv.getText().toString();

                if (TextUtils.isEmpty(InvNumber)) {
                    InvoiceNum.setError("Phone number is Required");
                    return;
                }

                Invoices invoices = new Invoices(InvNumber,InvName,InvEmail,InvTour);


                ref.add(invoices).
                        addOnSuccessListener(new OnSuccessListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                Toast.makeText(CustomerComplaints.this, "Agent will get back to you to complete the booking ", Toast.LENGTH_SHORT).show();
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