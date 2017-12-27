package com.example.android.pets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class filter_activity extends AppCompatActivity {

    RadioButton atozname;
    RadioButton ztoaname;
    RadioButton atozbreed;
    RadioButton ztoabreed;
    RadioButton incweight;
    RadioButton decweight;
    RadioButton gender_male;
    RadioButton gender_female;
    Intent intent;
    Button apply;


    List<RadioButton> radioButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_activity);

      intent=  getIntent();
        atozname = (RadioButton) findViewById(R.id.atoz_name);
        ztoaname = (RadioButton) findViewById(R.id.ztoa_name);
        atozbreed = (RadioButton) findViewById(R.id.atoz_breed);
        ztoabreed = (RadioButton) findViewById(R.id.ztoa_breed);
        incweight = (RadioButton) findViewById(R.id.increasing);
        decweight = (RadioButton) findViewById(R.id.decreasing);
        apply = (Button) findViewById(R.id.apply);
        gender_male = (RadioButton) findViewById(R.id.radioButton2);
        gender_female = (RadioButton) findViewById(R.id.radioButton3);


        radioButtons.add((RadioButton) findViewById(R.id.atoz_name));
        radioButtons.add((RadioButton) findViewById(R.id.ztoa_name));
        radioButtons.add((RadioButton) findViewById(R.id.atoz_breed));
        radioButtons.add((RadioButton) findViewById(R.id.ztoa_breed));
        radioButtons.add((RadioButton) findViewById(R.id.increasing));
        radioButtons.add((RadioButton) findViewById(R.id.decreasing));


        for (RadioButton button : radioButtons) {

            button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) processRadioButtonClick(buttonView);
                }
            });

        }
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent= new Intent (filter_activity.this,filter.class);
                Bundle b = new Bundle();
                if (atozname.isChecked() && !gender_male.isChecked() && !gender_female.isChecked()) {

                    int button =1;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (ztoaname.isChecked() && !gender_male.isChecked() && !gender_female.isChecked()) {

                    int button =2;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (atozbreed.isChecked()  && !gender_male.isChecked() && !gender_female.isChecked()) {

                    int button =3;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (ztoabreed.isChecked()  && !gender_male.isChecked() && !gender_female.isChecked()) {

                    int button =4;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (incweight.isChecked()  && !gender_male.isChecked() && !gender_female.isChecked()) {

                    int button =5;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (decweight.isChecked()  && !gender_male.isChecked() && !gender_female.isChecked()) {

                    int button =6;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }

// With MALE Pets Filter
               else if (atozname.isChecked() && gender_male.isChecked()) {

                    int button =11;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (ztoaname.isChecked() && gender_male.isChecked()) {

                    int button =21;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (atozbreed.isChecked() && gender_male.isChecked()) {

                    int button =31;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (ztoabreed.isChecked() && gender_male.isChecked()) {

                    int button =41;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (incweight.isChecked() && gender_male.isChecked()) {

                    int button =51;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (decweight.isChecked() && gender_male.isChecked()) {

                    int button =61;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }

//With FEMALE Pets filter
                if (atozname.isChecked() && gender_female.isChecked()) {

                    int button =12;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (ztoaname.isChecked()  && gender_female.isChecked()) {

                    int button =22;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (atozbreed.isChecked()  && gender_female.isChecked()) {

                    int button =32;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (ztoabreed.isChecked()  && gender_female.isChecked()) {

                    int button =42;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (incweight.isChecked()  && gender_female.isChecked()) {

                    int button =52;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                else if (decweight.isChecked()  && gender_female.isChecked()) {

                    int button =62;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);

                }

                if(gender_male.isChecked()){
                    int button =7;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);
                }
                else  if(gender_female.isChecked()){
                    int button =8;
                    b.putInt("sortorder", button);
                    intent.putExtras(b);
                    startActivity(intent);
                }




            }
        });
    }

    private void processRadioButtonClick(CompoundButton buttonView) {
        for (RadioButton button : radioButtons) {

            if (button != buttonView) button.setChecked(false);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                startActivity(new Intent(filter_activity.this, CatalogActivity.class));
                return true;

            case R.id.action_reset: {

                atozname.setChecked(false);
                ztoaname.setChecked(false);
                atozbreed.setChecked(false);
                ztoabreed.setChecked(false);
                incweight.setChecked(false);
                decweight.setChecked(false);
                gender_male.setChecked(false);
                gender_female.setChecked(false);

            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return true;
    }





}
