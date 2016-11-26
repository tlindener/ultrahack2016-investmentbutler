package org.ultrahack.investmentbutler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class BankAppActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Person> persons;
    private RecyclerView mRecyclerView2;
    private LinearLayoutManager mLayoutManager2;
    private ArrayList<Person> persons2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("My Bank App");
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        initializeData();
        initializeAdapter();

        // Yesterday

        mRecyclerView2 = (RecyclerView) findViewById(R.id.my_recycler_view2);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView2.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager2 = new LinearLayoutManager(this);
        mRecyclerView2.setLayoutManager(mLayoutManager2);
        DividerItemDecoration dividerItemDecoration2 = new DividerItemDecoration(mRecyclerView2.getContext(),
                mLayoutManager2.getOrientation());
        mRecyclerView2.addItemDecoration(dividerItemDecoration2);
        initializeData2();
        initializeAdapter2();

        ImageButton btnInvestmentButler = (ImageButton) findViewById(R.id.activity_bank_app_img_btn);
        btnInvestmentButler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), InvestmentButlerActivity.class);
                startActivity(i);
            }
        });
    }
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Netflix Monthly", "-9.99 €"));
        persons.add(new Person("Rent Bruno Event Location", "-475 €"));
        persons.add(new Person("Cash Withdrawal (Raiffaisen Graz)", "-55 €"));
    }

    private void initializeAdapter(){
        BankingListAdapter adapter = new BankingListAdapter(persons);
        mRecyclerView.setAdapter(adapter);
    }


    private void initializeData2(){
        persons2 = new ArrayList<>();
        persons2.add(new Person("Cash Withdrawal (DZ Bank FFM)", "-60 €"));
        persons2.add(new Person("Cash Withdrawal (OP Group)", "-40 €"));
        persons2.add(new Person("Salary November", "5.740 €"));
        persons2.add(new Person("Yummu Food Truck", "-7.50 €"));
    }

    private void initializeAdapter2(){
        BankingListAdapter adapter = new BankingListAdapter(persons2);
        mRecyclerView2.setAdapter(adapter);
    }

}
