package org.ultrahack.investmentbutler.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.ultrahack.investmentbutler.Person;
import org.ultrahack.investmentbutler.R;
import org.ultrahack.investmentbutler.RVAdapter;
import org.ultrahack.investmentbutler.interfaces.OnFragmentInteractionListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IBM.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IBM#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IBM extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Person> persons;

    public IBM() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IBM.
     */
    // TODO: Rename and change types and number of parameters
    public static IBM newInstance(String param1, String param2) {
        IBM fragment = new IBM();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ibm, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        initializeData();
        initializeAdapter();

        Button btnInvest = (Button) getView().findViewById(R.id.btn_fragment_id_invest);
        btnInvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.invokeBtnInvest("IBM",persons.get(1).getValue());
            }
        });
        Button btnNext = (Button) getView().findViewById(R.id.btn_fragment_id_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.invokeBtnNext("IBM");
            }
        });
    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Profile match", "82%"));
        persons.add(new Person("Associated risk level", "medium (6/10)"));
        persons.add(new Person("Trusted investors", "7"));
        persons.add(new Person("Tags", "#tech #ai #cloud"));

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        mRecyclerView.setAdapter(adapter);
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
