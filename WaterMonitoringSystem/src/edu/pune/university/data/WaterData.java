package edu.pune.university.data;

import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;

public class WaterData extends Document {

	private static final long serialVersionUID = 1L;

	private String location = "location";
	private String latitude = "latitude";
	private String longitude = "longitude";
	private String records = "records";

	public String getLocation() {
		return (String) this.get(this.location);
	}

	public void setLocation(String location) {
		this.append(this.location, location);
	}

	public double getLatitude() {
		return (double) this.get(this.latitude);
	}

	public void setLatitude(double latitude) {
		this.append(this.latitude, latitude);
	}

	public double getLongitude() {
		return (double) this.get(this.longitude);
	}

	public void setLongitude(double longitude) {
		this.append(this.longitude, longitude);
	}

	@SuppressWarnings("unchecked")
	public List<Record> getRecords() {
		return (new Gson()).fromJson(this.get(this.records).toString(), List.class);
	}

	public void setRecords(List<Record> records) {
		this.append(this.records, (new Gson()).toJson(records));
	}
	
	
}
