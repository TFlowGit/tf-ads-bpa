package com.techflow.openfda.drugs;

public class DrugEvent
{
	private int count;

	private String seriousness;

	public DrugEvent() {
	}

	public DrugEvent(int count) {
		this.count = count;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public String getSeriousness()
	{
		return seriousness;
	}

	public void setSeriousness(String seriousness)
	{
		this.seriousness = seriousness;
	}
}
