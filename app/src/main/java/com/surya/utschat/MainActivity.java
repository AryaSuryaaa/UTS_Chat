package com.surya.utschat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.chatList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        Inisialisasi daftar Item
        List<ItemList> itemList = new ArrayList<>();
        itemList.add(new ItemList("https://via.placeholder.com/150", "Arya Surya", "20:12", "Lorem asda adas adada dacsd frg rtgfdb ddrer "));
        itemList.add(new ItemList("https://via.placeholder.com/150", "Arya Surya", "20:12", "Lorem asda adas adada dacsd frg rtgfdb ddrer "));
        itemList.add(new ItemList("https://via.placeholder.com/150", "Arya Surya", "20:12", "Lorem asda adas adada dacsd frg rtgfdb ddrer "));
        itemList.add(new ItemList("https://via.placeholder.com/150", "Arya Surya", "20:12", "Lorem asda adas adada dacsd frg rtgfdb ddrer "));

//        Inisialisasi adapter RecyclerView
        AdapterList myAdapter = new AdapterList(itemList);
        recyclerView.setAdapter((RecyclerView.Adapter) myAdapter);


    }
}