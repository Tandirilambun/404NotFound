package id.ac.ukdw.fti.notfound.modal;

public class Verses {
    private String verse;
    private String verseText;
    private String eventsDescribed;
    private String displayTitle;

    public void setVerse (String verse){
        this.verse = verse;
    }

    public void setVerseText (String verseText){
        this.verseText = verseText;
    }

    public void setEventsDescribed (String eventsDescribed){
        this.eventsDescribed = eventsDescribed;
    }

    public void setDisplayTitle (String displayTitle){
        this.displayTitle = displayTitle;
    }

    public String getVerse(){
        if(this.verse==null){
            return "null";
        }
        return this.verse;
    }

    public String getVerseText(){
        if(this.verseText==null){
            return "null";
        }
        return this.verseText;
    }

    public String getEventsDescribed(){
        if(this.eventsDescribed==null){
            return "null";
        }
        return this.eventsDescribed;
    }

    public String getDisplayTitle() {
        if(this.displayTitle==null){
            return "null";
        }
        return this.displayTitle;
    }

}
