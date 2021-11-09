package Thainam.clothesshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ViewPager mviewPager;
    private BottomNavigationView mnavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mviewPager = findViewById(R.id.viewpager);
        mnavigationView = findViewById(R.id.bottom_navigation);

        ViewPagerAdapter viewPagerAdapter =new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mviewPager.setAdapter(viewPagerAdapter);
        mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mnavigationView.getMenu().findItem(R.id.shirt).setChecked(true);
                    case 1:
                        mnavigationView.getMenu().findItem(R.id.backpackk).setChecked(true);
                    case 2:
                        mnavigationView.getMenu().findItem(R.id.cap).setChecked(true);
                    case 3:
                        mnavigationView.getMenu().findItem(R.id.dress).setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mnavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.shirt:
                        mviewPager.setCurrentItem(0);
                        ShirtFragment fragmentA = (ShirtFragment) mviewPager.getAdapter().instantiateItem(mviewPager,0);
                        break;
                    case R.id.backpackk:
                        mviewPager.setCurrentItem(1);
                        break;
                    case R.id.cap:
                        mviewPager.setCurrentItem(2);
                        break;
                    case R.id.dress:
                        mviewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });


    }
}