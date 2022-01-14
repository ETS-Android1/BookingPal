package com.inchub.bookinpal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MTNBusiness extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Mains> options;
    FirebaseRecyclerAdapter<Mains,MyViewHolder> adapter;
    DatabaseReference DataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_t_n_business);

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
                        Intent intent = new Intent(MTNBusiness.this,PackageDetails.class);
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
}
