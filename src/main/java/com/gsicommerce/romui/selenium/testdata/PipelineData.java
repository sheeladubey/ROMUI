package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsicommerce.romui.selenium.utilities.Common;

public class PipelineData {

	@JsonProperty("pipelineName")
	String pipelineName;

	public String getPipelineName() {
		String pipelinename = pipelineName + Common.generateRandomID("Auto");
		// System.out.println("pipeline name is:" +pipelineName+
		// Common.generateRandomID("Auto"));
		// System.out.println("pipeline name is:" +pipelinename);
		// return pipelineName+ Common.generateRandomID("Auto");
		return pipelinename;
	}

	public static PipelineData get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(filename), PipelineData.class);
	}

}
