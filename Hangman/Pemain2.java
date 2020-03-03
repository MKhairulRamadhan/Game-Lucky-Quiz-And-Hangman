/**
 * Class pemain2 adalah kelas yang berfungsi untuk menyimpan dan mengreturn nama
 * dan Skor dari pemain
 *
 * @author Lucky Quiz Team
 * Projek PBO Kelas A Kelompok 6 , 01-Januari-2019
 */

public class Pemain2{
	private String nama;
	private int skor;
	
	/**
	 * Cunstructor 
	 */

	public Pemain2(String nama) {
		this.nama = nama;
		skor = 0;
	}
	
	/**
	 * Method getSkor untuk mengambil skor dari pemain 
	 */
	public int getSkor() {
		return skor;
	}
	
	/**
	 * Method setSkor untuk memberikan Skor kepada pemain
	 */
	public void setSkor(int skor) {
		this.skor = skor;
	}
	
	/**
	 * Method getNama untuk mengambil nama dari pemain
	 */
	public String getNama() {
		return nama;
	}	

	/**
	 * Method setNama untuk memberikan(inisialisasi) nama pemain
	 */
	public void setNama(String nama){
		this.nama = nama;
	}
}