package fi.oulu.tol.esde11.smart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by dengcanrong on 15/4/16.
 */
public class Setupfragment extends Fragment  {
    private GoogleMap googleMap;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View thisFragment = inflater.inflate(R.layout.fragment_setup, container, false);
        setUpMapIfNeed();
        return thisFragment;
    }


    private void setUpMapIfNeed() {

        if (googleMap == null) {
            FragmentManager fmanager = getChildFragmentManager();
            Fragment fragment = fmanager.findFragmentById(R.id.map);
            SupportMapFragment supportmapfragment = (SupportMapFragment) fragment;
            googleMap = supportmapfragment.getMap();

            if (googleMap != null) {
                setUpMap();

            }
        }
    }

    protected void setUpMap() {
        googleMap.setMyLocationEnabled(false);
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

    }


}
