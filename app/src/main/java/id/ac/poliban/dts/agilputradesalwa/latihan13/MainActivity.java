package id.ac.poliban.dts.agilputradesalwa.latihan13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etFirst = findViewById(R.id.etFirst);
        EditText etLast = findViewById(R.id.etLast);
        Button btLoad = findViewById(R.id.btLoad);
        Button btSave = findViewById(R.id.btSave);

        btLoad.setOnClickListener(v -> startActivity(new Intent(this, SecondActivity.class)));
        btSave.setOnClickListener(v -> {
            String file = "Roman";
            SharedPreferences sp = getSharedPreferences(file, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            String iname = etFirst.getText().toString();
            String fname = etLast.getText().toString();

            editor.putString("fname", fname);
            editor.putString("iname", iname);
            editor.apply();

            Toast.makeText(this, "Save It", Toast.LENGTH_SHORT).show();
        });
    }
}
