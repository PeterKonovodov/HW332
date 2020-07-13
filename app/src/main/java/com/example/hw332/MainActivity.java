package com.example.hw332;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner languageSpinner;
    Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        languageSpinner = findViewById(R.id.languagesSpinner);
        okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(onClickListener);
        initSpinner();


    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapterLangs = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterLangs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapterLangs);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

Button.OnClickListener onClickListener = new Button.OnClickListener() {

    @Override
    public void onClick(View v) {
        Locale locale;
        switch ((int) languageSpinner.getSelectedItemPosition()) {
            case 1:
                locale = new Locale("ru");
                break;
            case 2:
                locale = new Locale("ch");
                break;
            case 3:
                locale = new Locale("tt");
                break;
            default:
                locale = new Locale("en");
                break;
        }
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();

    }
};


}