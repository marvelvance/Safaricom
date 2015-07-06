package com.marvelvance.safaricom.UserInput;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marvelvance.safaricom.MainActivity;
import com.marvelvance.safaricom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PinFragment extends Fragment {

    private EditText Pin;
    private Button btnOk;

    public PinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pin, container, false);

        Pin = (EditText) view.findViewById(R.id.pin);
        btnOk = (Button) view.findViewById(R.id.ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = Pin.getText().toString();
                if (TextUtils.isEmpty(amount)) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please provide your pin", Toast.LENGTH_SHORT).show();
                    return;
                }

                new ConfirmDialogFragment().show(getActivity().getSupportFragmentManager(), "");

            }
        });


        return view;
    }

    public static class ConfirmDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Send ksh 1000 to Nathan")
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    Intent login = new Intent(getActivity(),
                                            MainActivity.class);
                                    startActivity(login);
                                    getActivity().finish();
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    // User cancelled the dialog
                                }
                            });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }


}
