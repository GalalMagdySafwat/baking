package com.example.ga.bakingagain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

    public class IngredientsAdapter extends ArrayAdapter<Ingredients> {
        private Context context;

        public IngredientsAdapter(Context context, List<Ingredients> Reviews) {
            super(context, 0, Reviews);
            this.context = context;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.ingredients_list, parent, false);
            }
            Ingredients currentIngredients = getItem(position);
            String s = currentIngredients.getMeasure()+ currentIngredients.getMeasure()+currentIngredients.getIngredient();

            TextView Author = (TextView)listItemView.findViewById(R.id.ingredient_item);
            Author.setText(s);




            return listItemView;
        }
    }

