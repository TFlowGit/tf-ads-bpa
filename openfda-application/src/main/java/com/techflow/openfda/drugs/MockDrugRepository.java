package com.techflow.openfda.drugs;

public class MockDrugRepository extends NaiveInMemoryDrugRepository
{
	public MockDrugRepository() {
		add("Aspirin");
		add("Tylenol");
		add("Tylenol PM");
	}
}
