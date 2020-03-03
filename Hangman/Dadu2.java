/**
 * ClassDadu adalah kelas yang berfungsi untuk mengacak dan mengambil nilai dadu
 *
 * @author Lucky Quiz Team
 * Projek PBO Kelas A Kelompok 6 , 01-Januari-2019
 */

public class Dadu2{
	private int dadu;

	/**
	 * Cunstructor 
	 */
	Dadu2(int dadu){
		this.dadu = dadu;
	}

	/**
	 * method setDadu untuk memberikan nilai dadu
	 */
	public void setDadu(int dadu){
		this.dadu = dadu;
	}

	/**
	 * method getDadu untuk mengambil nilai dadu
	 */
	public int getDadu(){
		return dadu;
	}



}