package com.example.contactapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView R1;
    FloatingActionButton Float;
    ArrayList<ContactModel>array= new ArrayList<ContactModel>();
    Toolbar tool;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        R1 = findViewById(R.id.recyle);
        Float = findViewById(R.id.floatingbtn);
        tool=findViewById(R.id.tool);
        setSupportActionBar(tool);
        R1.setLayoutManager(new LinearLayoutManager(this));
        array.add(new ContactModel(R.drawable.b, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.e, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.f, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.b, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.c, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.d, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.f, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.d, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.b, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.f, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.c, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.b, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.d, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.f, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.c, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.e, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.b, "Sayan", "9609035082"));
        array.add(new ContactModel(R.drawable.e, "Sayan", "9609035082"));
        Adapter adapter = new Adapter(this, array);
        R1.setAdapter(adapter);

        Float.setOnClickListener(new View.OnClickListener() {
            EditText edtname, edtnumber;

            String txtname, txtnumber;
            Button btnaction;

            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update);

                edtname = dialog.findViewById(R.id.edtname);
                edtnumber = dialog.findViewById(R.id.edtnumber);
                btnaction = dialog.findViewById(R.id.btndialogue);
                btnaction.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {

                                                     txtname = edtname.getText().toString();
                                                     txtnumber = edtnumber.getText().toString();
                                                     array.add(new ContactModel(R.drawable.b, txtname, txtnumber));
                                                     adapter.notifyItemInserted(array.size());
                                                     R1.scrollToPosition(array.size() - 1);

                                                     dialog.dismiss();

                                                 }
                                             }
                );


                dialog.show();
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();
        if(itemid== R.id.New){
            EditText edtname, edtnumber;
            Button btnaction;



                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update);

                edtname = dialog.findViewById(R.id.edtname);
                edtnumber = dialog.findViewById(R.id.edtnumber);
                btnaction = dialog.findViewById(R.id.btndialogue);
                btnaction.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     String txtname, txtnumber;

                                                     txtname = edtname.getText().toString();
                                                     txtnumber = edtnumber.getText().toString();
                                                     array.add(new ContactModel(R.drawable.b, txtname, txtnumber));
                                                     Adapter adapter = new Adapter(getApplicationContext(),array);
                                                     adapter.notifyItemInserted(array.size());

                                                     R1.scrollToPosition(array.size() - 1);

                                                     dialog.dismiss();

                                                 }
                                             }
                );


                dialog.show();



        }
        return super.onOptionsItemSelected(item);
    }
}


