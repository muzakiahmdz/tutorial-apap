package apap.tutorial.manpromanpro.controller;

import java.util.UUID;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.manpromanpro.controller.DTO.ProyekDTO;
import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.service.ProyekService;

@Controller
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @GetMapping("/")
    private String home() {
        return "home";
    }

    @GetMapping("/proyek/add")
    public String addProyekForm(Model model) {
        // Membuat DTO baru sebagai isian form pengguna
        var proyekDTO = new ProyekDTO();
        model.addAttribute("proyekDTO", proyekDTO);
        return "form-add-proyek";
    }

    @PostMapping("/proyek/add")
    public String addProyek(@ModelAttribute ProyekDTO proyekDTO, Model model) {
        // Cek validasi tanggal
        if (proyekDTO.getTanggalSelesai().before(proyekDTO.getTanggalMulai())) {
            return "errorTanggal.html"; // Arahkan ke halaman error jika validasi gagal
        }

        // Generate UUID baru untuk proyek
        UUID idProyek = UUID.randomUUID();

        // Membuat objek proyek baru dengan data dari DTO
        var proyek = new Proyek(idProyek, proyekDTO.getNama(), proyekDTO.getTanggalMulai(),proyekDTO.getTanggalSelesai(), proyekDTO.getStatus(), proyekDTO.getDeveloper());

        // Memanggil service untuk menambahkan proyek
        proyekService.createProyek(proyek);

        // add variabel id proyek ke 'id' untuk dirender di thymeleaf
        model.addAttribute("id", proyek.getId());

        // add variabel nama proyek ke 'Nama' untuk dirender di thymeleaf
        model.addAttribute("Nama", proyek.getNama());

        return "success-add-proyek";
    }

    @GetMapping("/proyek/viewall")
    public String listProyek(Model model) {
        // Mengambil semua proyek yang telah tersimpan
        List<Proyek> listProyek = proyekService.getAllProyek();

        // Add listProyek ke 'listProyek' untuk dirender di thymeleaf
        model.addAttribute("listProyek", listProyek);

        return "viewall-proyek";
    }

    @GetMapping("/proyek/{id}")
    public String detailProyek(@PathVariable UUID id, Model model) {
        var proyek = proyekService.getProyekById(id);
        model.addAttribute("proyek", proyek);
        return "view-proyek";
    }

    @GetMapping("/proyek/{id}/update")
    public String showUpdateProyekForm(@PathVariable UUID id, Model model) {
        var proyek = proyekService.getProyekById(id);
        if (proyek != null) {
            // Isi DTO dengan data proyek yang ada
            ProyekDTO proyekDTO = new ProyekDTO(
                proyek.getId(), 
                proyek.getNama(), 
                proyek.getTanggalMulai(), 
                proyek.getTanggalSelesai(), 
                proyek.getStatus(), 
                proyek.getDeveloper());
            
            model.addAttribute("proyekDTO", proyekDTO);
            return "form-update-proyek";  // Mengarahkan ke halaman update
        }
        return "redirect:/proyek/viewall";  // Jika tidak ditemukan, kembali ke daftar
    }
    
    @PostMapping("/proyek/{id}/update")
    public String updateProyek(@PathVariable UUID id, @ModelAttribute ProyekDTO proyekDTO, Model model) {
        // Cek validasi tanggal
        if (proyekDTO.getTanggalSelesai().before(proyekDTO.getTanggalMulai())) {
            return "errorTanggal.html"; // Arahkan ke halaman error jika validasi gagal
        }
        var proyek = proyekService.getProyekById(id);
        if (proyek != null) {
            // Perbarui data proyek dengan data dari DTO
            proyek.setNama(proyekDTO.getNama());
            proyek.setTanggalMulai(proyekDTO.getTanggalMulai());
            proyek.setTanggalSelesai(proyekDTO.getTanggalSelesai());
            proyek.setStatus(proyekDTO.getStatus());
            proyek.setDeveloper(proyekDTO.getDeveloper());
            
            model.addAttribute("id", proyek.getId());
            return "success-update-proyek";  // Menampilkan halaman feedback sukses
        }
        return "redirect:/proyek/viewall";
    }
    @GetMapping("/proyek/{id}/delete")
    public String deleteProyek(@PathVariable UUID id, Model model) {
        var proyek = proyekService.getProyekById(id);
        if (proyek != null) {
            proyekService.deleteProyek(id);
            model.addAttribute("id", id);
            return "success-delete-proyek";
        }
        return "redirect:/proyek/viewall";
    }
    

}
