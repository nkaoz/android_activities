package com.npjruiz.neil.app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.TextView;
import android.view.View;

public class DetalleContacto extends AppCompatActivity {

    private TextView TvNombre;
    private TextView TvTelefono;
    private TextView TvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();

        String pnombres = parametros.getString(getResources().getString(R.string.pnombre));
        String ptelefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String pemail = parametros.getString(getResources().getString(R.string.pemail));

        TvNombre = (TextView) findViewById(R.id.tvNombre);
        TvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TvEmail = (TextView) findViewById(R.id.tvEmail);

        TvNombre.setText(pnombres);
        TvTelefono.setText(ptelefono);
        TvEmail.setText(pemail);

    }

    public void llamar(View v) {

        String telefono = TvTelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }


    public void enviarMail(View v){
        String email = TvEmail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,email);
        //emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
