package dessert.foodie.miracles.com.foodiedessert.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dessert.foodie.miracles.com.foodiedessert.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {


    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_, container, false);
        return view;
    }

}
