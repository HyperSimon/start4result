package com.roselism.start4result_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        Intent intent = new Intent().putExtra(Constants.Target.ARG_DEMO, "this is a demo string");
        this.setResult(Constants.Main.REQUEST_CODE_4_DEMO, intent);
        finish();
    }
}
