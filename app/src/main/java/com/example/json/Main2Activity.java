package com.example.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ArrayList<String> al;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    Button parse;
    String json = "{\n" +
            "  \"student\": {\n" +
            "    \"name\": \"kishore kethineni\",\n" +
            "    \"Regno\": 11605869,\n" +
            "    \"branch\": \"CSE\",\n" +
            "    \"contact\": [\n" +
            "      987538143,\n" +
            "      98654252165\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = findViewById(R.id.listview);
        parse = findViewById(R.id.button2);
        al = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, al);

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray=jsonObject.getJSONArray("student");

            for (int i=0;i<jsonArray.length();i++) {
                String name = jsonObject.getString("name");
                int Regno = jsonObject.getInt("Regno");
                String branch = jsonObject.getString("branch");
                int contact = jsonObject.getInt("contact");
                String parsed = name ;//+ " " + branch + " " + Regno + " " + contact;
                al.add(parsed);
                listView.setAdapter(arrayAdapter);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
