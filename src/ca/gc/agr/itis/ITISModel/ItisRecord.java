package ca.gc.agr.itis.ITISModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ItisRecord {
	
    // id for this record
    private String tsn;
	
    //i.e. Scientific Name; scientificName.combinedName
    private String combinedName;
    //scientificName.author
    private String nameAuthor;
    private List<String> rankSynomyms;
	

    // *** Taxonomy and Nomenclature part
    //kingdom and rank are extracted from taxonomicHierarchy

    //commonNameList.commonName  - commonNameList.language
    // key: language; value: list of vernacular names
    private Map<String, List<String>> vernacularNames; 

    // TaxonomicStanding
    private String currentTaxonomicStanding;
	
    //taxonUsageRating
    private String globalSpecies;             // Taxonomic Status: globalSpecies
    private String completeness;              // Taxonomic Status: completeness
    private String currencyRating;            // Taxonomic Status: currency


    //credRating
    private String recordCredibilityRating;    // Data Quality Indicators
	
	
    // *** Taxonomy Hierarchy part
	
    //Hierarchical list
    private List<TaxonomicRank> taxonomicHierarchy;
    // Flat list to display under taxonomic hierarchy
    private List<TaxonomicRank> belowSpeciesRanks;
	
	
    // *** References part
    //expertList
    List<TaxonExpert> experts;
    //otherSourceList
    List<TaxonOtherSource> otherSources;
    //publicationList
    List<TaxonPublication> references;
	
    //geographicDivisionList.geographicValue
    private String geographicInfo;
    private List<TaxonComment> comments;
	
	
    public ItisRecord() {
	rankSynomyms = new ArrayList<String>();
	vernacularNames = new HashMap<String, List<String>>();
	taxonomicHierarchy = new ArrayList<TaxonomicRank>();
	belowSpeciesRanks = new ArrayList<TaxonomicRank>();
	experts = new ArrayList<TaxonExpert>();
	otherSources = new ArrayList<TaxonOtherSource>();
	references = new ArrayList<TaxonPublication>();
	comments = new ArrayList<TaxonComment>();
    }
	
	
	
	
	
    public String getTsn() {
	return tsn;
    }
    public void setTsn(String tsn) {
	this.tsn = tsn;
    }

    public String getCombinedName() {
	return combinedName;
    }
    public void setCombinedName(String combinedName) {
	this.combinedName = combinedName;
    }

    public String getNameAuthor() {
	return nameAuthor;
    }
    public void setNameAuthor(String nameAuthor) {
	this.nameAuthor = nameAuthor;
    }

    public List<String> getRankSynomyms() {
	return rankSynomyms;
    }
    public void setRankSynomyms(List<String> rankSynomym) {
	this.rankSynomyms = rankSynomym;
    }
    public void addRankSynonym(String synonym) {
	rankSynomyms.add(synonym);
    }

    /**
     * @return kingdom for this record; null if taxonomic hierarchy was not set
     */
    public String getKingdom(){
	if (taxonomicHierarchy == null) return null;
		
	return taxonomicHierarchy.get(0).getRankValue();
    }

    /**
     * @return rank for this record; null if taxonomic hierarchy was not set
     */
    public String getRank(){
	if (taxonomicHierarchy == null) return null;
		
	int lastElement = taxonomicHierarchy.size() - 1;
	return taxonomicHierarchy.get(lastElement).getRankName();
    }

	
    public Map<String, List<String>> getVernacularNames() {
	return vernacularNames;
    }
    public void setVernacularNames(Map<String, List<String>> vernacularNames) {
	this.vernacularNames = vernacularNames;
    }
    public List<String> getVernacularNames(String language) {
	return vernacularNames.get(language);
    }
    public void addVernacularName(String name, String language){
	List<String> namesPerLanguage = getVernacularNames(language);
	if (namesPerLanguage == null) namesPerLanguage = new ArrayList<String>();
	namesPerLanguage.add(name);
	vernacularNames.put(language, namesPerLanguage);
    }



    public String getCurrentTaxonomicStanding() {
	return currentTaxonomicStanding;
    }
    public void setCurrentTaxonomicStanding(String currentTaxonomicStanding) {
	this.currentTaxonomicStanding = currentTaxonomicStanding;
    }

    public String getGlobalSpecies(){
	return this.globalSpecies;
    }
    public void setGlobalSpecies(String globalSpecies){
	this.globalSpecies = globalSpecies;
    }
    public String getCompleteness(){
	return this.completeness;
    }
    public void setCompleteness(String completeness){
	this.completeness = completeness;
    }
    public String getCurrencyRating(){
	return this.currencyRating;
    }
    public void setCurrencyRating(String currencyRating){
	this.currencyRating = currencyRating;
    }



    public List<TaxonomicRank> getTaxonomicHierarchy() {
	return taxonomicHierarchy;
    }
    public void setTaxonomicHierarchy(List<TaxonomicRank> taxonomicHierarchy) {
	this.taxonomicHierarchy = taxonomicHierarchy;
    }
    public void addTaxonomicHierarchy(TaxonomicRank taxonomicRank){
	taxonomicHierarchy.add(taxonomicRank);
    }


    public List<TaxonomicRank> getBelowSpeciesRanks() {
	return belowSpeciesRanks;
    }
    public void setBelowSpeciesRanks(List<TaxonomicRank> belowSpeciesRanks) {
	this.belowSpeciesRanks = belowSpeciesRanks;
    }
    public void addBelowSpeciesRank(TaxonomicRank taxonomicRank){
	belowSpeciesRanks.add(taxonomicRank);	
    }


    public List<TaxonExpert> getExperts() {
	return experts;
    }
    public void setExperts(List<TaxonExpert> experts) {
	this.experts = experts;
    }
    public void addExpert(TaxonExpert taxonExpert) {
	this.experts.add(taxonExpert);
    }
	


    public List<TaxonOtherSource> getOtherSources() {
	return otherSources;
    }
    public void setOtherSources(List<TaxonOtherSource> otherSources) {
	this.otherSources = otherSources;
    }
    public void addOtherSource(TaxonOtherSource taxonOtherSource) {
	this.otherSources.add(taxonOtherSource);
    }


    public List<TaxonPublication> getReferences() {
	return references;
    }
    public void setReferences(List<TaxonPublication> references) {
	this.references = references;
    }
    public void addReference(TaxonPublication taxonPublication) {
	this.references.add(taxonPublication);
    }


    public String getGeographicInfo() {
	return geographicInfo;
    }
    public void setGeographicInfo(String geographicInfo) {
	this.geographicInfo = geographicInfo;
    }


    public List<TaxonComment> getComments() {
	return comments;
    }
    public void setComments(List<TaxonComment> comments) {
	this.comments = comments;
    }
    public void addComment(TaxonComment taxonComment) {
	this.comments.add(taxonComment);
    }



}
