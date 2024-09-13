# Tutorial APAP

## Authors

* *Muzaki Ahmad Ridho Azizy - 2206824924

## Tutorial 2
### Apa yang telah saya pelajari hari ini
- Saya belajar tentang service, yaitu module atau bagian kita mengelola logika dari suatu web serta keseluruhan framewrok Springboot lebih mendalam lagi seperti control dan dto. Saya juga kilas balik terkait pbp dan ddp 2

### Pertanyaan 
1. Jelaskan kegunaan DTO pada proyek ini? Apakah bisa jika sebuah proyek tidak menggunakan DTO sama sekali?
   - DTO (Data Transfer Object) pada proyek ini berfungsi memisahkan data model di backend dari data yang dikirim atau diterima melalui view (HTML), sehingga memudahkan validasi dan manipulasi sebelum data disimpan di database, serta mengurangi risiko kebocoran data. Dengan menggunakan **ProyekDTO**, data form dapat dikumpulkan tanpa langsung menghubungkan ke entity utama, memberikan fleksibilitas lebih dalam pengolahan data. Meskipun proyek bisa berjalan tanpa DTO, hal ini akan membuat validasi lebih sulit, meningkatkan risiko kebocoran data, dan memperumit pengelolaan kode, terutama dalam aplikasi berskala besar. Oleh karena itu, penggunaan DTO sangat disarankan untuk menjaga keamanan dan memastikan struktur kode yang lebih teratur.
    - Referensi : https://stackoverflow.com/questions/63643331/shall-i-use-a-dto-or-not


2. Apa itu UUID? Mengapa UUID digunakan? Pada proyek ini, UUID digunakan sebagai apa?
UUID (Universally Unique Identifier) adalah 128-bit identifier yang unik secara global. UUID dapat menghasilkan nilai yang unik di seluruh dunia, bahkan tanpa koordinasi dari sistem pusat, menjadikannya sangat berguna dalam sistem terdistribusi.
UUID digunakan karena keunikan global yang diberikan tanpa perlu menjaga urutan di database seperti auto-increment, serta meningkatkan keamanan karena tidak memperlihatkan data urutan. UUID juga memastikan keunikan dalam skala besar dan cocok untuk aplikasi yang memerlukan ID unik di berbagai sistem dan perangkat.
Pada proyek ini, UUID digunakan sebagai ID proyek untuk mengidentifikasi proyek secara unik sehingga tidak ada duplikasi ID dalam sistem.

Referensi : https://www.techtarget.com/searchapparchitecture/definition/UUID-Universal-Unique-Identifier



3. Pada service, mengapa perlu ada pemisahan antara interface dan implementasinya? Apa keuntungan pemisahan tersebut?

Dalam proyek, pemisahan antara interface dan implementasi service mendukung prinsip loose coupling, di mana controller bergantung pada abstraksi (interface) daripada implementasi konkret. Interface menentukan kontrak atau metode yang perlu diimplementasikan, sementara implementasi adalah detail bagaimana metode itu dilakukan.
Keuntungan dari pemisahan ini antara lain: fleksibilitas untuk mengganti implementasi tanpa memengaruhi kode lain yang menggunakan service, mempermudah pengujian dengan menggunakan mock service, dan meningkatkan modularitas serta skalabilitas proyek.

Referensi : https://stackoverflow.com/questions/383947/what-does-it-mean-to-program-to-an-interface


4. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat.

Anotasi @Autowired mengimplementasikan konsep Dependency Injection (DI) di Spring Framework. Ini memungkinkan Spring untuk secara otomatis menyuntikkan dependensi yang diperlukan ke dalam class tanpa perlu membuat instance manual. 
Dalam konteks service dan controller di proyek ini, anotasi @Autowired pada controller menyuntikkan instance dari ProyekService ke dalam ProyekController. Saat aplikasi berjalan, Spring membuat instance service (misalnya, ProyekServiceImpl) dan secara otomatis menyuntikkannya ke controller yang memerlukannya.

Referensi :https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html


5. Apa perbedaan @GetMapping dan @PostMapping? Kapan @GetMapping dan @PostMapping digunakan?

