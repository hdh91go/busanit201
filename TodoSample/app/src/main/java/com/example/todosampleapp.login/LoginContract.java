package com.example.todosampleapp.login;

import com.example.todosampleapp.base.BasePresenter;
import com.example.todosampleapp.base.BaseView;
import com.example.todosampleapp.model.LoginItem;

public class LoginContract {
    public interface View extends BaseView {
        // 작성완료 ( <= Presenter)
        void saveDone();
    }

    public interface Presenter
            extends BasePresenter<View> {
        // 저장
        void save(LoginItem item);
        // 작성완료 ( <= Repository)
        void saveDone();
    }
}
}
