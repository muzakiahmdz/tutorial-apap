package apap.tutorial.manpromanpro.controller.DTO;

import java.util.UUID;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

public class ProyekDTO {
    private UUID id;
    private String nama;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalMulai;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalSelesai;

    private String status;
    private String developer;

    // Constructor kosong
    public ProyekDTO() {}

    // Constructor dengan parameter
    public ProyekDTO(UUID id, String nama, Date tanggalMulai, Date tanggalSelesai, String status, String developer) {
        this.id = id;
        this.nama = nama;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.status = status;
        this.developer = developer;
    }

    // Getter dan Setter untuk setiap field
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}
