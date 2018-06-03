package edu.pune.university.dao;

import java.util.ArrayList;
import java.util.List;

import edu.pune.university.data.Record;
import edu.pune.university.data.WaterData;
import edu.pune.university.data.WaterDataTO;
import edu.pune.university.exception.ApplicationException;
import junit.framework.TestCase;

public class WaterDataDaoTest extends TestCase {
	WaterDataDao waterDataDao = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		waterDataDao = new WaterDataDao();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreateWaterDataTest() {
		WaterData waterData = new WaterData();
		waterData.setLocation("Upper Lake, Bopkhel, Pimpri-Chinchwad, Maharashtra");
		waterData.setLatitude(18.603389);
		waterData.setLongitude(73.841207);
		
		List<Record> records = new ArrayList<Record>();
		
		Record record1 = new Record("01-January-2018", 6, 20.40F);
		records.add(record1);
		
		record1 = new Record("01-Febuary-2018", 7, 22.70F);
		records.add(record1);
		
		record1 = new Record("01-March-2018", 7, 24.30F);
		records.add(record1);
		
		record1 = new Record("01-April-2018", 7, 28.20F);
		records.add(record1);
		
		record1 = new Record("01-May-2018", 8, 33.60F);
		records.add(record1);
		
		record1 = new Record("01-June-2018", 9, 35.80F);
		records.add(record1);
		
		waterData.setRecords(records);
		
		try {
			waterDataDao.createWaterData(waterData);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

	public void testGetAllWaterData () {
		try {
			List<WaterData> allWaterData = waterDataDao.getAllWaterData();
			for (WaterData waterData : allWaterData) {
				WaterDataTO waterDataTO = new WaterDataTO(waterData);
				System.out.println(waterDataTO);
			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
