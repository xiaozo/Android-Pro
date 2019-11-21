package com.example.zlx.proframe;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.zlx.proframe.base.BaseActivity;
import com.example.zlx.proframe.base.BaseMvpActivity;
import com.example.zlx.proframe.bean.BaseObjectBean;
import com.example.zlx.proframe.bean.LoginBean;
import com.example.zlx.proframe.bean.LoginParams;
import com.example.zlx.proframe.contract.MainContract;
import com.example.zlx.proframe.net.HttpResult;
import com.example.zlx.proframe.presenter.MainPresenter;
import com.example.zlx.proframe.util.ProgressDialog;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.Subject;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.topbar)
    QMUITopBarLayout mTopBar;

    @BindView(R.id.et_username_login)
    TextInputEditText etUsernameLogin;
    @BindView(R.id.et_password_login)
    TextInputEditText etPasswordLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);

        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               System.out.println("addLeftBackImageButton");
            }
        });
        mTopBar.setTitle("MAINACTION");
    }

    /**
     * @return 帐号
     */
    private String getUsername() {
        return etUsernameLogin.getText().toString().trim();
    }

    /**
     * @return 密码
     */
    private String getPassword() {
        return etPasswordLogin.getText().toString().trim();
    }

    @Override
    public void onSuccess(BaseObjectBean bean) {

        Toast.makeText(this, bean.getErrorMsg(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLoading() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dismiss();
    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(this, throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_signin_login)
    public void onViewClicked() {
//        if (getUsername().isEmpty() || getPassword().isEmpty()) {
//            Toast.makeText(this, "帐号密码不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        mPresenter.login(getUsername(), getPassword(), new HttpResult<LoginBean>() {
//
//            @Override
//            public void onSuccess(LoginBean loginBean) throws Exception {
//
//            }
//
//            @Override
//            public void onError(Throwable throwable) throws Exception {
//
//            }
//        });

        LoginParams params = new LoginParams();
        params.setPassword(getPassword());
        params.setUsername(getUsername());
        mPresenter.login1(params, new HttpResult<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) throws Exception {
//                MainActivity.this.onSuccess(loginBean);
            }

            @Override
            public void onError(Throwable throwable) throws Exception {
                MainActivity.this.onError(throwable);
            }
        });

    }
}
