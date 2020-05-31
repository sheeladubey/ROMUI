package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsicommerce.romui.selenium.utilities.Common;

public class UserManagementData {

	@JsonProperty("roleName")
	String roleName;

	@JsonProperty("roleDescription")
	String roleDescription;

	@JsonProperty("userPassword")
	String userPassword;

	@JsonProperty("fName")
	String fName;

	@JsonProperty("lName")
	String lName;

	@JsonProperty("userPhone")
	String userPhone;

	@JsonProperty("userEmail")
	String userEmail;

	@JsonProperty("invaliduserId")
	String invaliduserId;

	@JsonProperty("fNameSearch")
	String fNameSearch;

	@JsonProperty("lNameSearch")
	String lNameSearch;

	@JsonProperty("userResetPassword")
	String userResetPassword;

	public String getRoleName() {
		return roleName + Common.generateRandomID("Auto");
	}

	public static UserManagementData get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(filename), UserManagementData.class);
	}

	public String getRoleDesc() {
		return roleDescription;
	}

	public String getPwd() {
		return userPassword;
	}

	public String getrstPwd() {
		return userResetPassword;
	}

	public String getFirstName() {
		return fName + Common.generateRandomID("T");
	}

	public String getLastName() {
		return lName + Common.generateRandomID("T");
	}

	public String getUserPhone() {
		return userPhone + Common.generateRandomID("2");
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserbylname() {
		return lNameSearch;
	}

	public String getInvalidUser() {
		return invaliduserId;
	}

	public String getUserbyfname() {
		return fNameSearch;
	}

}
