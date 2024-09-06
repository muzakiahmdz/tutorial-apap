## Tutorial 1

### Apa yang telah saya pelajari hari ini

#### GitLab

1. **Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**  
   Issue Tracker adalah fitur yang digunakan untuk mencatat, melacak, dan mengelola masalah atau pekerjaan yang harus diselesaikan dalam suatu proyek. Masalah yang bisa diselesaikan antara lain bug, permintaan fitur baru, peningkatan proyek, dan tugas yang memerlukan penyelesaian dalam proses pengembangan.

2. **Saat membuat Merge Request, terdapat 2 merge options yang diceklis. Jelaskan fungsi dari kedua pilihan tersebut! Mengapa hanya squash yang diceklis?**  
   - **Squash Commits**: Fungsinya untuk menggabungkan beberapa commit menjadi satu commit sebelum merge dilakukan. Ini menjaga riwayat commit tetap rapi dan tidak berantakan.
   - **Rebase without Fast-Forward**: Opsi ini melakukan rebase cabang, menempatkan commit baru di atas commit yang ada di cabang target tanpa mengubah urutan commit.

   Hanya **Squash** yang diceklis untuk menjaga riwayat commit tetap bersih, terutama jika ada banyak commit kecil yang tidak signifikan.

3. **Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?**  
   Beberapa keunggulan menggunakan Git antara lain:
   - **Versioning**: Melacak perubahan kode secara sistematis sehingga setiap versi kode dapat dipulihkan jika terjadi kesalahan.
   - **Kolaborasi**: Memungkinkan banyak pengembang untuk bekerja pada proyek yang sama tanpa konflik kode.
   - **Branching**: Memungkinkan pembuatan branch untuk fitur baru tanpa mengganggu kode utama, sehingga pengembangan lebih terstruktur.

#### Spring

4. **Apa itu Gradle? Mengapa kita menggunakan Gradle? Apakah ada alternatif dari Gradle?**  
   Gradle adalah alat otomasi build yang digunakan untuk mengelola dependensi dan melakukan build proyek. Kita menggunakan Gradle karena efisiensinya dalam menangani proyek besar, fleksibilitas scripting, dan kompatibilitasnya dengan Java.  
   Alternatif Gradle antara lain **Maven** dan **Ant**.

5. **Apa perbedaan dari `@RequestParam` dan `@PathVariable`?**  
   - **@RequestParam** digunakan untuk menangani parameter query yang dikirimkan melalui URL, misalnya `?param=value`.
   - **@PathVariable** digunakan untuk menangani variabel yang merupakan bagian dari path URL, misalnya `/path/{id}`.

6. **Apa itu DTO? Apakah DTO harus selalu digunakan? Kapan sebaiknya kita menggunakan DTO?**  
   DTO (Data Transfer Object) adalah objek yang digunakan untuk mentransfer data antara lapisan-lapisan dalam aplikasi. DTO tidak selalu harus digunakan, namun biasanya bermanfaat untuk menjaga keamanan dan memisahkan logika bisnis dari lapisan data. Sebaiknya digunakan ketika ada kebutuhan untuk menghindari transfer data sensitif atau untuk memformat data agar sesuai dengan kebutuhan API.

7. **Jelaskan bagaimana alur ketika kita menjalankan http://localhost:8080/roman-converter/MMXXIV sampai dengan muncul keluarannya di browser!**  
   Ketika URL ini diakses:
   - Server menerima permintaan GET di endpoint `/roman-converter/MMXXIV`.
   - Controller akan memanggil service yang mengonversi bilangan Romawi menjadi angka desimal.
   - Hasil konversi dikembalikan ke controller dan ditampilkan di halaman web melalui View.

8. **Jelaskan bagaimana alur ketika kita menjalankan http://localhost:8080/roman-converter?roman=MMXXIV sampai dengan muncul keluarannya di browser!**  
   Alurnya hampir sama dengan nomor 7, bedanya:
   - Parameter Romawi diterima sebagai query parameter `roman=MMXXIV`.
   - Controller mengambil nilai query parameter dan meneruskannya ke service untuk dikonversi menjadi angka desimal.

9. **Jelaskan bagaimana alur ketika kita menjalankan http://localhost:8080/convert sampai dengan muncul keluarannya di browser!**  
   - Server menerima permintaan GET untuk form konversi bilangan Romawi.
   - Controller merespons dengan menampilkan halaman form di browser.
   - Pengguna memasukkan bilangan Romawi dan mengirimkan form.
   - Server mengonversi input dan menampilkan hasilnya.

10. **Pada Tutorial 1 - Panduan bagian Spring Boot > VS Code / IDE > langkah 4, kita mendapati error. Apa penyebabnya?**  
    Penyebab error ini kemungkinan karena konfigurasi yang salah atau ketidaksesuaian versi dependency di `build.gradle`. Memeriksa commit `feat: tutorial 1 - initialize spring boot project` bisa membantu menemukan versi kode yang benar untuk memperbaiki masalah tersebut.


### Apa yang belum saya pahami

- [ ] **Masih banyak yang belum saya pahami, sehingga saya akan eksplor terlabih dahulu** 

- [x] **Kenapa..?**
