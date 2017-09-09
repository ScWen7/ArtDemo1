package io.scwen7.artdemo.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 解晓辉  on 2017/9/9 17:05 *
 * QQ  ：811733738
 * 作用:   公共的Fragment
 * 1、多状态布局通过 initStatusLayout()方法进行初始化
 * 2、布局的初始化操作通过  initView()方法进行
 * 3、正常加载 Fragment通过 initData() 方法进行加载数据
 * 4、针对  hide-show或 和ViewPager结合使用  懒加载 需要设置setLazy()来设置懒加载，通过initData方法进行懒加载
 */

public abstract class BaseFragment extends Fragment {

    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    private boolean isVisible;                  //是否可见状态
    private boolean isPrepared;                 //标志位，View已经初始化完成。
    private boolean isFirstLoad = true;         //是否第一次加载

    private boolean isLazy = false;             //是否需要懒加载

    protected LayoutInflater inflater;

    protected Activity mActivity;

    protected MyApplication mApplication;

    protected View mRootView;

    protected Unbinder mUnbinder;


    /**
     * Fragment 对应的视图
     */
    private ViewGroup rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
        }
        initStatusLayout(mRootView);
        mUnbinder = ButterKnife.bind(this, mRootView);
        initView();
        return mRootView;
    }


    /**
     * 子类如果需要多状态布局，需要重写此方法来配置多状态布局
     * 子类需要执行两部操作
     * Step1 初始化StatusLayout 配置多状态布局
     * Step2 添加到 ContentView的相应位置中
     *
     * @param rootView
     */
    public void initStatusLayout(View rootView) {

    }


    @Override
    public void onDestroyView() {

        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
        super.onDestroyView();
    }


    /**
     * 如果是与ViewPager一起使用，调用的是setUserVisibleHint
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("TAG", this.getClass().getSimpleName() + "    setUserVisibleHint() " + isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 如果是通过FragmentTransaction的show和hide的方法来控制显示，调用的是onHiddenChanged.
     * 若是初始就show的Fragment 为了触发该事件 需要先hide再show
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e("TAG", this.getClass().getSimpleName() + "    onHiddenChanged() " + hidden);
        if (!hidden) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }
    protected void onVisible() {
        lazyLoad();
    }

    protected void onInvisible() {
    }

    /**
     * 懒加载
     */
    protected void lazyLoad() {
        if (!isPrepared || !isVisible || !isFirstLoad) {
            return;
        }
        isFirstLoad = false;
        initData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        mApplication = (MyApplication) mActivity.getApplication();
        isPrepared = true;
        if (!isLazy) {
            isVisible = true;
        }
        lazyLoad();
    }

    /**
     * 设置是否需要懒加载  默认为  不需要 false
     * @param lazy
     */
    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }

    /**
     * 预留出 初始化视图的方法
     */
    protected void initView() {
    }



    /**
     * 子类需要提供布局ID
     *
     * @return activity对应的  布局id
     */
    protected abstract int getLayoutId();


    public <T extends Activity> T getParentActivity() {
        return (T) mActivity;
    }


    /**
     * 初始化Fragment时
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }

    }


    /**
     * 子类通过该方法来完成数据的初始化
     */
    protected abstract void initData();


    /**
     * 跳转Activity
     *
     * @param clazz
     */
    public void startActivity(Class clazz) {
        Intent intent = new Intent(mActivity, clazz);
        mActivity.startActivity(intent);
    }

    public ViewGroup getRootView() {
        return rootView;
    }


    public void hideInput(View view) {
        InputMethodManager imm = (InputMethodManager) mApplication.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }


}
