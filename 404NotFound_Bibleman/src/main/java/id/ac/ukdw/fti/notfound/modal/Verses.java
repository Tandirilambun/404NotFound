package id.ac.ukdw.fti.notfound.modal;

public class Verses {
    private String osisRef;
    private String verse;
    private String verseText;
    private String eventsDescribed;
    private String places;

    public Verses(String search){
        this.eventsDescribed = search;
        this.places = search;
    }
    public Verses(String osisRef, String verseText){
        this.osisRef = osisRef;
        this.verseText = verseText;
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

}
