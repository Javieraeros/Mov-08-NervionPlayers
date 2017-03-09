package es.iesnervion.fjruiz.mov_08_nervionplayers.principal.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import es.iesnervion.fjruiz.mov_08_nervionplayers.R;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Encuentro;


/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link //OnListFragmentInteractionListener}
 * interface.
 */
public class EncuentrosFragment extends ListFragment {

    private Runnable miFuncion;
    private ArrayList<Encuentro> encuentros;
    private Encuentro[] arrayEncuentros;
    public static final String CADENA_FUNCION="mifuncioncita";
    public static final String CADENA_ENCUENTROS="misencuentros";
    //private OnListFragmentInteractionListener mListener;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EncuentrosFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            miFuncion = getArguments().getParcelable(CADENA_FUNCION);
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
        /*if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }*/


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        try {
            miFuncion.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
