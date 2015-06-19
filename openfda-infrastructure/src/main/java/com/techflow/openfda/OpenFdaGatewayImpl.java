package com.techflow.openfda;

import java.io.IOException;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson.JacksonFactory;
import com.techflow.openfda.drugs.DrugLabel;

public class OpenFdaGatewayImpl implements OpenFdaGateway
{
	public HttpTransport transport = new NetHttpTransport();

	static final JsonFactory JSON_FACTORY = new JacksonFactory();

	@Override
	public DrugLabel getLabel(String label) throws IOException
	{
		final HttpRequestFactory requestFactory =
				transport.createRequestFactory(new HttpRequestInitializer() {
					@Override
					public void initialize(HttpRequest request)
					{
						request.setParser(new JsonObjectParser(JSON_FACTORY));
					}
				});

		final GenericUrl url = new GenericUrl("https://api.fda.gov/drug/label.json?search=brand_name:" + label + "+generic_name:" + label);
		final HttpRequest request = requestFactory.buildGetRequest(url);
		final OpenFdaDrugLabel jsonLabel = request.execute().parseAs(OpenFdaDrugLabel.class);

		final DrugLabel drugLabel = new DrugLabel();
		drugLabel.setName(jsonLabel.results.get(0).openfda.generic_name[0]);
		drugLabel.setAskDoctor(jsonLabel.results.get(0).ask_doctor[0]);
		drugLabel.setAskDoctorOrPharmacist(getZeroeth(jsonLabel.results.get(0).ask_doctor_or_pharmacist));
		drugLabel.setDosage(jsonLabel.results.get(0).dosage_and_administration[0]);
		drugLabel.setDoNotUse(jsonLabel.results.get(0).do_not_use[0]);
		drugLabel.setStopUse(jsonLabel.results.get(0).stop_use[0]);
		drugLabel.setActive(jsonLabel.results.get(0).active_ingredient[0]);
		drugLabel.setInactive(jsonLabel.results.get(0).inactive_ingredient[0]);
		drugLabel.setWarnings(jsonLabel.results.get(0).warnings[0]);
		drugLabel.setIndicationsAndUsage(jsonLabel.results.get(0).indications_and_usage[0]);

		return drugLabel;
	}

	private String getZeroeth(String[] ask_doctor_or_pharmacist)
	{
		if (ask_doctor_or_pharmacist == null) {
			return null;
		}
		return ask_doctor_or_pharmacist[0];
	}
}
