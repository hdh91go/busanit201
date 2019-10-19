package com.example.todosampleapp.logic.remote;

import com.example.todosampleapp.logic.Repository;
import com.example.todosampleapp.logic.DataSource;
import com.example.todosampleapp.model.LoginItem;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class RemoteDataSourceImpl implements DataSource {

    @Override
    public void setRepository(Repository repository) {

    }

    @Override
    public Single<Long> save(LoginItem item) {
        return null;
    }

    @Override
    public Flowable<List<LoginItem>> fetchItems() {
        return null;
    }

    @Override
    public Single<LoginItem> fetchItem(int no) {
        return null;
    }
}
