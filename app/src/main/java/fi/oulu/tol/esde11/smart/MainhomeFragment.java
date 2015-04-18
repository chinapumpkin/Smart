package fi.oulu.tol.esde11.smart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by dengcanrong on 15/4/18.
 */
public class MainhomeFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View thisFragment = inflater.inflate(R.layout.fragment_main_home, container, false);
        return thisFragment;
    }
}
