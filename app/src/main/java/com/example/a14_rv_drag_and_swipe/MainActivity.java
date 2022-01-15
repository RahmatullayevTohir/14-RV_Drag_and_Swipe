package com.example.a14_rv_drag_and_swipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a14_rv_drag_and_swipe.adapter.CustomAdapter;
import com.example.a14_rv_drag_and_swipe.helper.SimpleItemTouchHelperCallback;
import com.example.a14_rv_drag_and_swipe.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<User> users = prepareUserList();
        refreshAdapter(users);
    }

    private List<User> prepareUserList() {
        List<User> users = new ArrayList<>();
        for (int i=1; i<31; i++){
            users.add(new User(i+" AbuBakr ",i+" Akmal "));
        }
        return  users;
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    public void refreshAdapter(List<User> users){
        CustomAdapter customAdapter = new CustomAdapter(context,users);
        recyclerView.setAdapter(customAdapter);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(customAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }
}