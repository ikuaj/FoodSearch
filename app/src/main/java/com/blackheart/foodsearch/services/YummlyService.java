package com.blackheart.foodsearch.services;

import android.util.Log;

import com.blackheart.foodsearch.Constants;
import com.blackheart.foodsearch.models.Recipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class YummlyService {
    public static final String TAG = YummlyService.class.getSimpleName();

    public static OkHttpClient client = new OkHttpClient.Builder().build();

    public static void findRecipe(String food, Callback callback) {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YUMMLY_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YUMMLY_APP, Constants.YUMMLY_APP_ID);
        urlBuilder.addQueryParameter(Constants.YUMMLY_KEY, Constants.YUMMLY_CONSUMER_KEY);
        urlBuilder.addQueryParameter(Constants.YUMMLY_LOCATION_QUERY_PARAMETER, food);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .header("Authorization", "Bearer " + Constants.YUMMLY_CONSUMER_KEY)
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue((okhttp3.Callback) callback);
    }

    public List<Recipe> processResults(Response response) {
        List<Recipe> recipes = new ArrayList<>();

        try {
            String jsonData = response.body().string();

            if (response.isSuccessful()) {
                //the response json is an array of businesses objects within an object so we need to get thaat array
                JSONObject yummlyJSON = new JSONObject(jsonData);
                JSONArray businessesJSON = yummlyJSON.getJSONArray("matches");
                Log.v(TAG, businessesJSON.toString());
                Type collectionType = new TypeToken<List<Recipe>>() {}.getType();
                Gson gson = new GsonBuilder().create();
                recipes = gson.fromJson(businessesJSON.toString(), collectionType);

            }
        }catch (JSONException | NullPointerException | IOException e) {
            e.printStackTrace();
        }

        return recipes;
    }
}
