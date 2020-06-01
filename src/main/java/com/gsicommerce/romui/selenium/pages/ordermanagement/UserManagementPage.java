package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.UserManagementData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class UserManagementPage {

	WebDriver driver;
	Environment env;
	Action action;
	private UserManagementData data;
	Calendar futureStartDate = null;
	Calendar dateCurrent = null;
	Calendar endDateCal = null;
	private static String roleName;
	private static String userId;

	public UserManagementPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add Role')]")
	@CacheLookup
	private WebElement btnAddRole;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add')]")
	@CacheLookup
	private WebElement btnAddUser;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Confirm')]")
	@CacheLookup
	private WebElement btnConfirm;

	@FindBy(how = How.CSS, using = "[value='Confirm']")
	@CacheLookup
	private WebElement btnRoleConfirm;

	@FindBy(how = How.CSS, using = "#user_form_base_id")
	@CacheLookup
	private List<WebElement> txtUserId;

	@FindBy(how = How.XPATH, using = "//input[@name='user_form[password]']")
	@CacheLookup
	private WebElement txtPwd;

	@FindBy(how = How.XPATH, using = "//input[@name='user_form[password_confirmation]']")
	@CacheLookup
	private WebElement txtCnfmPwd;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Reset Password')]")
	@CacheLookup
	private WebElement txtRstPwd;

	@FindBy(how = How.CSS, using = "[class='radial-app-menu-open sso-header-navigation-menu-open']")
	@CacheLookup
	private WebElement btnMenu;

	@FindBy(how = How.CSS, using = "[title='Order Management']")
	@CacheLookup
	private WebElement btnOrderMenu;

	@FindBy(how = How.CSS, using = "[placeholder='Reset Password']")
	@CacheLookup
	private WebElement txtResetPwd;

	@FindBy(how = How.CSS, using = "[placeholder='Confirm Reset Password']")
	@CacheLookup
	private WebElement txtCnfrmResetPwd;

	@FindBy(how = How.CSS, using = "[class='radial-app-menu-open-icon']")
	@CacheLookup
	private WebElement btnMainMenu;

	@FindBy(how = How.CSS, using = ".alert-info")
	@CacheLookup
	public WebElement txtSuccessMsg;

	@FindBy(how = How.CSS, using = ".alert-danger")
	@CacheLookup
	public WebElement txtErrorMsg;

	@FindBy(how = How.CSS, using = "[id='user_form_policies_attributes_0_contexts']")
	@CacheLookup
	private WebElement drpdwnContext;

	@FindBy(how = How.CSS, using = "[id='user_form_policies_attributes_0_roles']")
	@CacheLookup
	private WebElement drpdwnroles;

	@FindBy(how = How.CSS, using = "#user_form_first_name")
	@CacheLookup
	private WebElement firstName;

	@FindBy(how = How.CSS, using = "#user_form_last_name")
	@CacheLookup
	private WebElement lastName;

	@FindBy(how = How.CSS, using = "#user_form_display_name")
	@CacheLookup
	private WebElement displayName;

	@FindBy(how = How.CSS, using = "#user_form_email")
	@CacheLookup
	private WebElement txtEmail;

	@FindBy(how = How.CSS, using = "#user_form_phone")
	@CacheLookup
	private WebElement txtphone;

	@FindBy(how = How.CSS, using = "#user_form_category")
	@CacheLookup
	private WebElement drpdwnCategory;

	@FindBy(how = How.CSS, using = "#user_form_time_zone")
	@CacheLookup
	private WebElement drpdwnTimeZone;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
	@CacheLookup
	private WebElement btnUserSave;

	@FindBy(how = How.XPATH, using = "//input[@type='text' and @id='user_form_base_id']")
	@CacheLookup
	private WebElement txtUser;

	@FindBy(how = How.CSS, using = "#role_id")
	@CacheLookup
	private WebElement txtRoleName;

	@FindBy(how = How.CSS, using = "#role_description")
	@CacheLookup
	private WebElement txtRoleDesc;

	@FindBy(how = How.CSS, using = "div[data-role-permission='atp_rule/create']")
	@CacheLookup
	private WebElement chkAtpRules;

	@FindBy(how = How.CSS, using = "div[data-role-permission='availability_search/read']")
	@CacheLookup
	private WebElement chkAvailability;

	@FindBy(how = How.CSS, using = "div[data-role-permission='core_rule/read']")
	@CacheLookup
	private WebElement chkCoreRules;

	@FindBy(how = How.CSS, using = "div[data-role-permission='store_fulfillment_dashboard/read']")
	@CacheLookup
	private WebElement chkDashboard;

	@FindBy(how = How.CSS, using = "div[data-role-permission='node_group/delete']")
	@CacheLookup
	private WebElement chkNodeGroups;

	@FindBy(how = How.CSS, using = "div[data-role-permission='node_item/update']")
	@CacheLookup
	private WebElement chkNodeItems;

	@FindBy(how = How.CSS, using = "div[data-role-permission='node/bulk_update']")
	@CacheLookup
	private WebElement chkNodes;

	@FindBy(how = How.CSS, using = "div[data-role-permission='fulfillment_order/bulk_decline_pack']")
	@CacheLookup
	private WebElement chkOrderDeclinePack;

	@FindBy(how = How.CSS, using = "div[data-role-permission='fulfillment_order/bulk_decline_pick']")
	@CacheLookup
	private WebElement chkOrderDeclinePick;

	@FindBy(how = How.CSS, using = "div[data-role-permission='fulfillment_order/check_in']")
	@CacheLookup
	private WebElement chkOrderCheckIn;

	@FindBy(how = How.CSS, using = "div[data-role-permission='inventory/move']")
	@CacheLookup
	private WebElement chkInventory;

	@FindBy(how = How.CSS, using = "div[data-role-permission='inventory_audit/read']")
	@CacheLookup
	private WebElement chkInvAudit;

	@FindBy(how = How.CSS, using = "div[data-role-permission='item/create']")
	@CacheLookup
	private WebElement chkItem;

	@FindBy(how = How.CSS, using = "div[data-role-permission='node_calendar/delete']")
	@CacheLookup
	private WebElement chkNodeCalendar;

	@FindBy(how = How.CSS, using = "div[data-role-permission='order_event/read']")
	@CacheLookup
	private WebElement chkOrderEvent;

	@FindBy(how = How.CSS, using = "div[data-role-permission='omnichannel_reporting_dashboard/read']")
	@CacheLookup
	private WebElement chkOmniDashboard;

	@FindBy(how = How.CSS, using = "div[data-role-permission='inventory_organization/read']")
	@CacheLookup
	private WebElement chkInvOrg;

	@FindBy(how = How.CSS, using = "div[data-role-permission='order_exception/edit']")
	@CacheLookup
	private WebElement chkOrderException;

	@FindBy(how = How.CSS, using = "div[data-role-permission='order_orchestration/read']")
	@CacheLookup
	private WebElement chkOrderOrchestration;

	@FindBy(how = How.CSS, using = "div[data-role-permission='fulfillment_order_queue/update']")
	@CacheLookup
	private WebElement chkOrderQueues;

	@FindBy(how = How.CSS, using = "div[data-role-permission='in_store_return/create']")
	@CacheLookup
	private WebElement chkOrderReturns;

	@FindBy(how = How.CSS, using = "div[data-role-permission='order/create']")
	@CacheLookup
	private WebElement chkOrders;

	@FindBy(how = How.CSS, using = "div[data-role-permission='payment_method_configuration/update']")
	@CacheLookup
	private WebElement chkPaymentMthdConfig;

	@FindBy(how = How.CSS, using = "div[data-role-permission='user_profile/read']")
	@CacheLookup
	private WebElement chkPrsnlProfile;

	@FindBy(how = How.CSS, using = "div[data-role-permission='pick_ticket/reassign']")
	@CacheLookup
	private WebElement chkPickTickets;

	@FindBy(how = How.CSS, using = "div[data-role-permission='print_template/publish']")
	@CacheLookup
	private WebElement chkPrintDocs;

	@FindBy(how = How.CSS, using = "div[data-role-permission='putaway_item/read']")
	@CacheLookup
	private WebElement chkPutawayItems;

	@FindBy(how = How.CSS, using = "div[data-role-permission='reason_code/update']")
	@CacheLookup
	private WebElement chkReasonCodes;

	@FindBy(how = How.CSS, using = "div[data-role-permission='release_notes/read']")
	@CacheLookup
	private WebElement chkReleaseNotes;

	@FindBy(how = How.CSS, using = "div[data-role-permission='reprint_document/read']")
	@CacheLookup
	private WebElement chkReprintDocs;

	@FindBy(how = How.CSS, using = "div[data-role-permission='user_role/create']")
	@CacheLookup
	private WebElement chkRoles;

	@FindBy(how = How.CSS, using = ".alert-info")
	@CacheLookup
	public WebElement userSuccessMsg;

	@FindBy(how = How.CSS, using = "div[data-role-permission='safety_stock_rule/delete']")
	@CacheLookup
	private WebElement chkSafetyStkRules;

	@FindBy(how = How.CSS, using = "div[data-role-permission='seller_sourcing_rule/update']")
	@CacheLookup
	private WebElement chkSellerRules;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'ROM')]")
	@CacheLookup
	private WebElement chkRom;

	@FindBy(how = How.CSS, using = "#user_id")
	@CacheLookup
	public WebElement searchUserId;

	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'Select')])[2]")
	@CacheLookup
	public WebElement selectRole;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Lookup')]")
	@CacheLookup
	public WebElement roleLookup;

	/*
	 * @FindBy(how = How.XPATH, using = "//span[contains(text(),'Lookup')]")
	 * 
	 * @CacheLookup public WebElement roleSearch;
	 */

	@FindBy(how = How.CSS, using = "#context")
	@CacheLookup
	public WebElement drpdwnNodeSearch;

	@FindBy(how = How.CSS, using = "div[data-role-permission='seller/update']")
	@CacheLookup
	private WebElement chkSellers;

	@FindBy(how = How.CSS, using = "div[data-role-permission='seller_service_group/internal_user']")

	@CacheLookup
	private WebElement chkSrvcGrpConfigInt;

	@FindBy(how = How.CSS, using = "div[data-role-permission='seller_service_group/update']")

	@CacheLookup
	private WebElement chkSrvcGrpConfig;

	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'User Management')]")
	@CacheLookup
	WebElement lkUserMgmt;

	@FindBy(how = How.XPATH, using = "//i/parent::a[contains(text(),'Omni Administration')]")
	@CacheLookup
	WebElement lkOmniAdministration;

	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Users')]")
	@CacheLookup
	WebElement lkUsers;

	@FindBy(how = How.CSS, using = "div[data-role-permission='shipping_distance_group/create']")

	@CacheLookup
	private WebElement chkShippingDistanceGrp;

	@FindBy(how = How.CSS, using = "div[data-role-permission='shipping_method_optimization/update']")

	@CacheLookup
	private WebElement chkShippingMthdOptimization;

	@FindBy(how = How.CSS, using = "div[data-role-permission='shipping_region_group/create']")

	@CacheLookup
	private WebElement chkShippingRegGrps;

	@FindBy(how = How.CSS, using = "div[data-role-permission='shipping_region/lookup']")

	@CacheLookup
	private WebElement chkShippingReg;

	@FindBy(how = How.CSS, using = "div[data-role-permission='shipping_zone_group/create']")

	@CacheLookup
	private WebElement chkShippingZoneGrps;

	@FindBy(how = How.CSS, using = "div[data-role-permission='store_reporting_dashboard/read']")

	@CacheLookup
	private WebElement chkStoreFulfillmentDashbrd;

	@FindBy(how = How.CSS, using = "div[data-role-permission='node_message/create']")

	@CacheLookup
	private WebElement chkStoreMessages;

	@FindBy(how = How.CSS, using = "div[data-role-permission='zero_cost_order/create']")

	@CacheLookup
	private WebElement chkZcr;

	@FindBy(how = How.CSS, using = "div[data-role-permission='audits/read']")

	@CacheLookup
	private WebElement chkAudits;

	@FindBy(how = How.CSS, using = "div[data-role-permission='shipping_label/create']")

	@CacheLookup
	private WebElement chkShippingLabel;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
	@CacheLookup
	private WebElement btnSave;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Search') and @type='submit']")
	@CacheLookup
	private WebElement btnSearch;

	@FindBy(how = How.CSS, using = ".pagination-heading")
	@CacheLookup
	private WebElement userSearchMsg;

	@FindBy(how = How.CSS, using = ".alert-info")
	@CacheLookup
	public WebElement userNotFound;

	@FindBy(how = How.CSS, using = "[data-tooltip='Show Advanced Search']")
	@CacheLookup
	public WebElement advancedSearch;

	@FindBy(how = How.CSS, using = "#first_name")
	@CacheLookup
	public WebElement firstnameSearch;

	@FindBy(how = How.CSS, using = "#last_name")
	@CacheLookup
	public WebElement lastnameSearch;

	@FindBy(how = How.CSS, using = "#email")
	@CacheLookup
	public WebElement emailSearch;

	@FindBy(how = How.CSS, using = "label>span")
	@CacheLookup
	public WebElement chkRole;

	@FindBy(how = How.CSS, using = ".reflow-table-row")
	@CacheLookup
	public List<WebElement> tableRows;

	public void addRole() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddRole, 06);
		btnAddRole.click();
		roleName = data.getRoleName();
		System.out.println("Role name is:-" + roleName);
		Action.enter(txtRoleName, roleName);
		Action.enter(txtRoleDesc, data.getRoleDesc());

		Action.scrollDown("200");
		List<WebElement> allCheckbox = driver.findElements(By.xpath("//div[@class='checkbox']"));

		for (WebElement ele : allCheckbox) {
			if (!ele.isSelected()) {
				ele.click();

				Action.scrollDown("20");
			}
		}
		btnSave.click();

	}

	public void addUser() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddRole, 06);
		btnMenu.click();
		Thread.sleep(10000);
		btnOrderMenu.click();
		btnMainMenu.click();
		Common.waitForElementPresent(driver, lkOmniAdministration, 06);
		lkOmniAdministration.click();
		Common.waitForElementPresent(driver, lkUserMgmt, 06);
		lkUserMgmt.click();
		Common.waitForElementPresent(driver, lkUsers, 06);
		lkUsers.click();
		driver.get(driver.getCurrentUrl());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		btnAddUser.click();
		chkRom.click();
		Action.selectByVisibleText(drpdwnContext, "  All TMSNA sellers and nodes");
		userId = roleName.toUpperCase();
		WebElement option = driver.findElement(By.xpath("//option[@value='" + userId + "']"));
		Actions action = new Actions(driver);
		action.moveToElement(option);
		action.perform();
		option.click();
		Action.scrollDown("500");
		Action.enter(txtUser, roleName);
		System.out.println("User name is:-" + roleName);
		// Action.enter(txtUserId.get(1), roleName+"@TMSNA");
		Action.scrollDown("200");
		Action.enter(txtPwd, data.getPwd());
		Action.enter(txtCnfmPwd, data.getPwd());
		Action.scrollDown("200");
		txtRstPwd.click();
		Action.selectByValue(drpdwnCategory, "ORGANIZATION");
		Action.enter(firstName, data.getFirstName());
		Action.enter(lastName, data.getLastName());
		Action.scrollDown("200");
		Action.enter(displayName, roleName);
		Action.enter(txtEmail, data.getUserEmail());
		Action.enter(txtphone, data.getUserPhone());
		Action.selectByValue(drpdwnTimeZone, "Atlantic/Canary");
		btnUserSave.click();
	}

	public void searchByUserId() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		Action.enter(searchUserId, roleName + "@tmsna");
		btnSearch.click();
		Assert.assertEquals(userSearchMsg.getText(), RomuiEnumValues.USER_FOUND.getMessage(),
				"User has not been found");

	}

	public void userNotFound() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		Action.enter(searchUserId, data.getInvalidUser());
		btnSearch.click();
		Assert.assertEquals(userNotFound.getText(), RomuiEnumValues.USER_NOTFOUND.getMessage(), "User has been found");

	}

	public void searchByFirstName() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		advancedSearch.click();
		Action.enter(firstnameSearch, data.getUserbyfname());
		btnSearch.click();
		int row = tableRows.size() - 1;
		Assert.assertEquals(userSearchMsg.getText(), row + " Users Found", "User has not been found");

	}

	public void searchByLastName() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		advancedSearch.click();
		Action.enter(lastnameSearch, data.getUserbylname());
		btnSearch.click();
		int row = tableRows.size() - 1;
		Assert.assertEquals(userSearchMsg.getText(), row + " Users Found", "User has not been found");

	}

	public void searchByEmail() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		advancedSearch.click();
		Action.enter(emailSearch, data.getUserEmail());
		btnSearch.click();
		int row = tableRows.size() - 1;
		Assert.assertEquals(userSearchMsg.getText(), row + " Users Found", "User has not been found");

	}

	public void searchByNode() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		advancedSearch.click();
		Action.selectByValue(drpdwnNodeSearch, "TMSNA.*");
		btnSearch.click();
		int row = tableRows.size() - 1;
		Assert.assertEquals(userSearchMsg.getText(), row + " Users Found", "User has not been found");

	}

	public void editUser() throws Exception {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		searchByUserId();
		Action.waitForElementToBeClickable(driver, btnAddUser, 30);
		CommonElementsPage.clickActionsIcon(1, 4, 0, 1);
		Action.scrollDown("500");
		Action.enter(txtResetPwd, data.getrstPwd());
		Action.enter(txtCnfrmResetPwd, data.getrstPwd());
		btnUserSave.click();

	}

	public void deleteUser() throws Exception {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		searchByUserId();
		Action.waitForElementToBeClickable(driver, btnAddUser, 30);
		CommonElementsPage.clickActionsIconDelete(1, 4, 0, 1);
		btnConfirm.click();

	}

	public void editRole() throws Exception {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		int rowNo = CommonElementsPage.getRoleRowNum(userId);
		Action.waitForElementToBeClickable(driver, btnAddUser, 30);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0, 1);
		chkAtpRules.click();
		btnSave.click();

	}

	public void deleteRole() throws Exception {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		int rowNo = CommonElementsPage.getRoleRowNum(userId);
		Action.waitForElementToBeClickable(driver, btnAddUser, 30);
		CommonElementsPage.clickActionsIconDelete(1, 4, 0, 1);
		btnRoleConfirm.click();

	}

	public void userValidation() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddUser, 06);
		btnAddUser.click();
		btnUserSave.click();
		Assert.assertEquals(txtErrorMsg.getText(), RomuiEnumValues.USER_VALIDATION.getMessage(),
				"User Validation message has not been found");

	}

	public void roleValidation() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = UserManagementData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddRole, 06);
		btnAddRole.click();
		btnSave.click();
		Assert.assertEquals(txtSuccessMsg.getText(), RomuiEnumValues.ROLE_VALIDATION.getMessage(),
				"User Validation message has not been found");

	}

}
