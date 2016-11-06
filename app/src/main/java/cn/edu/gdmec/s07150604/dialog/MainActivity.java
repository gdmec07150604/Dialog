package cn.edu.gdmec.s07150604.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 =(TextView) findViewById(R.id.uidate);
        tv2 =(TextView) findViewById(R.id.uitime);
        tv3 =(TextView) findViewById(R.id.charactor);

    }
    public void charactordialog(View v){
        final String option=tv1.getText().toString();
        CharacterPickerDialog cpd = new CharacterPickerDialog(this,new View(this),null,option,false){
            @Override
            public void onClick(View v) {
                Button btn =(Button) v;
                tv3.append(btn.getText().toString());
                if(btn.getText().toString().equals("")){
                    dismiss();
                }
            }
        };
        cpd.show();;
    }
    public void datedialog(View v){
        Calendar cal =Calendar.getInstance();
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv1.setText("日期："+year+"-"+month+"-"+dayOfMonth);
            }
        },cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));
        dpd.show();
    }
    public void timedialog(View v){
        TimePickerDialog tpd =new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv2.setText(hourOfDay+":"+minute);
            }
        },9,15,true);
        tpd.show();
    }
    public void progressdialog(View v){
        final ProgressDialog pg =ProgressDialog.show(this,"加载","加载中，请稍后……",true);
        new Thread(){
            public void run() {
                try {
                    sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pg.dismiss();
                }
            }
        }.start();
    }
}
