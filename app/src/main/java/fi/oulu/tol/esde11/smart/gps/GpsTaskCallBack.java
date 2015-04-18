package fi.oulu.tol.esde11.smart.gps;

import fi.oulu.tol.esde11.smart.gps.GpsTask.GpsData;

public interface GpsTaskCallBack {

	public void gpsConnected(GpsData gpsdata);
	
	public void gpsConnectedTimeOut();
	
}
