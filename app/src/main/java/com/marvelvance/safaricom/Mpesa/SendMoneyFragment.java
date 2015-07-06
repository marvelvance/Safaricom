package com.marvelvance.safaricom.Mpesa;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.marvelvance.safaricom.MainActivity;
import com.marvelvance.safaricom.R;
import com.marvelvance.safaricom.UserInput.PhoneNoFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SendMoneyFragment extends Fragment {

    private List<Button> buttons;
    private static final int[] BUTTON_IDS = {
            R.id.search,
            R.id.enter_phone_no,
    };

    public SendMoneyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String title = getResources().getString(R.string.fragment_send_money);
                ((MainActivity) getActivity()).setAcionBarTitle(String.valueOf(title));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_money, container, false);

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
                case R.id.search:
                    Toast.makeText(getActivity().getApplicationContext(), "Search for No.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.enter_phone_no:
                    // Toast.makeText(getActivity().getApplicationContext(), "Withdraw Cash Button", Toast.LENGTH_SHORT).show();
                    Fragment phnoeFragment = new PhoneNoFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    transaction.replace(R.id.main_activity, phnoeFragment);
                    transaction.addToBackStack(null);

                    transaction.commit();
                    break;
                default:
                    break;
            }
        }
    };


}
