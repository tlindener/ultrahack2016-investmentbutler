package org.ultrahack.investmentbutler;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.ultrahack.investmentbutler.fragments.EmergingMarkets;
import org.ultrahack.investmentbutler.fragments.IBM;
import org.ultrahack.investmentbutler.fragments.InvestFragment;
import org.ultrahack.investmentbutler.fragments.MSFT;
import org.ultrahack.investmentbutler.interfaces.OnFragmentInteractionListener;

public class InvestmentButlerActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    private static final String TAG = InvestmentButlerActivity.class.getName();

    private MyPagerAdapter mFragmentAdapter;
    private ViewPager mViewPager;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_investment_butler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Investment Butler");
        setSupportActionBar(toolbar);
        //Apply the Adapter
        mFragmentAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.vpPager);
        mViewPager.setAdapter(mFragmentAdapter);
        mContext = this;

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void invokeBtnInvest(String fragmentName, String riskLevel) {
        switch(fragmentName){
            case "IBM":
                mFragmentAdapter.investment = fragmentName;
                mFragmentAdapter.risklevel = riskLevel;
                mViewPager.setAdapter(mFragmentAdapter);
                mViewPager.setCurrentItem(4);
                break;
            case "MSFT":
                mFragmentAdapter.investment = fragmentName;
                mFragmentAdapter.risklevel = riskLevel;
                mViewPager.setAdapter(mFragmentAdapter);
                mViewPager.setCurrentItem(4);
                break;
            case "EmergingMarkets":
                mFragmentAdapter.investment = "iShares MSCI Emerging Markets";
                mFragmentAdapter.risklevel = riskLevel;
                mViewPager.setAdapter(mFragmentAdapter);
                mViewPager.setCurrentItem(4);
                break;
        }
    }

    @Override
    public void invokeBtnNext(String fragmentName) {
        switch(fragmentName){
            case "IBM":
                mViewPager.setCurrentItem(1);
                break;
            case "MSFT":
                mViewPager.setCurrentItem(2);
                break;
            case "EmergingMarkets":
                // 1. Instantiate an AlertDialog.Builder with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

// 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage("Unfortunately we didn't found an interesting investment for you this time. We will continuously analyze possible investments for you in the background!")
                        .setTitle("Recommendations");

// 3. Get the AlertDialog from create()
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public String investment = "";
        public String risklevel ="";

        public MyPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return new IBM();

                case 1:
                    return new MSFT();
                case 2:
                    return new EmergingMarkets();
                case 3:

                    return InvestFragment.newInstance(investment,risklevel);
                default:
                    return null;
            }
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return 4;
        }

    }
}