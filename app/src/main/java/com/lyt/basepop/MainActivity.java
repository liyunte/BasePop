package com.lyt.basepop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.lyt.pop.BasePop;
import com.lyt.pop.OnInitViewAdapter;
import com.lyt.pop.PopConfig;
import com.lyt.pop.QuickPopupBuilder;

public class MainActivity extends AppCompatActivity {
    BasePop pop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void show(View view){
       pop = QuickPopupBuilder.with(this)
                .setContentView(R.layout.pop_test)
                .setOnInitViewListener(new OnInitViewAdapter(){
                    @Override
                    public void onInitView(View view) {
                        super.onInitView(view);
                        EditText tv_test = view.findViewById(R.id.tv_test);
                        tv_test.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pop.dismiss();
                            }
                        });
                    }
                })
                .build();
        pop.show();

    }
}
