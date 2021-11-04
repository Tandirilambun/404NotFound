package id.ac.ukdw.fti.notfound.modal;

public class Verses {
    private String verse;
    private String verseText;
    private String eventsDescribed;

    public void setVerse (String verse){
        this.verse = verse;
    }

    public void setVerseText (String verseText){
        this.verseText = verseText;
    }

    public void setEventsDescribed (String eventsDescribed){
        this.eventsDescribed = eventsDescribed;
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
    
}
