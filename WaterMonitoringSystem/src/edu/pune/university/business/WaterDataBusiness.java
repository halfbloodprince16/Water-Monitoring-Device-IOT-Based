package edu.pune.university.business;

import java.util.ArrayList;
import java.util.List;

import edu.pune.university.dao.WaterDataDao;
import edu.pune.university.data.WaterData;
import edu.pune.university.data.WaterDataTO;
import edu.pune.university.exception.ApplicationException;
import edu.pune.university.service.rest.WaterDataService;

/**
 * WaterDataBusiness class is responsible for holding the business logic for
 * water data. This class will interact with {@link WaterDataDao} for database
 * operations and with {@link WaterDataService} for returning the result to
 * user.
 * 
 * @author <a href="mailto:mayap282@gmail.com">Maya Pilania</a>
 *
 */
public class WaterDataBusiness {

	/**
	 * Instance variable declaration for {@link WaterDataDao}.
	 */
	private WaterDataDao waterDataDao = null;

	/**
	 * Create an instance of {@link WaterDataDao}.
	 */
	public WaterDataBusiness() {
		waterDataDao = new WaterDataDao();
	}

	/**
	 * Get all the {@link WaterDataTO} from {@link WaterDataDao}.
	 * @return {@link List} of {@link WaterDataTO}
	 * @throws ApplicationException
	 */
	public List<WaterDataTO> getAllWaterDataTOs() throws ApplicationException {
		List<WaterDataTO> waterDataTOs = new ArrayList<WaterDataTO>();
		List<WaterData> allWaterData = waterDataDao.getAllWaterData();
		for (WaterData waterData : allWaterData) {
			waterDataTOs.add(new WaterDataTO(waterData));
		}
		return waterDataTOs;
	}
}
