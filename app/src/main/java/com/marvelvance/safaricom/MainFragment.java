package com.marvelvance.safaricom;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private List<Button> buttons;
    private static final int[] BUTTON_IDS = {
            R.id.safcom,
            R.id.mpesa,
    };



    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String title = getResources().getString(R.string.fragment_main);
                ((MainActivity) getActivity()).setAcionBarTitle(String.valueOf(title));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        buttons = new ArrayList<Button>();
        for(int id : BUTTON_IDS){
            Button button = (Button) view.findViewById(id);
            button.setOnClickListener(myListener);
            buttons.add(button);
        }

        return view;
    }

    private View.OnClickListener myListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            switch (v.getId()) {
                case R.id.safcom:
                    Toast.makeText(getActivity().getApplicationContext(), "Safaricom+ Button", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mpesa:
                    // Toast.makeText(getActivity().getApplicationContext(), "Mpesa Button", Toast.LENGTH_SHORT).show();
                    Fragment mpesaFragment = new MpesaFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    transaction.replace(R.id.main_activity, mpesaFragment);
                    transaction.addToBackStack(null);

                    transaction.commit();
                    break;
                default:
                    break;
            }
        }
    };

}
