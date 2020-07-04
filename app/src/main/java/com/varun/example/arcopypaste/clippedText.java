package com.varun.example.arcopypaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class clippedText extends AppCompatActivity implements View.OnClickListener {
    public static final String Text = "CLIPPED TEXT";
    private TextView textView;
    private ImageButton imageButton;
    int TEXT_COLOR = Color.BLACK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipped_text);
        textView = (TextView)findViewById(R.id.textView);
        imageButton = (ImageButton) findViewById((R.id.imageButton));
        imageButton.setOnClickListener(this);
        String textToSet = getIntent().getStringExtra(Text);
        textView.setTextColor(TEXT_COLOR);

        textView.setText(textToSet);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButton:
                shareText();
        }
    }

    public void shareText(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String te = textView.getText().toString();
        sendIntent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}
