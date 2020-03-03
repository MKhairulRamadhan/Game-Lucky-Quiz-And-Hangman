package Lucky_Q;

/**
 *  Kelas ini berfungsi untuk mengacak dadu yang berisi method getSisi dan Lempar dadu
 * 
 * @author LuckyQuizTeam
 * Projek PBO Angkatan 2017, 01-Januari-2019
 */
public class Dadu extends Object {
    //Deklarasi variabel
    private int sisi;
    
    /**
     * Method constructor class dadu
     */
    public Dadu(){
        sisi = 1;
    }
    
    /**
     * Method accessor untuk memperoleh sisi dadu
     * @return sisi
     */
    public int getSisi(){
        lemparDadu();
        return this.sisi;
    }
    
    /**
     * Method untuk melempar dadu
     */
    private void lemparDadu(){
        this.sisi = (int)(Math.random()*(6)+1);
    }
}
