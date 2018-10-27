package com.example.delaney.foodrater9;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by boutell on 11/6/2015.
 */
public class Food {

  private String mName;
  private int mImageResourceId;
  private float mRating;
  private Random random = new Random();

  public static final HashMap<String, Integer> sFoodImageMap;
  static {
    sFoodImageMap = new HashMap<>();
    sFoodImageMap.put("Banana", R.drawable.banana);
    sFoodImageMap.put("Broccoli", R.drawable.broccoli);
    sFoodImageMap.put("Homemade Bread", R.drawable.bread);
    sFoodImageMap.put("Chicken", R.drawable.chicken);
    sFoodImageMap.put("Chocolate", R.drawable.chocolate);
    sFoodImageMap.put("Ice Cream", R.drawable.icecream);
    sFoodImageMap.put("Lima Beans", R.drawable.limabeans);
    sFoodImageMap.put("Steak", R.drawable.steak);
  }

  public Food() {
    mName = getRandomFoodName();
    mImageResourceId = sFoodImageMap.get(mName);
    mRating = 0.0f;
  }

  private String getRandomFoodName() {
    Object[] foods = Food.sFoodImageMap.keySet().toArray();
    return (String)foods[random.nextInt(foods.length)];
  }

  public String getName() {
    return mName;
  }

  public float getRating() {
    return mRating;
  }

  public void setRating(float rating) {
    mRating = rating;
  }

  public int getImageResourceId() {
    return mImageResourceId;
  }
}
