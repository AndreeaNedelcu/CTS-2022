package ro.ase.cts.g1099.clean.code.models.marketing;

import ro.ase.cts.g1099.clean.code.interfaces.MarketingStrategyInterface;

public class SummerMarketingStrategy implements MarketingStrategyInterface {

	@Override
	public float getAccountDiscount(int accountAgeInYears) {
		// TODO Auto-generated method stub
		return 0.3f;
	}

}
