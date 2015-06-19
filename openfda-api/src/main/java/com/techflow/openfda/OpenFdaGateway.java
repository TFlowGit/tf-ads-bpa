package com.techflow.openfda;

import java.io.IOException;
import com.techflow.openfda.drugs.DrugLabel;

public interface OpenFdaGateway
{
	DrugLabel getLabel(String name) throws IOException;
}
