package com.inchub.bookinpal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseRecyclerOptions <Mains> options;
    FirebaseRecyclerAdapter<Mains,MyViewHolder>adapter;
    DatabaseReference DataRef;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();

        FirebaseMessaging.getInstance().subscribeToTopic("mains")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Done";
                         if (!task.isSuccessful()) {
                            msg = "Failed";
                        }
                    }
                });


        recyclerView = findViewById(R.id.recycleMain);
        DataRef = FirebaseDatabase.getInstance().getReference().child("Mains");
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        LoadData();

    }

    private void LoadData() {

        options = new FirebaseRecyclerOptions.Builder<Mains>().setQuery(DataRef,Mains.class).build();
        adapter = new FirebaseRecyclerAdapter<Mains, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, final int position, @NonNull Mains model) {
                holder.textView1.setText(model.getPackageName());
                holder.textView2.setText(model.getPackageDestination());
                holder.textView3.setText(model.getPackageBio());

                Picasso.get().load(model.getImageUrl()).into(holder.imageView);
                Picasso.get().load(model.getImageUrls()).into(holder.imageView2);

                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this,PackageDetails.class);
                        intent.putExtra("Mainskey",getRef(position).getKey());
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row,parent,false);
                return new MyViewHolder(v);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ex_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.items1:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                return true;


            case R.id.items2:
                startActivity(new Intent(getApplicationContext(), Contracts.class));
                return true;

            case R.id.items3:
                startActivity(new Intent(getApplicationContext(), Prepaid.class));
                return true;

            case R.id.items4:
                startActivity(new Intent(getApplicationContext(), EveryWhereWeGo.class));
                return true;

            case R.id.items5:
                startActivity(new Intent(getApplicationContext(), Gobot.class));
                return true;

            default:


                return super.onOptionsItemSelected(item);
        }

    }
}