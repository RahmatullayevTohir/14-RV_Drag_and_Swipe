package com.example.a14_rv_drag_and_swipe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a14_rv_drag_and_swipe.R;
import com.example.a14_rv_drag_and_swipe.helper.ItemTouchHelperAdapter;
import com.example.a14_rv_drag_and_swipe.model.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchHelperAdapter {

    private Context context;
    private List<User> users;

    public CustomAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_view,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);
        if (holder instanceof CustomViewHolder){
            TextView name1 = ((CustomViewHolder)holder).Name1;
            TextView name2 = ((CustomViewHolder)holder).Name2;

            name1.setText(user.getAbubakr());
            name2.setText(user.getAkmal());
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView Name1, Name2;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            Name1 = view.findViewById(R.id.abubakr);
            Name2 = view.findViewById(R.id.akmal);
        }
    }

    @Override
    public void onItemDismiss(int position) {
        users.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition<toPosition){
            for (int i=fromPosition; i<toPosition; i++){
                Collections.swap(users,i,i+1);
            }
        }else {
            for (int i=fromPosition; i>toPosition; i--){
                Collections.swap(users,i,i-1);
            }
        }
        notifyItemMoved(fromPosition,toPosition);
    }
}
