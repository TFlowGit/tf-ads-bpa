package com.techflow.openfda.drug.server;

import com.techflow.openfda.drug.usecase.FindDrugRequest;

public class DescribeDrugRequest implements FindDrugRequest
{
	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
