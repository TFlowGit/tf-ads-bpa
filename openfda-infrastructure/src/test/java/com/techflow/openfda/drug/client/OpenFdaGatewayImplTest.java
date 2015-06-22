package com.techflow.openfda.drug.client;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import java.net.URL;
import org.junit.Test;
import com.google.api.client.util.Charsets;
import com.google.common.io.Resources;
import com.techflow.openfda.drug.client.OpenFdaGatewayImpl;
import com.techflow.openfda.drugs.DrugLabel;

public class OpenFdaGatewayImplTest
{
	@Test
	public void shouldFindAspirin() throws IOException
	{
		final URL url = Resources.getResource("aspirin.json");
		final String text = Resources.toString(url, Charsets.UTF_8);
		final ContentProducingMockHttpTransport transport = new ContentProducingMockHttpTransport(text);
		final OpenFdaGatewayImpl g = new OpenFdaGatewayImpl();
		g.transport = transport;

		final DrugLabel drug = g.getLabel("aspirin");

		assertThat(
				transport.getMethod(),
				equalTo("GET"));
		assertThat(
				transport.getUrl(),
				equalTo("https://api.fda.gov/drug/label.json?search=brand_name:aspirin%20generic_name:aspirin"));
		assertThat(
				drug.getAskDoctor(),
				equalTo("Ask a doctor before use if stomach bleeding warning applies to you you have a history of stomach problems, such as heartburn you have high blood pressure, heart disease, liver cirrhosis, or kidney disease you are taking a diuretic you have asthma"));
		assertThat(
				drug.getAskDoctorOrPharmacist(),
				equalTo("Ask a doctor or pharmacist before use if you are taking a prescription drug for: anticoagulation (thinning of the blood) gout diabetes arthritis"));
		assertThat(
				drug.getDosage(),
				equalTo("Directions do not exceed recommended dosage drink a full glass of water with each dose adults and children 12 years of age and over: take 4 to 8 tablets every 4 hours not to exceed 48 tablets in 24 hours, unless directed by a doctor children under 12 years of age: consult a doctor"));
		assertThat(
				drug.getDoNotUse(),
				equalTo("Do not use if you have ever had an allergic reaction to any other pain reliever/fever reducer"));
		assertThat(
				drug.getStopUse(),
				equalTo("Stop use and ask a doctor if you experience any of the following signs of stomach bleeding: feel faint vomit blood have bloody or black stools have stomach pain that does not get better allergic reaction occurs ringing in the ears or a loss of hearing occurs pain gets worse or lasts more than 10 days fever gets worse or lasts more than 3 days any new symptoms appear redness or swelling is present in the painful area"));
		assertThat(
				drug.getActive(),
				equalTo("Active ingredient (in each tablet) Aspirin 81 mg (NSAID)* *nonsteroidal anti- inflammatory drug"));
		assertThat(
				drug.getInactive(),
				equalTo("Inactive ingredients *acetylated monoglycerides, *anhydrous lactose, *carnauba wax, colloidal silicon dioxide,*corn starch, *croscarmellose sodium, D&C Yellow #10 Aluminum Lake, FD&C Yellow #6 Aluminum Lake, hypromellose, *hypromellose phthalate, *iron oxide Yellow (iron oxide ochre), methacrylic acid copolymer, microcrystalline cellulose, *mineral oil, *polyethylene glycol (PEG)-400, *polysorbate 80, povidone, pregelatinized starch, *propylene glycol, *simethicone, silicon dioxide, sodium bicarbonate, sodium hydroxide, sodium lauryl sulfate, starch, stearic acid, talc, titanium dioxide, triacetin, and triethyl citrate. *May also contain."));
		assertThat(
				drug.getWarnings(),
				equalTo("Warnings Reye’s syndrome: Children and teenagers who have or are recovering from chicken pox or flu-like symptoms should not use this product. When using this product, if changes in behavior with nausea and vomiting occur, consult a doctor because these symptoms could be an early sign of Reye’s syndrome, a rare but serious illness. Allergy alert: Aspirin may cause a severe allergic reaction which may include: hives facial swelling asthma(wheezing) shock Stomach bleeding warning: This product contains a nonsteroidal anti-inflammatory drug (NSAID), which may cause stomach bleeding. The chance is higher if you: are age 60 or older have had stomach ulcers or bleeding problems take a blood thinning (anticoagulant) or steroid drug take other drugs containing prescription or nonprescription NSAIDs (aspirin, ibuprofen, naproxen, or others) have 3 or more alcoholic drinks every day while using this product take more or for a longer time than directed Do not use if you have ever had an allergic reaction to any other pain reliever/fever reducer Ask a doctor before use if stomach bleeding warning applies to you you have a history of stomach problems, such as heartburn you have high blood pressure, heart disease, liver cirrhosis, or kidney disease you are taking a diuretic you have asthma Ask a doctor or pharmacist before use if you are taking a prescription drug for: anticoagulation (thinning of the blood) gout diabetes arthritis Stop use and ask a doctor if you experience any of the following signs of stomach bleeding: feel faint vomit blood have bloody or black stools have stomach pain that does not get better allergic reaction occurs ringing in the ears or a loss of hearing occurs pain gets worse or lasts more than 10 days fever gets worse or lasts more than 3 days any new symptoms appear redness or swelling is present in the painful area If pregnant or breast- feeding, ask a health professional before use. It is especially important not to use aspirin during the last 3 months of pregnancy unless definitely directed to do so by a doctor because it may cause problems in the unborn child or complications during delivery. Keep out of reach of children In case of overdose, get medical help or contact a Poison Control Center right away."));
		assertThat(
				drug.getIndicationsAndUsage(),
				equalTo("Uses temporarily relieves minor aches and pains other therapy as recommended by your doctor. Because of its delayed action, this product will not provide fast relief of headaches, fever, or other symptoms needing immediate relief."));
		assertThat(
				drug.getName(),
				equalTo("ASPIRIN"));
	}

