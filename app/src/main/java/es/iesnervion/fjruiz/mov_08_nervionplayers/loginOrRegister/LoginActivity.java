package es.iesnervion.fjruiz.mov_08_nervionplayers.loginOrRegister;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import es.iesnervion.fjruiz.mov_08_nervionplayers.R;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import es.iesnervion.fjruiz.mov_08_nervionplayers.notifications.MyFirebaseMessagingService;
import es.iesnervion.fjruiz.mov_08_nervionplayers.principal.AlumnoActivity;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.comunicatorInterfaces.ICAlumno;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.comunicatorInterfaces.ICToken;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.MiRetrofit;
import es.iesnervion.fjruiz.mov_08_nervionplayers.utilidades.AuthUtilities;
import es.iesnervion.fjruiz.mov_08_nervionplayers.utilidades.FilesUtilities;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * A login screen that offers login via email/password.
 */
//TODO eliminar todo lo que tenga que ver con authorization si no está implementada en la API
public class LoginActivity extends AppCompatActivity
        implements ICToken, TextView.OnEditorActionListener,ICAlumno {

    private boolean isThreadRunning=false;
    static final int REGISTER_REQUEST =24;
    static final String bundle_Alumno="RegistroAlumno";

    //No pongo private para que se puedan acceder desde otras clases de este package
    @BindView(R.id.email_nick) AutoCompleteTextView mEmailNick;
    @BindView(R.id.password) EditText mPasswordView;
    @BindView(R.id.login_progress) View mProgressView;
    @BindView(R.id.login_form) View mLoginFormView;
    @BindView(R.id.sign_in_button) Button mEmailSignInButton;
    @BindView(R.id.register_button) Button mRegisterButton;
    private AuthUtilities authUtilities;
    private MiRetrofit mr;
    private String email;
    private String password;
    private FilesUtilities miGuardador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        Necesario poner antes del onCreate para que la primera vez que se inicia la aplicación
        se cargue bien la fuente
         */
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("badseed.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        startService(new Intent(this, MyFirebaseMessagingService.class));
        //startService(new Intent(this, GetToken.class));

        ButterKnife.bind(this);

        authUtilities=new AuthUtilities();
        miGuardador=new FilesUtilities(this);
        //populateAutoComplete();

        //Toast.makeText(this,miGuardador.loadAtuhorization(),Toast.LENGTH_SHORT).show();

        if(miGuardador.loadAtuhorization()!=null){
            iniciaAlumnoActivity();
        }
    }

    /**
     * Necesario para Calligraphy
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void iniciaAlumnoActivity(){
        Intent alumnoActivity=new Intent(this,AlumnoActivity.class);
        startActivity(alumnoActivity);
    }

    /**
     * Called when an action is being performed.
     *
     * @param v        The view that was clicked.
     * @param actionId Identifier of the action.  This will be either the
     *                 identifier you supplied, or {@link EditorInfo#IME_NULL
     *                 EditorInfo.IME_NULL} if being called due to the enter key
     *                 being pressed.
     * @param event    If triggered by an enter key, this is the event;
     *                 otherwise, this is null.
     * @return Return true if you have consumed the action, else false.
     */
    @OnEditorAction(R.id.password)
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        boolean devolver=false;
        if (actionId == R.id.password || actionId == EditorInfo.IME_ACTION_DONE) {
            loggear(v);
            devolver= true;
        }
        return devolver;
    }

    @OnClick(R.id.register_button)
    public void register(View v){
        //TODO mirar examen
        Intent registrar=new Intent(this,RegisterActivity.class);
        startActivityForResult(registrar, REGISTER_REQUEST);
    }

    /**
     * Attempts to sign in .
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    @OnClick(R.id.sign_in_button)
    public void loggear(View v) {
        if (!isThreadRunning) {
            // Reset errors.
            mEmailNick.setError(null);
            mPasswordView.setError(null);

            // Store values at the time of the login attempt.
            email = mEmailNick.getText().toString();
            password = mPasswordView.getText().toString();

            boolean cancel = false;
            View focusView = null;

            // Check for a valid password, if the user entered one.
            if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
                mPasswordView.setError(getString(R.string.error_invalid_password));
                focusView = mPasswordView;
                cancel = true;
            }

            // Check for a valid email address.
            if (TextUtils.isEmpty(email)) {
                mEmailNick.setError(getString(R.string.error_field_required));
                focusView = mEmailNick;
                cancel = true;
            }

            if (cancel) {
                // There was an error; don't attempt login and focus the first
                // form field with an error.
                focusView.requestFocus();
            } else {
                // Show a progress spinner, and kick off a background task to
                // perform the user login attempt.
                showProgress(true);
                isThreadRunning=true;

                String basicAuth=authUtilities.creaBasicAuth(email,password);

                //TODO cambiar
                /*mr=new MiRetrofit(this);
                mr.getToken(basicAuth);*/
                showProgress(false);
                isThreadRunning=false;
                iniciaAlumnoActivity();
            }
        }
    }
    @Override
    public void onBackPressed(){
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        switch (requestCode){
            case REGISTER_REQUEST:
                if(resultCode==2){
                    showProgress(true);
                    isThreadRunning=true;
                    Alumno alumnoRegistrar=data.getParcelableExtra(bundle_Alumno);
                    //TODO PostAlumno
                    Toast.makeText(this, "El Alumno ha llegado "+alumnoRegistrar.getNombre(), Toast.LENGTH_SHORT).show();
                    //mr.postAlumno(alumnoRegistrar);
                }
                break;
        }
    }
    //region Respuestas Retrofit
    @Override
    public void getTokenAceptado(Response<Alumno> response) {
        isThreadRunning=false;
        String auth=response.headers().get("Authorization");
        miGuardador.saveAuthorization(auth);

        Alumno miAlumno=response.body();
        miGuardador.saveAlumno(miAlumno);
        iniciaAlumnoActivity();
    }

    @Override
    public void getTokenRechazado(){
        showProgress(false);
        isThreadRunning=false;
        Toast.makeText(this,"Error, el nombre o contraseña son incorrectos",Toast.LENGTH_LONG).show();
    }
    @Override
    public void postAlumnoAceptado(Response<Alumno> response) {
        isThreadRunning=false;
        String auth=response.headers().get("Authorization");
        miGuardador.saveAuthorization(auth);

        Alumno miAlumno=response.body();
        miGuardador.saveAlumno(miAlumno);
        showProgress(false);
        iniciaAlumnoActivity();
    }

    @Override
    public void postAlumnoRechazado() {
        isThreadRunning=false;
        showProgress(false);
        Toast.makeText(this, "Algo ha fallado, vuelve a intentarlo", Toast.LENGTH_SHORT).show();
    }

    //endregion
    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /*
    Ya no es necesario puesto que la API nos devuelve el alumno en el cuerpo
    @Override
    public void getAlumnoAceptado(Response<Alumno> response) {
        miGuardador.saveAuthorization(response.headers().get("Authorization"));
        showProgress(false);
        isThreadRunning=false;
        Alumno miAlumno=response.body();
        miGuardador.saveAlumno(miAlumno);

    }

    @Override
    public void getAlumnoRechazado() {
        Toast.makeText(this, "Ha ocurrido un error, lo sentimos", Toast.LENGTH_SHORT).show();
    }
    */
    //endregion


    //region Autocompletar email
    /*


    private void populateAutoComplete() {
        if (!mayRequestContacts()) {
            return;
        }

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(LoginActivity.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mEmailNick.setAdapter(adapter);
    }


    private boolean mayRequestContacts() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
            Snackbar.make(mEmailNick, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
                        }
                    });
        } else {
            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
        }
        return false;
    }

    //Callback received when a permissions request has been completed.

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_READ_CONTACTS) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                populateAutoComplete();
            }
        }
    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }*/

    //endregion
}

