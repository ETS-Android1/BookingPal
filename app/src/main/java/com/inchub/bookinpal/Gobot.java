package com.inchub.bookinpal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Gobot extends AppCompatActivity {

    TextView fullName,email,phone, verifyMsg;
    FirebaseAuth fAuth;

    FirebaseFirestore fStore;
    String userId;
    Button resendCode, changeProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gobot);

        phone = findViewById(R.id.profilePhone);
        fullName = findViewById(R.id.editprofilename);
        email =  findViewById(R.id.profileemail);

        resendCode = findViewById(R.id.resendCode);
        changeProfile = findViewById(R.id.goteditprofile);
        verifyMsg = findViewById(R.id.varifyMsg);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();
        final FirebaseUser user = fAuth.getCurrentUser();

        if(!user.isEmailVerified()){
         resendCode.setVisibility(View.VISIBLE);
         verifyMsg.setVisibility(View.VISIBLE);

         resendCode.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(final View view) {

                 user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                     @Override
                     public void onSuccess(Void aVoid) {
                         Toast.makeText(view.getContext(), "Verification Email Sent",Toast.LENGTH_SHORT);
                         startActivity(new Intent(getApplicationContext(),MainActivity.class));

                     }
                 }).addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {

                         Log.d("TAG","onFailure: Email not sent"+ e.getMessage());

                     }
                 });
             }
         });
        }


        changeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(view.getContext(), Gobots.class);
                i.putExtra("fname", fullName.getText().toString());
                i.putExtra("email", email.getText().toString());
                i.putExtra("phone", phone.getText().toString());
                startActivity(i);

            }
        });
        final DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                 phone.setText(documentSnapshot.getString("phone"));
                fullName.setText(documentSnapshot.getString("fname"));
                email.setText(documentSnapshot.getString("email"));
            }
        });
    }

     public  void logout(View view){
         FirebaseAuth.getInstance().signOut();
         startActivity(new Intent(getApplicationContext(),Login.class));
     }

}