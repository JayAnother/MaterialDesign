package org.jay.materialdesign.contraintlayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jay.materialdesign.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConstraintFragment extends Fragment {


    public ConstraintFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_constraint, container, false);
    }

}
