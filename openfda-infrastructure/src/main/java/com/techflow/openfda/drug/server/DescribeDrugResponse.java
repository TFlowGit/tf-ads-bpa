package com.techflow.openfda.drug.server;

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

	public String getPurpose()
	{
		return purpose;
	}

	@Override
	public void setPurpose(String purpose)
	{
		this.purpose = purpose;
	}

	public String getDosage()
	{
		return dosage;
	}

	@Override
	public void setDosage(String dosage)
	{
		this.dosage = dosage;
	}

	public String getActive()
	{
		return active;
	}

	@Override
	public void setActive(String active)
	{
		this.active = active;
	}

	public String getInactive()
	{
		return inactive;
	}

	@Override
	public void setInactive(String inactive)
	{
		this.inactive = inactive;
	}

	public String getWarnings()
	{
		return warnings;
	}

	@Override
	public void setWarnings(String warnings)
	{
		this.warnings = warnings;
	}

	public String getDoNotUse()
	{
		return doNotUse;
	}

	@Override
	public void setDoNotUse(String doNotUse)
	{
		this.doNotUse = doNotUse;
	}

	public String getStopUse()
	{
		return stopUse;
	}

	@Override
	public void setStopUse(String stopUse)
	{
		this.stopUse = stopUse;
	}

	public String getAskDoctor()
	{
		return askDoctor;
	}

	@Override
	public void setAskDoctor(String askDoctor)
	{
		this.askDoctor = askDoctor;
	}

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

	public String getBrandName()
	{
		return brandName;
	}

	@Override
	public void setBrandName(String brandName)
	{
		this.brandName = brandName;
	}

	public String getGenericName()
	{
		return genericName;
	}

	@Override
	public void setGenericName(String genericName)
	{
		this.genericName = genericName;
	}

	public String getAskDoctorOrPharmacist()
	{
		return askDoctorOrPharmacist;
	}

	@Override
	public void setAskDoctorOrPharmacist(String askDoctorOrPharmacist)
	{
		this.askDoctorOrPharmacist = askDoctorOrPharmacist;
	}

	public String getAdverseReactions()
	{
		return adverseReactions;
	}

	@Override
	public void setAdverseReactions(String adverseReactions)
	{
		this.adverseReactions = adverseReactions;
	}

	public String getManufacturerName()
	{
		return manufacturerName;
	}

	@Override
	public void setManufacturerName(String manufacturerName)
	{
		this.manufacturerName = manufacturerName;
	}
}
