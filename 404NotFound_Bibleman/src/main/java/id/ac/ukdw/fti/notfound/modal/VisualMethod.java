package id.ac.ukdw.fti.notfound.modal;

public class VisualMethod {

    private String osisRef;
    private String verseText;
    private String people;
    private String verse;
    private String verseCount;
    private int peopleCount;
    private String places;
    private int placesCount;


    public VisualMethod(String verse, String verseCount) {
        this.verse = verse;
        this.verseCount = verseCount;
    }

    public VisualMethod(String people, int peopleCount, String places, int placesCount) {
        this.people = people;
        this.peopleCount = peopleCount;
        this.places = places;
        this.placesCount = placesCount;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public String getVerseCount() {
        return verseCount;
    }

    public void setVerseCount(String verseCount) {
        this.verseCount = verseCount;
    }

    public void setOsisRef(String osisRef) {
        this.osisRef = osisRef;
    }

    public void setVerseText(String verseText) {
        this.verseText = verseText;
    }

    public void setPeople(String people){
        this.people = people;
    }

    public void setPeopleCount(int peopleCount){
        this.peopleCount = peopleCount;
    }
    public void setPlaces(String places){
        this.places = places;
    }

    public void setPlacesCount(int placesCount){
        this.placesCount = placesCount;
    }

    public String getOsisRef() {
        return osisRef;
    }

    public String getVerseText() {
        return verseText;
    }


    public String getPeople() {
        return people;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public String getPlaces() {
        return places;
    }

    public int getPlacesCount() {
        return placesCount;
    }

    
}
