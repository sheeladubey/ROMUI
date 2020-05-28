package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.ServiceGroupConfigsData;
import com.gsicommerce.romui.selenium.utilities.Action;

public class ServiceGroupConfigsPage {
	
	WebDriver driver;
	Environment env;
	
	private ServiceGroupConfigsData data;

	public ServiceGroupConfigsPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Basic Seller Configurations')]")
	@CacheLookup
	WebElement lkBasicSellerConfig;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Invoice Shipment Service Group')]")
	@CacheLookup
	WebElement lkInvoiceShipmtServcGrp;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Release Service Group')]")
	@CacheLookup
	WebElement lkReleaseServcGrp;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Return Service Group')]")
	@CacheLookup
	WebElement lkReturnServcGrp;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Sales Order Create Service Group')]")
	@CacheLookup
	WebElement lkBSalesOrderCreateServcGrp;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Schedule Service Group')]")
	@CacheLookup
	WebElement lkSchlServcGrp;
	
	@FindBy(how = How.XPATH, using = "//li/a[starts-with(text(),'Shipment Service Group')]")
	@CacheLookup
	WebElement lkShipmtServcGrp;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_basic_attributes_header_logo_url_attributes_value")
	@CacheLookup
	private WebElement txtHeaderLogoURL;	
	
	@FindBy(how = How.CSS, using = "#seller_service_group_basic_attributes_menu_logo_url_attributes_value")
	@CacheLookup
	private WebElement txtMenuLogoURL;
		
