package com.example.androidlessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = "LIST";

    private EditText editTextMsg;
    private Spinner spinnerMsg;
    private TextView textViewConfig;
    private Switch switchRemember;

    private String msg_save_mode;
    private String rememberConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.i(TAG, "onCreate");
        editTextMsg = findViewById(R.id.editTextMsg);
        spinnerMsg = findViewById(R.id.spinnerMsg);
        textViewConfig = findViewById(R.id.textViewConfig);
        switchRemember = findViewById(R.id.switchRemember);
        switchRemember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((Switch) v).isChecked();
                if (checked){
                    rememberConfig = "Да";
                }
                else{
                    rememberConfig = "Нет";
                }
            }
        });
    }

    public void showMsgConfig(View view) {
        String msg = editTextMsg.getText().toString().trim();
        String msg_options = spinnerMsg.getSelectedItem().toString();
        String msg_config = String.format("Ваше сообщение: %s\nТип отправки: %s" +
                "\nРежим сохранения: %s\nЗапомнить конфигурацию: %s\n",
                msg, msg_options, msg_save_mode, rememberConfig);
        textViewConfig.setText(msg_config);
    }

    public void radioClick(View view) {
        RadioButton button = (RadioButton) view;
        int id = button.getId();
        if (id == R.id.radioSave){
            msg_save_mode = getString(R.string.save_msg);
        } else {
            msg_save_mode = getString(R.string.no_save_msg);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}