package com.techflow.openfda.drug.client;

import java.util.ArrayList;
import java.util.List;

public class DrugRepositoryImpl implements DrugRepository
{
	@Override
	public List<String> startsWith(String drugName)
	{
		final ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Tylenol");
		arrayList.add("Tylenol PM");
		return arrayList;
	}
}
