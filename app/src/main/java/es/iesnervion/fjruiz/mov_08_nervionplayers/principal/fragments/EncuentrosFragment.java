package es.iesnervion.fjruiz.mov_08_nervionplayers.principal.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

import es.iesnervion.fjruiz.mov_08_nervionplayers.R;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Encuentro;
import es.iesnervion.fjruiz.mov_08_nervionplayers.principal.AlumnoActivity;


/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link //OnListFragmentInteractionListener}
 * interface.
 */
public class EncuentrosFragment extends ListFragment {

    private Method miFuncion;
    private ArrayList<Encuentro> encuentros;
    private Encuentro[] arrayEncuentros;
    public static final String CADENA_FUNCION="mifuncioncita";
    public static final String CADENA_ENCUENTROS="misencuentros";
    //private OnListFragmentInteractionListener mListener;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EncuentrosFragment(Method miFuncion) {
        this.miFuncion=miFuncion;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            //miFuncion = getArguments().getParcelable(CADENA_FUNCION);
            encuentros=getArguments().getParcelableArrayList(CADENA_ENCUENTROS);
            arrayEncuentros=new Encuentro[encuentros.size()];
            encuentros.toArray(arrayEncuentros);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_encuentros_list, container, false);

        // Set the adapter

        ViewAdapter miVA=new ViewAdapter(getContext(),R.layout.row,R.id.equipo1,arrayEncuentros);
        setListAdapter(miVA);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        try {
            //Pongo null porque la función a la que llamo es estática, en caso de que no lo sea
            //debo hacerlo sobre un objeto válido de la clase
            miFuncion.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
