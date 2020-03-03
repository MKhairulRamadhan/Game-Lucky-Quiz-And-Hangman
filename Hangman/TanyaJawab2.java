/**
 * Class TanyaJawab2 adalah kelas yang berfungsi untuk menyimpan dan mengreturn soal dan jawaban
 *
 * @author Lucky Quiz Team
 * Projek PBO Kelas A Kelompok 6 , 01-Januari-2019
 */

public class TanyaJawab2 {
	private String soal;
	private String jawaban;
	
	/**
	 * Cunstructor 
	 */
	public TanyaJawab2(String soal, String jawaban){
		this.soal = soal;								//memberikan nilai awal
		this.jawaban = jawaban;
	}

	/**
	 * Method getSoal untuk mengambil soal
	 */
	public String getSoal(){
		return soal;
	}
	
	/**
	 * setSoal untuk memberikan nilai soal(isi soal)
	 */
	public void setSoal(String soal) {
		this.soal = soal;
	}
	
	/**
	 * mehtod getJawaban untuk mengambil Jawaban 
	 */
	public String getJawaban() {
		return jawaban;
	}
	
	/**
	 * methood setJawaban untuk memberikan nilai untuk jawaban
	 */
	public void setJawaban(String jawaban) {
		this.jawaban = jawaban;
	}
	
}
