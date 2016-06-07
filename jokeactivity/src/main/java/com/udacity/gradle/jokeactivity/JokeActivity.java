package com.udacity.gradle.jokeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static final String EXTRA_JOKE = "extra_joke";

    private TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        jokeTextView = (TextView) findViewById(R.id.joke_text);

        String jokeText = getIntent().getStringExtra(EXTRA_JOKE);

        if (jokeText == null) jokeTextView.setText("Joke not found");
        else jokeTextView.setText(jokeText);
    }
}
