package com.techflow.openfda;

import com.techflow.openfda.drugs.Drug;

public class MockFdaGateway implements FdaGateway
{
	@Override
	public Drug findDrug(String name)
	{
		if (name == null) {
			return null;
		}

		switch (name) {
		case "aspirin":
			final Drug drug = new Drug();
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
}
