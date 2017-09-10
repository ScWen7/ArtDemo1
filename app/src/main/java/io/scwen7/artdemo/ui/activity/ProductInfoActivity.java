package io.scwen7.artdemo.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import io.scwen7.artdemo.R;
import io.scwen7.artdemo.base.BaseActivity;
import io.scwen7.artdemo.utils.StatusBarUtil;

/**
 * Created by 解晓辉  on 2017/9/10 18:45 *
 * QQ  ：811733738
 * 作用:
 */

public class ProductInfoActivity extends BaseActivity {

    @BindView(R.id.rl_works_info)
    RelativeLayout mRlBuyNav;
    @BindView(R.id.tv_add_cart)
    TextView mTvAddACart;
    private ImageView mVp_works_pic;
    private AnimatorSet mSet;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_product_info;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
        mVp_works_pic = (ImageView) findViewById(R.id.vp_works_pic);
        Glide.with(this).load("http://images.artbloger.com/2000_1600_1/artwork/2017/01/12/Art_14842108071224.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop().into(mVp_works_pic);
//        http://images.artbloger.com/70_70_3/avatar/2014/08/30/Art_14094030718641.jpg
        mTvAddACart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCart(mVp_works_pic);
            }
        });
    }


    private void addCart(ImageView iv) {
//      一、创造出执行动画的主题---imageview
        //代码new一个imageview，图片资源是上面的imageview的图片
        final ImageView goods = new ImageView(this);
        goods.setImageDrawable(iv.getDrawable());
        //大小与原图片相同
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(iv.getWidth(), iv.getHeight());
        mRlBuyNav.addView(goods, params);

        //得到原图片的坐标（用于计算动画开始的坐标）
        int startLoc[] = new int[2];
        iv.getLocationInWindow(startLoc);

        //得到购物车按钮坐标
        int endLoc[] = new int[2];
        mTvAddACart.getLocationInWindow(endLoc);


//        三、正式开始计算动画开始/结束的坐标
        //开始掉落的商品的起始点：商品起始点+该商品图片的一半
        float startX = startLoc[0] + iv.getWidth() / 2;
        float startY = startLoc[1] + iv.getHeight() / 2;

        //商品掉落后的终点坐标：购物车起始点+购物车的1/2
        float toX = endLoc[0] + mTvAddACart.getWidth() / 2;
        float toY = endLoc[1] + mTvAddACart.getHeight() / 2;

        //计算动画差值
        float defX = toX - startX;
        float defY = toY - startY;


        //执行平移和缩放动画
        ObjectAnimator tranX = ObjectAnimator.ofFloat(goods, "translationX", 0, defX);
        ObjectAnimator tranY = ObjectAnimator.ofFloat(goods, "translationY", 0, defY);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(goods, "scaleX", 1f, 0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(goods, "scaleY", 1f, 0f);

        mSet = new AnimatorSet();
        mSet.playTogether(tranX, tranY, scaleX, scaleY);
        mSet.setDuration(1000);
        mSet.setInterpolator(new AccelerateInterpolator());
        mSet.start();
        mSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //动画结束时候需要将布局移除
                mRlBuyNav.removeView(goods);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        //退出时需要释放资源
        if(mSet!=null ) {
            if(mSet.isRunning()) {
                mSet.cancel();
            }
            mSet.removeAllListeners();
        }
        super.onDestroy();
    }
}
