package com.lakj.comspace.simpletextclient;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class finalize_order extends Activity {
    finalize_order a=this;
    public static  Socket client;
    public static PrintWriter printwriter;
    public static BufferedReader bb;
    public static String messsage;
    public static String m1;
    static int old_all_total;
    static int all_total;

    String personal_preferences;
    Object oo;
    String fin_order_string="";
    public String S;
    static int next_ord_flag;
    static String order_string;
    static String old_ord_string="";

    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_order);
        show_Order();
        tot_v();
        oo=this;
    }


    public void show_Order() {
        if (Dessert.chocolate_ice_cream > 0) {
            fin_order_string = fin_order_string + "Honda City - for " + String.valueOf(Dessert.chocolate_ice_cream) + " Hours" + "\n";
        }
        if (Dessert.vanilla_ice_cream > 0) {
            fin_order_string = fin_order_string + "Honda Civic - for " + String.valueOf(Dessert.vanilla_ice_cream) + " Hours" + "\n";
        }
        if (Dessert.strawberry_ice_cream > 0) {
            fin_order_string = fin_order_string + "Honda BR-V - for " + String.valueOf(Dessert.strawberry_ice_cream) + " Hours" + "\n";
        }
        if (Dessert.falooda > 0) {
            fin_order_string = fin_order_string + "falooda - " + String.valueOf(Dessert.falooda) + "\n";
        }
        if (Dessert.brownie_fudge > 0) {
            fin_order_string = fin_order_string + "brownie fudge - " + String.valueOf(Dessert.brownie_fudge) + "\n";
        }
        if (Dessert.alpine_chocolate > 0) {
            fin_order_string = fin_order_string + "alpine chocolate - " + String.valueOf(Dessert.alpine_chocolate) + "\n";
        }
        if (Dessert.devils_delight > 0) {
            fin_order_string = fin_order_string + "devils delite - " + String.valueOf(Dessert.devils_delight) + "\n";
        }

        if (Dessert.black_forest > 0) {
            fin_order_string = fin_order_string + "black forest - " + String.valueOf(Dessert.black_forest) + "\n";
        }
        if (Dessert.chocolate_lava > 0) {
            fin_order_string = fin_order_string + "chocolate lava - " + String.valueOf(Dessert.chocolate_lava) + "\n";
        }

        if (Dessert.dutch_almond > 0) {
            fin_order_string = fin_order_string + "dutch almond - " + String.valueOf(Dessert.dutch_almond) + "\n";
        }
        if (N_Veg.chicken_burger > 0) {
            fin_order_string = fin_order_string + "Hyundai Accent - for " + String.valueOf(N_Veg.chicken_burger) + " Hours" + "\n";
        }
        if (N_Veg.chicken_bbq_pizza > 0) {
            fin_order_string = fin_order_string + "Hyundai Tucson - for " + String.valueOf(N_Veg.chicken_bbq_pizza) + " Hours" + "\n";
        }
        if (N_Veg.chicken_tikka > 0) {
            fin_order_string = fin_order_string + "Hyundai Venue - for " + String.valueOf(N_Veg.chicken_tikka) + " Hours" + "\n";
        }
        if (N_Veg.fried_fish_rice > 0) {
            fin_order_string = fin_order_string + "fried fish rice - " + String.valueOf(N_Veg.fried_fish_rice) + "\n";
        }
        if (N_Veg.kolhapuri_chicken > 0) {
            fin_order_string = fin_order_string + "kolhapur chicken - " + String.valueOf(N_Veg.kolhapuri_chicken) + "\n";
        }
        if (N_Veg.chicken_noodles > 0) {
            fin_order_string = fin_order_string + "chicken noodles - " + String.valueOf(N_Veg.chicken_noodles) + "\n";
        }
        if (N_Veg.chicken_fried_rice > 0) {
            fin_order_string = fin_order_string + "chicken fried rice - " + String.valueOf(N_Veg.chicken_fried_rice) + "\n";
        }

        if (N_Veg.chicken_lollipop > 0) {
            fin_order_string = fin_order_string + "chicken lollipop - " + String.valueOf(N_Veg.chicken_lollipop) + "\n";
        }

        if (N_Veg.chicken_biryani> 0) {
            fin_order_string = fin_order_string + "chicken biryani - " + String.valueOf(N_Veg.chicken_biryani) + "\n";
        }
        if (N_Veg.mutton_biryani> 0) {
            fin_order_string = fin_order_string + "mutton biryani - " + String.valueOf(N_Veg.mutton_biryani) + "\n";
        }

        if (Veg.roti > 0) {
            fin_order_string = fin_order_string + "Nissan Almera - for " + String.valueOf(Veg.roti) + " Hours" + "\n";
        }
        if (Veg.butter_roti > 0) {
            fin_order_string = fin_order_string + "Nissan Navara - for " + String.valueOf(Veg.butter_roti) + " Hours" + "\n";
        }
        if (Veg.paneer_tikka > 0) {
            fin_order_string = fin_order_string + "Nissan Terra - for " + String.valueOf(Veg.paneer_tikka) + " Hours" + "\n";
        }

        if (Veg.veg_pulao > 0) {
            fin_order_string = fin_order_string + "veg pulao - " + String.valueOf(Veg.veg_pulao) + " Hours" + "\n";
        }
        if (Veg.mutter_paneer> 0) {
            fin_order_string = fin_order_string + "mutter paneer - " + String.valueOf(Veg.mutter_paneer) + "\n";
        }
        if (Veg.veg_noodles> 0) {
            fin_order_string = fin_order_string + "veg noodles - " + String.valueOf(Veg.veg_noodles) + "\n";
        }

        if (Veg.veg_fried_rice> 0) {
            fin_order_string = fin_order_string + "veg fried rice - " + String.valueOf(Veg.veg_fried_rice) + "\n";
        }
        if (Veg.veg_burger> 0) {
            fin_order_string = fin_order_string + "veg burger - " + String.valueOf(Veg.veg_burger) + "\n";
        }
        if (Veg.veg_biryani> 0) {
            fin_order_string = fin_order_string + "veg briyani - " + String.valueOf(Veg.veg_biryani) + "\n";
        }

        if (Veg.paneer_kofta> 0) {
            fin_order_string = fin_order_string + "paneer kofta - " + String.valueOf(Veg.paneer_kofta) + "\n";
        }
        if (Starters.veg_crispy > 0) {
            fin_order_string = fin_order_string + "Toyota Vios - for " + String.valueOf(Starters.veg_crispy) + " Hours" + "\n";
        }
        if (Starters.chicken_crispy > 0) {
            fin_order_string = fin_order_string + "Toyota Wigo - for " + String.valueOf(Starters.chicken_crispy) + " Hours" + "\n";
        }
        if (Starters.paneer_chilly > 0) {
            fin_order_string = fin_order_string + "Toyota Avanza - for " + String.valueOf(Starters.paneer_chilly) + " Hours" + "\n";
        }
        if (Starters.masala_papad > 0) {
            fin_order_string = fin_order_string + "masala papad - " + String.valueOf(Starters.masala_papad) + "\n";
        }
        if (Starters.veg_soup > 0) {
            fin_order_string = fin_order_string + "veg soup - " + String.valueOf(Starters.veg_soup) + "\n";
        }
        if (Starters.chicken_soup > 0) {
            fin_order_string = fin_order_string + "chicken soup - " + String.valueOf(Starters.chicken_soup) + "\n";
        }
        if (Starters.tomato_soup > 0) {
            fin_order_string = fin_order_string + "tomato soup - " + String.valueOf(Starters.tomato_soup) + "\n";
        }
        if (Starters.cheese_pakoda > 0) {
            fin_order_string = fin_order_string + "cheese pakoda - " + String.valueOf(Starters.cheese_pakoda) + "\n";
        }
        if (Starters.paneer_pakoda > 0) {
            fin_order_string = fin_order_string + "paneer pakoda - " + String.valueOf(Starters.paneer_pakoda) + "\n";
        }
        if (Starters.chicken_chilly > 0) {
            fin_order_string = fin_order_string + "chicken chilly - " + String.valueOf(Starters.chicken_chilly) + "\n";
        }
        String temp_order_view=fin_order_string+old_ord_string;
        TextView tv = (TextView) findViewById(R.id.order_final);
        tv.setText("" + temp_order_view);
    }

    public void main_menu(View view) {
        Intent goto_main_menu = new Intent(this, Order_Type.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void tot_v(){
        all_total=all_total+old_all_total;
        TextView tv = (TextView) findViewById(R.id.tot_p);
        tv.setText("Amount: " + "₱" +(finalize_order.all_total));
    }




    public void send_ord(View v){
        order_string=fin_order_string;

    EditText Ed= (EditText) findViewById(R.id.personalp);

    personal_preferences=Ed.getText().toString();

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage("Are you sure you want to confirm this rent?")
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                      messsage = "Renting Details: \n"
                              + "Name: " + SlimpleTextClientActivity.name
                              + " Renting: \n" + fin_order_string
                              + "\nTotal: ₱" + Integer.toString(all_total)
                              + "\nAdditional Notes" +personal_preferences;
                        String msg = messsage;
                        String no = new editPhoneNumber().num.toString();

                        //Get the SmsManager instance and call the sendTextMessage method to send message
                        Intent intent=new Intent(getApplicationContext(),thankyou.class);
                        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                        SmsManager sms=SmsManager.getDefault();
                        sms.sendTextMessage(no, null, msg, pi,null);

                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
    });
    AlertDialog alert = builder.create();
    alert.show();
}
}