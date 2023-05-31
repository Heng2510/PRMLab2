package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvCart);
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        myRecyclerViewAdapter.setData(getlistUser());
        myRecyclerViewAdapter.setClickListener(this::onItemClick);
        recyclerView.setAdapter(myRecyclerViewAdapter);
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(this,
                        myRecyclerViewAdapter.getItem(position) + "",
                Toast.LENGTH_SHORT).show();
    }

    private List<Product> getlistUser() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(R.drawable.hetcuu, "Product 1"));
        list.add(new Product(R.drawable.hetcuu2, "Product 2"));
        list.add(new Product(R.drawable.hetcuu, "Product 3"));
        list.add(new Product(R.drawable.hetcuu, "Product 4"));

        return list;
    }
}