package sg.edu.rp.c346.id19042545.p04_ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter<Song> aa;
    ArrayList<Song> al;
    Button btn5Star;
    ArrayList<Integer> yearList;
    Spinner spn;
    ArrayAdapter<Integer> aaSPN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) findViewById(R.id.lv);
        btn5Star = (Button) findViewById(R.id.btn5Star);
        spn = findViewById(R.id.spn);
        yearList =new ArrayList<>();

        DBHelper dbh = new DBHelper(SecondActivity.this);
        // Display all songs
        al = new ArrayList<Song>();
        al = dbh.getAllSongs("");
        dbh.close();
        aa = new SongAdapter(this, R.layout.row, al);
        lv.setAdapter(aa);

        // Year Spinner
        for (Song i:al) {
            if (!yearList.contains(i.getYears()))
                yearList.add(i.getYears());
        }
        aaSPN = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, years);
        spn.setAdapter(aaSPN);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String year = yearList.get(position)+"";
                DBHelper db = new DBHelper(SecondActivity.this);
                al.clear();
                al.addAll(db.getAllSongsForyear(year));
                db.close();
                aa.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // List View Selected items
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(SecondActivity.this,
                        ThirdActivity.class);
                i.putExtra("data",data);
                startActivityForResult(i, 9);
            }
        });


        btn5Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(SecondActivity.this);
                al.clear();
                al.addAll(dbh.getAllSongs("5"));
                dbh.close();
                aa.notifyDataSetChanged();

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
            al.addAll(dbh.getAllSongs(""));
            aa.notifyDataSetChanged();
            dbh.close();
            updatedYearList();

        }
    }

    public void updatedYearList() {
        yearList.clear();
        for (Song i:al) {
            if (!yearList.contains(i.getYears()))
                yearList.add(i.getYears());
        }
        aaSPN.notifyDataSetChanged();
    }
}