	@Test
	public void shouldFindSudafed() throws IOException
	{
		final URL url = Resources.getResource("sudafed.json");
		final String text = Resources.toString(url, Charsets.UTF_8);
		final ContentProducingMockHttpTransport transport = new ContentProducingMockHttpTransport(text);
		final OpenFdaGatewayImpl g = new OpenFdaGatewayImpl();
		g.transport = transport;

		final DrugLabel drug = g.getLabel("sudafed");

		assertThat(
				transport.getMethod(),
				equalTo("GET"));
		assertThat(
				transport.getUrl(),
				equalTo("https://api.fda.gov/drug/label.json?search=brand_name:sudafed%20generic_name:sudafed"));
		assertThat(
				drug.getAskDoctor(),
				equalTo("Ask a doctor before use if the child has heart disease high blood pressure thyroid disease diabetes a sodium-restricted diet"));
		assertThat(
				drug.getAskDoctorOrPharmacist(),
				nullValue());
		assertThat(
				drug.getDosage(),
				equalTo("Directions find right dose on chart below mL = milliliter; tsp = teaspoonful repeat dose every 4 hours do not use more than 6 times in 24 hours Age (yr) Dose (mL or tsp) under 4 years do not use 4 to 5 years 5 mL (1 tsp) 6 to 11 years 10 mL (2 tsp) Attention: use only enclosed dosing cup designed for use with this product. Do not use any other dosing device."));
		assertThat(
				drug.getDoNotUse(),
				equalTo("Do not use in a child who is taking a prescription monoamine oxidase inhibitor (MAOI) (certain drugs for depression, psychiatric or emotional conditions, or Parkinson's disease), or for 2 weeks after stopping the MAOI drug. If you do not know if your child's prescription drug contains an MAOI, ask a doctor or pharmacist before giving this product."));
		assertThat(
				drug.getStopUse(),
				equalTo("Stop use and ask a doctor if nervousness, dizziness, or sleeplessness occur symptoms do not improve within 7 days or occur with a fever"));
		assertThat(
				drug.getActive(),
				equalTo("Active ingredient (in each 5 mL = 1 teaspoonful) Phenylephrine HCl 2.5 mg"));
		assertThat(
				drug.getInactive(),
				equalTo("Inactive ingredients anhydrous citric acid, carboxymethylcellulose sodium, edetate disodium, FD&C red #40, flavors, glycerin, purified water, sodium benzoate, sodium citrate, sorbitol solution, sucralose"));
		assertThat(
				drug.getWarnings(),
				equalTo("Warnings Do not use in a child who is taking a prescription monoamine oxidase inhibitor (MAOI) (certain drugs for depression, psychiatric or emotional conditions, or Parkinson's disease), or for 2 weeks after stopping the MAOI drug. If you do not know if your child's prescription drug contains an MAOI, ask a doctor or pharmacist before giving this product. Ask a doctor before use if the child has heart disease high blood pressure thyroid disease diabetes a sodium-restricted diet When using this product do not exceed recommended dose Stop use and ask a doctor if nervousness, dizziness, or sleeplessness occur symptoms do not improve within 7 days or occur with a fever Keep out of reach of children. In case of overdose, get medical help or contact a Poison Control Center right away. (1-800-222-1222)"));
		assertThat(
				drug.getIndicationsAndUsage(),
				equalTo("Use temporarily relieves nasal congestion due to the common cold, hay fever or other upper respiratory allergies"));
		assertThat(
				drug.getName(),
				equalTo("PHENYLEPHRINE HYDROCHLORIDE"));
	}

