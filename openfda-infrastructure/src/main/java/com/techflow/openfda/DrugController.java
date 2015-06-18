package com.techflow.openfda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.techflow.openfda.drugs.DescribeDrugRequest;
import com.techflow.openfda.drugs.Drug;
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
	public ResponseEntity<Drug> describeDrug(DescribeDrugRequest request)
	{
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

		return new ResponseEntity<Drug>(drug, HttpStatus.OK);
	}
}
