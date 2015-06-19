package com.techflow.openfda.drug.server;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.techflow.openfda.drug.client.MockOpenFdaGateway;
import com.techflow.openfda.drug.client.OpenFdaGateway;
import com.techflow.openfda.drug.server.DescribeDrugRequest;
import com.techflow.openfda.drug.server.DescribeDrugResponse;
import com.techflow.openfda.drug.server.DrugController;
import com.techflow.openfda.drug.usecase.FindDrugUseCase;
import com.techflow.openfda.drug.usecase.OpenFdaUseCaseFactory;
import com.techflow.openfda.drugs.FindDrugImpl;

public class DrugControllerTest
{
	private final OpenFdaGateway mockFdaGateway = new MockOpenFdaGateway();

	@Test
	public void test()
	{
		final OpenFdaUseCaseFactory useCaseFactory = new OpenFdaUseCaseFactory() {
			@Override
			public FindDrugUseCase newFindDrugUseCase()
			{
				return new FindDrugImpl(mockFdaGateway);
			}
		};

		final DrugController controller = new DrugController(useCaseFactory);
		final DescribeDrugRequest request = new DescribeDrugRequest();
		request.setName("aspirin");

		final ResponseEntity<DescribeDrugResponse> response = controller.describeDrug(request);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		final DescribeDrugResponse body = response.getBody();

		assertThat(body.getName(), equalTo("Aspirin"));
		assertThat(body.getPurpose(), equalTo("Relieves pain."));
		assertThat(body.getActive(), equalTo("active"));
		assertThat(body.getInactive(), equalTo("inactive"));
		assertThat(body.getAskDoctor(), equalTo("ask"));
		assertThat(body.getDoNotUse(), equalTo("do not use"));
		assertThat(body.getIndicationsAndUsage(), equalTo("indications"));
		assertThat(body.getStopUse(), equalTo("stop use"));
		assertThat(body.getWarnings(), equalTo("warnings"));
	}

	@Test
	public void missingDrug()
	{
		final OpenFdaUseCaseFactory useCaseFactory = new OpenFdaUseCaseFactory() {
			@Override
			public FindDrugUseCase newFindDrugUseCase()
			{
				return new FindDrugImpl(mockFdaGateway);
			}
		};

		final DrugController controller = new DrugController(useCaseFactory);
		final DescribeDrugRequest request = new DescribeDrugRequest();
		request.setName(null);

		final ResponseEntity<DescribeDrugResponse> response = controller.describeDrug(request);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));

		final DescribeDrugResponse body = response.getBody();
		assertThat(body, nullValue());
	}
}
