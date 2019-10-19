package com.example.todosampleapp.write;

import com.example.todosampleapp.base.BasePresenter;
import com.example.todosampleapp.base.BaseView;
import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.LoginItem;

public class WriteContract {
    public interface View extends BaseView {
        // 작성완료 ( <= Presenter)
        void saveDone();
    }

    public interface Presenter
            extends BasePresenter<View> {
        // 저장
        void save(Item item);
        // 작성완료 ( <= Repository)
        void saveDone();

        // 저장
        void save(LoginItem item);
        // 작성완료 ( <= Repository)
        void saveLoginDone();
    }
}
}
