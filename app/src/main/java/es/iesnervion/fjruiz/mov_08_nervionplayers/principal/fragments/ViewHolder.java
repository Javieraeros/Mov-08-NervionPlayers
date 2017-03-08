package es.iesnervion.fjruiz.mov_08_nervionplayers.principal.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import es.iesnervion.fjruiz.mov_08_nervionplayers.R;

/**
 * Created by javi on 8/03/17.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    private final View mView;
    private final TextView mIdView;
    private final TextView mContentView;
    private DummyContent.DummyItem mItem;

    public ViewHolder(View view) {
        super(view);
        mView = view;
        mIdView = (TextView) view.findViewById(R.id.id);
        mContentView = (TextView) view.findViewById(R.id.content);
    }

    @Override
    public String toString() {
        return super.toString() + " '" + mContentView.getText() + "'";
    }
}
