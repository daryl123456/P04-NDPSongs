package sg.edu.rp.c346.id19042545.p04_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ThirdActivity extends AppCompatActivity {

    EditText etId,etTitle,etSinger,etYear;
    Button btnUpdate,btnDelete,btnCancel;
    Song data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        etId = findViewById(R.id.etId);
        etTitle = findViewById(R.id.etTitle1);
        etSinger = findViewById(R.id.etSinger1);
        etYear = findViewById(R.id.etYears1);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnCancel = findViewById(R.id.buttonCancel);
        btnDelete = findViewById(R.id.btnDelete);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        etId.setText(data.get_id()+"");
        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText(data.getYears()+"");


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup rg = findViewById(R.id.rgSecond);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup rg = findViewById(R.id.rgSecond);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}