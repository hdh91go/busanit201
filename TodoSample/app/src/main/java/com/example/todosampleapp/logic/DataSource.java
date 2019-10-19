package com.example.todosampleapp.logic;

import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.LoginItem;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface DataSource {
    void setRepository(Repository repository);

    Single<Long> save(Item item);
    Flowable<List<Item>> fetchItems();
    Single<Item> fetchItem(int no);

    Single<Long> saveLogin(LoginItem item);
    Flowable<List<LoginItem>> fetchLoginItems();
    Single<LoginItem> fetchLoginItem(int no);
}
