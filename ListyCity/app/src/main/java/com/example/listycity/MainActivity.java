package com.example.listycity;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    TextInputLayout input_text;
    View confirm_button;
    View add_button;
    View delete_button;
    String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_text = findViewById(R.id.input_city);
        confirm_button=findViewById(R.id.Confirm);
        add_button=findViewById(R.id.Add);
        delete_button=findViewById(R.id.Delete);

        input_text.setVisibility(INVISIBLE);
        confirm_button.setVisibility(INVISIBLE);

        cityList=findViewById(R.id.city_list);
        String []cities = {"Edmonton","Saskatoon","Maracaibo","Mexico City","Quebec City"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this,R.layout.content,dataList);
        cityList.setAdapter(cityAdapter);

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selection=cityAdapter.getItem(position);

            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selection!=null){
                    cityAdapter.remove(selection);
                    cityList.setAdapter(cityAdapter);
                }
            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_button.setVisibility(INVISIBLE);
                delete_button.setVisibility(INVISIBLE);

                input_text.setVisibility(VISIBLE);
                confirm_button.setVisibility(VISIBLE);

            }
        });
        confirm_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                input_text.setVisibility(INVISIBLE);
                confirm_button.setVisibility(INVISIBLE);

                String input = input_text.getEditText().getText().toString();

                cityAdapter.add(input);

                add_button.setVisibility(VISIBLE);
                delete_button.setVisibility(VISIBLE);
            }
        });





    }
}