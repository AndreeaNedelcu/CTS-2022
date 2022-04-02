package ro.ase.cts.g1099.clean.code.main;

import ro.ase.cts.g1099.clean.code.models.marketing.MarketingStrategy;
import ro.ase.cts.g1099.clean.code.models.marketing.SummerMarketingStrategy;
import ro.ase.cts.g1099.clean.code.stage7.DiscountStrategy;
import ro.ase.cts.g1099.clean.code.stage7.ProductType;

public class Main {

	public static void main(String[] args) {
		// test DIP
		DiscountStrategy discountStrategy=new DiscountStrategy();
		discountStrategy.setMarketingStrategy(new MarketingStrategy());
		float finalPrice=discountStrategy.getFinalPrice(ProductType.NEW, 1000, 10);
		System.out.println("Final price is : " + finalPrice);
		
		discountStrategy.setMarketingStrategy(new SummerMarketingStrategy());
		finalPrice=discountStrategy.getFinalPrice(ProductType.ON_SALE, 1000, 10);
		System.out.println("Final summer price is : " + finalPrice);

	}

}
