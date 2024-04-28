package directMacroPages;

public class XpathClass {

	public final String dMurl = "https://directmacro.com/";
	

	
	//Search bar test cases xpaths
		
	    //public final String searchBar = "//input[@id='hello']"; //testing purpose to fail test case intentionally
	    public final String searchBar = "//input[@id='search']";	
		public final String searchData = "V156W - Dell 330-Watts 11.7VDC Battery Module for EqualLogic FS7600 FS8600";
		public final String searchButton = "//div[@class='actions']/button[@title='Search' and @class='search']/i";
		public final String searchPageFirstRecord = "//div[@class='product-list-details']/h4[@class='product name product-item-name']/a";
		public final String loaderDisplay = "//div[@class='loading-mask']/div[@class='loader']";
		//public final String searchDataFirstProduct = "(//ul[@id=\"product-search-list\"]/li/a)[1]";
		
		
	//Add To Cart TestCases Xpaths
		
		public final String storagePageUrl = "https://directmacro.com/storage-devices/storage.html";
		public final String storagePageFirstProduct ="(//div[@class='product-list-details']/h4/a[@class='product-item-link'])[1]";
		//public final String increaseQty ="//div[@class='custom-qty increase']/button[@class='btn-qty plus']";
		public final String getProductQty = "//input[@id='qty' and @name='qty']";
		
		public final String productPageQty ="1";
		
		public final String addToCart ="//div[@class='actions d-flex']/button[@id='product-addtocart-button']";
		public final String checkOutPageQty = "(//div[@class='title']/strong[@role='heading']/span)[1]";
		
		public final String placOrderButton ="//div[@id='actions-toolbar']/div/button[@class='action primary checkout']";
		public final String errorMessageToast = "//div[@class='message message-error error']/div[contains(text(), 'Please complete your payment details.')]";
		public final String errorToast = "Please complete your payment details.";
		
		
	//product min/max quantity check test cases
		public final String homePageProduct= "(//h3[@class='product-item-name']/a[@class='product-item-link'])[1]";
		public final String productPageQuantity = "//div[@class='control']/input[@id='qty']";
		
		public final String productZeroQtyCheck="//div[contains(text(), 'Please enter a quantity greater than 0.') and @id='qty-error']";
		public final String productZeroQtyErrorMessage = "Please enter a quantity greater than 0.";
		
		public final String productMaxQtyCheck="//div[contains(text(), 'The maximum you may purchase is 10000.') and @id='qty-error']";
		public final String productMaxQtyErrorMessage = "The maximum you may purchase is 10000.";
		
	//check form validation
		
		public final String checkoutEmail="//form[@class='form form-login']//input[@type='email']";
		public final String checkoutFirstName="//form[@id='co-shipping-form']//input[@class='input-text' and @name='firstname']";
		public final String checkoutLastName="//form[@id='co-shipping-form']//input[@class='input-text' and @name='lastname']";
		public final String checkoutCompanyName="//form[@id='co-shipping-form']//input[@class='input-text' and @name='company']";
		public final String checkoutAddress1 = "//form[@id='co-shipping-form']//input[@class='input-text' and @name='street[0]']";
		public final String checkoutCountry = "//form[@id='co-shipping-form']//select[@class='select' and @name='country_id']";
		public final String checkoutRegion = "//form[@id='co-shipping-form']//select[@class='select' and @name='region_id']";
		public final String checkoutCity = "//form[@id='co-shipping-form']//input[@class='input-text' and @name='city']";
		public final String checkoutPostalCode = "//form[@id='co-shipping-form']//input[@class='input-text' and @name='postcode']";
		public final String checkoutPhone = "//form[@id='co-shipping-form']//input[@class='input-text' and @name='telephone']";
		
		
}
