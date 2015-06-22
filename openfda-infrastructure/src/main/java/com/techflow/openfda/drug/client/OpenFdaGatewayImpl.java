package com.techflow.openfda.drug.client;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.techflow.openfda.GatewayException;
import com.techflow.openfda.drug.client.OpenFdaDrugLabel.OpenFdaDrugLabelResult;
import com.techflow.openfda.drugs.DrugEffect;
import com.techflow.openfda.drugs.DrugLabel;

/**
 * OpenFDA API gateway.
 */
public class OpenFdaGatewayImpl implements OpenFdaGateway
{
	public HttpTransport transport = new NetHttpTransport();

	static final JsonFactory JSON_FACTORY = new JacksonFactory();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DrugLabel getLabel(String drugName) throws GatewayException
	{
		try {
			final HttpRequestFactory requestFactory = createRequestFactory();
			final GenericUrl url = new DrugLabelUrl(drugName);
			final HttpRequest request = requestFactory.buildGetRequest(url);
			final OpenFdaDrugLabel jsonLabel = request.execute().parseAs(OpenFdaDrugLabel.class);
			final DrugLabel drugLabel = new DrugLabel();
			if (jsonLabel.results != null) {
				final OpenFdaDrugLabelResult results = jsonLabel.results[0];

				drugLabel.setIndicationsAndUsage(getZeroeth(results.indications_and_usage));
				drugLabel.setPurpose(getZeroeth(results.purpose));
				drugLabel.setActive(getZeroeth(results.active_ingredient));
				drugLabel.setInactive(getZeroeth(results.inactive_ingredient));
				drugLabel.setWarnings(getZeroeth(results.warnings));
				drugLabel.setDoNotUse(getZeroeth(results.do_not_use));
				drugLabel.setAskDoctor(getZeroeth(results.ask_doctor));
				drugLabel.setAskDoctorOrPharmacist(getZeroeth(results.ask_doctor_or_pharmacist));
				drugLabel.setDosage(getZeroeth(results.dosage_and_administration));
				drugLabel.setStopUse(getZeroeth(results.stop_use));
				drugLabel.setAdverseReactions(getZeroeth(results.adverse_reactions));

				if (results.openfda != null) {
					drugLabel.setBrandName(getZeroeth(results.openfda.brand_name));
					drugLabel.setGenericName(getZeroeth(results.openfda.generic_name));
					drugLabel.setManufacturerName(getZeroeth(results.openfda.manufacturer_name));
				}
			}

			return drugLabel;
		} catch (final HttpResponseException e) {
			if (e.getStatusCode() == 404) {
				return null;
			}
			throw new GatewayException(e);
		} catch (final Exception e) {
			throw new GatewayException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DrugEffect getEffects(String name) throws GatewayException
	{
		return null;
	}

	/**
	 * Returns the 0th element of an array or null.
	 */
	private String getZeroeth(String[] array)
	{
		if (array == null) {
			return null;
		}

		return array[0];
	}

	/**
	 * Helper method to create an HttpRequestFactory.
	 */
	private HttpRequestFactory createRequestFactory()
	{
		final HttpRequestFactory requestFactory = transport.createRequestFactory(new JsonHttpRequestInitializer());
		return requestFactory;
	}

	/**
	 * A HttpRequestInitializer for Json requests.
	 */
	private final class JsonHttpRequestInitializer implements HttpRequestInitializer
	{
		@Override
		public void initialize(HttpRequest request)
		{
			request.setParser(new JsonObjectParser(JSON_FACTORY));
		}
	}

	/**
	 * A HttpRequestInitializer for Json requests.
	 */
	private final class DrugLabelUrl extends GenericUrl
	{
		static final String endpoint = "https://api.fda.gov";

		public DrugLabelUrl(String drugName) {
			super(endpoint + "/drug/label.json?search=brand_name:" + drugName + "+generic_name:" + drugName);
		}
	}
}
