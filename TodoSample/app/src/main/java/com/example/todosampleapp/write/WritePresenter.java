package com.example.todosampleapp.write;

import android.util.Log;

import com.example.todosampleapp.base.BasePresenterImpl;
import com.example.todosampleapp.logic.Repository;
import com.example.todosampleapp.logic.RepositoryImpl;
import com.example.todosampleapp.model.Item;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WritePresenter extends BasePresenterImpl<WriteContract.View>
        implements WriteContract.Presenter {
    WriteContract.View view;
    Repository repository;

    @Override
    public void setView(WriteContract.View view) {
        this.view = view;
        repository = new RepositoryImpl();
        repository.setPresenter(this);
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void save(Item item) {
        //TODO Repository에 저장
        repository.save(item)
                .doOnSuccess((object)
                        -> Log.d("WritePresenter",
                        Thread.currentThread().getName()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> view.saveDone());
    }

    @Override
    public void saveDone() {
        view.saveDone();
    }
}

