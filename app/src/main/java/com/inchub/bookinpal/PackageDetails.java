package com.inchub.bookinpal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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

    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;



    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);


        imageView1 = findViewById(R.id.packViews);
        textView1 = findViewById(R.id.textView6);
        textView2 = findViewById(R.id.textView7);
        textView3 = findViewById(R.id.textView8);
        textView4 = findViewById(R.id.textView9);
        textView5 = findViewById(R.id.textView10);
        textView6 = findViewById(R.id.textView11);
        textView7 = findViewById(R.id.textView12);
        textView8 = findViewById(R.id.textView14);
        textView9 = findViewById(R.id.textView16);
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

                    String InBio = snapshot.child("InBio").getValue().toString();
                    String OutMoney = snapshot.child("OutMoney").getValue().toString();
                    String OutBio = snapshot.child("OutBio").getValue().toString();
                    String Tips = snapshot.child("Tips").getValue().toString();
                    String HighGood = snapshot.child("HighGood").getValue().toString();

                    String ImageUrls = snapshot.child("ImageUrls").getValue().toString();

                    Picasso.get().load(ImageUrls).into(imageView1);
                    textView1.setText(PackageName);
                    textView2.setText(PackageDestination);
                    textView3.setText(PackageBio);
                    textView4.setText(PackageStops);
                    textView5.setText(InBio);
                    textView6.setText(OutMoney);
                    textView7.setText(OutBio);
                    textView8.setText(HighGood);
                    textView9.setText(Tips);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0794363314"));

                if (ActivityCompat.checkSelfPermission(PackageDetails.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
    }
}