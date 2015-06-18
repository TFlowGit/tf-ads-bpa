package com.techflow.openfda;

import com.techflow.openfda.drugs.Drug;

public interface FdaGateway
{
	Drug findDrug(String name);
}
