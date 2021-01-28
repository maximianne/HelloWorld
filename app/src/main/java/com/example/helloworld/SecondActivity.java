package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity extends AppCompatActivity {
    private ConstraintLayout constraintLayout;
    private LinearLayout linearLayout;
    private Button button_goBack;
    private String receivedMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //display a message
        //x was passed from main activity
        //extract intent extras infnoration
        Intent intent = getIntent();
        receivedMessage =intent.getStringExtra("count");
        Log.d("Data from Main Activity", receivedMessage);
        //grab the contraint laylour cview
        constraintLayout= findViewById(R.id.second_root_layout);
        linearLayout=findViewById(R.id.secondLinearLayout);
        button_goBack= findViewById(R.id.button_goBack);
        //create a text view and set the text to recieved message + was passed from main activity
        //add text view to recycler view

//        TextView textView= new TextView(this);
//        textView.setText(receivedMessage + " was passed from mainActivity");
//        textView.setTextSize(30);
//        constraintLayout.addView(textView);

        //way to create views if you do not know how many views
        //for example, homework we do not know how many we need to create,
        // that depends onn the template you recieve from the API call
        //what if we want to show Hi the number of time the counter was pressed
        for(int i=0; i<Integer.parseInt(receivedMessage);i++) {
            TextView textView= new TextView(this);
            textView.setText("hi!");
            linearLayout.addView(textView);
            }
        //add a click listener for our button
    button_goBack.setOnClickListener(v-> {
        replayIntent(v);
    });

    }
    //we linked the second activity to the XML

    public void replayIntent(View view){
        //create a replay intent and pack the informationa dn send it back to main activity
        Intent replyIntent= new Intent();
        replyIntent.putExtra("reply count",receivedMessage);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
