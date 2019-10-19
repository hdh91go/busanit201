package com.example.todosampleapp;

import com.example.todosampleapp.base.BasePresenter;
import com.example.todosampleapp.base.BaseView;
import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.LoginItem;

import java.util.List;

public class MainContract {
    public interface View
            extends BaseView {
        void fetchItemsDone(List<Item> items);
        void showDetail(int pos);
    }

    public interface Presenter
            extends BasePresenter<View> {
        //TODO fetch Items
        void fetchItems();
        void fetchItemsDone(List<Item> items);
        void showDetail(int no);

        void fetchLoginItems();
        void fetchLoginItemsDone(List<LoginItem> items);
    }
}
