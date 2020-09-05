package com.maderastra.unguided2.nomor1;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.maderastra.unguided2.nomor1.MainActivity;
import com.maderastra.unguided2.nomor1.R;

import static android.widget.Toast.makeText;


public class FirstFragment extends Fragment {

    public static String KEY_ACTIVITY = "msg_activity";

    TextView txtName;
    Button btn_back, btn_done;
    Slider slidee;
    AutoCompleteTextView list_snack;
    String[] snacks = {"Mie Kremes","Oreo","Wafer Nabati","Taro","Doritos"};

    void showToast(CharSequence msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    View v = inflater.inflate(R.layout.fragment_first, container, false);
    txtName = (TextView) v.findViewById(R.id.txt_Name);
    slidee = (Slider) v.findViewById(R.id.slider_move);
    btn_back = (Button) v.findViewById(R.id.back_btn);
    btn_done = (Button) v.findViewById(R.id.done_btn);
    list_snack = (AutoCompleteTextView) v.findViewById(R.id.snack_list);
    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_singlechoice, snacks);

    slidee.setEnabled(false);
    String message = getArguments().getString(KEY_ACTIVITY);
    if (message.equals("")) {
        txtName.setText("Try Again");
        slidee.setVisibility(v.VISIBLE);
        list_snack.setEnabled(false);
    } else {
        txtName.setText(message);
        slidee.setVisibility(v.INVISIBLE);
        txtName.setVisibility(v.VISIBLE);
        list_snack.setAdapter(adapter);
        list_snack.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast("Saya suka makan "+ adapter.getItem(i));
            }
        });
    }

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtName.equals("Try Again")) {
                    txtName.setText("");
                }

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.findViewById(R.id.txtHello).setVisibility(v.VISIBLE);
                mainActivity.findViewById(R.id.story).setVisibility(v.VISIBLE);
                mainActivity.findViewById(R.id.submit_btn).setVisibility(v.VISIBLE);
                mainActivity.findViewById(R.id.fullname_layout).setVisibility(v.VISIBLE);
                mainActivity.findViewById(R.id.age_layout).setVisibility(v.VISIBLE);
                mainActivity.findViewById(R.id.spacee).setVisibility(v.VISIBLE);
                mainActivity.findViewById(R.id.fragmentku).setVisibility(v.GONE);
            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finishAndRemoveTask();
            }
        });



    return v;
    }
}