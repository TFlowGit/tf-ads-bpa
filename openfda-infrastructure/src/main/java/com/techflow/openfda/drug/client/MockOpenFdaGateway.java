package com.techflow.openfda.drug.client;

import java.io.IOException;
import com.techflow.openfda.drug.client.OpenFdaGateway;
import com.techflow.openfda.drugs.DrugEffect;
import com.techflow.openfda.drugs.DrugLabel;

public class MockOpenFdaGateway implements OpenFdaGateway
{
	@Override
	public DrugLabel getLabel(String label)
	{
		if (label == null) {
			return null;
		}

		switch (label) {
		case "aspirin":
			final DrugLabel drug = new DrugLabel();
			drug.setName("Aspirin");
			drug.setPurpose("Relieves pain.");
			drug.setActive("active");
			drug.setInactive("inactive");
			drug.setAskDoctor("ask");
			drug.setDoNotUse("do not use");
			drug.setIndicationsAndUsage("indications");
			drug.setStopUse("stop use");
			drug.setWarnings("warnings");

			return drug;
		}

		return null;
	}

	@Override
	public DrugEffect getEffects(String name) throws IOException
	{
		return null;
	}
}
