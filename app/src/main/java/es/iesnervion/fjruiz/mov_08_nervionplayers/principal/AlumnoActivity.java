package es.iesnervion.fjruiz.mov_08_nervionplayers.principal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.iesnervion.fjruiz.mov_08_nervionplayers.R;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Duelo;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Encuentro;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Partido;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.submodel.DueloNombre;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.submodel.PartidoNombre;
import es.iesnervion.fjruiz.mov_08_nervionplayers.principal.fragments.EncuentrosFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
//TODO

/**
 * Intentar usar expresiones lambda para pasarle por parametros a cada uno de los fragments
 * lo que queremos que pase cuando algo pasa en los fragments
 */
public class AlumnoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    static Context miContexto;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        miContexto=this;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.alumno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_partidos:
                Method method=null;
                try {
                    method= getClass().getDeclaredMethod("prueba", null);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                /*EncuentrosFragment encuentrosFragment = new EncuentrosFragment(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(AlumnoActivity.this, "Funciona!!!", Toast.LENGTH_SHORT).show();
                    }
                });*/

                //Paso el método por el constructor porque la clase Method no es parcelable ni serializable
                //Y eso me impide que lo ponga en el Bundle.
                //FIXME crear clase que herede de Method e implemente parcelable
                EncuentrosFragment encuentrosFragment = new EncuentrosFragment(method);
                Bundle datos=new Bundle();
                //TODO recuperar de servidor
                ArrayList<Encuentro> encuentros=generaEncuentros();
                datos.putParcelableArrayList(EncuentrosFragment.CADENA_ENCUENTROS,encuentros);
                encuentrosFragment.setArguments(datos);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.content_alumno, encuentrosFragment);
                transaction.addToBackStack(null);


                // Commit the transaction
                transaction.commit();
                break;
            case R.id.nav_aniadir:
                Toast.makeText(this, "En construcción", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_Grupos:
                Toast.makeText(this, "En construcción", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_partidos_jugados:
                Toast.makeText(this, "En construcción", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_user:
                Toast.makeText(this, "En construcción", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_exit:
                Toast.makeText(this, "En construcción", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return  true;
    }

    private ArrayList<Encuentro> generaEncuentros() {
        ArrayList<Encuentro> encuentro=new ArrayList<>();
        Partido partido=new Partido();
        partido.setId_Local(1);
        partido.setId_Visitante(2);
        Duelo duelo1=new Duelo();
        duelo1.setId_Local(4);
        duelo1.setId_Visitante(5);
        Duelo duelo2=new Duelo();
        duelo2.setId_Local(40);
        duelo2.setId_Visitante(50);

        PartidoNombre pn=new PartidoNombre(partido,"Caraescombros","Los Machacaos","Futbol");
        DueloNombre dn=new DueloNombre(duelo1,"Asun","Fernando","Programación");
        DueloNombre dn2=new DueloNombre(duelo2,"Miguel Angel","Leo","Java");


        encuentro.add(pn);
        encuentro.add(dn);
        encuentro.add(dn2);
        return encuentro;
    }
    public static void prueba(){
        Toast.makeText(miContexto, "Prueba función por parametros", Toast.LENGTH_SHORT).show();
    }
}
