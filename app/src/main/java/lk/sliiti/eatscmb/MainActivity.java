package lk.sliiti.eatscmb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lk.sliiti.eatscmb.adapter.PicksAdapter;
import lk.sliiti.eatscmb.adapter.RestaurantAdapter;
import lk.sliiti.eatscmb.model.PicksForYou;
import lk.sliiti.eatscmb.model.Restaurants;

public class MainActivity extends AppCompatActivity {

    RecyclerView picksForYouRecycler, restaurantRecycler;
    PicksAdapter picksForYouAdapter;
    RestaurantAdapter restaurantAdapter;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button shoppingCart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_EatsCMB);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

        Button loginBtn = findViewById(R.id.loginBtn);
        shoppingCart = findViewById(R.id.mainCart);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LogInActivity.class));
            }
        });

        //configureLogIn();


        List<PicksForYou> picksForYouList = new ArrayList<>();
        picksForYouList.add(new PicksForYou("French Fries","LKR 320",R.drawable.mcdonald_frenchfries));
        picksForYouList.add(new PicksForYou("Spicy Sandwich","LKR 1200",R.drawable.popeyes_spicy_sandwich));
        picksForYouList.add(new PicksForYou("Big Mac","LKR 1350",R.drawable.mcdonalds_big_mac_fries));
        picksForYouList.add(new PicksForYou("Chicken Bucket","LKR 3450",R.drawable.kfc_chicken_bucket));
        picksForYouList.add(new PicksForYou("Chicken Strips","LKR 1400",R.drawable.popeyes_chicken_strips));

        setPicksForYouRecycler(picksForYouList);

        List<Restaurants> restaurantsList = new ArrayList<>();
        restaurantsList.add(new Restaurants("McDonald's","10-15 mins",R.drawable.mcdonalds_big_mac_fries_1));
        restaurantsList.add(new Restaurants("KFC","20-30 mins",R.drawable.kfc_review));
        restaurantsList.add(new Restaurants("Popeyes","15 mins",R.drawable.popeyes_restaurant));
        restaurantsList.add(new Restaurants("Burger King","20 mins",R.drawable.burgerking_restaurant));
        restaurantsList.add(new Restaurants("Pizza Hut","30 mins",R.drawable.pizzahut_restaurant));
        restaurantsList.add(new Restaurants("Domino's Pizza","35 mins",R.drawable.dominos_restaurant));
        restaurantsList.add(new Restaurants("Subway","10 mins",R.drawable.subway_restaurant));
        restaurantsList.add(new Restaurants("Taco Bell","15 mins",R.drawable.tacobell_restaurant));
        restaurantsList.add(new Restaurants("Starbucks","20 mins",R.drawable.starbucks_restaurent));
        restaurantsList.add(new Restaurants("Dunkin'","10 mins",R.drawable.dunkindonuts_restaurant));

        setRestaurantRecycler(restaurantsList);

    }

    public void setPicksForYouRecycler(List<PicksForYou> picksForYouList) {
        picksForYouRecycler = findViewById(R.id.picksRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        picksForYouRecycler.setLayoutManager(layoutManager);
        picksForYouAdapter = new PicksAdapter(this, picksForYouList);
        picksForYouRecycler.setAdapter(picksForYouAdapter);
    }

    public void setRestaurantRecycler(List<Restaurants> restaurantsList){
        restaurantRecycler = findViewById(R.id.restaurent_recycler);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        restaurantRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(),2,RecyclerView.HORIZONTAL,false));
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        //gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        restaurantAdapter = new RestaurantAdapter(this, restaurantsList);
        restaurantRecycler.setAdapter(restaurantAdapter);
    }

    /*private void configureLogIn()
    {
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogInActivity(new Intent(MainActivity.this,LogInActivity.class));
            }
        });


    }*/


    /*public void addFragment(){
        fragment = new FragmentLogin();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer,fragment);

    }*/







}