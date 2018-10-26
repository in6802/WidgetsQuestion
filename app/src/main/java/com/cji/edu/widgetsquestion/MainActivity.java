package com.cji.edu.widgetsquestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name = "";
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰와 연결
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        final EditText editTextName = (EditText) findViewById(R.id.editTextName);
        final EditText editTextAge = (EditText) findViewById(R.id.editTextAge);
        final RadioGroup radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        final RadioGroup radioGroupJob = (RadioGroup) findViewById(R.id.radioGroupJob);

        //결과 버튼 리스너 등록
        Button buttonResult = (Button) findViewById(R.id.buttonResult);
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 예외처리
                String name = editTextName.getText().toString();
                if("".equals(name))
                    name = "최정인";

                String age = editTextAge.getText().toString();
                if("".equals(age))
                    age = "20";

                RadioButton radioButtonGender = (RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId());
                String radioButtonGendertext = "여자";
                if(radioButtonGender != null)
                    radioButtonGendertext = radioButtonGender.getText().toString();

                RadioButton radioButtonJob = (RadioButton) findViewById(radioGroupJob.getCheckedRadioButtonId());
                String radioButtonJobtext = "학생";
                if(radioButtonJob != null)
                    radioButtonJobtext = radioButtonJob.getText().toString();

                String text = "이름은 " + name +
                        ", 나이는 " + age +
                        "세, 성별은 " + radioButtonGendertext +
                        ", 직업은 " + radioButtonJobtext +
                        "입니다.";

                textViewResult.setText(text);
            }
        });

        Button buttonResultHalf = (Button) findViewById(R.id.buttonResultHalf);
        buttonResultHalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String text = "이름은 " + editTextName.getText().toString() +
                        ", 나이는 " + editTextAge.getText().toString();

                textViewResult.setText(text);
            }
        });
    }
}