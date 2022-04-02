package ro.ase.cts.g1099.clean.code.stage6;

import java.util.MissingFormatArgumentException;

import ro.ase.cts.g1099.clean.code.models.marketing.MarketingStrategy;
import ro.ase.cts.g1099.clean.code.stage6.exceptions.MissingMarketingStrategyException;

//stage 7
//Dependency Inversion Principle DIP
//- remove the dependency injection 
public class DiscountStrategy {

	MarketingStrategy marketingStrategy;

	public float getDiscountValue(ProductType productType, float productPrice) {
		return productType.getDiscount() * productPrice;
	}
	
	public float getPriceWithDiscount(ProductType productType, float productPrice) {
		return productPrice-this.getDiscountValue(productType, productPrice);
	}
	
	public float getFinalPrice(ProductType productType, float productPrice, int accountAgeInYears)
	{
		if(marketingStrategy ==null) {
			throw new MissingMarketingStrategyException();
		}
		float accountDiscount = (productType !=ProductType.NEW) ? marketingStrategy.getAccountDiscount(accountAgeInYears) :0;
		
		float finalPrice = this.getPriceWithDiscount(productType, productPrice) *(1-accountDiscount);

		return finalPrice;
	}
}