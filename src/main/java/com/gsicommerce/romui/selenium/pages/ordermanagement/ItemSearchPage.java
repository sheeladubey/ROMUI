package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.CatalogInventorySearchData;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;

public class ItemSearchPage {

	WebDriver driver;
	Environment env;
	Action action;

	public ItemSearchPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);

	}

	@FindBy(how = How.CSS, using = "#items_item_search_form_query")
	private WebElement txtItemIDSearch;

	@FindBy(how = How.CSS, using = "#items_item_search_form_client_item_id")
	private WebElement txtClientIDSearch;

	@FindBy(how = How.CSS, using = "#items_item_search_form_style_id")
	@CacheLookup
	private WebElement txtStyleIDSearch;

	@FindBy(how = How.CSS, using = "#items_item_client_item_id")
	@CacheLookup
	private WebElement txtClientItemID;

	@FindBy(how = How.CSS, using = "#items_item_search_form_display_product_id")
	@CacheLookup
	private WebElement txtDisProdID;

	@FindBy(how = How.CSS, using = "#items_item_search_form_status")
	@CacheLookup
	private WebElement drpdwnSearchStatus;

	@FindBy(how = How.CSS, using = "#items_item_status")
	@CacheLookup
	private WebElement dropDownStatus;

	@FindBy(how = How.CSS, using = "#items_item_style_id")
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
	private WebElement txtUPC;

	@FindBy(how = How.CSS, using = "#items_item_sales_class")
	@CacheLookup
	private WebElement drpdwnSalesClass;

	@FindBy(how = How.CSS, using = ".btn.btn-default.item-add-more-btn")
	@CacheLookup
	private List<WebElement> btnAddAttributes;

	@FindBy(how = How.CSS, using = "#items_item_color_code")
	@CacheLookup
	private WebElement txtColorCode;

	@FindBy(how = How.CSS, using = "#items_item_color_descriptions_attributes_0_locale")
	@CacheLookup
	private WebElement drpdwnColorLocale;

	@FindBy(how = How.CSS, using = "#items_item_color_descriptions_attributes_0_description")
	@CacheLookup
	private WebElement txtColorDescrp;

	@FindBy(how = How.CSS, using = "#items_item_size_code")
	@CacheLookup
	private WebElement txtSizeCode;

	@FindBy(how = How.CSS, using = "#items_item_size_descriptions_attributes_0_locale")
	@CacheLookup
	private WebElement drpdwnSizeLocale;

	@FindBy(how = How.CSS, using = "#items_item_size_descriptions_attributes_0_description")
	@CacheLookup
	private WebElement txtSizeDescrp;

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

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='items_item[item_eligibility_attributes][set_infinite_inventory]']")
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

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Select')]")
	@CacheLookup
	private WebElement lkSelectATPRule;

	@FindBy(how = How.CSS, using = ".order-line-item-attribute")
	@CacheLookup
	public WebElement txtItemID;

	@FindBy(how = How.CSS, using = ".col-sm-3")
	@CacheLookup
	public List<WebElement> viewItemDetailsPanel;

	@FindBy(how = How.CSS, using = ".item-summary-desc")
	@CacheLookup
	public WebElement txtItemSummaryDescrp;

	public void searchForItem(String searchterm, String type) {
		CommonElementsPage.clickOnSearchIcon();
		if (type.contains("clientItemID")) {
			Action.enter(txtClientIDSearch, searchterm);
		} else if (type.contains("productID")) {
			Action.enter(txtDisProdID, searchterm);
		} else if (type.contains("status")) {
			Action.selectByVisibleText(drpdwnSearchStatus, searchterm);
		}
		// CommonElementsPage.clickOnSearchBtn();
		Action.clickUsingJavaScipt(CommonElementsPage.btnSearch);
	}

	public void searchForMultipleOptions(CatalogInventorySearchData data) {
		CommonElementsPage.clickOnSearchIcon();
		Action.enter(txtItemIDSearch, data.getItemID());
		Action.enter(txtClientIDSearch, data.getClientItemID());
		Action.enter(txtDisProdID, data.getProductID());
		Action.selectByVisibleText(drpdwnSearchStatus, data.getStatus());
		Action.enter(txtStyleIDSearch, data.getStyleID());

		// CommonElementsPage.clickOnSearchBtn();
		Action.clickUsingJavaScipt(CommonElementsPage.btnSearch);
	}

	public void addItem(CatalogInventorySearchData data, String clientItemID) {
		CommonElementsPage.clickOnAddBtn();
		Action.waitForElementToBeClickable(driver, drpdwnCatalogID, 30);
		Action.selectByIndex(drpdwnCatalogID, 1);
		Action.enter(txtClientItemID, clientItemID);
		Action.enter(txtItemDescrp, data.getItemDescrp());
		Action.enter(txtTaxCode, data.getTaxCode());
		Action.selectByVisibleText(drpdwnItemType, data.getItemType());
		Action.selectByVisibleText(drpdwnStatus, data.getStatus());
		Action.enter(txtDispProdID, data.getProductID());
		Action.enter(txtDispProdTitle, data.getProductTitle());
		Action.selectByVisibleText(drpdwnCurrency, data.getCurrency());
		Action.enter(txtUnitCost, data.getUnitCost());
		Action.selectByVisibleText(drpdwnCountyOfOrigin, data.getCountryOfOrigin());
		Action.enter(txtBrandName, data.getBrandName());
		btnAddBrandDesc.click();
		Action.selectByVisibleText(drpdwnBrandLocale, data.getBrandLocale());
		Action.enter(txtBrandDesc, data.getBrandDescp());
		Action.scrollDown("500");
		btnAddUPC.click();
		Action.selectByVisibleText(drpdwnUPCType, data.getUpcType());
		Action.enter(txtUPC, data.getUpc());
		Action.selectByIndex(drpdwnSalesClass, 1);
		btnAddAttributes.get(0).click();
		Action.enter(txtColorCode, data.getColorCode());
		Action.selectByVisibleText(drpdwnColorLocale, data.getColorLocale());
		Action.enter(txtColorDescrp, data.getColorDescrp());
		Action.scrollDown("500");
		btnAddAttributes.get(1).click();
		Action.enter(txtSizeCode, data.getSizeCode());
		Action.selectByVisibleText(drpdwnSizeLocale, data.getSizeLocale());
		Action.enter(txtSizeDescrp, data.getSizeDescrp());
		Action.enter(txtStyleID, data.getStyleID());
		Action.enter(txtItemStyleDesc, data.getStyleDescrp());
		Action.enter(txtDSSupplierName, data.getDsSupplierName());
		Action.enter(txtDSSupplierNo, data.getDsSupplierNo());
		Action.enter(txtDSSupplierPartName, data.getDsSupplierPartNo());
		chkboxISPUEligible.click();
		chkboxSFSEligible.click();
		chkboxSTSEligible.click();
		chkboxAsscDelvryEligible.click();
		Action.scrollDown("500");
		chkboxSetInfiniteInvtry.click();
		chkboxShipMethdOptmzEligible.click();
		chkboxHFReturnsEligible.click();
		Action.selectByVisibleText(drpdwnSurcngOverride, data.getSourcingOverride());
		Action.selectByVisibleText(drpdwnSurcngPrefrnce, data.getSourcingPreference());
		Action.enter(txtSurcngClassfctn1, data.getSourcingClassfication1());
		Action.enter(txtSurcngClassfctn2, data.getSourcingClassfication2());
		Action.enter(txtSurcngClassfctn3, data.getSourcingClassfication3());
		Action.enter(txtHazardousMatrialCode, data.getHazardousMaterlCode());
		Action.selectByVisibleText(drpdwnMassWtUnitOfMeasure, data.getWeightUnitOfMeasure());
		Action.enter(txtMassItemWt, data.getItemWeight());
		Action.selectByVisibleText(drpdwnPackngDimensionUnitOfMeasure, data.getDimensionUnitOfMeasure());
		Action.enter(txtItemPackgeWidth, data.getItemPackWidth());
		Action.enter(txtItemPackgeLength, data.getItemPackLength());
		Action.enter(txtItemPackgeHeight, data.getItemPackHeight());
		Action.enter(txtItemPackgeType, data.getItemPackType());
		Action.selectByVisibleText(drpdwnDimensionlWtUOM, data.getDimensionalWeightUOM());
		Action.enter(txtDimensionlWeight, data.getDimensionalWeight());
		Action.enter(txtFreightClass, data.getFreightClass());
		Action.selectByVisibleText(drpdwnShipAlone, data.getShipAlone());
		Action.enter(txtShippngSurchrgOverride, data.getShippingSurchargeOverride());
		Action.enter(txtShippngChrgOverride, data.getShippingChargeOverride());
		Action.enter(txtMinShmptProcssngDays, data.getMinShipmtProcessingDays());
		Action.enter(txtMaxShmptProcssngDays, data.getMaxShipmtProcessingDays());
		Action.enter(txtMinOrderableQty, data.getMinOrderableQty());
		Action.enter(txtMaxOrderableQty, data.getMaxOrderableQty());
		txtStreetDt.click();
		btnATPConfigID.click();
		Action.waitForElementToBeClickable(driver, lkSelectATPRule, 30);
		lkSelectATPRule.click();
		Action.waitForElementToBeClickable(driver, btnAddImg, 60);
		btnAddImg.click();
		Action.enter(txtImgType, data.getImgType());
		Action.enter(txtImgView, data.getImgView());
		Action.enter(txtImgHeight, data.getImgHeight());
		Action.enter(txtImgWidth, data.getImgWidth());
		Action.enter(txtImgURL, data.getImgURL());
		btnAddAttribute.click();
		Action.enter(txtAttrbName, data.getAttribName());
		Action.enter(txtAttrbValue, data.getAttribVal());
		CommonElementsPage.clickOnSaveBtn();
	}

	public void editItem(CatalogInventorySearchData data) throws Exception {
		CommonElementsPage.clickSingleRowActionsIcon(4, 2);
		Action.enter(txtItemDescrp, "Auto - " + data.getItemDescrp());
		CommonElementsPage.clickOnSaveBtn();
	}

	public boolean verifyViewItem(int index, String expected) throws Exception {
		boolean found = false;
		String actual = viewItemDetailsPanel.get(index).getText();
		if (actual.contains(expected)) {
			found = true;
		} else {
			found = false;
		}
		return found;
	}

	public boolean verifySearch(int row, int col, String expected) throws Exception {
		boolean found = false;
		if (CommonElementsPage.getRowCellTextVal(row, col).contains(expected)) {
			found = true;
		} else {
			found = false;
		}
		return found;
	}

}
