package id.ac.ukdw.fti.notfound.modal;

public class tampil {
    private String osisRef;
    private String verseText;
    private String kitab;
    private String pasal;
    private int ayat;

    // public tampil(String osisRef, String verseText){
    //     this.osisRef = osisRef;
    //     this.verseText = verseText;
    // }

    public tampil(String osisRef, String verseText, int verseNum){
        this.osisRef = osisRef;
        this.verseText = verseText;
    }

    public String getKitab(){
        return this.kitab;
    }
    public String getPasal(){
        return this.pasal;
    }
    public int getAyat(){
        return this.ayat;
    }
    public String getOsisRef(){
        return this.osisRef;
    }
    public String getVerseText(){
        return this.verseText;
    }
}
