package njj.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mFragmentList = new ArrayList<>();
        mFragmentList.add(new MyFragment0());
        mFragmentList.add(new MyFragment1());
        mFragmentList.add(new MyFragment2());
        mFragmentList.add(new MyFragment3());

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        // 预加载的页面数，（前后）默认是1，最少也是1，设置0，也是1
        mViewPager.setOffscreenPageLimit(2);

    }

    /**
     * FragmentStatePagerAdapter 和 FragmentPagerAdapter的区别。
     * FragmentPagerAdapter：对于不在需要的Fragment，仅仅只会调用onDestoryView方法，也就是只销毁视图并没有销毁Fragment。
     * FragmentStatePagerAdapter：会销毁不再需要的fragment，一直调用到onDetach方法，将fragment和activity接触绑定。
     *      销毁时，会调用onSaveInstanceState(Bundle outState)方法通过bundle将信息保存下来，当用户切换回来，
     *      可以通过该bundle恢复生成新的fragment，也就是说，我们可以在onSaveInstanceState(Bundle outState)
     *      方法中保存一些数据，在onCreate中进行恢复创建
     */
    class MyPagerAdapter extends FragmentPagerAdapter {


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        /**
         * 页面更新后调用此方法。可以用于处理tab视图的切换
         * http://blog.csdn.net/harvic880925/article/details/38487149
         */
        @Override
        public void finishUpdate(ViewGroup container) {
            super.finishUpdate(container);
            Log.i("niejianjian"," ->  ->" + mViewPager.getCurrentItem());
        }

    }

}
