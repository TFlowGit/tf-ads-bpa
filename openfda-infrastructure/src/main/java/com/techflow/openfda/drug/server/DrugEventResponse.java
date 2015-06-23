package com.techflow.openfda.drug.server;

import java.util.Map;
import com.techflow.openfda.drugs.Seriousness;

public class DrugEventResponse
{
	private int congenitalAnomali;

	private int death;

	private int disabling;

	private int hospitalization;

	private int lifeThreatening;

	private int other;

	public int getCongenitalAnomali()
	{
		return congenitalAnomali;
	}

	public void setCongenitalAnomali(int congenitalAnomali)
	{
		this.congenitalAnomali = congenitalAnomali;
	}

	public int getDeath()
	{
		return death;
	}

	public void setDeath(int death)
	{
		this.death = death;
	}

	public int getDisabling()
	{
		return disabling;
	}

	public void setDisabling(int disabling)
	{
		this.disabling = disabling;
	}

	public int getHospitialization()
	{
		return hospitalization;
	}

	public void setHospitialization(int hospitalization)
	{
		this.hospitalization = hospitalization;
	}

	public int getLifeThreatening()
	{
		return lifeThreatening;
	}

	public void setLifeThreatening(int lifeThreatening)
	{
		this.lifeThreatening = lifeThreatening;
	}

	public int getOther()
	{
		return other;
	}

	public void setOther(int other)
	{
		this.other = other;
	}

	public DrugEventResponse() {
	}

	public DrugEventResponse(Map<String, Integer> drugEvents) {
		congenitalAnomali = get(drugEvents, Seriousness.CONGENITAL_ANOMALI);
		death = get(drugEvents, Seriousness.DEATH);
		disabling = get(drugEvents, Seriousness.DISABLING);
		hospitalization = get(drugEvents, Seriousness.HOSPITALIZATION);
		lifeThreatening = get(drugEvents, Seriousness.LIFE_THREATENING);
		other = get(drugEvents, Seriousness.OTHER);
	}

	private int get(Map<String, Integer> drugEffects, Seriousness seriousness)
	{
		final Integer integer = drugEffects.get(seriousness.key());
		if (integer == null) {
			return 0;
		}

		return integer;
	}

}
