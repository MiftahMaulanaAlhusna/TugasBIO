package com.example.belanja.tugasbio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mLocationTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationTextView=findViewById(R.id.maps);
    }

    public void email(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(    "mailto", "miftahmaulana89@gmail.com", null));

        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject");

        emailIntent.putExtra(Intent.EXTRA_TEXT, "Isi Email");

        startActivity(Intent.createChooser(emailIntent, "Feedback"));
    }

    public void telepon(View view) {
        String nomor = "0812 2542 9767" ;
        Intent panggil = new Intent(Intent. ACTION_DIAL);
        panggil.setData(Uri. fromParts("tel",nomor,null));
        startActivity(panggil);
    }

    public void map(View view) {
        String loc = mLocationTextView.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }

    }

}
