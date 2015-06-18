package com.techflow.openfda.drugs;

public class DrugJson
{
	protected String name;

	protected String purpose;

	protected String dosage;

	protected String active;

	protected String inactive;

	protected String warnings;

	protected String doNotUse;

	protected String adverseReactions;

	protected String stopUse;

	protected String askDoctor;

	protected String indicationsAndUsage;

	protected boolean notFound;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPurpose()
	{
		return purpose;
	}

	public void setPurpose(String purpose)
	{
		this.purpose = purpose;
	}

	public String getDosage()
	{
		return dosage;
	}

	public void setDosage(String dosage)
	{
		this.dosage = dosage;
	}

	public String getActive()
	{
		return active;
	}

	public void setActive(String active)
	{
		this.active = active;
	}

	public String getInactive()
	{
		return inactive;
	}

	public void setInactive(String inactive)
	{
		this.inactive = inactive;
	}

	public String getWarnings()
	{
		return warnings;
	}

	public void setWarnings(String warnings)
	{
		this.warnings = warnings;
	}

	public String getDoNotUse()
	{
		return doNotUse;
	}

	public void setDoNotUse(String doNotUse)
	{
		this.doNotUse = doNotUse;
	}

	public String getAdverseReactions()
	{
		return adverseReactions;
	}

	public void setAdverseReactions(String adverseReactions)
	{
		this.adverseReactions = adverseReactions;
	}

	public String getStopUse()
	{
		return stopUse;
	}

	public void setStopUse(String stopUse)
	{
		this.stopUse = stopUse;
	}

	public String getAskDoctor()
	{
		return askDoctor;
	}

	public void setAskDoctor(String askDoctor)
	{
		this.askDoctor = askDoctor;
	}

	public String getIndicationsAndUsage()
	{
		return indicationsAndUsage;
	}

	public void setIndicationsAndUsage(String indicationsAndUsage)
	{
		this.indicationsAndUsage = indicationsAndUsage;
	}

	public boolean isNotFound()
	{
		return notFound;
	}

	public void setNotFound(boolean notFound)
	{
		this.notFound = notFound;
	}
}
