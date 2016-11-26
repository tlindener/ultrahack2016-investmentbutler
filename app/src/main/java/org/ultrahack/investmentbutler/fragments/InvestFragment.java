package org.ultrahack.investmentbutler.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.blackcat.currencyedittext.CurrencyEditText;

import org.ultrahack.investmentbutler.Person;
import org.ultrahack.investmentbutler.R;
import org.ultrahack.investmentbutler.RVAdapter;
import org.ultrahack.investmentbutler.interfaces.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.Locale;


public class InvestFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Person> persons;
    private OnFragmentInteractionListener mListener;

    public InvestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InvestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InvestFragment newInstance(String param1, String param2) {
        InvestFragment fragment = new InvestFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invest, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView)getView().findViewById(R.id.invest_fragment_textview);
        if(mParam1 == null || mParam1 == ""){
            mParam1 = "iShares MSCI Emerging Markets";
            mParam2 = "low (3/10)";
        }
        textView.setText(mParam1);
        TextView textView2 = (TextView)getView().findViewById(R.id.person_age);
        textView2.setText(mParam2);

        CurrencyEditText editText = (CurrencyEditText ) getView().findViewById(R.id.invest_fragment_edittext);
        editText.setLocale(Locale.GERMANY);
        editText.setText("300,00");

    }
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Profile match", "87%"));
        persons.add(new Person("Associated risk level", "low (3/10)"));
        persons.add(new Person("Friends who already invested", "4"));
        persons.add(new Person("Tags", "#tech #ai #cloud #lowrisk"));

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        mRecyclerView.setAdapter(adapter);
    }
    @Override
    public void onResume() {
        super.onResume();

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
