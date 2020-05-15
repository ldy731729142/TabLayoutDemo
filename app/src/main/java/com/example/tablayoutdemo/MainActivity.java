package com.example.tablayoutdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private TabLayout tlTabs;
    private ViewPager vpContent;

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragments.add(new MyFragment("第一页"));
        fragments.add(new MyFragment("第二页"));
        fragments.add(new MyFragment("第三页"));
        fragments.add(new MyFragment("第四页"));
        fragments.add(new MyFragment("第五页"));
        titles.add("第一页");
        titles.add("第二页");
        titles.add("第三页");
        titles.add("第四页");
        titles.add("第五页");
        vpContent.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {

                return titles.get(position);
            }
        });

        tlTabs.setupWithViewPager(vpContent);
    }


    private void initViews() {
        tlTabs = findViewById(R.id.tl_tabs);
        vpContent = findViewById(R.id.vp_content);
    }

    public static class MyFragment extends Fragment {
        String name;
        private TextView tvName;

        public MyFragment(String s) {
            name = s;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment1, null);
            initViews(view);
            tvName.setText(name);
            return view;
        }

        private void initViews(View view) {
            tvName = view.findViewById(R.id.tvName);
        }
    }
}
