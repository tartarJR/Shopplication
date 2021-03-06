package com.tatar.shoppinglist.di.app.module;


import com.tatar.shoppinglist.data.db.item.ItemDao;
import com.tatar.shoppinglist.data.db.item.ItemDaoImpl;
import com.tatar.shoppinglist.data.db.shoppinglist.ShoppingListDao;
import com.tatar.shoppinglist.data.db.shoppinglist.ShoppingListDaoImpl;
import com.tatar.shoppinglist.di.app.scope.AppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class DaoModule {

    @AppScope
    @Provides
    public ItemDao itemDao() {
        return new ItemDaoImpl();
    }

    @AppScope
    @Provides
    public ShoppingListDao shoppingListDao() {
        return new ShoppingListDaoImpl();
    }

}
