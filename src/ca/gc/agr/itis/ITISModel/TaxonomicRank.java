package ca.gc.agr.itis.ITISModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxonomicRank {
	
	private int tsn;
	private String rankName;  // i.e. Kingdom
	private String rankValue; // i.e. Animalia
	private Map<String, List<String>> commonNames;

	public TaxonomicRank() {
		commonNames = new HashMap<String, List<String>>();
	}
	
	
	
	public int getTsn() {
		return tsn;
	}
	public void setTsn(int tsn) {
		this.tsn = tsn;
	}

	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public String getRankValue() {
		return rankValue;
	}
	public void setRankValue(String rankValue) {
		this.rankValue = rankValue;
	}

	public Map<String, List<String>> getCommonNames() {
		return commonNames;
	}
	public void setCommonNames(Map<String, List<String>> commonName) {
		this.commonNames = commonName;
	}
	public List<String> getCommonNames(String language) {
		return commonNames.get(language);
	}
	public void addCommonName(String name, String language){
		List<String> commonNamesPerLanguage = getCommonNames(language);
		if (commonNamesPerLanguage == null) commonNamesPerLanguage = new ArrayList<String>();
		commonNamesPerLanguage.add(name);
		commonNames.put(language, commonNamesPerLanguage);
	}

	

}
