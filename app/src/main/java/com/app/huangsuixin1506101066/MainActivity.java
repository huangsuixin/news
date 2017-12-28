package com.app.huangsuixin1506101066;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.app.huangsuixin1506101066.adapter.MyPagerAdapter;
import com.app.huangsuixin1506101066.fragment.IndexFragment;
import com.app.huangsuixin1506101066.fragment.MineFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * @author Silence
 */
public class MainActivity extends AppCompatActivity {

    /** 底部导航 */
    private BottomNavigationViewEx bnve;
    private ViewPager vp;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigation();

    }

    /**
     * 初始化Navigation导航栏
     */
    private void initNavigation() {
        vp = (ViewPager) findViewById(R.id.vp);
        bnve = (BottomNavigationViewEx) findViewById(R.id.bnve);

        //禁止所有动画效果
        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);

        //添加参数
        List<Fragment> fragments = new ArrayList<>();
        //首页fragment
        fragments.add(new IndexFragment());
        //我的fragment
        fragments.add(new MineFragment());

        //添加适配器
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),fragments));

        //和 ViewPager 绑定####
        bnve.setupWithViewPager(vp,false);
        //小红点设置（一个参数是nav的位置，第二个参数是小红点的数字）
//        addBadgeAt(2, 8);


    }

    /**
     * 添加小红点方法
     */
    private Badge addBadgeAt(int position, int number) {
        // add badge
        return new QBadgeView(this)
                .setBadgeNumber(number)
                .setGravityOffset(12, 2, true)
                .setBadgeTextSize(8,true)//设置小红点里面字体的大小
                .setGravityOffset(16,4,true)//设置小红点距离右上角的位置
                .bindTarget(bnve.getBottomNavigationItemView(position))
                .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                        if (Badge.OnDragStateChangedListener.STATE_SUCCEED == dragState) {
                            Toast.makeText(MainActivity.this, "小红点消失了", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
