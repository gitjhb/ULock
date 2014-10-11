package com.itjhb.ulock;

import com.itjhb.ulock.fragment.UserAppsFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.ListFragment;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity implements ActionBar.TabListener{
	private ViewPager mViewPager;
	private AppSectionsPagerAdapter mAppSectionsPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.applock);
		
		android.app.ActionBar actionBar=getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		 actionBar.setDisplayHomeAsUpEnabled(true);
		 
		 mViewPager = (ViewPager) findViewById(R.id.pager);
		 // Create the adapter that will return a fragment for each of the three primary sections
	        // of the app.
	     mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
		 mViewPager.setAdapter(mAppSectionsPagerAdapter);
		 mViewPager.setOnPageChangeListener(
		            new ViewPager.SimpleOnPageChangeListener() {
		                @Override
		                public void onPageSelected(int position) {
		                    // When swiping between pages, select the
		                    // corresponding tab.
		                    getActionBar().setSelectedNavigationItem(position);
		                }
		            });
		 
//		 ActionBar.TabListener tabListener = new ActionBar.TabListener() {
//
//			@Override
//			public void onTabSelected(Tab tab, FragmentTransaction ft) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onTabReselected(Tab tab, FragmentTransaction ft) {
//				// TODO Auto-generated method stub
//				
//			}
//		    };

		    // Add 3 tabs, specifying the tab's text and TabListener
		    for (int i = 0; i < 3; i++) {
		        actionBar.addTab(
		                actionBar.newTab()
		                        .setText("Tab " + (i + 1))
		                        .setTabListener(this));
		    }
	}
	
	public class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    // The first section of the app is the most interesting -- it offers
                    // a launchpad into the other demonstrations in this example application.
                    return new UserAppsFragment();

                default:
                    // The other sections of the app are dummy placeholders.
                    Fragment fragment = new DummySectionFragment();
                    Bundle args = new Bundle();
                    args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
                    fragment.setArguments(args);
                    return fragment;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Section " + (position + 1);
        }
    }
	

    public static class DummySectionFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_page_dummy, container, false);
            Bundle args = getArguments();
            ((TextView) rootView.findViewById(android.R.id.text1)).setText("1111");
            return rootView;
        }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
