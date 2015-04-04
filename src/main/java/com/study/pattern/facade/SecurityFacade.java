package com.study.pattern.facade;

public class SecurityFacade {

	 private Camera camera1, camera2;
	 private Light light1, light2, light3;
	 private Sensor sensor;
	 private Alarm alarm;
	 
	 public void activete(){
		  camera1.turnon();
		  camera2.turnon();
		  light1.turnon();
		  light2.turnon();
		  light3.turnon();
		  sensor.turnon();
		  alarm.activate();
	 }	 
	 public void deactivate(){
		  camera1.turnoff();
		  camera2.turnoff();
		  light1.turnoff();
		  light2.turnoff();
		  light3.turnoff();
		  sensor.turnoff();
		  alarm.deactivate();
	 }	 
}
