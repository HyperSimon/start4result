package com.roselism.start4result_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.roselism.start4result.RoselismActivity;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class JavaActivity extends RoselismActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button kotlinButton = (Button) findViewById(R.id.kotlin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JavaActivity.this, TargetActivity.class);
                startActivityForResult(intent, Constants.Main.REQUEST_CODE_4_DEMO, new Function1<Intent, Unit>() {
                    @Override
                    public Unit invoke(Intent intent) {
                        Toast.makeText(JavaActivity.this, intent.getStringExtra(Constants.Target.ARG_DEMO), Toast.LENGTH_SHORT).show();
                        return Unit.INSTANCE;
                    }
                });
            }
        });

        kotlinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KotlinActivity.Companion.start(JavaActivity.this);
                finish();
            }
        });
    }
}
