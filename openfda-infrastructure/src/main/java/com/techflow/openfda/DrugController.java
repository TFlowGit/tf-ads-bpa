package com.techflow.openfda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.techflow.openfda.drugs.DescribeDrugRequest;
import com.techflow.openfda.drugs.DrugJson;
import com.techflow.openfda.drugs.FindDrug;
import com.techflow.openfda.drugs.OpenFdaUseCaseFactory;

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
	public ResponseEntity<DrugJson> describeDrug(DescribeDrugRequest request)
	{
		final FindDrug useCase = useCaseFactory.newFindDrugUseCase();
		final DrugAdapter drug = new DrugAdapter();
		useCase.setRequest(request);
		useCase.setResponse(drug);
		useCase.execute();

		if (drug.isNotFound()) {
			return new ResponseEntity<DrugJson>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<DrugJson>(drug, HttpStatus.OK);
	}
}
