package com.techflow.openfda;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.techflow.openfda.drugs.DescribeDrugRequest;
import com.techflow.openfda.drugs.DrugJson;
import com.techflow.openfda.drugs.FindDrug;
import com.techflow.openfda.drugs.FindDrugImpl;
import com.techflow.openfda.drugs.OpenFdaUseCaseFactory;

public class DrugControllerTest
{
	private final FdaGateway mockFdaGateway = new MockFdaGateway();

	@Test
	public void test()
	{
		final OpenFdaUseCaseFactory useCaseFactory = new OpenFdaUseCaseFactory() {
			@Override
			public FindDrug newFindDrugUseCase()
			{
				return new FindDrugImpl(mockFdaGateway);
			}
		};

		final DrugController controller = new DrugController(useCaseFactory);
		final DescribeDrugRequest request = new DescribeDrugRequest();
		request.setName("aspirin");

		final ResponseEntity<DrugJson> response = controller.describeDrug(request);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		final DrugJson body = response.getBody();

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
			public FindDrug newFindDrugUseCase()
			{
				return new FindDrugImpl(mockFdaGateway);
			}
		};

		final DrugController controller = new DrugController(useCaseFactory);
		final DescribeDrugRequest request = new DescribeDrugRequest();
		request.setName(null);

		final ResponseEntity<DrugJson> response = controller.describeDrug(request);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));

		final DrugJson body = response.getBody();
		assertThat(body, nullValue());
	}
}
