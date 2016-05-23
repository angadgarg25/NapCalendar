package greggnod.napcalendar;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView naptype;
    private Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewToNap(View view){
        setContentView(R.layout.nap_main);
        naptype = null;
    }

    public void chooseTypeNap(View view){
        LinearLayout list = (LinearLayout) findViewById(R.id.list);
        Button but = (Button) findViewById(R.id.radioButton);
        Button but2 = (Button) findViewById(R.id.radioButton2);
        Button napbut = (Button) findViewById(R.id.napbutton);
        but.setVisibility(View.INVISIBLE);
        but2.setVisibility(View.INVISIBLE);
        list.setVisibility(View.VISIBLE);
        napbut.setVisibility(View.VISIBLE);
    }

    public void viewToSch(View view){

    }
     public void chosenNap(View view){
         RelativeLayout rl = (RelativeLayout) findViewById(R.id.naplayout);
         if (naptype != null){
             naptype.setBackgroundColor(rl.getDrawingCacheBackgroundColor());
             naptype.setTextColor(Color.rgb(229,57,53));
         }
         naptype = (TextView) view;
         naptype.setTextColor(Color.WHITE);
         naptype.setBackgroundColor(Color.rgb(229,57,53));
     }

    public void viewToPrev(View view){
        LinearLayout list = (LinearLayout) findViewById(R.id.list);
        Button but = (Button) findViewById(R.id.radioButton);
        Button but2 = (Button) findViewById(R.id.radioButton2);
        Button napbut = (Button) findViewById(R.id.napbutton);
        if (list.getVisibility()==View.VISIBLE){
            but.setVisibility(View.VISIBLE);
            but2.setVisibility(View.VISIBLE);
            list.setVisibility(View.INVISIBLE);
            napbut.setVisibility(View.INVISIBLE);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void naptime(View v){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.new_dialogue);
        if (naptype !=null){
            String napt = naptype.getText().toString();
            dialog.setTitle("Time to Nap!");
            String message = "";
            switch (napt) {
                case "Power Nap":
                    message = "You are set for a 20 minute Power Nap. Are you ready to begin your nap?";
                    break;
                case "Slow-Wave Nap 1":
                    message = "You are set for a 30 minute Slow-Wave Nap. Are you ready to begin your nap?";
                    break;
                case "Slow-Wave Nap 2":
                    message = "You are set for a 45 minute Slow-Wave Nap. Are you ready to begin your nap?";
                    break;
                case "Slow-Wave Nap 3":
                    message = "You are set for a 60 minute Slow-Wave Nap. Are you ready to begin your nap?";
                    break;
                case "REM Cycle Nap":
                    message = "You are set for a 90 minute REM Cycle Nap. Are you ready to begin your nap?";
                    break;
            }
            TextView dialogMsg = (TextView) dialog.findViewById(R.id.textView2) ;
            dialogMsg.setText(message);
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_color);
            Button btOK = (Button) dialog.findViewById(R.id.button4);
            btOK.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    dialog.dismiss();
                }
            });
            dialog.show();
        } else {
            dialog.setTitle("Please Pick a Nap Type!");
            TextView dialogMsg = (TextView) dialog.findViewById(R.id.textView2) ;
            dialogMsg.setText("Pick one of the listed nap types.");
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_color);
            Button btOK = (Button) dialog.findViewById(R.id.button3);
            Button hide = (Button) dialog.findViewById(R.id.button4);
            hide.setVisibility(View.INVISIBLE);
            btOK.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    }
}
