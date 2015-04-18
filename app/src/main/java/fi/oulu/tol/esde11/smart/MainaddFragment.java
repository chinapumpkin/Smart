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
public class MainaddFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View thisFragment = inflater.inflate(R.layout.fragment_main_add, container, false);
        return thisFragment;


    }
}
