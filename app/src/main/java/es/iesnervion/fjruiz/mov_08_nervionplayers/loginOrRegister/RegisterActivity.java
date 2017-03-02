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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

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
    @BindView(R.id.ibFoto)ImageButton foto;
    @BindView(R.id.lblFoto) TextView lblFoto;
    @BindView(R.id.lblAlias) TextView lblAlias;
    @BindView(R.id.lblPass) TextView lblPass;
    @BindView(R.id.lblPass2) TextView lblPass2;
    @BindView(R.id.lblNombre) TextView lblNombre;
    @BindView(R.id.lblApellidos) TextView lblApellidos;
    @BindView(R.id.lblCorreo) TextView lblCorreo;
    @BindView(R.id.lblCurso) TextView lblCurso;
    @BindView(R.id.lblLetra) TextView lblLetra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("badseed.ttf")
                .build());
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
                // Log.d(TAG, String.valueOf(bitmap));

                foto.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
