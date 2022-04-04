package ro.ase.cts.g1099.asgn1.stage6;

public class Account {
	private double loanValue;
	private double rate;	
	private int	daysActive;
	private AccountType accountType;
	public static final double BROKER_FEE_PERCENTAGE=0.0125;
	public static final int DAYS_PER_YEAR = 365; 
	
	public double getLoanValue() {
		System.out.println("The loan value is " + this.loanValue);
		return loanValue;
	}
	
	public double getRate() {
		System.out.println("The rate is "+rate);
		return this.rate;
	}
	
	
	public int getDaysActive() {
		return daysActive;
	}
	public AccountType getAccountType() {
		return accountType;
	}


	public void setDaysActive(int daysActive) {
		this.daysActive = daysActive;
	}

	
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void setLoanValue(double value) throws Exception {
		if(value<0)
			throw new Exception();
		else
		{
			loanValue = value;
		}
	}
	
	
	public void setRate(double rate) {
		this.rate = rate;
	}

	//must have method - the lead has requested it in all classes
	public double getMonthlyRate() {
		return loanValue*rate;
	}
	

	public String toString() {
		return "Loan: "+this.loanValue+"; rate: "+this.rate+"; days active:"+daysActive+"; Type: "+accountType+";";
	}
	
	public static boolean accountIsPremiumOrSuperPremium(Account account) {
		if(account.accountType==AccountType.PREMIUM||account.accountType==AccountType.SUPER_PREMIUM) {	
			return true;
			}
		else {
			return false;
			}
	}
	
	public static  double getPrincipalInterest(Account account) {
		return account.loanValue*Math.pow(account.rate,(account.daysActive/DAYS_PER_YEAR)) - account.loanValue;
	}

	public static double getTotalFee(Account[] 	accounts)
	{
	double totalFee=0.0;
	Account	account;
	
	for	(int	i=0;i<accounts.length;i++)	{
	account=accounts[i];
	
	if(accountIsPremiumOrSuperPremium(account))	
		totalFee+=BROKER_FEE_PERCENTAGE	*getPrincipalInterest(account);
	}
	return	totalFee;
	}

	public Account(double value, double rate, AccountType account_Type) throws Exception {
		if(value<0)
			throw new Exception();
		else
		{
			loanValue = value;
		}
		this.rate = rate;
		this.accountType = account_Type;
	}
	
}
