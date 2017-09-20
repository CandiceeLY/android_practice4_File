package com.example.luyue.rw;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static com.example.luyue.rw.R.id.rgSex;


public class MainActivity extends AppCompatActivity {

    //public RadioGroup radioGroup;
   // public RadioButton male, female;
    public String strSex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        String FILE_NAME = "fileDemo.txt";
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String text = "no data" ;
        try {
            fos.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // String FILE_NAME = "fileDemo.txt";
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] readBytes = new byte[0];
        try {
            readBytes = new byte[fis.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while(fis.read(readBytes) != -1){
             }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //write
        Button btnWrite = (Button)findViewById(R.id.btnWrite);
        btnWrite.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view){

                /*
                radioGroup = (RadioGroup) findViewById(R.id.rgSex);
                male = (RadioButton) findViewById(R.id.radioButtonMale);
                female = (RadioButton) findViewById(R.id.radioButtonFemale);

                RadioGroup.OnCheckedChangeListener radiogpchange = new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (checkedId == male.getId()) {
                       // Toast.makeText(getApplicationContext(), "女孩", Toast.LENGTH_LONG).show();
                        strSex="男";
                    } else if (checkedId == female.getId()) {
                       // Toast.makeText(getApplicationContext(), "男孩", Toast.LENGTH_LONG).show();
                        strSex="女";
                    }
                }
            };
                radioGroup.setOnCheckedChangeListener(radiogpchange);
*/

                //写入文件
                OutputStream out = null;
                try {
                    FileOutputStream fos = openFileOutput("fileDemo.txt",MODE_PRIVATE);
                    out = new BufferedOutputStream(new FileOutputStream(String.valueOf(fos)));
                    try{
                    }
                    finally {
                        if (out != null) {
                            out.close();
                        }
                    }
                }catch (Exception e){

                }

                try{
                    FileOutputStream
                            fileOutputStream=openFileOutput("fileDemo.txt",MODE_PRIVATE);
                    out=new BufferedOutputStream(fileOutputStream);

                    EditText editTextUserName =(EditText)findViewById(R.id.editTextUserName);
                    String str1=editTextUserName.getText().toString();
                    EditText editTextUserID =(EditText)findViewById(R.id.editTextUserID);
                    String str2=editTextUserID.getText().toString();
                    String str="姓名:"+str1+'\n'+"ID:"+str2+'\n'+"性别:"+strSex;
                    try{
                        out.write(str.getBytes(Charset.forName("UTF-8")));
                    }
                    finally {
                        if(out!=null)
                            out.close();
                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    //read
        Button btnRead = (Button)findViewById(R.id.btnRead);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //读取文件
               // InputStream in=null;
               /* try {
                    FileInputStream fis= openFileInput("fileDemo.txt");
                    in=new BufferedInputStream(fis);

                    try{   //read data from file
                    }
                    finally {
                        if(in!=null)
                            in.close();
                    }
                }
                catch (Exception e){
                }*/

                try {
                    FileInputStream fileInputStream = openFileInput("fileDemo.txt");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
                    //in=new BufferedInputStream(fileInputStream);

                   // StringBuilder stringBuilder=new StringBuilder("");
                   // stringBuilder = (TextView)findViewById()
                    String str = null;
                    String c;
                        while ((c=reader.readLine())!=null) {
                            if (str == null) str = c;
                            else str += '\n' + c;
                        }
                    Toast.makeText(MainActivity.this,str.toString(),Toast.LENGTH_LONG).show();
                            reader.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }


            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
      //  TextView textView=(TextView)findViewById(R.id.textView);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonMale:
                if (checked)
               //     textView.setText("您的性别为男");
                strSex="男";
                break;
            case R.id.radioButtonFemale:
                if (checked)
               //     textView.setText("您的性别为女");
                strSex="女";
                break;
        }
    }

}
