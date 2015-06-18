package com.techflow.openfda.drugs;

public interface UseCase<REQ, RESP>
{
	void setRequest(REQ request);

	void setResponse(RESP response);

	void execute();
}
