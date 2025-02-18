package com.example.todosampleapp.logic;

import com.example.todosampleapp.base.BasePresenter;
import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.LoginItem;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface Repository<T> {
    void setPresenter(BasePresenter<T> presenter);
    Single<Long> save(T item);
    void saveDone();

    //Fetch
    Flowable<List<Item>> fetchItems();
    void fetchItemsDone(List<Item> items);

    Single<Item> fetchItem(int no);

    Flowable<List<LoginItem>> fetchLoginItems();
    void fetchLoginItemsDone(List<LoginItem> items);

    Single<Item> fetchLoginItem(int no);
}
