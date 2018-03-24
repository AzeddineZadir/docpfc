package com.example.salim.db_test;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.salim.db_test.modele.*;

import petrov.kristiyan.colorpicker.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText ettitre,etdescri;
    Button bajout,bcoul;
    RadioButton verifoui,verifnon;
    Spinner sprio;

    Calendrier_Manager db=new Calendrier_Manager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ettitre=(EditText)findViewById(R.id.ettitre);
        etdescri=(EditText)findViewById(R.id.etdescri);

        bajout=(Button)findViewById(R.id.bajout);
        bajout.setOnClickListener(this);

        verifoui=(RadioButton) findViewById(R.id.radiooui);
        verifnon=(RadioButton)findViewById(R.id.radionon);
        sprio=(Spinner)findViewById(R.id.sprio);

        bcoul=(Button)findViewById(R.id.bcoul);
        bcoul.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view==bajout){
            Calendrier c = new Calendrier();
            ColorDrawable bcoul_background=(ColorDrawable)bcoul.getBackground();
           if (verifoui.isChecked()) {



               c.setTitre("" + ettitre.getText());
               c.setDescription("" + etdescri.getText());
               c.setCouleur("" + bcoul_background.getColor());
               c.setPriorite("" +sprio.getSelectedItem());
               c.setVisib(true);
            //Open DB
               db.open();
               db.insertCalendar(c);
               Toast.makeText(this,"Insertion réussie",Toast.LENGTH_LONG).show();
             //close it
               db.close();


           }else if ((verifnon.isChecked())){


               c.setTitre("" + ettitre.getText());
               c.setDescription("" + etdescri.getText());
               c.setCouleur("" + bcoul_background.getColor());
               c.setPriorite("" + sprio.getSelectedItem());
               c.setVisib(false);
               //Open DB
               db.open();
               db.insertCalendar(c);
               Toast.makeText(this,"Insertion réussie",Toast.LENGTH_LONG).show();
               //close it
               db.close();

           }else{
               Toast.makeText(this,"Veuillez indiquer la visiblité",Toast.LENGTH_LONG).show();
           }




        }

        if (view==bcoul){


            ColorPicker  colorPicker = new ColorPicker(this);
            colorPicker.setRoundColorButton(true);
            colorPicker.show();
            colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                @Override
                public void onChooseColor(int position, int color) {
                    bcoul.setBackgroundColor(color);

                }

                @Override
                public void onCancel() {

                }
            });

        }
    }
}
