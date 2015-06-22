package com.techflow.openfda.drug.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.techflow.openfda.GatewayException;
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

	@RequestMapping(value = "")
	@ResponseBody
	public ResponseEntity<DescribeDrugResponse> describeDrug(DescribeDrugRequest request) throws GatewayException
	{
		final FindDrugUseCase useCase = useCaseFactory.newFindDrugUseCase();
		final DescribeDrugResponse response = new DescribeDrugResponse();
		useCase.setRequest(request);
		useCase.setResponse(response);
		useCase.execute();

		if (response.isNotFound()) {
			return new ResponseEntity<DescribeDrugResponse>(HttpStatus.NOT_FOUND);
		}

		final ResponseEntity<DescribeDrugResponse> responseEntity = new ResponseEntity<DescribeDrugResponse>(response, HttpStatus.OK);
		return responseEntity;
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(GatewayException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleGatewayException()
	{
		final ErrorResponse errorResponse = new ErrorResponse("Error communicating with OpenFDA API");

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
