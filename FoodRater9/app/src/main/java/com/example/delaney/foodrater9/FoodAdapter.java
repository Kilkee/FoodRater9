package com.example.delaney.foodrater9;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> mFoods = new ArrayList<>();
    private RecyclerView mRecyclerView;

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }


    public void addFood(){
    // TODO: I do this (I'm gonna have to do a lot of things that are similar
        // TODO: to name adapter, I'm going to have to figure this out

        //**************
        mFoods.add(0, new Food());
        notifyItemInserted(0);
        notifyItemRangeChanged(0, mFoods.size());
        mRecyclerView.getLayoutManager().scrollToPosition(0);
        //*******************
    }

    private void deleteFood(int position) {
        mFoods.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, mFoods.size());
    }


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        // TODO: Ido this
    //**********
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_item_view, parent, false);
        return new FoodViewHolder(itemView);

    //**********
      //  return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
    final Food food = mFoods.get(position);
    holder.mName.setText(food.getName());
    // TODO: I do this

    //**************
        holder.mImageView.setImageResource(food.getImageResourceId());
        holder.mRatingBar.setRating(food.getRating());
    //********************

    }

    @Override
    public int getItemCount() {
        //TODO: I do this

        //********
        return mFoods.size();
        //*******

      //  return 0;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView mName;
        private RatingBar mRatingBar;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.food_pic);
            mName = itemView.findViewById(R.id.name);
            mRatingBar = itemView.findViewById(R.id.rating_bar);

            // TODO: Delete this food on long press // I need to do this

            //**************
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    deleteFood(getAdapterPosition());
                    return true;

                }
            });

            //*****************8

                    // Done together, update the rating for this food

            mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    if (fromUser){
                        // Update this food's rating
                        Food currentFood = mFoods.get(getAdapterPosition());
                        currentFood.setRating(rating);
                    }
                }
            });

        }
    }
}

