package com.techflow.openfda.drug.usecase;

public interface FindDrugResponse
{
	void setName(String name);

	void setPurpose(String purpose);

	void setDosage(String dosage);

	void setActive(String active);

	void setInactive(String inactive);

	void setWarnings(String warnings);

	void setDoNotUse(String doNotUse);

	void setAdverseReactions(String adverseReactions);

	void setStopUse(String stopUse);

	void setAskDoctor(String askDoctor);

	void setIndicationsAndUsage(String indicationsAndUsage);

	void setNotFound(boolean notFound);
}
