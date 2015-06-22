package com.techflow.openfda.drug.client;

import com.techflow.openfda.GatewayException;
import com.techflow.openfda.drugs.DrugEffect;
import com.techflow.openfda.drugs.DrugLabel;

public class MockOpenFdaGateway implements OpenFdaGateway
{
	public GatewayException exception;

	@Override
	public DrugLabel getLabel(String label) throws GatewayException
	{
		if (exception != null) {
			throw exception;
		}

		if (label == null) {
			return null;
		}

		switch (label) {
		case "aspirin":
			final DrugLabel drug = new DrugLabel();
			drug.setIndicationsAndUsage("indications");
			drug.setBrandName("brand name");
			drug.setGenericName("generic name");
			drug.setPurpose("purpose");
			drug.setActive("active");
			drug.setInactive("inactive");
			drug.setWarnings("warnings");
			drug.setDoNotUse("do not use");
			drug.setAskDoctor("ask doctor");
			drug.setAskDoctorOrPharmacist("ask doctor or pharmacist");
			drug.setDosage("dosage");
			drug.setStopUse("stop use");
			drug.setAdverseReactions("adverse reactions");
			drug.setManufacturerName("manufacturer name");

			return drug;
		}

		return null;
	}

	@Override
	public DrugEffect getEffects(String name) throws GatewayException
	{
		return null;
	}
}
