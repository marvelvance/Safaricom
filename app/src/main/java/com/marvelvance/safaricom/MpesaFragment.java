package com.marvelvance.safaricom;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.marvelvance.safaricom.Mpesa.SendMoneyFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MpesaFragment extends Fragment {

    private List<Button> buttons;
    private static final int[] BUTTON_IDS = {
            R.id.send_money,
            R.id.withdraw_cash,
            R.id.buy_airtime,
            R.id.m_shwari,
            R.id.lipa_na_mpesa,
            R.id.my_account,
    };

    public MpesaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String title = getResources().getString(R.string.fragment_mpesa);
        ((MainActivity) getActivity()).setAcionBarTitle(String.valueOf(title));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mpesa, container, false);

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
                case R.id.send_money:
                    Toast.makeText(getActivity().getApplicationContext(), "Send Money Button", Toast.LENGTH_SHORT).show();
                    Fragment sendMoneyFragment = new SendMoneyFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    transaction.replace(R.id.main_activity, sendMoneyFragment);
                    transaction.addToBackStack(null);

                    transaction.commit();
                    break;
                case R.id.withdraw_cash:
                    Toast.makeText(getActivity().getApplicationContext(), "Withdraw Cash Button", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buy_airtime:
                    Toast.makeText(getActivity().getApplicationContext(), "Buy Airtime Button", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.m_shwari:
                    Toast.makeText(getActivity().getApplicationContext(), "M-Shwari Button", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.lipa_na_mpesa:
                    Toast.makeText(getActivity().getApplicationContext(), "Lipa na MPESA Button", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.my_account:
                    Toast.makeText(getActivity().getApplicationContext(), "My Account Button", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };



}
