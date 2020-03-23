package com.andmate.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textViewTwo;
    private TextView textViewThree;
    private Switch beginnerSwitch;
    private Switch secondSwitch;
    private Switch thirdSwitch;
    private TextView textViewDate;
    private final String counterDataKey = "counterDataKey";
    private Button button;
    private TextView textViewC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setOnSwitchChanged();
        setOnSwitchChangedTwo();
        setOnSwitchChangedThree();
        setDateOnApp();
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        initIncreaseBtnBehavior();
    }
    private void initViews() {
        textView = findViewById(R.id.textView6);
        textViewTwo = findViewById(R.id.textView7);
        textViewThree = findViewById(R.id.textView8);
        textViewDate = findViewById(R.id.textView5);
        button = findViewById(R.id.increaseCounterBtn);
        textViewC = findViewById(R.id.textViewCount);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            beginnerSwitch = findViewById(R.id.switch1);
            secondSwitch = findViewById(R.id.switch2);
            thirdSwitch = findViewById(R.id.switch3);
        }
    }
    private void initIncreaseBtnBehavior() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counterValue = Integer.parseInt(textViewC.getText().toString());
                String newTextValue = String.valueOf(++counterValue);
                textViewC.setText(newTextValue);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);

        String text = saveInstanceState.getString(counterDataKey, "0");
        textViewC.setText(text);

        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle saveInstanceState){
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();

        String text = textViewC.getText().toString();
        saveInstanceState.putString(counterDataKey, text);

        super.onSaveInstanceState(saveInstanceState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
    }

    private void setDateOnApp() {
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        textViewDate.setText(currentDate);
    }

    private void setOnSwitchChanged() {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            beginnerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String text;
                    if(isChecked) {
                        text = getString(R.string.celsius);
                    } else {
                        text = getString(R.string.fahrenheit);
                    }
                    textView.setText(text);
                }
            });
        }
    }

    private void setOnSwitchChangedTwo() {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            secondSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String text;
                    if(isChecked) {
                        text = getString(R.string.mm);
                    } else {
                        text = getString(R.string.mbar);
                    }
                    textViewTwo.setText(text);
                }
            });
        }
    }

    private void setOnSwitchChangedThree() {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            thirdSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String text;
                    if(isChecked) {
                        text = getString(R.string.m_s);
                    } else {
                        text = getString(R.string.km_h);
                    }
                    textViewThree.setText(text);
                }
            });
        }
    }
}