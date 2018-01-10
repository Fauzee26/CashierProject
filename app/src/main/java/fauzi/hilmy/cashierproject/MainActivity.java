package fauzi.hilmy.cashierproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etPensil, etPena, etBuku;
    Button btnHitung;
    TextView lblTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //memanggil id widget
        etPensil = (EditText)findViewById(R.id.etPensil);
        etPena = (EditText)findViewById(R.id.etPena);
        etBuku = (EditText)findViewById(R.id.etBuku);
        btnHitung = (Button)findViewById(R.id.btnHitung);
        lblTotal = (TextView)findViewById(R.id.lblTotal);

        //aksi ketika button di klik
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mengambil nilai dari widget editText dan memasukkan ke nilai string
                String nPensil = etPensil.getText().toString();
                String nPena = etPena.getText().toString();
                String nBuku = etBuku.getText().toString();

                //mengecek apakah editText kosong
                //kondisi ketika panjangnya kosong
                if(nPensil.isEmpty()){
                    //memberi warning berupa error
                    etPensil.setError("Nilai Tidak Boleh Kosong");
                }else if (nPena.isEmpty()){
                    etPena.setError("Nilai tidak boleh kosong");
                }else if (nBuku.isEmpty()){
                    etBuku.setError("Nilai tidak boleh kosong");
                }else{
                    //mengubah nilai dari string k integer
                    int aPensil = Integer.parseInt(nPensil);
                    int aPena = Integer.parseInt(nPena);
                    int aBuku = Integer.parseInt(nBuku);

                    int hasilTotal = (aBuku * 7000) + (aPena * 3500) + (aPensil * 2500);

                    //menampilkan hasil hitung ke widget textView
                    lblTotal.setText("Total Belanjaan = Rp" + hasilTotal);
                }
            }
        });
    }
}
