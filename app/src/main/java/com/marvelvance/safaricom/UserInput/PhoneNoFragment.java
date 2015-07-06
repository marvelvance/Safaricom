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

import com.marvelvance.safaricom.MpesaFragment;
import com.marvelvance.safaricom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneNoFragment extends Fragment {

    private EditText PhoneNo;
    private Button btnOk;

    public PhoneNoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phone_no, container, false);

        PhoneNo = (EditText) view.findViewById(R.id.phone_no);
        btnOk = (Button) view.findViewById(R.id.ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_no = PhoneNo.getText().toString();
                if (TextUtils.isEmpty(phone_no)) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please provide phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                Fragment amountFragment = new AmountFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.main_activity, amountFragment);
                transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        return view;
    }


}
