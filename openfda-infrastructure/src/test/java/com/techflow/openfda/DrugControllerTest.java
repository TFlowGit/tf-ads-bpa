package com.techflow.openfda;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import com.techflow.openfda.drugs.DescribeDrugRequest;
import com.techflow.openfda.drugs.Drug;
import com.techflow.openfda.drugs.FindDrug;
import com.techflow.openfda.drugs.FindDrugImpl;
import com.techflow.openfda.drugs.OpenFdaUseCaseFactory;

public class DrugControllerTest
{
	@Test
	public void test()
	{
		final OpenFdaUseCaseFactory useCaseFactory = new OpenFdaUseCaseFactory() {
			@Override
			public FindDrug newFindDrugUseCase()
			{
				return new FindDrugImpl();
			}
		};

		final DrugController controller = new DrugController(useCaseFactory);
		final DescribeDrugRequest request = new DescribeDrugRequest();
		request.setName("aspirin");

		final ResponseEntity<Drug> response = controller.describeDrug(request);

		final Drug body = response.getBody();
	}
}
