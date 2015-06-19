package com.techflow.openfda.drug.client;

import java.io.IOException;
import com.techflow.openfda.drugs.DrugEffect;
import com.techflow.openfda.drugs.DrugLabel;

public interface OpenFdaGateway
{
	DrugLabel getLabel(String name) throws IOException;

	DrugEffect getEffects(String name) throws IOException;
}
