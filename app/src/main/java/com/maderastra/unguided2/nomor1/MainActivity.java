package com.maderastra.unguided2.nomor1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextAge;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.fullname);
        editTextAge = (EditText) findViewById(R.id.age);
        btnSubmit = (Button) findViewById(R.id.submit_btn);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.txtHello).setVisibility(v.GONE);
                findViewById(R.id.story).setVisibility(v.GONE);
                findViewById(R.id.submit_btn).setVisibility(v.GONE);
                findViewById(R.id.fullname_layout).setVisibility(v.GONE);
                findViewById(R.id.age_layout).setVisibility(v.GONE);
                findViewById(R.id.spacee).setVisibility(v.GONE);;
                String message;
                message = editTextName.getText().toString();
                Bundle data = new Bundle();
                data.putString(FirstFragment.KEY_ACTIVITY, message);
                FirstFragment frag = new FirstFragment();
                frag.setArguments(data);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainku, frag).commit();
            }
        });
    }
}