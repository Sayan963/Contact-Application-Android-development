package com.example.contactapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder> {
    @NonNull

            Context context;
             ArrayList<ContactModel>array;
             int lastpos=-1;

    Adapter(Context context, ArrayList<ContactModel>array){
        this.context=context;
        this.array=array;
    }
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyle_main,parent,false);
        viewholder viewholder=new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.img.setImageResource(array.get(position).img);
        holder.name.setText(array.get(position).name);
        holder.number.setText(array.get(position).number);
        holder.llmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtname,edtnumber;
                Button btnaction ;

                Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.add_update);
                edtname=dialog.findViewById(R.id.edtname);
                edtnumber=dialog.findViewById(R.id.edtnumber);
                btnaction=dialog.findViewById(R.id.btndialogue);
                btnaction.setText("Update");
                edtname.setText(array.get(position).name);
                edtnumber.setText(array.get(position).number);
                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String newname,newnumber;
                         newname=edtname.getText().toString();
                         newnumber=edtnumber.getText().toString();
                         array.set(position,new ContactModel(R.drawable.c,newname,newnumber));
                         notifyItemChanged(position);
                         dialog.dismiss();
                    }

                });
                dialog.show();
            }
        });

       setanimation(holder.itemView,position);

       holder.llmain.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View view) {

               AlertDialog.Builder builder = new AlertDialog.Builder(context).setTitle("Delete")
                       .setMessage("Do you want to delete ").setIcon(R.drawable.delete).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               array.remove(position);
                               notifyItemRemoved(position);
                           }
                       }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               Toast.makeText(context, "Item is not delected", Toast.LENGTH_SHORT).show();
                           }
                       });
               builder.show();
               return true;
           }
       });



    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class viewholder extends  RecyclerView.ViewHolder{

         ImageView img;
         TextView name,number;
         LinearLayout llmain;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.contact);
            number=itemView.findViewById(R.id.number);
            llmain=itemView.findViewById(R.id.llmain);
        }
    }
    public void setanimation (View v,int positon){

        if(positon>lastpos){
        Animation slidin = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        v.startAnimation(slidin);
        lastpos=positon;
    }
}
}
