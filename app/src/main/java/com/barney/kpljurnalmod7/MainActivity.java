package com.barney.kpljurnalmod7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.txt);
        TextView txt2 = findViewById(R.id.txt2);
        TextView txt3 = findViewById(R.id.txt3);
        EditText edit = findViewById(R.id.edit);
        EditText edit2 = findViewById(R.id.edit2);
        Button btn = findViewById(R.id.btn);
        Button btn2 = findViewById(R.id.btn2);

        String lang = getString(R.string.lang);

        if(lang == "en")
        {
            txt.setText("Please insert the amount of money to transfer:");
        }
        else if (lang == "id")
        {
            txt.setText("Masukkan jumlah uang yang akan di-transfer:");
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer uang, hargaTransferan;
                uang = Integer.parseInt(String.valueOf(edit.getText()));
                Resources res = getResources();
                String[] transfer = res.getStringArray(R.array.transfer);
                String threshold = transfer[0];
                int low_fee = Integer.parseInt(transfer[1]);
                int high_fee = Integer.parseInt(transfer[2]);


                if(uang <= Integer.parseInt(threshold)) {
                    hargaTransferan = low_fee;
                }else {
                    hargaTransferan = high_fee;
                }

                int total = uang + hargaTransferan;

                if(lang == "en") {
                    txt2.setText("Transfer fee = " + hargaTransferan +
                            "\nTotal amount = " + total +
                            "\nSelect transfer method"
                    );
                }
                else if (lang == "id")
                {
                    txt2.setText("Biaya transfer = " + hargaTransferan +
                            "\nTotal biaya = " + total +
                            "\nPilih metode transfer"
                    );
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Resources res = getResources();
                String[] confirmation = res.getStringArray(R.array.confirmation);

                if (lang == "en") {
                    txt3.setText("Please type '" + confirmation[0] + "' to confirm the transaction:");
                    String confirm = edit2.getText().toString();
                    if (confirm == confirmation[0]) {
                        txt3.setText("The transfer is completed");
                    }else{
                        txt3.setText("Transfer is cancelled");
                    }
                }
                else if (lang == "id")
                {
                    txt3.setText("Ketik '" + confirmation[1] + "' untuk mengkonfirmasi transaksi:");
                    String confirm = edit2.getText().toString();
                    if (confirm == confirmation[1]) {
                        txt3.setText("Proses transfer berhasil");
                    }else {
                        txt3.setText("Transfer dibatalkan");
                    }
                }
            }
        });
    }
}