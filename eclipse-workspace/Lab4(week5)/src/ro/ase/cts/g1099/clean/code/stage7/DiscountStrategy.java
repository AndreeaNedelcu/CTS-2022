package ro.ase.cts.g1099.clean.code.stage7;

import java.util.MissingFormatArgumentException;

import ro.ase.cts.g1099.clean.code.interfaces.MarketingStrategyInterface;
import ro.ase.cts.g1099.clean.code.stage6.exceptions.MissingMarketingStrategyException;

//stage 6
//Single Responsability at class level 
// - outsource the way we compute the account discount
public class DiscountStrategy {
	//DIP
	MarketingStrategyInterface marketingStrategy;
	
	//dependency injection by ctor
	public DiscountStrategy(MarketingStrategyInterface marketingStrategy) {
		super();
		if(marketingStrategy ==null) {
			throw new MissingMarketingStrategyException();
		}
		this.marketingStrategy = marketingStrategy;
	}
	
	public DiscountStrategy() {
		
	}

	//dependency injection by setter
	public void setMarketingStrategy(MarketingStrategyInterface marketingStrategy) {
		if(marketingStrategy ==null) {
			throw new MissingMarketingStrategyException();
		}
		this.marketingStrategy = marketingStrategy;
	}


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