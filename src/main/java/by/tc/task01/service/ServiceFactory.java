package by.tc.task01.service;

import by.tc.task01.service.impl.ApplianceServiceImpl;

/**
 * The type of factory for creating ApplianceService.
 */
public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ApplianceService applianceService = new ApplianceServiceImpl();
	
	private ServiceFactory() {}

	/**
	 * Gets new ApplianceService object.
	 *
	 * @return mew ApplianceService object.
	 */
	public ApplianceService getApplianceService() {

		return applianceService;
	}

	/**
	 * Gets current ServiceFactory object.
	 *
	 * @return instance of ServiceFactory
	 */
	public static ServiceFactory getInstance() {
		return instance;
	}

}
