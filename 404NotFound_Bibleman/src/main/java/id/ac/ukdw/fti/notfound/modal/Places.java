package id.ac.ukdw.fti.notfound.modal;

public class Places {
    private String places;
    private String verseText;
    private int verseCount;
    private String displayTitle;
    private Float latitude;
    private Float longitude;

    //constructor
    public Places(String places, String verseText, String displayTitle, int verseCount){
        this.places = places;
        this.verseText = verseText;
        this.displayTitle = displayTitle;
        this.verseCount = verseCount;
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
    public void setLatitude (Float latitude){
        this.latitude = latitude;
    }
    public void setLongitude (Float longitude){
        this.longitude = longitude;
    }

    //Method Getter
    public Float getLatitude(){
        return this.latitude;
    }

    public Float getLongitude(){
        return this.longitude;
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
