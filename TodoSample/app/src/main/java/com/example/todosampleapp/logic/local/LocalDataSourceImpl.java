package com.example.todosampleapp.logic.local;

import com.example.todosampleapp.logic.DataSource;
import com.example.todosampleapp.logic.Repository;
import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.LoginItem;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class LocalDataSourceImpl implements DataSource {
    Repository repository;
    AppDatabase appDatabase;

    public LocalDataSourceImpl() {
        try {
            appDatabase = AppDatabaseProvider.getINSTANCE();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Long> save(final Item item) {
        //TODO SAVE
        return getItemDao().saveItem(item);
    }

    // Fetch Items
    @Override
    public Flowable<List<Item>> fetchItems() {
        return getItemDao().fetchItems();
    }

    @Override
    public Single<Item> fetchItem(int no) {
        return getItemDao().fetchItem(no)
                .firstOrError();

    }

    @Override
    public Single<Long> saveLogin(final LoginItem item) {
        //TODO SAVE
        return getItemDao().saveItem(item);
    }

    // Fetch Items
    @Override
    public Flowable<List<Item>> fetchItems() {
        return getItemDao().fetchItems();
    }

    @Override
    public Single<Item> fetchItem(int no) {
        return getItemDao().fetchItem(no)
                .firstOrError();

    }

    //

    @Override
    public Flowable<List<LoginItem>> fetchLoginItems() {
        return getItemDao().fetchLoginItems();
    }

    @Override
    public Single<LoginItem> fetchLoginItem(int no) {
        return getItemDao().fetchLoginItem(no)
                .firstOrError();

    }

    @Override
    public Single<Long> saveLogin(final LoginItem item) {
        //TODO SAVE
        return getItemDao().saveLoginItem(item);
    }

    // Fetch Items
    @Override
    public Flowable<List<LoginItem>> fetchLoginItems() {
        return getItemDao().fetchLoginItems();
    }

    @Override
    public Single<LoginItem> fetchLoginItem(int no) {
        return getItemDao().fetchLoginItem(no)
                .firstOrError();

    }

    private ItemDao getItemDao() {
        return appDatabase.getItemDao();
    }
}
