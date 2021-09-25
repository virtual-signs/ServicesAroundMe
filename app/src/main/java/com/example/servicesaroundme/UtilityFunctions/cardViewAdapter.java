package com.example.servicesaroundme.UtilityFunctions;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servicesaroundme.MyAccount.userAccountAddresses;
import com.example.servicesaroundme.R;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class cardViewAdapter extends RecyclerView.Adapter<cardViewAdapter.MyViewHolder> {

    public List<userAccountAddresses.AddressBook> dataModelList;
    private Context mContext;

    public cardViewAdapter(List<userAccountAddresses.AddressBook> dataModelList, Context mContext) {
        this.dataModelList = dataModelList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate out card list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_cardview, parent, false);
        // Return a new view holder
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cardViewAdapter.MyViewHolder holder, int position) {
        holder.bindData(dataModelList.get(position), mContext);
    }

    @Override
    public int getItemCount() {
        // Return the total number of items
        return dataModelList.size();
    }

    // View holder class whose objects represent each list item

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardImageView;
        public TextView titleTextView;
        public TextView subTitleTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            cardImageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.txtTitle);
            subTitleTextView = itemView.findViewById(R.id.txtSubtitle);
        }

        public void bindData(userAccountAddresses.AddressBook addressBook, Context context) {
//            cardImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_home_work_24));
            titleTextView.setText(addressBook.getNickName());
            subTitleTextView.setText(addressBook.getLine1());
        }
    }
}
