package com.techflow.openfda.drug.client;

import com.techflow.openfda.GatewayException;
import com.techflow.openfda.drugs.DrugEvent;
import com.techflow.openfda.drugs.DrugLabel;
import com.techflow.openfda.drugs.Seriousness;

public interface OpenFdaGateway
{
	DrugLabel getLabel(String name) throws GatewayException;

	DrugEvent getEvents(String name, Seriousness s) throws GatewayException;
}
