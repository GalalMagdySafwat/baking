package com.example.ga.bakingagain;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.List;

public class ListWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new ListRemoteViewsFactory(this.getApplicationContext());
    }
}

class ListRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
    Dish dish;
    List<Ingredients> ingredientsList;
    Context context;


    public ListRemoteViewsFactory(Context applicationContext) {
        context = applicationContext;

    }
    @Override
    public void onCreate() {



    }

    @Override
    public void onDataSetChanged() {


    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        if (ingredientsList == null) return 0;
        return ingredientsList.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        Intent intent = new Intent();
        ingredientsList = intent.getParcelableArrayListExtra("i");
        Ingredients currentIngredients =ingredientsList.get(position);
        CharSequence s = currentIngredients.getMeasure()+ currentIngredients.getMeasure()+currentIngredients.getIngredient();
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ingredients_list);
        views.setTextViewText(R.id.ingredient_item,s);
        return views;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
