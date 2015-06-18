package com.techflow.openfda.drugs;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

@Component
@Path("/api/drugs")
public class DrugResource
{
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Drug describeDrug(@BeanParam DesribeDrugRequest request)
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

		return drug;
	}
}
