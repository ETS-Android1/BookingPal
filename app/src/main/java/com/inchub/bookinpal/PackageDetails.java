package com.inchub.bookinpal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class PackageDetails extends AppCompatActivity {

    private ImageView imageView, imageView1,imageView2 ;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    Button btnMail;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);

        imageView = findViewById(R.id.packView);
        imageView1 = findViewById(R.id.packViews);
        imageView2 = findViewById(R.id.packView2);
        textView1 = findViewById(R.id.textView6);
        textView2 = findViewById(R.id.textView7);
        textView3 = findViewById(R.id.textView8);
        textView4 = findViewById(R.id.textView9);
        btnMail = findViewById(R.id.bookbutton);

        ref = FirebaseDatabase.getInstance().getReference().child("Mains");

        String Mainskey = getIntent().getStringExtra("Mainskey");

        ref.child(Mainskey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists())
                {
                  String PackageName = snapshot.child("PackageName").getValue().toString();
                    String PackageDestination = snapshot.child("PackageDestination").getValue().toString();
                    String PackageBio = snapshot.child("PackageBio").getValue().toString();
                    String PackageStops = snapshot.child("PackageStops").getValue().toString();

                    String ImageUrl = snapshot.child("ImageUrl").getValue().toString();
                    String ImageUrls = snapshot.child("ImageUrls").getValue().toString();
                    String ImageUrlz = snapshot.child("ImageUrlz").getValue().toString();

                    Picasso.get().load(ImageUrl).into(imageView);
                    Picasso.get().load(ImageUrls).into(imageView1);
                    Picasso.get().load(ImageUrlz).into(imageView2);
                    textView1.setText(PackageName);
                    textView2.setText(PackageDestination);
                    textView3.setText(PackageBio);
                    textView4.setText(PackageStops);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CustomerComplaints.class));
            }
        });
    }
}