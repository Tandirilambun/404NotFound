package id.ac.ukdw.fti.notfound.modal;

public class Event {
    private String title;
    private int startDate;
    private String verses;
    private String location;

    //constructor

    //method setter
    public void setTitle(String title){
        this.title = title;
    }
    public void setStartDate (int startDate){
        this.startDate = startDate;
    }
    public void setVerses(String verses){
        this.verses = verses;
    }
    public void setLocation(String location){
        this.location = location;
    }

    //method getter
    public String getTitle(){
        return this.title;
    }
    public int getStartDate(){
        return this.startDate;
    }
    public String getVerses(){
        return this.verses;
    }
    public String getLocation(){
        return this.location;
    }

}
