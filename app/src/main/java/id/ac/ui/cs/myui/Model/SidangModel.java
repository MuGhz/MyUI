package id.ac.ui.cs.myui.Model;

import java.util.List;

/**
 * Created by maulana.wisnu on 14/07/17.
 */

public class SidangModel {

    String term;
    String ruangan;
    String jamselesai;
    String judul;
    String jenissidang;
    String mahasiswa;
    String tanggal;
    List<Dosen> dosens;
    String jammulai;

    public SidangModel(String term, String ruangan, String jamselesai, String judul, String jenissidang, String mahasiswa, String tanggal, List<Dosen> dosens, String jammulai) {
        this.term = term;
        this.ruangan = ruangan;
        this.jamselesai = jamselesai;
        this.judul = judul;
        this.jenissidang = jenissidang;
        this.mahasiswa = mahasiswa;
        this.tanggal = tanggal;
        this.dosens = dosens;
        this.jammulai = jammulai;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public String getJamselesai() {
        return jamselesai;
    }

    public void setJamselesai(String jamselesai) {
        this.jamselesai = jamselesai;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJenissidang() {
        return jenissidang;
    }

    public void setJenissidang(String jenissidang) {
        this.jenissidang = jenissidang;
    }

    public String getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(String mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public List<Dosen> getDosens() {
        return dosens;
    }

    public void setDosens(List<Dosen> dosens) {
        this.dosens = dosens;
    }

    public String getJammulai() {
        return jammulai;
    }

    public void setJammulai(String jammulai) {
        this.jammulai = jammulai;
    }
}
