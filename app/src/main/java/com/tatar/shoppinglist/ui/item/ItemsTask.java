package com.tatar.shoppinglist.ui.item;

import android.os.AsyncTask;

import com.tatar.shoppinglist.data.db.item.ItemDao;
import com.tatar.shoppinglist.data.db.item.model.Item;

import java.util.List;

import static com.tatar.shoppinglist.ui.item.ItemsContract.ItemsView;

public class ItemsTask extends AsyncTask<Void, Void, List<Item>> {

    private ItemsView itemsView;
    private ItemDao itemDao;

    public ItemsTask(ItemsView itemsView, ItemDao itemDao) {
        this.itemsView = itemsView;
        this.itemDao = itemDao;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        itemsView.toggleProgressBar();
    }

    @Override
    protected List<Item> doInBackground(Void... voids) {
        return itemDao.getAllItems();
    }

    @Override
    protected void onPostExecute(List<Item> items) {
        super.onPostExecute(items);
        itemsView.toggleProgressBar();

        if (items == null) {
            itemsView.displayMessage("Upps ! Something went wrong.");
        } else {
            itemsView.toggleNoItemsTv(items.size());
            itemsView.displayItems(items);
        }
    }
}