package es.iesnervion.fjruiz.mov_08_nervionplayers.loginOrRegister;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.StringReader;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import es.iesnervion.fjruiz.mov_08_nervionplayers.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RegisterActivity extends AppCompatActivity{
    private final int registerCode=0;
    private final int PICK_IMAGE_REQUEST=1;
    private String[] cadenasSpinner={"1º ESO","2º ESO","3º ESO","4º ESO","1º Bach","2º Bach","1º Ciclo","2º Ciclo"};
    @BindView(R.id.ibFoto)ImageButton foto;
    @BindView(R.id.txtAlias) EditText txtAlias;
    @BindView(R.id.txtPass) EditText txtPass;
    @BindView(R.id.txtPass2) EditText txtPass2;
    @BindView(R.id.txtnombre) EditText txtNombre;
    @BindView(R.id.txtApellidos) EditText txtApellidos;
    @BindView(R.id.txtCorreo) EditText txtCorreo;
    @BindView(R.id.spnCurso) Spinner spnCurso;
    @BindView(R.id.txtLetra) EditText txtLetra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        spnCurso.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,cadenasSpinner));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @OnClick(R.id.ibFoto)
    public void onClick(View v) {
        //Toast.makeText(getApplicationContext(),"image clicked",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        // Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        // Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                foto.setImageBitmap(bitmap);
                int size     = bitmap.getRowBytes() * bitmap.getHeight();
                ByteBuffer b = ByteBuffer.allocate(size);

                bitmap.copyPixelsToBuffer(b);

                byte[] bytes = new byte[size];

                try {
                    b.get(bytes, 0, bytes.length);
                } catch (BufferUnderflowException e) {
                    // always happens
                }
                // do something with byte[]
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
