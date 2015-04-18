package fi.oulu.tol.esde11.smart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by dengcanrong on 15/4/18.
 */
public class MaindoorFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View thisFragment = inflater.inflate(R.layout.fragment_main_door, container, false);
        return thisFragment;


    }


}
