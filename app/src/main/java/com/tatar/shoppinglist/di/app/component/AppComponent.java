package com.tatar.shoppinglist.di.app.component;

import com.tatar.shoppinglist.data.db.item.ItemDao;
import com.tatar.shoppinglist.di.app.module.ContextModule;
import com.tatar.shoppinglist.di.app.module.DaoModule;
import com.tatar.shoppinglist.di.app.scope.AppScope;

import dagger.Component;

@AppScope
@Component(modules = {ContextModule.class, DaoModule.class})
public interface AppComponent {

    ItemDao getItemDao();
}
