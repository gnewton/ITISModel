package ca.gc.agr.itis.ITISModel;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItisRecordTest extends TestCase {

	ItisRecord fixture = new ItisRecord();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRankSynomyms() {
		ArrayList<String> synonyms = new ArrayList<String>();
		synonyms.add("s1");
		synonyms.add("s2");
		fixture.setRankSynomyms(synonyms);
		
		assertEquals(2, fixture.getRankSynomyms().size());
		
		fixture.addRankSynonym("s3");
		
		assertEquals(3, fixture.getRankSynomyms().size());
		
	}
	
	
	@Test
	public void testVernacularNames() {
		fixture.addVernacularName("namq1", "en");
		fixture.addVernacularName("namq2", "en");
		fixture.addVernacularName("namq3", "fr");
		fixture.addVernacularName("namq4", "fr");
		fixture.addVernacularName("namq5", "fr");
		
		assertEquals(2, fixture.getVernacularNames().size());
		
		assertEquals(2, fixture.getVernacularNames("en").size());
		assertEquals(3, fixture.getVernacularNames("fr").size());
	}
	
	@Test
	public void testTaxonomicHierarchy() {
		TaxonomicRank rank1 = new TaxonomicRank();
		TaxonomicRank rank2 = new TaxonomicRank();
		rank2.addCommonName("name1", "en");
		rank2.addCommonName("name2", "en");
		rank2.addCommonName("name3", "fr");
		ArrayList<TaxonomicRank> hierarchy = new ArrayList<TaxonomicRank>();
		hierarchy.add(rank1);
		hierarchy.add(rank2);
		
		fixture.setTaxonomicHierarchy(hierarchy);
		
		assertEquals(2, fixture.getTaxonomicHierarchy().size());
		
		TaxonomicRank rank3 = new TaxonomicRank();
		rank3.addCommonName("lala", "sp");
		fixture.addTaxonomicHierarchy(rank3);
		
		assertEquals(3, fixture.getTaxonomicHierarchy().size());
		assertEquals(2, fixture.getTaxonomicHierarchy().get(1).getCommonNames("en").size());
		
	}

}