@GetMapping digunakan untuk menangani permintaan HTTP GET, umumnya untuk mengambil data atau menampilkan halaman (misalnya, menampilkan form untuk diisi). 
@PostMapping digunakan untuk menangani permintaan HTTP POST, biasanya untuk mengirimkan data ke server, seperti mengirimkan data form untuk membuat atau memperbarui proyek. 
Intinya, @GetMapping digunakan untuk membaca data dari server, sedangkan @PostMapping digunakan untuk mengirimkan atau memodifikasi data di server.

Referensi :https://stackoverflow.com/questions/14254049/spring-framework-difference-between-get-and-post

6. Apakah terdapat jenis mapping lain yang dapat digunakan? Jelaskan minimal 3 jenis mapping lain!

@PutMapping: Digunakan untuk menangani permintaan HTTP PUT. Biasanya digunakan untuk memperbarui seluruh data dari resource yang sudah ada di server. 
@DeleteMapping: Digunakan untuk menangani permintaan HTTP DELETE. Digunakan untuk menghapus data dari server, seperti menghapus entitas berdasarkan ID. 
@PatchMapping: Digunakan untuk menangani permintaan HTTP PATCH. Berbeda dengan PUT, PATCH digunakan untuk memperbarui sebagian dari resource.

Referensi : https://www.geeksforgeeks.org/spring-deletemapping-and-putmapping-annotation/

7. Jelaskan proses yang terjadi di controller, model, dan service pada proses create proyek, mulai dari fungsi addFormProyek hingga pengguna menerima halaman success-add-proyek.

Controller (addProyekForm): Menampilkan form kosong untuk pengguna dengan menggunakan anotasi @GetMapping. 
Pengguna mengisi form: Setelah form diisi, data dikirim ke server dengan menggunakan @PostMapping pada controller. 
DTO dan Model: Data dari form dimasukkan ke dalam DTO (ProyekDTO), kemudian dikonversi ke model Proyek. 
Service: Controller memanggil ProyekService untuk memproses dan menyimpan data proyek baru ke database. 
View: Setelah proyek berhasil disimpan, pengguna diarahkan ke halaman sukses (success-add-proyek) yang menunjukkan bahwa proyek telah dibuat.

Referensi : https://spring.io/guides/gs/serving-web-content


8. Jelaskan mengenai th:object!

th:object adalah atribut di Thymeleaf yang digunakan untuk mengikat form HTML dengan objek model. Dengan th:object, semua elemen dalam form dapat secara otomatis terkait dengan atribut objek yang ditentukan, memungkinkan binding data secara otomatis saat form dikirimkan. 
Dalam proyek ini, th:object digunakan untuk menghubungkan form dengan ProyekDTO sehingga setiap input form dapat dikaitkan langsung dengan atribut dari ProyekDTO.

Referensi : https://teamtreehouse.com/community/how-to-add-an-object-and-then-another-object-as-an-attribute-to-the-first-object-in-a-thymeleaf-template


9. Jelaskan mengenai th:field!
TIPS: Buka “view page source” dari halaman Tambah Proyek di browser. Lakukan screenshot kemudian jelaskan temuan kalian.

- ![alt text](image-1.png)

th:field digunakan untuk memetakan input dari form HTML ke atribut dalam objek model. Atribut ini memudahkan binding data antara form dan objek yang dikirimkan ke backend. 
Misalnya, di halaman Tambah Proyek, th:field digunakan untuk mengikat nilai dari input HTML seperti nama, tanggalMulai, tanggalSelesai ke atribut yang sesuai di objek ProyekDTO.

Referensi : https://www.baeldung.com/thymeleaf-in-spring-mvc

10. Apakah terdapat jenis “th” lainnya? Jelaskan minimal 3 jenis “th” lainnya yang kamu temukan!

th:classappend: Digunakan untuk menambahkan kelas CSS secara dinamis ke elemen berdasarkan kondisi tertentu. 
th:href: Digunakan untuk menetapkan atribut href pada elemen <a> yang mengarahkan ke link dinamis. 
th:text: Digunakan untuk menampilkan teks dinamis dalam elemen HTML berdasarkan data dari model.

Referensi : https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#standard-expression-syntax

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

- [ ] **Apakah bisa convert int to roman dgn tipe string?** 

- [x] **Kenapa..?**
