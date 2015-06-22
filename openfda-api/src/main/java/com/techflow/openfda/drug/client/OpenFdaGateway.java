package com.techflow.openfda.drug.client;

import com.techflow.openfda.GatewayException;
import com.techflow.openfda.drugs.DrugEffect;
import com.techflow.openfda.drugs.DrugLabel;

public interface OpenFdaGateway
{
	DrugLabel getLabel(String name) throws GatewayException;

	DrugEffect getEffects(String name) throws GatewayException;
}
