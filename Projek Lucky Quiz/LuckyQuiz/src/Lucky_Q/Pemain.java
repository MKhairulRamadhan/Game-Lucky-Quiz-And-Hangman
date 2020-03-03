package Lucky_Q;

/**
 * Class Pemain ini berisi variabel, method constructor, mutator, accessor
 * yang berhubungan dengan pemain dan nilainya.
 *
 * @author LuckyQuizTeam
 * Projek PBO Angkatan 2017, 01-Januari-2019
 */
public class Pemain extends Object {
    // Variabel nama pemain dan nilai  
    private String nama;
    private int nilai=0;
    
    /**
     * Method constructor dari class Pemain
     * @param nama
     */
    public Pemain(String nama){
        this.nama=nama;
    }
    
    /**
     * Method accessor untuk memperoleh nama pemain
     * @return nama
     */
    public String getNama(){
        return this.nama;
    }
    
    /**
     * Method mutator untuk mengubah nama pemain
     * @param nama
     */
    public void setNama(String nama){
        this.nama = nama;
    }
    
    /**
     * Method accessor untuk memperoleh nilai
     * @return nilai
     */
    public int getNilai(){
        return nilai;
    }
    
    /**
     * Method mutator untuk mengubah nilai pemain
     * @param nilai
     */
    public void setNilai(int nilai){
        this.nilai=nilai;
    }
}
