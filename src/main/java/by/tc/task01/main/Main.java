package by.tc.task01.main;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Kettle;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.characteristics.Color;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ApplianceService service = ServiceFactory.getInstance().getApplianceService();

		Kettle k1 = new Kettle(340.0, "Scarlett SC-EK27G73", 123, 1000.0, Color.Red);
		Kettle k2 = new Kettle(210.0, "Redmond SkyKettle RK-M216S", 2000, 1700.0, Color.Black);
		Oven o1 = new Oven(174.0, "Samsung NV68R1310BS", 1000, 50, 100, 17, 60.0, 70.0);

		List<Appliance> list = new ArrayList<>();
		list.add(k1);
		list.add(k2);
		list.add(o1);

		DAOFactory appliancesFactory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = appliancesFactory.getApplianceDAO();
		applianceDAO.save(list);
		
		Criteria kettleCriteria = new Criteria(SearchCriteria.Kettle.class.getSimpleName());
		List<Appliance> kettles = service.find(kettleCriteria);
		if (kettles != null) {
			List<Appliance> kettlesOrderedByName = service.sort(Comparator.comparing(Appliance::getName), kettles);
			System.out.println("\nAll kettles sorted alphabetically: ");
			PrintApplianceInfo.print(kettlesOrderedByName);
		}

		List<Appliance> minPriceAppliances = service.getMin(Comparator.comparing(Appliance::getPrice));
		if (minPriceAppliances != null) {
			System.out.println("\nThe cheapest appliance: ");
			PrintApplianceInfo.print(minPriceAppliances);
		}
	}
}
