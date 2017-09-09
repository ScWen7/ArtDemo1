package io.scwen7.artdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.scwen7.artdemo.R;
import io.scwen7.artdemo.weight.PullScrollView;

public class TestActivity extends AppCompatActivity implements PullScrollView.OnTurnListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mine);

    }

    @Override
    public void onTurn() {

    }
}
