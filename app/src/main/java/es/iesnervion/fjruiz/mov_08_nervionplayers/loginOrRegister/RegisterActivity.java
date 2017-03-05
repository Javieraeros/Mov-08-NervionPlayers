package es.iesnervion.fjruiz.mov_08_nervionplayers.loginOrRegister;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import es.iesnervion.fjruiz.mov_08_nervionplayers.R;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Letra máximo 10 caracteres
 *
 */
public class RegisterActivity extends AppCompatActivity{
    private final int PICK_IMAGE_REQUEST=16541;
    private String[] cadenasSpinner={"1º ESO","2º ESO","3º ESO","4º ESO",
            "1º Bach","2º Bach","1º Ciclo","2º Ciclo"};

    @BindView(R.id.ibFoto)ImageButton foto;
    @BindView(R.id.spnCurso) Spinner spnCurso;
    @BindView(R.id.txtAlias) EditText txtAlias;
    @BindView(R.id.txtPass) EditText txtPass;
    @BindView(R.id.txtPass2) EditText txtPass2;
    @BindView(R.id.txtnombre) EditText txtNombre;
    @BindView(R.id.txtApellidos) EditText txtApellidos;
    @BindView(R.id.txtCorreo) EditText txtCorreo;
    @BindView(R.id.txtLetra) EditText txtLetra;
    private String mAlias,mPass,mPass2,mNombre,mApellidos,mCorreo,mLetra;
    private int mCurso;
    private boolean cursoSeleccionado,fotoSeleccionada,alumnoValido;
    private byte[] imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        cursoSeleccionado=false;
        fotoSeleccionada=false;
        spnCurso.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,cadenasSpinner));

    }

    /**
     * Para cambiar la fuente
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @OnClick(R.id.ibFoto)
    public void onClick(View v) {
        //Toast.makeText(getApplicationContext(),"image clicked",Toast.LENGTH_SHORT).show();

        //Imagen galería
        /*Intent intent = new Intent();
        // Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        // Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);*/

        //Foto
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, PICK_IMAGE_REQUEST);
    }

    //FIXME
    @OnItemSelected(R.id.spnCurso)
    public void onItemSelected(AdapterView<?> parent, View v, int position,long id){
        cursoSeleccionado=true;
        //La posición del spinner empieza en 0, mientras que en la BBDD los cursos empiezan en 1
        mCurso=position+1;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //foto
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK ) {
            //&& data != null && data.getData() != null
            //Uri uri = data.getData();

            Bitmap bitmap = null;
            //try {
                //bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                bitmap = (Bitmap) data.getExtras().get("data");
                foto.setImageBitmap(bitmap);
                fotoSeleccionada=true;
                int size = bitmap.getRowBytes() * bitmap.getHeight();
                ByteBuffer byteBuffer = ByteBuffer.allocate(size);
                bitmap.copyPixelsToBuffer(byteBuffer);
                imagen = byteBuffer.array();
            /*} catch (IOException e) {
                e.printStackTrace();
            }*/
        }

        //Imagen galería
        /*if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();

            Bitmap bitmap = null;
            try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            foto.setImageBitmap(bitmap);
            fotoSeleccionada=true;
            int size = bitmap.getRowBytes() * bitmap.getHeight();
            ByteBuffer byteBuffer = ByteBuffer.allocate(size);
            bitmap.copyPixelsToBuffer(byteBuffer);
            imagen = byteBuffer.array();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }

    @OnClick(R.id.btnAceptar)
    public void onClick(){
        resuelveEditText();
        alumnoValido=true;
        if(mNombre.length()<1 ||mNombre.length()>=30){
            Toast.makeText(this, "El nombre debe contener entre 1 y 30 caracteres", Toast.LENGTH_SHORT).show();
            alumnoValido=false;
        }
        if(mApellidos.length()<1 || mApellidos.length()>=50){
            Toast.makeText(this, "Los apellidos deben contener entre 1 y 50 caracteres", Toast.LENGTH_SHORT).show();
            alumnoValido=false;
        }
        if(!compruebaPass(mPass,mPass2)){
            Toast.makeText(this, "La contraseña no es válida", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Debe contener un número, un caracter especial y otro en mayúsculas", Toast.LENGTH_SHORT).show();
            alumnoValido=false;
        }
        if(!compruebaCorreo(mCorreo)){
            Toast.makeText(this, "El correo debe ser válido", Toast.LENGTH_SHORT).show();
            alumnoValido=false;
        }
        if(mLetra.length()>10){
            Toast.makeText(this, "La letra debe ser menor de 10 caracteres", Toast.LENGTH_SHORT).show();
            alumnoValido=false;
        }
        if(!cursoSeleccionado){
            Toast.makeText(this, "Debe seleccionar un curso", Toast.LENGTH_SHORT).show();
            alumnoValido=false;
        }
        if(!fotoSeleccionada){
            Toast.makeText(this, "Debe seleccionar una imagen", Toast.LENGTH_SHORT).show();
            alumnoValido=false;
        }
        if(alumnoValido){
            Alumno miAlumno=new Alumno(0,mNombre,mApellidos,mPass,mAlias,
                    mCorreo,null,(byte) mCurso,mLetra,null,false,imagen);
            Intent returnIntent = new Intent();
            returnIntent.putExtra(LoginActivity.bundle_Alumno, (Parcelable) miAlumno);
            setResult(2,returnIntent);
            //FixMe Cuando le doy a aceptar no ahce nada
            /*
            Esto se debe a que creo un intent para recoger la foto, y creo que eso es lo que hace
            que falle.
             */
            finish();
        }
    }

    /**
     * Método que recoge todo lo que haya en los editText y guarda su valor
     * en al cadena correspondiente
     */
    private void resuelveEditText() {
        mAlias=txtAlias.getText().toString();
        mPass=txtPass.getText().toString();
        mPass2=txtPass2.getText().toString();
        mNombre=txtNombre.getText().toString();
        mApellidos=txtApellidos.getText().toString();
        mCorreo=txtCorreo.getText().toString();
        mLetra=txtLetra.getText().toString();
    }

    private boolean compruebaPass(String pass,String pass2){
        boolean isValid = false;
        boolean isSpecialChar = Pattern.compile("[^a-zA-Z0-9]").matcher(pass).find();
        boolean isUpper = Pattern.compile("[A-Z]").matcher(pass).find();
        boolean isDigit = Pattern.compile("[0-9]").matcher(pass).find();
        if (pass.length() < 255 && isUpper && isDigit && isSpecialChar && pass.equals(pass2))
        {
            isValid = true;
        }

        return isValid;
    }

    private boolean compruebaCorreo(String correo){
        return Pattern.matches(".+@.+\\..+",correo);
    }
}
