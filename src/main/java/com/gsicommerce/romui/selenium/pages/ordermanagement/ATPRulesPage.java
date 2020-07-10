package com.gsicommerce.romui.selenium.pages.ordermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.InventoryAvailabilityData;
import com.gsicommerce.romui.selenium.utilities.Action;

public class ATPRulesPage {
	WebDriver driver;
	Environment env;
	private InventoryAvailabilityData inventoryAvailabilityData;
	private static int rowATP;
	private static String ATPRuleName;

	public ATPRulesPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = ".inventory-organization-display")
	private WebElement invOrgHeader;

	@FindBy(how = How.CSS, using = ".pagination-heading")
	private WebElement invAvlHeader;

	@FindBy(how = How.CSS, using = "#store_fulfillment_atp_rule_id")
	private WebElement txtbxatpRuleName;

	@FindBy(how = How.CSS, using = "#store_fulfillment_atp_rule_description")
	private WebElement txtbxatpDescription;

	@FindBy(how = How.CSS, using = "#store_fulfillment_atp_rule_past_due_supply_days")
	private WebElement txtbxOverdueSupply;

	@FindBy(how = How.CSS, using = "#store_fulfillment_atp_rule_past_due_demand_days")
	private WebElement txtbxOverdueDemand;

	@FindBy(how = How.CSS, using = "#store_fulfillment_atp_rule_forward_consumption")
	private WebElement txtbxForwardConsumption;

	@FindBy(how = How.CSS, using = "#store_fulfillment_atp_rule_backwards_consumption")
	private WebElement txtbxBackwardsConsumption;

	@FindBy(how = How.CSS, using = "#store_fulfillment_atp_rule_receipt_processing_days")
	private WebElement txtbxReceiptProcessingDays;

	@FindBy(how = How.CSS, using = "#store_fulfillment_atp_rule_advance_notification_time")
	private WebElement txtbxAdvanceNotificationDays;

	public boolean verifyInvAvail() throws Exception {
		boolean found = false;
		int rowNo = CommonElementsPage.getTotalRows();
		if (invAvlHeader.getText().contains("Rules Found") && (rowNo > 0)
				&& invOrgHeader.getText().contains("TMSNA_INV_ORG")) {
			found = true;
		}
		return found;
	}

	public void addATPRule() throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		CommonElementsPage.clickOnAddBtn();
		ATPRuleName = inventoryAvailabilityData.getATP_Rule_Name();
		System.out.println("New ATP Rule Name is::" + ATPRuleName);
		Action.enter(txtbxatpRuleName, ATPRuleName);
		Action.enter(txtbxatpDescription, inventoryAvailabilityData.getATP_Rule_Description());
		Action.enter(txtbxOverdueSupply, inventoryAvailabilityData.getOverdue_Supply());
		Action.enter(txtbxOverdueDemand, inventoryAvailabilityData.getOverdue_Demand());
		Action.enter(txtbxForwardConsumption, inventoryAvailabilityData.getForward_Days());
		Action.enter(txtbxBackwardsConsumption, inventoryAvailabilityData.getBackward_Days());
		Action.enter(txtbxReceiptProcessingDays, inventoryAvailabilityData.getReceipt_Processing_Time());
		Action.enter(txtbxAdvanceNotificationDays, inventoryAvailabilityData.getAdvance_Notification());
		CommonElementsPage.clickOnSaveBtn();
		System.out.println("Newly added ATP Rule Name is::" + ATPRuleName);
		rowATP = CommonElementsPage.getRowNo(ATPRuleName, 1);
		System.out.println("Newly Added ATP Rule Name is:" + CommonElementsPage.getRowCellTextVal(rowATP, 1));
		Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowATP, 1),
				inventoryAvailabilityData.getATP_Rule_Name(), "New ATP not Added");
	}

	public void editATPRule() throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		Reporter.log("Click Edit ATP Rule icon");
		CommonElementsPage.clickDivSpanLink(rowATP, 4, 0, 1, 1);
		Action.waitForElementToBeClickable(driver, txtbxOverdueSupply, 10);
		Action.enter(txtbxOverdueSupply, inventoryAvailabilityData.getOverdue_Supply());
		Action.waitForElementToBeClickable(driver, txtbxOverdueDemand, 10);
		Action.enter(txtbxOverdueDemand, inventoryAvailabilityData.getOverdue_Demand());
		Action.enter(txtbxForwardConsumption, inventoryAvailabilityData.getForward_Days());
		Action.enter(txtbxBackwardsConsumption, inventoryAvailabilityData.getBackward_Days());
		Action.enter(txtbxReceiptProcessingDays, inventoryAvailabilityData.getReceipt_Processing_Time());
		Action.enter(txtbxAdvanceNotificationDays, inventoryAvailabilityData.getAdvance_Notification());
		CommonElementsPage.clickOnSaveBtn();

	}

	public void deleteATPRule() throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		Reporter.log("Click Delete ATP Rule icon");
		CommonElementsPage.clickDivSpanLink(rowATP, 4, 0, 2, 1);
		CommonElementsPage.clickOnConfirmBtn();
	}
}
