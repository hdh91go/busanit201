package com.example.todosampleapp.login.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todosampleapp.R;
import com.example.todosampleapp.base.BaseActivity;
import com.example.todosampleapp.login.LoginContract;
import com.example.todosampleapp.login.LoginPresenter;
import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.LoginItem;

import butterknife.BindView;

public class LoginActivity
        extends BaseActivity<LoginContract.View, LoginContract.Presenter>
        implements LoginContract.View {

    @BindView(R.id.btnSave)
    Button btnSave;

    @BindView(R.id.etEmail)
    EditText etEmail;

    @BindView(R.id.etPassword)
    EditText etPassword;

    public LoginContract.Presenter setPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO new Item

                LoginItem item = new LoginItem();
                item.setEmail(getEtString(etEmail));
                item.setPassword(getEtString(etPassword));
//                item.setDone(true);
                // TODO save item
                mPresenter.save(item);
            }
        });
    }

    private String getEtString(EditText et) {
        return et.getText().toString();
    }

    @Override
    public void saveDone() {
        Toast.makeText(this, "Save Done", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }
}

