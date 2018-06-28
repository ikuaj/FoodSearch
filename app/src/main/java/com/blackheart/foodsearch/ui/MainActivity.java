package com.blackheart.foodsearch.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.SearchEvent;
import android.widget.SearchView;

import com.blackheart.foodsearch.R;
import com.blackheart.foodsearch.adapters.FoodListAdapter;
import com.blackheart.foodsearch.models.Recipe;
import com.blackheart.foodsearch.services.YummlyService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    public static final String TAG = FoodSearchActivity.class.getSimpleName();
    @BindView(R.id.search) SearchView mSearch;
    private FoodListAdapter mAdapter;
    public List<Recipe> mRecipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mSearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        query = mSearch.getQuery().toString();
        Intent intent = new Intent(MainActivity.this, FoodSearchActivity.class);
        intent.putExtra("query", query);
        startActivity(intent);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
