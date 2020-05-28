package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Webtable;

public class ItemSearchPage {

	WebDriver driver;
	Environment env;
	Action action;

	public ItemSearchPage(WebDriver driver, Environment env) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);

	}

	@FindBy(how = How.CSS, using = "#items_item_search_form_query")
	@CacheLookup
	private WebElement txtSearch;

	@FindBy(how = How.CSS, using = "#items_item_search_form_client_item_id")
	@CacheLookup
	private WebElement txtClientItemID;

	@FindBy(how = How.CSS, using = "#items_item_search_form_display_product_id")
	@CacheLookup
	private WebElement txtDisProdID;

	@FindBy(how = How.CSS, using = "#items_item_search_form_status")
	@CacheLookup
	private WebElement dropDownStatus;

	@FindBy(how = How.CSS, using = "#items_item_search_form_style_id")
	@CacheLookup
	private WebElement txtStyleID;

	@FindBy(how = How.CSS, using = "#items_item_catalog_id")
	@CacheLookup
	private WebElement drpdwnCatalogID;

	@FindBy(how = How.CSS, using = "#items_item_client_item_id")
	@CacheLookup
	private WebElement txtAddClientItemID;

	@FindBy(how = How.CSS, using = "#items_item_description")
	@CacheLookup
	private WebElement txtItemDescrp;

	@FindBy(how = How.CSS, using = "#items_item_tax_code")
	@CacheLookup
	private WebElement txtTaxCode;

	@FindBy(how = How.CSS, using = "#items_item_item_type")
	@CacheLookup
	private WebElement drpdwnItemType;

	@FindBy(how = How.CSS, using = "#items_item_status")
	@CacheLookup
	private WebElement drpdwnStatus;

	@FindBy(how = How.CSS, using = "#items_item_product_id")
	@CacheLookup
	private WebElement txtDispProdID;

	@FindBy(how = How.CSS, using = "#items_item_product_title")
	@CacheLookup
	private WebElement txtDispProdTitle;

	@FindBy(how = How.CSS, using = "#items_item_unit_cost_attributes_currency")
	@CacheLookup
	private WebElement drpdwnCurrency;

	@FindBy(how = How.CSS, using = "#items_item_unit_cost_attributes_unit_cost")
	@CacheLookup
	private WebElement txtUnitCost;

	@FindBy(how = How.CSS, using = "#items_item_country_of_origin")
	@CacheLookup
	private WebElement drpdwnCountyOfOrigin;

	@FindBy(how = How.CSS, using = "#items_item_brand_name")
	@CacheLookup
	private WebElement txtBrandName;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Brand Description')]")
	@CacheLookup
	private WebElement btnAddBrandDesc;

	@FindBy(how = How.CSS, using = "#items_item_brand_descriptions_attributes_0_locale")
	@CacheLookup
	private WebElement drpdwnBrandLocale;

	@FindBy(how = How.CSS, using = "#items_item_brand_descriptions_attributes_0_description")
	@CacheLookup
	private WebElement txtBrandDesc;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add UPC')]")
	@CacheLookup
	private WebElement btnAddUPC;

	@FindBy(how = How.CSS, using = "#items_item_upcs_attributes_0_type")
	@CacheLookup
	private WebElement drpdwnUPCType;

	@FindBy(how = How.CSS, using = "#items_item_upcs_attributes_0_upc")
	@CacheLookup
	private WebElement drpdwnUPC;

	@FindBy(how = How.CSS, using = "#items_item_sales_class")
	@CacheLookup
	private WebElement drpdwnSalesClass;

	@FindBy(how = How.CSS, using = "//button[text(),'Add']")
	@CacheLookup
	private List<WebElement> btnAddAttributes;

	@FindBy(how = How.CSS, using = "#items_item_style_id")
	@CacheLookup
	private WebElement txtItemStyleID;

	@FindBy(how = How.CSS, using = "#items_item_style_description")
	@CacheLookup
	private WebElement txtItemStyleDesc;

	@FindBy(how = How.CSS, using = "#items_item_drop_ship_supplier_info_attributes_drop_ship_supplier_name")
	@CacheLookup
	private WebElement txtDSSupplierName;

	@FindBy(how = How.CSS, using = "#items_item_drop_ship_supplier_info_attributes_drop_ship_supplier_number")
	@CacheLookup
	private WebElement txtDSSupplierNo;

	@FindBy(how = How.CSS, using = "#items_item_drop_ship_supplier_info_attributes_drop_ship_supplier_part_number")
	@CacheLookup
	private WebElement txtDSSupplierPartName;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='items_item[item_eligibility_attributes][ispu_eligible]']")
	@CacheLookup
	private WebElement chkboxISPUEligible;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='items_item[item_eligibility_attributes][sfs_eligible]']")
	@CacheLookup
	private WebElement chkboxSFSEligible;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='items_item[item_eligibility_attributes][sts_eligible]']")
	@CacheLookup
	private WebElement chkboxSTSEligible;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='items_item[item_eligibility_attributes][associate_delivery_eligible]']")
	@CacheLookup
	private WebElement chkboxAsscDelvryEligible;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='items_item[item_eligibility_attributes][eligible_to_modify]']")
	@CacheLookup
	private WebElement chkboxEligibleToModify;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='items_item[item_eligibility_attributes][set_infinite_inventory]']']")
	@CacheLookup
	private WebElement chkboxSetInfiniteInvtry;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='items_item[shipping_method_optimization_eligible]']")
	@CacheLookup
	private WebElement chkboxShipMethdOptmzEligible;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='items_item[hfr_eligible]']")
	@CacheLookup
	private WebElement chkboxHFReturnsEligible;

	@FindBy(how = How.CSS, using = "#items_item_sourcing_override")
	@CacheLookup
	private WebElement drpdwnSurcngOverride;

	@FindBy(how = How.CSS, using = "#items_item_sourcing_preference")
	@CacheLookup
	private WebElement drpdwnSurcngPrefrnce;

	@FindBy(how = How.CSS, using = "#items_item_sourcing_classification1")
	@CacheLookup
	private WebElement txtSurcngClassfctn1;

	@FindBy(how = How.CSS, using = "#items_item_sourcing_classification2")
	@CacheLookup
	private WebElement txtSurcngClassfctn2;

	@FindBy(how = How.CSS, using = "#items_item_sourcing_classification3")
	@CacheLookup
	private WebElement txtSurcngClassfctn3;

	@FindBy(how = How.CSS, using = "#items_item_hazardous_material_code")
	@CacheLookup
	private WebElement txtHazardousMatrialCode;

	@FindBy(how = How.CSS, using = "#items_item_display_mass_dimensions_attributes_unit")
	@CacheLookup
	private WebElement drpdwnMassWtUnitOfMeasure;

	@FindBy(how = How.CSS, using = "#items_item_display_mass_dimensions_attributes_weight")
	@CacheLookup
	private WebElement txtMassItemWt;

	@FindBy(how = How.CSS, using = "#items_item_display_package_dimensions_attributes_unit")
	@CacheLookup
	private WebElement drpdwnPackngDimensionUnitOfMeasure;

	@FindBy(how = How.CSS, using = "#items_item_display_package_dimensions_attributes_width")
	@CacheLookup
	private WebElement txtItemPackgeWidth;

	@FindBy(how = How.CSS, using = "#items_item_display_package_dimensions_attributes_length")
	@CacheLookup
	private WebElement txtItemPackgeLength;

	@FindBy(how = How.CSS, using = "#items_item_display_package_dimensions_attributes_height")
	@CacheLookup
	private WebElement txtItemPackgeHeight;

	@FindBy(how = How.CSS, using = "#items_item_eligible_package_type")
	@CacheLookup
	private WebElement txtItemPackgeType;

	@FindBy(how = How.CSS, using = "#items_item_dimensional_weight_attributes_dimensional_unit")
	@CacheLookup
	private WebElement drpdwnDimensionlWtUOM;

	@FindBy(how = How.CSS, using = "#items_item_dimensional_weight_attributes_dimensional_weight")
	@CacheLookup
	private WebElement txtDimensionlWeight;

	@FindBy(how = How.CSS, using = "#items_item_freight_class")
	@CacheLookup
	private WebElement txtFreightClass;

	@FindBy(how = How.CSS, using = "#items_item_ship_alone")
	@CacheLookup
	private WebElement drpdwnShipAlone;

	@FindBy(how = How.CSS, using = "#items_item_shipping_surcharge_override")
	@CacheLookup
	private WebElement txtShippngSurchrgOverride;

	@FindBy(how = How.CSS, using = "#items_item_shipping_charge_override")
	@CacheLookup
	private WebElement txtShippngChrgOverride;

	@FindBy(how = How.CSS, using = "#items_item_item_fulfillment_info_attributes_min_shipment_processing_days")
	@CacheLookup
	private WebElement txtMinShmptProcssngDays;

	@FindBy(how = How.CSS, using = "#items_item_item_fulfillment_info_attributes_max_shipment_processing_days")
	@CacheLookup
	private WebElement txtMaxShmptProcssngDays;

	@FindBy(how = How.CSS, using = "#items_item_item_fulfillment_info_attributes_min_orderable_quantity")
	@CacheLookup
	private WebElement txtMinOrderableQty;

	@FindBy(how = How.CSS, using = "#items_item_item_fulfillment_info_attributes_max_orderable_quantity")
	@CacheLookup
	private WebElement txtMaxOrderableQty;

	@FindBy(how = How.CSS, using = "#items_item_item_fulfillment_info_attributes_street_date")
	@CacheLookup
	private WebElement txtStreetDt;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Lookup')]")
	@CacheLookup
	private WebElement btnATPConfigID;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Image')]")
	@CacheLookup
	private WebElement btnAddImg;

	@FindBy(how = How.CSS, using = "#items_item_item_images_attributes_0_type")
	@CacheLookup
	private WebElement txtImgType;

	@FindBy(how = How.CSS, using = "#items_item_item_images_attributes_0_view")
	@CacheLookup
	private WebElement txtImgView;

	@FindBy(how = How.CSS, using = "#items_item_item_images_attributes_0_height")
	@CacheLookup
	private WebElement txtImgHeight;

	@FindBy(how = How.CSS, using = "#items_item_item_images_attributes_0_width")
	@CacheLookup
	private WebElement txtImgWidth;

	@FindBy(how = How.CSS, using = "#items_item_item_images_attributes_0_url")
	@CacheLookup
	private WebElement txtImgURL;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Attribute')]")
	@CacheLookup
	private WebElement btnAddAttribute;

	@FindBy(how = How.CSS, using = "#items_item_dynamic_attributes_attributes_0_name")
	@CacheLookup
	private WebElement txtAttrbName;

	@FindBy(how = How.CSS, using = "#items_item_dynamic_attributes_attributes_0_value")
	@CacheLookup
	private WebElement txtAttrbValue;

	@FindBy(how = How.CSS, using = ".reflow-table")
	@CacheLookup
	private List<WebElement> itemWebTable;

	public void searchForItem(String searchterm) {
		Action.enter(txtSearch, searchterm);
		CommonElementsPage.clickOnSearchBtn();
	}

	public void addItem() {
		CommonElementsPage.clickOnAddBtn();
	}

	public Webtable itemWebTable(int i) {
		Webtable wt = new Webtable(driver, (WebElement) itemWebTable(i));
		return wt;

	}

}
