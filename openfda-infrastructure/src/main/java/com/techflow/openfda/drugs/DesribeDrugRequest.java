package com.techflow.openfda.drugs;

import javax.ws.rs.PathParam;

public class DesribeDrugRequest
{
	private String name;

	@PathParam("name")
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
