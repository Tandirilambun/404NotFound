package id.ac.ukdw.fti.notfound.modal;

public class Places {
    private String places;
    private String verseText;
    private int verseCount;
    private String displayTitle;
    private String eventsHere;

    //constructor
    public Places(String places, String verseText, String displayTitle, int verseCount){
        this.places = places;
        this.verseText = verseText;
        this.displayTitle = displayTitle;
        this.verseCount = verseCount;
    }

    public void setEventsHere(String eventsHere) {
        this.eventsHere = eventsHere;
    }

    //Method Setter
    public void setPlaces(String places){
        this.places = places;
    }
    public void setVerseText(String verseText){
        this.verseText = verseText;
    }
    public void setVerseCount(int verseCount){
        this.verseCount = verseCount;
    }
    public void displayTitle (String displayTitle){
        this.displayTitle = displayTitle;
    }

    //Method Getter

    public String getEventsHere() {
        return eventsHere;
    }

    public String getPlaces(){
        return this.places;

    }
    public String getVerseText(){
        return this.verseText;
    }
    public String getfDisplayTitle(){
        return this.displayTitle;
    }
    public int verseCount(){
        return this.verseCount;
    }
}
