package id.ac.ukdw.fti.notfound.modal;

public class Verses {
    private String osisRef;
    private String verse;
    private String verseText;
    private String eventsDescribed;
    private String places;
    private int peopleCount;
    private int placeCount;
    


    
    public Verses(String search){
        this.eventsDescribed = search;
        this.places = search;
    }
    public Verses(String osisRef, String verseText){
        this.osisRef = osisRef;
        this.verseText = verseText;
    }
    public Verses(String osisRef, String verseText, int peopleCount, int placeCount){
        this.osisRef = osisRef;
        this.verseText = verseText;
        this.peopleCount = peopleCount;
        this.placeCount = placeCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public void setPlaceCount(int placeCount) {
        this.placeCount = placeCount;
    }

    public void setOsisRef(String oString){
        this.osisRef= osisRef;
    }

    public void setVerse (String verse){
        this.verse = verse;
    }

    public void setVerseText (String verseText){
        this.verseText = verseText;
    }

    public void setEventsDescribed (String eventsDescribed){
        this.eventsDescribed = eventsDescribed;
    }

    public void setPlaces (String places){
        this.places = places;
    }

    public int getPeopleCount() {
        return peopleCount;
    }
    public String getOsisRef(){
        return this.osisRef;
    }

    public String getVerse(){
        return this.verse;
    }

    public String getVerseText(){
        return this.verseText;
    }

    public String getEventsDescribed(){
        return this.eventsDescribed;
    }

    public String getPlaces() {
        return this.places;
    }

    public int getPlaceCount() {
        return placeCount;
    }

}
