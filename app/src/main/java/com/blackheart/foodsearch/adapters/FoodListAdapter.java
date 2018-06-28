package com.blackheart.foodsearch.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackheart.foodsearch.R;
import com.blackheart.foodsearch.models.Recipe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {
    private List<Recipe> mRecipes;
    private Context mContext;

    public FoodListAdapter(Context context, List<Recipe> recipes) {
        mContext = context;
        mRecipes = recipes;
    }

    @NonNull
    @Override
    public FoodListAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_item, parent, false);
        FoodViewHolder viewHolder = new FoodViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.FoodViewHolder holder, int position) {
        holder.bindRecipe(mRecipes.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recipeimage)
        ImageView mRecipeImage;
        @BindView(R.id.recipename)
        TextView mRecipeName;
        @BindView(R.id.ingridiens)
        TextView mIngridients;

        private Context mContext;

        public FoodViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRecipe(Recipe recipe) {
            mRecipeName.setText(recipe.getRecipeName());
            mIngridients.setText(recipe.getIngredients().toString());

            if (!(recipe.getImageUrlsBySize().get90().isEmpty())) {
                Picasso.with(mContext).load(recipe.getImageUrlsBySize().get90())
                        .fit()
                        .centerCrop()
                        .into(mRecipeImage);
            }
        }
    }
}
