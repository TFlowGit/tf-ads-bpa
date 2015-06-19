package com.techflow.openfda.drug.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.techflow.openfda.drug.usecase.FindDrugUseCase;
import com.techflow.openfda.drug.usecase.OpenFdaUseCaseFactory;

@Controller
@RequestMapping("/api/drugs")
public class DrugController
{
	private final OpenFdaUseCaseFactory useCaseFactory;

	@Autowired
	public DrugController(OpenFdaUseCaseFactory useCaseFactory)
	{
		this.useCaseFactory = useCaseFactory;
	}

	@RequestMapping("")
	public ResponseEntity<DescribeDrugResponse> describeDrug(DescribeDrugRequest request)
	{
		final FindDrugUseCase useCase = useCaseFactory.newFindDrugUseCase();
		final DescribeDrugResponse response = new DescribeDrugResponse();
		useCase.setRequest(request);
		useCase.setResponse(response);
		useCase.execute();

		if (response.isNotFound()) {
			return new ResponseEntity<DescribeDrugResponse>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<DescribeDrugResponse>(response, HttpStatus.OK);
	}
}
