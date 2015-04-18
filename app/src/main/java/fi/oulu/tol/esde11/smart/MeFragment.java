package fi.oulu.tol.esde11.smart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dengcanrong on 15/4/16.
 */
public class MeFragment extends Fragment {
    public GridView gridView;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View thisFragment = inflater.inflate(R.layout.fragment_me, container, false);
        gridView=(GridView)thisFragment.findViewById(R.id.gridView);
        SimpleAdapter adapter=new SimpleAdapter(getActivity(), getData(), R.layout.grid_item_me, new String[]{"img", "title"}, new int[]{R.id.me_grid_img, R.id.me_grid_text});
        gridView.setAdapter(adapter);
        return thisFragment;
    }
    private ArrayList<HashMap<String, Object>> getData() {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> tempHashMap = new HashMap<String, Object>();


        tempHashMap.put("img", R.drawable.family_icon2);
        tempHashMap.put("title", "Son");
        arrayList.add(tempHashMap);

        tempHashMap = new HashMap<>();
        tempHashMap.put("img", R.drawable.family_icon3);
        tempHashMap.put("title", "Daughter");
        arrayList.add(tempHashMap);

        tempHashMap = new HashMap<>();
        tempHashMap.put("img", R.drawable.family_icon4);
        tempHashMap.put("title", "Wife");
        arrayList.add(tempHashMap);



        return arrayList;

    }
}
