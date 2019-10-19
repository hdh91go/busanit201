package com.example.todosampleapp.logic;

import com.example.todosampleapp.MainContract;
import com.example.todosampleapp.base.BasePresenter;
import com.example.todosampleapp.logic.local.LocalDataSourceImpl;
import com.example.todosampleapp.logic.remote.RemoteDataSourceImpl;
import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.LoginItem;
import com.example.todosampleapp.write.WriteContract;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class RepositoryImpl<T> implements Repository {
    BasePresenter<T> presenter;
    DataSource localDataSource;
    DataSource remoteDataSource;

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = presenter;
        localDataSource = new LocalDataSourceImpl();
        remoteDataSource = new RemoteDataSourceImpl();
        localDataSource.setRepository(this);
        remoteDataSource.setRepository(this);
    }

    @Override
    public Single<Long> save(Item item) {
        return localDataSource.save(item);
    }

    @Override
    public void saveDone() {
        ((WriteContract.Presenter)presenter).saveDone();
    }

    @Override
    public Flowable<List<Item>> fetchItems() {
        return localDataSource.fetchItems();
    }

    @Override
    public void fetchItemsDone(List list) {
        ((MainContract.Presenter)presenter).fetchItemsDone(list);
    }

    @Override
    public Single<Item> fetchItem(int no) {
        return localDataSource.fetchItem(no)
                .map(item -> {
                    item.setTitle(item.getTitle() + "_");
                    return item;
                });
    }

    //

    @Override
    public Single<Long> saveLogin(LoginItem item) {
        return localDataSource.saveLogin(item);
    }

    @Override
    public void saveLoginDone() {
        ((WriteContract.Presenter)presenter).saveLoginDone();
    }

    @Override
    public Flowable<List<LoginItem>> fetchLoginItems() {
        return localDataSource.fetchLoginItems();
    }

    @Override
    public void fetchLoginItemsDone(List list) {
        ((MainContract.Presenter)presenter).fetchLoginItemsDone(list);
    }

    @Override
    public Single<LoginItem> fetchLoginItem(int no) {
        return localDataSource.fetchLoginItem(no)
                .map(item -> {
                    item.setEmail(item.getEmail() + "_");
                    return item;
                });
    }
}
