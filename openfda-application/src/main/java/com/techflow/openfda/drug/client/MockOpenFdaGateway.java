package com.techflow.openfda.drug.client;

import java.util.HashMap;
import java.util.Map;
import com.techflow.openfda.GatewayException;
import com.techflow.openfda.drugs.DrugEvent;
import com.techflow.openfda.drugs.DrugLabel;
import com.techflow.openfda.drugs.Seriousness;

/**
 * Mock implementation of OpenFdaGateway.
 */
public class MockOpenFdaGateway implements OpenFdaGateway
{
	private static final String ASPIRIN_NDC = "63941-440";

	public GatewayException exception;

	private final Map<EventKey, DrugEvent> events = new HashMap<MockOpenFdaGateway.EventKey, DrugEvent>();

	public MockOpenFdaGateway()
	{
		addDrugEvent(ASPIRIN_NDC, Seriousness.CONGENITAL_ANOMALI, 5);
		addDrugEvent(ASPIRIN_NDC, Seriousness.DEATH, 10);
		addDrugEvent(ASPIRIN_NDC, Seriousness.DISABLING, 13);
		addDrugEvent(ASPIRIN_NDC, Seriousness.HOSPITALIZATION, 17);
		addDrugEvent(ASPIRIN_NDC, Seriousness.LIFE_THREATENING, 25);
		addDrugEvent(ASPIRIN_NDC, Seriousness.OTHER, 30);
	}

	private void addDrugEvent(String productNdc, Seriousness seriousness, int count)
	{
		String key = seriousness.key();
		events.put(new EventKey(productNdc, key), new DrugEvent(count));
	}

	/**
	 * {@inheritDoc}
	 */
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
			drug.setProductNdc(ASPIRIN_NDC);
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DrugEvent getEvents(String productNdc, Seriousness s) throws GatewayException
	{
		final EventKey eventKey = new EventKey(productNdc, s.key());
		final DrugEvent drugEvent = events.get(eventKey);

		return drugEvent;
	}

	static final class EventKey
	{
		private final String productNdc;

		private final String seriousness;

		public EventKey(String productNdc, String seriousness) {
			this.productNdc = productNdc;
			this.seriousness = seriousness;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((productNdc == null) ? 0 : productNdc.hashCode());
			result = prime * result + ((seriousness == null) ? 0 : seriousness.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final EventKey other = (EventKey)obj;
			if (productNdc == null) {
				if (other.productNdc != null) {
					return false;
				}
			} else if (!productNdc.equals(other.productNdc)) {
				return false;
			}
			if (seriousness == null) {
				if (other.seriousness != null) {
					return false;
				}
			} else if (!seriousness.equals(other.seriousness)) {
				return false;
			}
			return true;
		}
	}
}
