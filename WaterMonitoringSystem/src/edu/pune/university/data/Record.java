package edu.pune.university.data;

public class Record {
	
	private String time;
	private int pH;
	private float temprature;
	
	public Record(String time, int pH, float temprature) {
		this.setTime(time);
		this.setpH(pH);
		this.setTemprature(temprature);
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getpH() {
		return pH;
	}

	public void setpH(int pH) {
		this.pH = pH;
	}

	public float getTemprature() {
		return temprature;
	}

	public void setTemprature(float temprature) {
		this.temprature = temprature;
	}

	@Override
	public String toString() {
		return "Record [time=" + time + ", pH=" + pH + ", temprature=" + temprature + "]";
	}
}
