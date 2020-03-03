package Lucky_Q;

/**
 * Class TanyaJawab ini berisi variabel, method constructor, mutator, accessor
 * yang berhubungan dengan soal dan jawabannya.
 *
* @author LuckyQuizTeam
 * Projek PBO Angkatan 2017, 01-Januari-2019
 */
public class TanyaJawab extends Object{
    // Variabel soal dan jawaban
    private String soal;
    private String jawaban;
   
    /**
     * Method constructor dari class TanyaJawab
     * @param soal
     * @param jawaban
     */
    public TanyaJawab(String soal, String jawaban){
        this.soal = soal;
        this.jawaban = jawaban;
    }
   
    /**
     * Method accessor untuk memperoleh soal
     * @return soal
     */
    public String getSoal(){
        return soal;
    }
   
    /**
     * Method mutator untuk mengubah soal
     * @param soal
     */
    public void setSoal(String soal){
        this.soal = soal;
    }
   
    /**
     * Method accessor untuk memperoleh jawaban
     * @return jawaban
     */
    public String getJawab(){
        return jawaban;
    }
   
    /**
     * Method mutator untuk mengubah jawaban
     * @param jawaban
     */
    public void setJawab(String jawaban){
        this.jawaban = jawaban;
    }
}
