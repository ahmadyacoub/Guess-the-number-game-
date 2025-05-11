package com.example.todo1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start_button = (Button) findViewById(R.id.start_game);
        start_button.setBackgroundColor(Color.parseColor("#673AB7FF"));

        EditText first_name_text = (EditText) findViewById(R.id.first_text);
        EditText last_name_text = (EditText) findViewById(R.id.last_text);
        Spinner gender_spinner = (Spinner) findViewById(R.id.spinner);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first_name = first_name_text.getText().toString().trim();
                String last_name = last_name_text.getText().toString().trim();
                String gender = gender_spinner.getSelectedItem().toString();
                if (first_name.isEmpty() || last_name.isEmpty()) {
                    Toast toast=   Toast.makeText(MainActivity.this,"Please enter both first and last names! ! ",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if (isNumeric(first_name) || isNumeric(last_name)) {
                    Toast toast=   Toast.makeText(MainActivity.this,"Names cannot be numbers only!! ",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if (gender.equals("Select Gender")) {
                    Toast toast=   Toast.makeText(MainActivity.this,"Select Your Gender!! ",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, game_page.class);
                intent.putExtra("first_name",first_name);
                intent.putExtra("last_name",last_name);
                intent.putExtra("gender",gender);
                startActivity(intent);
            }
        });
        String[] options = {"Select Gender", "Male", "Female" };
        ArrayAdapter<String> objGenderArr = new
        ArrayAdapter<>(this,android.R.layout.simple_spinner_item, options);
        gender_spinner.setAdapter(objGenderArr);

    }
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        return str.matches("[0-9]+");
    }
}