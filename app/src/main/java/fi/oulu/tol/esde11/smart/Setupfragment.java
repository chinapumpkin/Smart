package fi.oulu.tol.esde11.smart;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fi.oulu.tol.esde11.smart.gps.GpsTask;
import fi.oulu.tol.esde11.smart.gps.GpsTaskCallBack;
import fi.oulu.tol.esde11.smart.gps.IAddressTask;

/**
 * Created by dengcanrong on 15/4/16.
 */
public class Setupfragment extends Fragment implements View.OnClickListener{
    private TextView gps_tip = null;
    private AlertDialog dialog = null;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View thisFragment = inflater.inflate(R.layout.fragment_setup, container, false);
        gps_tip = (TextView)thisFragment.findViewById(R.id.gps_tip);
        thisFragment.findViewById(R.id.do_gps).setOnClickListener(this);
        thisFragment.findViewById(R.id.do_apn).setOnClickListener(this);
        thisFragment.findViewById(R.id.do_wifi).setOnClickListener(this);

        dialog = new ProgressDialog(getActivity());
        dialog.setTitle("请稍等...");
        dialog.setMessage("正在定位...");


        
        return thisFragment;
    }
    public void onClick(View v) {
        gps_tip.setText("");
        switch (v.getId()) {
            case R.id.do_apn:
                do_apn();
                break;
            case R.id.do_gps:
                GpsTask gpstask = new GpsTask(getActivity(),
                        new GpsTaskCallBack() {

                            @Override
                            public void gpsConnectedTimeOut() {
                                gps_tip.setText("获取GPS超时了");
                            }

                            @Override
                            public void gpsConnected(GpsTask.GpsData gpsdata) {
                                do_gps(gpsdata);
                            }

                        }, 30 * 1000);
                gpstask.execute();
                break;
            case R.id.do_wifi:
                do_wifi();
                break;
        }
    }

    private void do_apn() {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                IAddressTask.MLocation location = null;
                try {
                    location = new AddressTask(getActivity(),
                            AddressTask.DO_APN).doApnPost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(location == null)
                    return null;
                return location.toString();
            }

            @Override
            protected void onPreExecute() {
                dialog.show();
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String result) {
                if(result == null){
                    gps_tip.setText("基站定位失败了...");
                }else {
                    gps_tip.setText(result);
                }
                dialog.dismiss();
                super.onPostExecute(result);
            }

        }.execute();
    }

    private void do_gps(final GpsTask.GpsData gpsdata) {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                IAddressTask.MLocation location = null;
                try {
                    Log.i("do_gpspost", "经纬度：" + gpsdata.getLatitude() + "----" + gpsdata.getLongitude());
                    location = new AddressTask(getActivity(),
                            AddressTask.DO_GPS).doGpsPost(gpsdata.getLatitude(),
                            gpsdata.getLongitude());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(location == null)
                    return "GPS信息获取错误";
                return location.toString();
            }

            @Override
            protected void onPreExecute() {
                dialog.show();
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String result) {
                gps_tip.setText(result);
                dialog.dismiss();
                super.onPostExecute(result);
            }

        }.execute();
    }

    private void do_wifi() {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                IAddressTask.MLocation location = null;
                try {
                    location = new AddressTask(getActivity(),
                            AddressTask.DO_WIFI).doWifiPost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(location == null)
                    return null;
                return location.toString();
            }

            @Override
            protected void onPreExecute() {
                dialog.show();
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String result) {
                if(result != null){
                    gps_tip.setText(result);
                }else {
                    gps_tip.setText("WIFI定位失败了...");
                }

                dialog.dismiss();
                super.onPostExecute(result);
            }

        }.execute();
    }
}