	@FindBy(how = How.CSS, using = "#seller_service_group_basic_attributes_cancel_reasons_attributes_0_id")
	@CacheLookup
	private WebElement txtCancelReasonCode;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_basic_attributes_cancel_reasons_attributes_0_description")
	@CacheLookup
	private WebElement txtCancelReason;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Cancel Reason')]")
	@CacheLookup
	public WebElement btnAddCanclReason;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_invoice_shipment_attributes_publish_invoice_milestones_attributes_0_id")
	@CacheLookup
	private WebElement drpdwnInvoiceVal;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_invoice_shipment_attributes_publish_invoice_milestones_attributes_0_description")
	@CacheLookup
	private WebElement drpdwnInvoiceSource;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Milestone')]")
	@CacheLookup
	public WebElement btnAddMilestone;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_invoice_shipment_attributes_non_sellable_return_reason_codes_attributes_0_id")
	@CacheLookup
	private WebElement txtNonSellableReturnReasonCode;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_invoice_shipment_attributes_non_sellable_return_reason_codes_attributes_0_description")
	@CacheLookup
	private WebElement txtNonSellableReturnReason;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Return Reason')]")
	@CacheLookup
	public WebElement btnAddReturnReason;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_release_attributes_ftc_rules_setup_attributes_0_entry_type")
	@CacheLookup
	private WebElement drpdwnFTCEntryType;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_release_attributes_ftc_rules_setup_attributes_0_ship_to_country")
	@CacheLookup
	private WebElement drpdwnFTCShipToCountry;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_release_attributes_ftc_rules_setup_attributes_0_flow")
	@CacheLookup
	private WebElement drpdwnFTCFlow;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_release_attributes_ftc_rules_setup_attributes_0_type_of_order")
	@CacheLookup
	private WebElement drpdwnFTCTypeOfOrder;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_release_attributes_ftc_rules_setup_attributes_0_number_of_hours")
	@CacheLookup
	private WebElement txtNoOfHrs;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add FTC Rule')]")
	@CacheLookup
	public WebElement btnAddFTCRule;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_return_service_attributes_return_window_days_attributes_value")
	@CacheLookup
	private WebElement txtReturnWindowDays;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_return_service_attributes_return_location_override_attributes_value")
	@CacheLookup
	private WebElement drpdwnReturnLocOverride;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_return_service_attributes_return_eligible_ranks_attributes_0_id")
	@CacheLookup
	private WebElement txtReturnEligibleRank;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_return_service_attributes_return_eligible_ranks_attributes_0_description")
	@CacheLookup
	private WebElement txtReturnEligibleDesc;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_return_service_attributes_return_refund_charge_rules_attributes_0_value")
	@CacheLookup
	private WebElement drpdwnReturnRefundChargeRule;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Refund Charge Rule')]")
	@CacheLookup
	public WebElement btnAddRefundChargeRule;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_return_service_attributes_return_reason_codes_attributes_0_id")
	@CacheLookup
	private WebElement txtReturnReasonCode;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_return_service_attributes_return_reason_codes_attributes_0_description")
	@CacheLookup
	private WebElement txtReturnReason;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_return_service_attributes_return_product_condition_codes_attributes_0_id")
	@CacheLookup
	private WebElement txtReturnProdCondCode;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_return_service_attributes_return_product_condition_codes_attributes_0_description")
	@CacheLookup
	private WebElement txtReturnProdCondReason;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Product Condition Code')]")
	@CacheLookup
	public WebElement btnAddProdCondCode;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_sales_order_create_attributes_iship_solution_verision_attributes_value")
	@CacheLookup
	private WebElement drpdwnIShipSolVer;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_sales_order_create_attributes_tax_admin_address_type_attributes_value")
	@CacheLookup
	private WebElement drpdwnAdminAddrTaxCalc;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Enable Origin Based Tax')]")
	@CacheLookup
	public WebElement chkboxEnableOrgnBasedTax;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_sales_order_create_attributes_tax_strategies_attributes_0_id")
	@CacheLookup
	private WebElement drpdwnStrategyVal;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_sales_order_create_attributes_tax_strategies_attributes_0_description")
	@CacheLookup
	private WebElement drpdwnEntryType;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Strategy')]")
	@CacheLookup
	public WebElement btnAddStrategy;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[schedule_attributes][carrier_exception_required_attributes][value]']")
	@CacheLookup
	private WebElement chkboxCarrierExceptn;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[schedule_attributes][max_split_exception_required_attributes][value]']")
	@CacheLookup
	private WebElement chkboxMaxSplitExceptn;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[schedule_attributes][max_resource_exception_required_attributes][value]']")
	@CacheLookup
	private WebElement chkboxMaxResrceExceptn;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_schedule_attributes_backordered_retry_minutes_attributes_value")
	@CacheLookup
	private WebElement txtBackOrdrdRetryMin;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][pin_required_attributes][value]']")
	@CacheLookup
	private WebElement chkboxActive;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_pin_length_attributes_value")
	@CacheLookup
	private WebElement txtPinLength;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][require_pick_ticket_print_attributes][value]']")
	@CacheLookup
	private WebElement chkboxPickTkt;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][require_hold_ticket_print_attributes][value]']")
	@CacheLookup
	private WebElement chkboxHoldTkt;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][require_customer_reciept_print_attributes][value]']")
	@CacheLookup
	private WebElement chkboxCustRecpt;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][require_pack_slip_print_attributes][value]']")
	@CacheLookup
	private WebElement chkboxPackSlip;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][require_delivery_slip_print_attributes][value]']")
	@CacheLookup
	private WebElement chkboxDelvrySlip;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][require_return_receipt_print_attributes][value]']")
	@CacheLookup
	private WebElement chkboxReturnRecpt;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_ispu_sla_attributes_start_pick_approaching")
	@CacheLookup
	private WebElement txtISPUStPickProcessApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_ispu_sla_attributes_start_pick_expired")
	@CacheLookup
	private WebElement txtISPUStPickProcessExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_ispu_sla_attributes_complete_picking_approaching")
	@CacheLookup
	private WebElement txtISPUCompltPickingApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_ispu_sla_attributes_complete_picking_expired")
	@CacheLookup
	private WebElement txtISPUCompltPickingExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_ispu_sla_attributes_customer_pickup_approaching")
	@CacheLookup
	private WebElement txtISPUCustPickupApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_ispu_sla_attributes_customer_pickup_expired")
	@CacheLookup
	private WebElement txtISPUCustPickupExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sfs_sla_attributes_start_pick_approaching")
	@CacheLookup
	private WebElement txtSFSStPickProcessApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sfs_sla_attributes_start_pick_expired")
	@CacheLookup
	private WebElement txtSFSStPickProcessExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sfs_sla_attributes_complete_picking_approaching")
	@CacheLookup
	private WebElement txtSFSCompltPickingApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sfs_sla_attributes_complete_picking_expired")
	@CacheLookup
	private WebElement txtSFSCompltPickingExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sfs_sla_attributes_complete_packing_approaching")
	@CacheLookup
	private WebElement txtSFSCompltPackingApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sfs_sla_attributes_complete_packing_expired")
	@CacheLookup
	private WebElement txtSFSCompltPackingExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller[sfs_sla_attributes][seller_auto_resource]']")
	@CacheLookup
	private WebElement chkboxSFSAutoResource;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sfs_sla_attributes_pick_expired_cancel_sla")
	@CacheLookup
	private WebElement txtSFSPickExprdCancelSLA;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sts_sla_attributes_start_pick_approaching")
	@CacheLookup
	private WebElement txtSTSStPickProcessApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sts_sla_attributes_start_pick_expired")
	@CacheLookup
	private WebElement txtSTSStPickProcessExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sts_sla_attributes_complete_picking_approaching")
	@CacheLookup
	private WebElement txtSTSCompltPickingApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sts_sla_attributes_complete_picking_expired")
	@CacheLookup
	private WebElement txtSTSCompltPickingExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sts_sla_attributes_complete_packing_approaching")
	@CacheLookup
	private WebElement txtSTSCompltPackingApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sts_sla_attributes_complete_packing_expired")
	@CacheLookup
	private WebElement txtSTSCompltPackingExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sts_sla_attributes_customer_pickup_approaching")
	@CacheLookup
	private WebElement txtSTSCustPickupApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sts_sla_attributes_customer_pickup_expired")
	@CacheLookup
	private WebElement txtSTSCustPickupExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller[sts_sla_attributes][seller_auto_resource]']")
	@CacheLookup
	private WebElement chkboxSTSAutoResource;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_sts_sla_attributes_pick_expired_cancel_sla")
	@CacheLookup
	private WebElement txtSTSPickExprdCancelSLA;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_associate_delivery_sla_attributes_start_pick_approaching")
	@CacheLookup
	private WebElement txtADStPickProcessApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_associate_delivery_sla_attributes_start_pick_expired")
	@CacheLookup
	private WebElement txtADStPickProcessExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_associate_delivery_sla_attributes_complete_picking_approaching")
	@CacheLookup
	private WebElement txtADCompltPickingApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_associate_delivery_sla_attributes_complete_picking_expired")
	@CacheLookup
	private WebElement txtADCompltPickingExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_associate_delivery_sla_attributes_complete_packing_approaching")
	@CacheLookup
	private WebElement txtADCmpltPackngApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_associate_delivery_sla_attributes_complete_packing_expired")
	@CacheLookup
	private WebElement txtADCmpltPackngExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_associate_delivery_sla_attributes_customer_delivery_approaching")
	@CacheLookup
	private WebElement txtADCustDelvryApprchg;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_associate_delivery_sla_attributes_customer_delivery_expired")
	@CacheLookup
	private WebElement txtADCustDelvryExpired;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_pick_decline_reasons_attributes_0_id")
	@CacheLookup
	private WebElement txtPickDeclineReasonCode;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_pick_decline_reasons_attributes_0_description")
	@CacheLookup
	private WebElement txtPickDeclineReason;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Decline Reason')]")
	@CacheLookup
	public List<WebElement> btnAddDeclineReason;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_pickup_decline_reasons_attributes_0_id")
	@CacheLookup
	private WebElement txtPickupDeclineReasonCode;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_pickup_decline_reasons_attributes_0_description")
	@CacheLookup
	private WebElement txtPickupDeclineReason;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_pack_decline_reasons_attributes_0_id")
	@CacheLookup
	private WebElement txtPackDeclineReasonCode;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_pack_decline_reasons_attributes_0_description")
	@CacheLookup
	private WebElement txtPackDeclineReason;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_check_in_decline_reasons_attributes_0_id")
	@CacheLookup
	private WebElement txtCheckInDeclineReasonCode;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_check_in_decline_reasons_attributes_0_description")
	@CacheLookup
	private WebElement txtCheckInDeclineReason;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_applicable_maketplace_orders_attributes_0_value")
	@CacheLookup
	private WebElement txtMrktPlaceOrderEntryType;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Entry Type')]")
	@CacheLookup
	public WebElement btnAddEntryType;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][hfr_applicable_attributes][value]']")
	@CacheLookup
	private WebElement chkboxHFRAppl;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][put_aways_required_attributes][value]']")
	@CacheLookup
	private WebElement chkboxPutawayReqd;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_pickup_expired_cancel_minutes_attributes_value")
	@CacheLookup
	private WebElement txtPickupExpiredCancelMin;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_package_configurations_attributes_0_id")
	@CacheLookup
	private WebElement txtPackageID;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_package_configurations_attributes_0_weight")
	@CacheLookup
	private WebElement txtWeight;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_package_configurations_attributes_0_material_weight")
	@CacheLookup
	private WebElement txtPkgMaterialWt;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_package_configurations_attributes_0_height")
	@CacheLookup
	private WebElement txtHeight;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_package_configurations_attributes_0_width")
	@CacheLookup
	private WebElement txtWidth;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_package_configurations_attributes_0_length")
	@CacheLookup
	private WebElement txtLength;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_package_configurations_attributes_0_weight_uom")
	@CacheLookup
	private WebElement drpdwnWeightUnits;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_package_configurations_attributes_0_material_weight_uom")
	@CacheLookup
	private WebElement drpdwnPkgMtWtUnits;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_package_configurations_attributes_0_height_uom")
	@CacheLookup
	private WebElement drpdwnHeighUnits;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_package_configurations_attributes_0_width_uom")
	@CacheLookup
	private WebElement drpdwnWidthUnits;
	
	@FindBy(how = How.CSS, using = "#seller_service_group_shipment_attributes_package_configurations_attributes_0_length_uom")
	@CacheLookup
	private WebElement drpdwnLengthUnits;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add a Package')]")
	@CacheLookup
	public WebElement btnAddAPackage;
	
	@FindBy(how = How.CSS, using = "[name='seller_service_group[shipment_attributes][default_package_index]'][value='0']")
	@CacheLookup
	private WebElement rbDefaultPkg;
	
	@FindBy(how = How.CSS, using = "[value='sms']")
	@CacheLookup
	private WebElement rbSMS;
	
	@FindBy(how = How.CSS, using = "[value='email']")
	@CacheLookup
	private WebElement rbEmail;
	
	@FindBy(how = How.CSS, using = "[name='seller_service_group[shipment_attributes][ispu_push_notification_config_attributes][backroom_pick_approaching]'][type='checkbox']")
	@CacheLookup
	private WebElement chkboxISPUBRPickApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ispu_push_notification_config_attributes][backroom_pick_expired]']")
	@CacheLookup
	private WebElement chkboxISPUBRPickExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ispu_push_notification_config_attributes][customer_pick_approaching]']")
	@CacheLookup
	private WebElement chkboxISPUCustPickApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ispu_push_notification_config_attributes][customer_pick_expired]']")
	@CacheLookup
	private WebElement chkboxISPUCustPickExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ispu_push_notification_config_attributes][pick_ticket_generate_approaching]']")
	@CacheLookup
	private WebElement chkboxISPUPickTkGenerateApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ispu_push_notification_config_attributes][pick_ticket_generate_expired]']")
	@CacheLookup
	private WebElement chkboxISPUPickTkGenerateExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ispu_push_notification_config_attributes][fulfillment_order_create]']")
	@CacheLookup
	private WebElement chkboxISPUNewOrderWaitingToPick;
	
	
	@FindBy(how = How.CSS, using = "[name='seller_service_group[shipment_attributes][sfs_push_notification_config_attributes][backroom_pick_approaching]'][type='checkbox']")
	@CacheLookup
	private WebElement chkboxSFSBRPickApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sfs_push_notification_config_attributes][backroom_pick_expired]']")
	@CacheLookup
	private WebElement chkboxSFSBRPickExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sfs_push_notification_config_attributes][pack_shipment_approaching]']")
	@CacheLookup
	private WebElement chkboxSFSPackShmptApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sfs_push_notification_config_attributes][pack_shipment_expired]']")
	@CacheLookup
	private WebElement chkboxSFSPackShmptExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sfs_push_notification_config_attributes][pick_ticket_generate_approaching]']")
	@CacheLookup
	private WebElement chkboxSFSPickTkGenerateApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sfs_push_notification_config_attributes][pick_ticket_generate_expired]']")
	@CacheLookup
	private WebElement chkboxSFSPickTkGenerateExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sfs_push_notification_config_attributes][fulfillment_order_create]']")
	@CacheLookup
	private WebElement chkboxSFSNewOrderWaitingToPick;
	
	
	@FindBy(how = How.CSS, using = "[name='seller_service_group[shipment_attributes][sts_push_notification_config_attributes][backroom_pick_approaching]'][type='checkbox']")
	@CacheLookup
	private WebElement chkboxSTSBRPickApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sts_push_notification_config_attributes][backroom_pick_expired]']")
	@CacheLookup
	private WebElement chkboxSTSBRPickExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sts_push_notification_config_attributes][customer_pick_approaching]']")
	@CacheLookup
	private WebElement chkboxSTSCustPickApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sts_push_notification_config_attributes][customer_pick_expired]']")
	@CacheLookup
	private WebElement chkboxSTSCustPickExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sts_push_notification_config_attributes][pack_shipment_approaching]']")
	@CacheLookup
	private WebElement chkboxSTSPackShpmtApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sts_push_notification_config_attributes][pack_shipment_expired]']")
	@CacheLookup
	private WebElement chkboxSTSPackShpmtExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sts_push_notification_config_attributes][pick_ticket_generate_approaching]']")
	@CacheLookup
	private WebElement chkboxSTSPickTkGenerateApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sts_push_notification_config_attributes][pick_ticket_generate_expired]']")
	@CacheLookup
	private WebElement chkboxSTSPickTkGenerateExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][sts_push_notification_config_attributes][fulfillment_order_create]']")
	@CacheLookup
	private WebElement chkboxSTSNewOrderWaitingToPick;
	
	@FindBy(how = How.CSS, using = "[name='seller_service_group[shipment_attributes][ad_push_notification_config_attributes][backroom_pick_approaching]'][type='checkbox']")
	@CacheLookup
	private WebElement chkboxADBRPickApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ad_push_notification_config_attributes][backroom_pick_expired]']")
	@CacheLookup
	private WebElement chkboxADBRPickExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ad_push_notification_config_attributes][delivery_approaching]']")
	@CacheLookup
	private WebElement chkboxADDelvryApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ad_push_notification_config_attributes][delivery_expired]']")
	@CacheLookup
	private WebElement chkboxADDelvryExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ad_push_notification_config_attributes][pack_shipment_approaching]']")
	@CacheLookup
	private WebElement chkboxADPackShpmtApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ad_push_notification_config_attributes][pack_shipment_expired]']")
	@CacheLookup
	private WebElement chkboxADPackShpmtExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ad_push_notification_config_attributes][pick_ticket_generate_approaching]']")
	@CacheLookup
	private WebElement chkboxADPickTkGenerateApprchng;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ad_push_notification_config_attributes][pick_ticket_generate_expired]']")
	@CacheLookup
	private WebElement chkboxADPickTkGenerateExpired;
	
	@FindBy(how = How.CSS, using = "[type='checkbox'][name='seller_service_group[shipment_attributes][ad_push_notification_config_attributes][fulfillment_order_create]']")
	@CacheLookup
	private WebElement chkboxADNewOrderWaitingToPick;
	
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Remove')]")
	@CacheLookup
	public WebElement iconRemove;
	
	@FindBy(how = How.CSS, using = ".alert-info")
	@CacheLookup
	public WebElement txtEditSuccessMsg;
	
			
	public void editSellerServiceGroupConfigs() throws JsonParseException, JsonMappingException, IOException {
		data = ServiceGroupConfigsData.get(env.getFileLocation());
		//Basic Seller Configruations
		Action.enter(txtHeaderLogoURL, data.getHeaderLogoURL());
		Action.enter(txtMenuLogoURL, data.getMenuLogoURL());
		Action.enter(txtCancelReasonCode, data.getCancelCode());
		Action.enter(txtCancelReason, data.getCancelReason());
		
		//Invoice ShipmentService Group
		lkInvoiceShipmtServcGrp.click();
		Action.selectByIndex(drpdwnInvoiceSource, 2);
		Action.selectByVisibleText(drpdwnInvoiceVal, data.getPublishInvoiceValue());
		Action.enter(txtNonSellableReturnReasonCode, data.getReturnReasonCode());
		Action.enter(txtNonSellableReturnReason, data.getReturnReason());
		
		//Return Service Group
		lkReturnServcGrp.click();
		Action.enter(txtReturnWindowDays, data.getReturnWindowDays());
		Action.selectByVisibleText(drpdwnReturnLocOverride, data.getReturnLocOverride());
		Action.enter(txtReturnEligibleRank, data.getReturnEligibleRank());
		Action.enter(txtReturnEligibleDesc, data.getReturnEligibleRankDesc());
		Action.selectByVisibleText(drpdwnReturnRefundChargeRule, data.getReturnRefundChargeRule());
		Action.enter(txtReturnReasonCode, data.getReturnReasonCode());
		Action.enter(txtReturnReason, data.getReturnReason());
		Action.enter(txtReturnProdCondCode, data.getReturnRefundProductCondCode());
		Action.enter(txtReturnProdCondReason, data.getReturnRefundProductCondReason());
		Action.scrollDown("-500");
		
		//Sales Order Create Service Group
		lkBSalesOrderCreateServcGrp.click();
		Action.selectByVisibleText(drpdwnIShipSolVer, data.getiShipSolVer());
		Action.selectByVisibleText(drpdwnAdminAddrTaxCalc, data.getAdminAddrTaxCalc());
		if(!chkboxEnableOrgnBasedTax.isEnabled()) {
		chkboxEnableOrgnBasedTax.click();
		}
		Action.selectByVisibleText(drpdwnStrategyVal, data.getTaxStrategyVal());
		Action.selectByVisibleText(drpdwnEntryType, data.getTaxEntryType());
		
		//Schedule Service Group
		lkSchlServcGrp.click();
		chkboxCarrierExceptn.click();
		chkboxMaxSplitExceptn.click();
		chkboxMaxResrceExceptn.click();
		Action.enter(txtBackOrdrdRetryMin, data.getBackOrderedRetryMin());
		
		//Shipment Service Group
		lkShipmtServcGrp.click();
		if(!chkboxActive.isEnabled()) {
		chkboxActive.click();
		Action.enter(txtPinLength, data.getPinLength());		
		chkboxPickTkt.click();
		chkboxHoldTkt.click();
		chkboxCustRecpt.click();
		chkboxPackSlip.click();
		chkboxDelvrySlip.click();
		chkboxReturnRecpt.click();
		}
		Action.enter(txtISPUStPickProcessApprchg, data.getSsgISPUStPickProcessApprng());
		Action.enter(txtISPUStPickProcessExpired, data.getSsgISPUStPickProcessExpired());
		Action.enter(txtISPUCompltPickingApprchg, data.getSsgISPUCompletePickingApprng());
		Action.enter(txtISPUCompltPickingExpired, data.getSsgISPUCompletePickingExpired());
		Action.enter(txtISPUCustPickupApprchg, data.getSsgISPUCustPickupApprng());
		Action.enter(txtISPUCustPickupExpired, data.getSsgISPUCustPickupExpired());
		Action.enter(txtSFSStPickProcessApprchg, data.getSsgSFSStPickProcessApprng());
		Action.enter(txtSFSStPickProcessExpired, data.getSsgSFSStPickProcessExpired());
		Action.enter(txtSFSCompltPickingApprchg, data.getSsgSFSCompletePickingApprng());
		Action.enter(txtSFSCompltPickingExpired, data.getSsgSFSCompletePickingExpired());
		Action.enter(txtSFSCompltPackingApprchg, data.getSsgSFSCompletePackingApprng());
		Action.enter(txtSFSCompltPackingExpired, data.getSsgSFSCompletePackingExpired());
		if(!chkboxSFSAutoResource.isEnabled()) {
		chkboxSFSAutoResource.click();
		Action.enter(txtSFSPickExprdCancelSLA, data.getSsgSFSPickExpiredCanclSLA());
		}
		
		Action.enter(txtSTSStPickProcessApprchg, data.getSsgSTSStPickProcessApprng());
		Action.enter(txtSTSStPickProcessExpired, data.getSsgSTSStPickProcessExpired());
		Action.enter(txtSTSCompltPickingApprchg, data.getSsgSTSCompletePickingApprng());
		Action.enter(txtSTSCompltPickingExpired, data.getSsgSTSCompletePickingExpired());
		Action.enter(txtSTSCompltPackingApprchg, data.getSsgSTSCompletePackingApprng());
		Action.enter(txtSTSCompltPackingExpired, data.getSsgSTSCompletePackingExpired());
		Action.enter(txtSTSCustPickupApprchg, data.getSsgSTSCustPickupApprng());
		Action.enter(txtSTSCustPickupExpired, data.getSsgSTSCustPickupExpired());
		if(!chkboxSTSAutoResource.isEnabled()) {
		chkboxSTSAutoResource.click();
		Action.enter(txtSTSPickExprdCancelSLA, data.getSsgSTSPickExpiredCanclSLA());
		}
		
		Action.enter(txtADStPickProcessApprchg, data.getSsgAssctStPickProcessApprng());
		Action.enter(txtADStPickProcessExpired, data.getSsgAssctStPickProcessExpired());
		Action.enter(txtADCompltPickingApprchg, data.getSsgAssctCompletePickingApprng());
		Action.enter(txtADCompltPickingExpired, data.getSsgAssctCompletePickingExpired());
		Action.enter(txtADCmpltPackngApprchg, data.getSsgAssctCmpltPackingApprng());
		Action.enter(txtADCmpltPackngExpired, data.getSsgAssctCmpltPackingExpired());
		Action.enter(txtADCustDelvryApprchg, data.getSsgAssctCustDelvryApprng());
		Action.enter(txtADCustDelvryExpired, data.getSsgAssctCustDelvryExpired());
		
		Action.enter(txtPickDeclineReasonCode, data.getSsgPickDeclineReasonCode());
		Action.enter(txtPickDeclineReason, data.getSsgPickDeclineReason());
		
		Action.enter(txtPickupDeclineReasonCode, data.getSsgCustPickupDeclineReasonCode());
		Action.enter(txtPickupDeclineReason, data.getSsgCustPickupDeclineReason());
		
		Action.enter(txtPackDeclineReasonCode, data.getSsgPackDeclineReasonCode());
		Action.enter(txtPackDeclineReason, data.getSsgPackDeclineReason());
		
		Action.enter(txtCheckInDeclineReasonCode, data.getSsgCheckInDeclineReasonCode());
		Action.enter(txtCheckInDeclineReason, data.getSsgCheckInDeclineReason());
		
		Action.enter(txtMrktPlaceOrderEntryType, data.getMarketPlaceOrderEntryType());
		if(!chkboxHFRAppl.isEnabled()) {
		chkboxHFRAppl.click();
		}
		Action.scrollDown("500");
		if(!chkboxPutawayReqd.isEnabled()) {
		chkboxPutawayReqd.click();		
		}
		Action.enter(txtPickupExpiredCancelMin, data.getPickupExpiredCnclMin());
		Action.enter(txtPackageID, data.getPackageID());
		Action.enter(txtWeight, data.getPackageWeight());
		Action.selectByIndex(drpdwnWeightUnits, 1);
		Action.enter(txtPkgMaterialWt, data.getPackngMaterialWeight());
		Action.selectByIndex(drpdwnPkgMtWtUnits, 1);
		Action.enter(txtHeight, data.getPackageHeight());
		Action.selectByIndex(drpdwnHeighUnits, 1);
		Action.enter(txtWidth, data.getPackagewidth());
		Action.selectByIndex(drpdwnWidthUnits, 1);
		Action.enter(txtLength, data.getPackageLength());
		Action.selectByIndex(drpdwnLengthUnits, 1);
		rbDefaultPkg.click();
		
		//Push Notifications
		rbSMS.click();
		if(!chkboxISPUBRPickApprchng.isEnabled()) {		
		chkboxISPUBRPickApprchng.click();
		chkboxISPUBRPickExpired.click();
		Action.scrollDown("500");
		chkboxISPUCustPickApprchng.click();
		chkboxISPUCustPickExpired.click();
		chkboxISPUPickTkGenerateApprchng.click();
		chkboxISPUPickTkGenerateExpired.click();
		chkboxISPUNewOrderWaitingToPick.click();
		
		chkboxSFSBRPickApprchng.click();
		chkboxSFSBRPickExpired.click();
		chkboxSFSPackShmptApprchng.click();
		chkboxSFSPackShmptExpired.click();
		chkboxSFSPickTkGenerateApprchng.click();
		chkboxSFSPickTkGenerateExpired.click();
		chkboxSFSNewOrderWaitingToPick.click();
		
		chkboxSTSBRPickApprchng.click();
		chkboxSTSBRPickExpired.click();
		chkboxSTSCustPickApprchng.click();
		chkboxSTSCustPickExpired.click();
		Action.scrollDown("500");
		chkboxSTSPackShpmtApprchng.click();
		chkboxSTSPackShpmtExpired.click();		
		chkboxSTSPickTkGenerateApprchng.click();
		chkboxSTSPickTkGenerateExpired.click();
		chkboxSTSNewOrderWaitingToPick.click();
		
		chkboxADBRPickApprchng.click();
		chkboxADBRPickExpired.click();
		Action.scrollDown("500");
		chkboxADPackShpmtApprchng.click();
		chkboxADPackShpmtExpired.click();
		chkboxADDelvryApprchng.click();
		chkboxADDelvryExpired.click();
		chkboxADPickTkGenerateApprchng.click();
		chkboxADPickTkGenerateExpired.click();
		chkboxADNewOrderWaitingToPick.click();		
		}
		CommonElementsPage.clickOnSaveBtn();
	}

}	
