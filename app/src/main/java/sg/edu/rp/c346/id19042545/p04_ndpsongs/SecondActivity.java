package sg.edu.rp.c346.id19042545.p04_ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter<Song> aa;
    ArrayList<Song> al;
    Button btn5Star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) findViewById(R.id.lv);
        btn5Star = (Button) findViewById(R.id.btn5Star);

        btn5Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(SecondActivity.this);
                Intent i = getIntent();


                al = new ArrayList<Song>();

            }
        });

        DBHelper dbh = new DBHelper(SecondActivity.this);
        al = new ArrayList<Song>();

        aa = new SongAdapter(this, R.layout.row, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {

                Song data = al.get(position);
                Intent i = new Intent(SecondActivity.this,
                        ThirdActivity.class);

                startActivityForResult(i, 9);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9) {
            DBHelper dbh = new DBHelper(SecondActivity.this);
            al.clear();

            aa.notifyDataSetChanged();
            dbh.close();

        } else {
            aa.notifyDataSetChanged();
        }
    }
}