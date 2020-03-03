package Lucky_Q;

/**
 *  Kelas ini berfungsi sebagai penghubung antara kelas TanyaJawab dan kelas Frame
 *  yang berisikan soal-soal yang akan ditampilkan pada kelas Frame
 *  dan juga berisikan method getSoal dan getJawaban
 * 
 * @author LuckyQuizTeam
 * Projek PBO Angkatan 2017, 01-Januari-2019
 */
public class BankSoal extends Object {
    
    public String getSoal(int a){       
        return tJ[a].getSoal();
    }
    
    public String getJawab(int a){
        return tJ[a].getJawab();
    }
    /**
     * Objek dari class TanyaJawab berupa pertanyaan quiz dan jawabannya
     */
    TanyaJawab tJ[] = {
        new TanyaJawab ("Binatang yang hidup di air dan di darat disebut", "Amfibi"),
        new TanyaJawab ("Bagian pada motor sebagai pembuangan gas ", "Knalpot"),
        new TanyaJawab ("Pusat peredaran tata surya adalah","Matahari"),
        new TanyaJawab ("Ilmu Pengetahuan Alam disebut juga ilmu","Sains"),
        new TanyaJawab ("Gunung tertinggi di dunia adalah Gunung","Everest"),
        new TanyaJawab ("Hewan terkecil adalah","Amuba"),
        new TanyaJawab ("Bahan bakar PLTN adalah","Uranium"),
        new TanyaJawab ("Monumen terkenal di kota Paris adalah menara","Eiffel"),
        new TanyaJawab ("Piramida Giza terletak di negara","Mesir"),
        new TanyaJawab ("Jenis kumbang terbesar adalah kumbang","Goliath"),
        new TanyaJawab ("apakah nama ibukota prancis ?", "paris"),
        new TanyaJawab ("Ikon untuk menyimpan data pada MS Word, adalah","Disket"),
        new TanyaJawab ("Negara terluas keempat di dunia adalah","Amerika-Serikat"),
        new TanyaJawab ("Tumbuhan berduri yang tumbuh di gurun adalah","Kaktus"),
        new TanyaJawab ("Mata uang negara Jepang yaitu","Yen"),
        new TanyaJawab ("Arah jam 9 itu sama dengan arah","Barat"),
        new TanyaJawab ("Vitamin yang banyak terkandung dalam buah-buahan adalah","Vitamin C"),
        new TanyaJawab ("Nama obat untuk membunuh jentik nyamuk di air adalah","Abate"),
        new TanyaJawab ("Alat pembayaran resmi untuk pengiriman melalui pos adalah","Perangko"),
        new TanyaJawab ("Papan catur memiliki kotak-kotak tempat bidak sebanyak ... kotak","64"),
        new TanyaJawab ("Flute adalah alat musik yang dimainkan dengan cara","Ditiup"),
        new TanyaJawab ("Nama resmi negara Belanda adalah","Netherland"),
        new TanyaJawab ("Suara dengan frekuensi 20 - 20.000 Hz termasuk bunyi","Audiosonik"),
        new TanyaJawab ("Indra manusia yang digunakan untuk mengecap adalah","Lidah"),
        new TanyaJawab ("Paus pembunuh adalah nama lain dari paus","Orca"),
        new TanyaJawab ("Ibukota negara Rusia yaitu","Moscow"),
        new TanyaJawab ("Udara yang bergerak disebut juga","Angin"),
        new TanyaJawab ("Bahan yang digunakan lebah untuk membuat madu adalah","Nektar"),
        new TanyaJawab ("Layar komputer disebut juga","Monitor"),
        new TanyaJawab ("Rumput yang tumbuh paling cepat adalah","Bambu"),
        new TanyaJawab ("Provinsi terbarat di Indonesia adalah","Aceh"),
        new TanyaJawab ("Penemu radio berasal dari negara","Italia"),
        new TanyaJawab ("Anjing Pitbull berasal dari negara","Inggris"),
        new TanyaJawab ("Patung Liberty berada di pulau","Liberty"),
        new TanyaJawab ("Ilmu pengetahuan alam .","Sains"),
        new TanyaJawab ("Kota dengan istilah kota hujan adalah kota", "Bogor"), 
        new TanyaJawab ("Nama kapal pesiar yang tenggelam pada 15 Juni 1912 adalah","Titanic"),
        new TanyaJawab ("Sinonim 'Tembok' .","Dinding"),
        new TanyaJawab ("Bahasa Inggris dari kapal selam adalah","Submarine"),
        new TanyaJawab ("Burung tercepat di dunia adalah","Falcon"),
        new TanyaJawab ("Angkor Wat terletak di negara","Kamboja"),
        new TanyaJawab ("Danau terbesar di dunia adalah Danau","Kaspia"),
        new TanyaJawab ("Patung Liberty dibuat di negara","Perancis"),
        new TanyaJawab ("Nama ayah Zuko adalah","Ozai"),
        new TanyaJawab ("Rabun Dekat adalah","Miopi"),
        new TanyaJawab ("Benua beku adalah benua", "Antartika"),
        new TanyaJawab ("Seni menulis Arab disebut", "Kaligrafi"),
        new TanyaJawab ("Mamalia tertinggi adalah", "Jerapah"),
        new TanyaJawab ("Bahan yang digunakan sebagai pengembang adonan kue adalah","Ragi"),
        new TanyaJawab ("Alat pernafasan belalang adalah","Trakea"),
    };
}
