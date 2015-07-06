package com.marvelvance.safaricom.UserInput;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marvelvance.safaricom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AmountFragment extends Fragment {

    private EditText Amount;
    private Button btnOk;

    public AmountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_amount, container, false);

        Amount = (EditText) view.findViewById(R.id.amount);
        btnOk = (Button) view.findViewById(R.id.ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = Amount.getText().toString();
                if (TextUtils.isEmpty(amount)) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please provide phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                Fragment pinFragment = new PinFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.main_activity, pinFragment);
                transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        return view;
    }


}
