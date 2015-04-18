package fi.oulu.tol.esde11.smart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dengcanrong on 15/4/15.
 */
public class MainFragment extends Fragment {

    public ListView listView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View thisFragment = inflater.inflate(R.layout.fragment_main, container, false);

        listView = (ListView) thisFragment.findViewById(R.id.list_view_main);
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), getData(), R.layout.list_item_main, new String[]{"img", "title", "info"}, new int[]{R.id.imageView, R.id.title, R.id.info});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment objfragment = null;
                FragmentTransaction fragmentManager = getFragmentManager().beginTransaction();
                switch (position) {
                    case 0:

                        objfragment = new MainhomeFragment();

                        break;
                    case 1:
                        objfragment = new MainmodeFragment();
                        break;
                    case 2:
                        objfragment = new MainlightsFragment();
                        break;
                    case 3:
                        objfragment=new MaindoorFragment();
                        break;
                    case 4:
                        objfragment=new MainaddFragment();

                }
                Toast.makeText(getActivity(), "selected Item Name is " + position, Toast.LENGTH_LONG).show();
                // update the main content by replacing fragments

                fragmentManager.replace(R.id.container, objfragment);
                fragmentManager.addToBackStack(null);
                fragmentManager.commit();
            }
        });


        return thisFragment;
    }

    private ArrayList<HashMap<String, Object>> getData() {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> tempHashMap = new HashMap<String, Object>();
        tempHashMap.put("img", R.drawable.camera);
        tempHashMap.put("title", "Home");
        tempHashMap.put("info", "default");
        arrayList.add(tempHashMap);



        tempHashMap = new HashMap<>();
        tempHashMap.put("img", R.drawable.transition);
        tempHashMap.put("title", "Mode Transition");
        tempHashMap.put("info", "default");
        arrayList.add(tempHashMap);


        tempHashMap = new HashMap<>();
        tempHashMap.put("img", R.drawable.lights);
        tempHashMap.put("title", "Light&Switcher");
        tempHashMap.put("info", "default");
        arrayList.add(tempHashMap);

        tempHashMap = new HashMap<>();
        tempHashMap.put("img", R.drawable.lock);
        tempHashMap.put("title", "Door&Lock");
        tempHashMap.put("info", "default");
        arrayList.add(tempHashMap);

        tempHashMap = new HashMap<>();
        tempHashMap.put("img", R.drawable.add);
        tempHashMap.put("title", "Add Device");
        tempHashMap.put("info", "default");
        arrayList.add(tempHashMap);
        return arrayList;

    }


}
