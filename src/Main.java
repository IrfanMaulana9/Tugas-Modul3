import java.util.Random;
import java.util.Scanner;

/**
 * Kelas utama untuk permainan Tebak Angka.
 * Pengguna harus menebak angka rahasia yang dipilih secara acak.
 */
class TebakAngka {
    private int nomorRahasia;
    private int jumlahTebakan;
    private Scanner scanner;
    private Random random;

    /**
     * Konstruktor untuk memulai permainan Tebak Angka.
     * Inisialisasi scanner dan random number generator.
     */
    public TebakAngka() {
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.jumlahTebakan = 0;
    }

    /**
     * Memulai permainan Tebak Angka.
     * Inisialisasi permainan, menampilkan pesan selamat datang, dan menjalankan loop permainan.
     */
    public void mulaiPermainan() {
        inisialisasiPermainan();
        tampilkanPesanSelamatDatang();

        boolean tebakanBenar = false;
        while (!tebakanBenar) {
            int tebakan = dapatkanTebakanPengguna();
            tebakanBenar = periksaTebakan(tebakan);
        }

        tampilkanHasilAkhir();
        scanner.close();
    }

    /**
     * Menginisialisasi permainan dengan memilih angka rahasia secara acak.
     */
    private void inisialisasiPermainan() {
        setNomorRahasia(random.nextInt(100) + 1);
    }

    /**
     * Menampilkan pesan selamat datang untuk pemain.
     */
    private void tampilkanPesanSelamatDatang() {
        System.out.println("Selamat datang di permainan Tebak Angka!");
        System.out.println("Saya telah memilih sebuah angka antara 1 dan 100. Coba tebak!");
    }

    /**
     * Meminta tebakan dari pengguna.
     * @return Tebakan pengguna dalam bentuk integer.
     */
    private int dapatkanTebakanPengguna() {
        System.out.print("Masukkan tebakan Anda: ");
        return scanner.nextInt();
    }

    /**
     * Memeriksa tebakan pengguna dan memperbarui jumlah tebakan.
     * @param tebakan Tebakan pengguna.
     * @return true jika tebakan benar, false jika salah.
     */
    private boolean periksaTebakan(int tebakan) {
        incrementJumlahTebakan();

        if (tebakan < getNomorRahasia()) {
            System.out.println("Terlalu rendah! Coba lagi.");
            return false;
        } else if (tebakan > getNomorRahasia()) {
            System.out.println("Terlalu tinggi! Coba lagi.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Menampilkan hasil akhir permainan setelah pengguna berhasil menebak angka rahasia.
     */
    private void tampilkanHasilAkhir() {
        System.out.println("Selamat! Anda berhasil menebak angka " + getNomorRahasia() + " dalam " + getJumlahTebakan() + " tebakan.");
    }

    /**
     * Mendapatkan nilai nomor rahasia.
     * @return Nomor rahasia yang telah dipilih.
     */
    public int getNomorRahasia() {
        return nomorRahasia;
    }

    /**
     * Mengatur nilai nomor rahasia.
     * @param nomorRahasia Nomor rahasia yang akan diset, harus berada dalam rentang 1-100.
     * @throws IllegalArgumentException Jika nomor rahasia di luar rentang 1-100.
     */
    private void setNomorRahasia(int nomorRahasia) {
        if (nomorRahasia > 0 && nomorRahasia <= 100) {
            this.nomorRahasia = nomorRahasia;
        } else {
            throw new IllegalArgumentException("Nomor rahasia harus antara 1 dan 100");
        }
    }

    /**
     * Mendapatkan jumlah tebakan yang telah dilakukan.
     * @return Jumlah tebakan.
     */
    public int getJumlahTebakan() {
        return jumlahTebakan;
    }

    /**
     * Menambah jumlah tebakan yang telah dilakukan.
     */
    private void incrementJumlahTebakan() {
        this.jumlahTebakan++;
    }

    /**
     * Titik masuk utama program.
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        new TebakAngka().mulaiPermainan();
    }
}