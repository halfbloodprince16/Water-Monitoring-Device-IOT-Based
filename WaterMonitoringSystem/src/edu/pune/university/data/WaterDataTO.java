package edu.pune.university.data;

import java.util.List;

/**
 * {@link WaterDataTO} is transfer object for {@link WaterData}. The
 * {@link WaterData} information will be converted to {@link WaterDataTO} before
 * sending to user.
 * 
 * @author <a href="mailto:mayap282@gmail.com">Maya Pilania</a>
 */
public class WaterDataTO {

	private String location;
	private double latitude;
	private double longitude;
	private List<Record> records;

	/**
	 * Get {@link WaterDataTO} using {@link WaterData}.
	 * @param waterData {@link WaterData}
	 */
	public WaterDataTO(WaterData waterData) {
		this.location = waterData.getLocation();
		this.latitude = waterData.getLatitude();
		this.longitude = waterData.getLongitude();
		this.records = waterData.getRecords();
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}


	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}


	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	/**
	 * @return the records
	 */
	public List<Record> getRecords() {
		return records;
	}


	/**
	 * @param records the records to set
	 */
	public void setRecords(List<Record> records) {
		this.records = records;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WaterDataTO other = (WaterDataTO) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WaterDataTO [location=" + location + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", records=" + records + "]";
	}

}