	@Test
	public void shouldhandleEmptyResponse() throws IOException
	{
		final URL url = Resources.getResource("empty.json");
		final String text = Resources.toString(url, Charsets.UTF_8);
		final ContentProducingMockHttpTransport transport = new ContentProducingMockHttpTransport(text);
		final OpenFdaGatewayImpl g = new OpenFdaGatewayImpl();
		g.transport = transport;

		final DrugLabel drug = g.getLabel("empty");

		assertThat(
				drug.getAskDoctor(),
				nullValue());
		assertThat(
				drug.getAskDoctorOrPharmacist(),
				nullValue());
		assertThat(
				drug.getDosage(),
				nullValue());
		assertThat(
				drug.getDoNotUse(),
				nullValue());
		assertThat(
				drug.getStopUse(),
				nullValue());
		assertThat(
				drug.getActive(),
				nullValue());
		assertThat(
				drug.getInactive(),
				nullValue());
		assertThat(
				drug.getWarnings(),
				nullValue());
		assertThat(
				drug.getIndicationsAndUsage(),
				nullValue());
		assertThat(
				drug.getName(),
				nullValue());
	}

	@Test
	public void shouldhandleMoreEmptyResponse() throws IOException
	{
		final URL url = Resources.getResource("missingopenfda.json");
		final String text = Resources.toString(url, Charsets.UTF_8);
		final ContentProducingMockHttpTransport transport = new ContentProducingMockHttpTransport(text);
		final OpenFdaGatewayImpl g = new OpenFdaGatewayImpl();
		g.transport = transport;

		final DrugLabel drug = g.getLabel("empty");

		assertThat(
				drug.getAskDoctor(),
				nullValue());
		assertThat(
				drug.getAskDoctorOrPharmacist(),
				nullValue());
		assertThat(
				drug.getDosage(),
				nullValue());
		assertThat(
				drug.getDoNotUse(),
				nullValue());
		assertThat(
				drug.getStopUse(),
				nullValue());
		assertThat(
				drug.getActive(),
				nullValue());
		assertThat(
				drug.getInactive(),
				nullValue());
		assertThat(
				drug.getWarnings(),
				nullValue());
		assertThat(
				drug.getIndicationsAndUsage(),
				nullValue());
		assertThat(
				drug.getName(),
				nullValue());
	}

	@Test
	public void shouldhandleMissingResults() throws IOException
	{
		final URL url = Resources.getResource("missingresults.json");
		final String text = Resources.toString(url, Charsets.UTF_8);
		final ContentProducingMockHttpTransport transport = new ContentProducingMockHttpTransport(text);
		final OpenFdaGatewayImpl g = new OpenFdaGatewayImpl();
		g.transport = transport;

		final DrugLabel drug = g.getLabel("empty");

		assertThat(
				drug.getAskDoctor(),
				nullValue());
		assertThat(
				drug.getAskDoctorOrPharmacist(),
				nullValue());
		assertThat(
				drug.getDosage(),
				nullValue());
		assertThat(
				drug.getDoNotUse(),
				nullValue());
		assertThat(
				drug.getStopUse(),
				nullValue());
		assertThat(
				drug.getActive(),
				nullValue());
		assertThat(
				drug.getInactive(),
				nullValue());
		assertThat(
				drug.getWarnings(),
				nullValue());
		assertThat(
				drug.getIndicationsAndUsage(),
				nullValue());
		assertThat(
				drug.getName(),
				nullValue());
	}
}
