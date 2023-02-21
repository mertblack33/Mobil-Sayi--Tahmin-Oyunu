package com.mert.sayitahmin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText sayi;
    TextView sonuc;
    int[] rasgele;
    int toplam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sayi = findViewById(R.id.mert);
        sonuc = findViewById(R.id.textView);
        rasgele = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        toplam = 3;
    }


    public  void tahmin(View view) {
        Random random = new Random();
        int i = random.nextInt(10);
        int e = rasgele[i];
        //System.out.println("Test Sayi :"+ e);
        int deger = Integer.parseInt(sayi.getText().toString());
        if (e == deger){
            System.out.println("İf Kontrolüne Girdi");
            sonuc.setText("Tebrikler Tahmin Başarılı");
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, Context.MODE_PRIVATE);
            alert.setTitle("Kazandınız");
            alert.setMessage("Tebrikler Kazandınız");
            alert.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }).show();

        }else if (toplam == 0){
            System.out.println("İf else Kontrolüne Girdi");
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, Context.MODE_PRIVATE);
            alert.setTitle("Kaybettin");
            alert.setMessage("Kaybettin Tutulan Sayı :"+e);
            alert.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }).show();


        }else {
            System.out.println("İf else  Kontrolüne Girdi");
            Toast.makeText(MainActivity.this,"Kalan Hakkınız : "+toplam,Toast.LENGTH_LONG).show();
            toplam--;
        }
    }
}