package com.techflow.openfda.drugs;

public abstract class AbstractUseCase<REQ, RESP> implements UseCase<REQ, RESP>
{
	protected REQ request;

	protected RESP response;

	@Override
	public void setRequest(REQ request)
	{
		this.request = request;
	}

	@Override
	public void setResponse(RESP response)
	{
		this.response = response;
	}
}
