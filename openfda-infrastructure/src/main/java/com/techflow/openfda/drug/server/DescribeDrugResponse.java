package com.techflow.openfda.drug.server;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techflow.openfda.drug.usecase.FindDrugResponse;

public class DescribeDrugResponse implements FindDrugResponse
{
	protected String indicationsAndUsage;

	private String brandName;

	private String genericName;

	protected String purpose;

	protected String active;

	protected String inactive;

	protected String warnings;

	protected String doNotUse;

	protected String askDoctor;

	private String askDoctorOrPharmacist;

	protected String dosage;

	protected String stopUse;

	private String adverseReactions;

	private String manufacturerName;

	boolean notFound;

	private DrugEventResponse drugEvents;

	@ApiModelProperty(value = "The purpose of the drug")
	public String getPurpose()
	{
		return purpose;
	}

	@Override
	public void setPurpose(String purpose)
	{
		this.purpose = purpose;
	}

	@ApiModelProperty(value = "Dosage information")
	public String getDosage()
	{
		return dosage;
	}

	@Override
	public void setDosage(String dosage)
	{
		this.dosage = dosage;
	}

	@ApiModelProperty(value = "Active ingredients")
	public String getActive()
	{
		return active;
	}

	@Override
	public void setActive(String active)
	{
		this.active = active;
	}

	@ApiModelProperty(value = "Inactive ingredients")
	public String getInactive()
	{
		return inactive;
	}

	@Override
	public void setInactive(String inactive)
	{
		this.inactive = inactive;
	}

	@ApiModelProperty(value = "Warning label")
	public String getWarnings()
	{
		return warnings;
	}

	@Override
	public void setWarnings(String warnings)
	{
		this.warnings = warnings;
	}

	@ApiModelProperty(value = "When not to use the drug")
	public String getDoNotUse()
	{
		return doNotUse;
	}

	@Override
	public void setDoNotUse(String doNotUse)
	{
		this.doNotUse = doNotUse;
	}

	@ApiModelProperty(value = "When to stop usage of the drug")
	public String getStopUse()
	{
		return stopUse;
	}

	@Override
	public void setStopUse(String stopUse)
	{
		this.stopUse = stopUse;
	}

	@ApiModelProperty(value = "Questions to ask your doctor")
	public String getAskDoctor()
	{
		return askDoctor;
	}

	@Override
	public void setAskDoctor(String askDoctor)
	{
		this.askDoctor = askDoctor;
	}

	@ApiModelProperty(value = "Indications and usage")
	public String getIndicationsAndUsage()
	{
		return indicationsAndUsage;
	}

	@Override
	public void setIndicationsAndUsage(String indicationsAndUsage)
	{
		this.indicationsAndUsage = indicationsAndUsage;
	}

	boolean isNotFound()
	{
		return notFound;
	}

	@Override
	public void setNotFound(boolean notFound)
	{
		this.notFound = notFound;
	}

	@ApiModelProperty(value = "The brand name of the drug")
	public String getBrandName()
	{
		return brandName;
	}

	@Override
	public void setBrandName(String brandName)
	{
		this.brandName = brandName;
	}

	@ApiModelProperty(value = "The generic name of the drug")
	public String getGenericName()
	{
		return genericName;
	}

	@Override
	public void setGenericName(String genericName)
	{
		this.genericName = genericName;
	}

	@ApiModelProperty(value = "Questions to ask your doctor or pharmacist")
	public String getAskDoctorOrPharmacist()
	{
		return askDoctorOrPharmacist;
	}

	@Override
	public void setAskDoctorOrPharmacist(String askDoctorOrPharmacist)
	{
		this.askDoctorOrPharmacist = askDoctorOrPharmacist;
	}

	@ApiModelProperty(value = "Adverse reactions")
	public String getAdverseReactions()
	{
		return adverseReactions;
	}

	@Override
	public void setAdverseReactions(String adverseReactions)
	{
		this.adverseReactions = adverseReactions;
	}

	@ApiModelProperty(value = "The manufacturer of the drug")
	public String getManufacturerName()
	{
		return manufacturerName;
	}

	@Override
	public void setManufacturerName(String manufacturerName)
	{
		this.manufacturerName = manufacturerName;
	}

	@ApiModelProperty(value = "Adverse events related to the drug")
	public DrugEventResponse getEvents()
	{
		return drugEvents;
	}

	@JsonIgnore
	@Override
	public void setEvents(Map<String, Integer> drugEffects)
	{
		this.drugEvents = new DrugEventResponse(drugEffects);
	}

	@JsonProperty("events")
	public void setEvents(DrugEventResponse drugEvents)
	{
		this.drugEvents = drugEvents;
	}
}
