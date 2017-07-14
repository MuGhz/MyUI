package id.ac.ui.cs.myui.model;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by ekanaradhipa.d on 14/07/17.
 */

public class Sidang {
    String term;
    String ruangan;
    String jamSelesai;
    String judul;
    String jenisSidang;
    String mahasiswa;
    String tanggal;
    List<Dosen> dosens;

    public Sidang(String term, String ruangan, String jamSelesai, String judul, String jenisSidang, String mahasiswa, String tanggal, List<Dosen> dosens) {
        this.term = term;
        this.ruangan = ruangan;
        this.jamSelesai = jamSelesai;
        this.judul = judul;
        this.jenisSidang = jenisSidang;
        this.mahasiswa = mahasiswa;
        this.tanggal = tanggal;
        this.dosens = dosens;
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

    public String getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(String jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJenisSidang() {
        return jenisSidang;
    }

    public void setJenisSidang(String jenisSidang) {
        this.jenisSidang = jenisSidang;
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


    //
//    public Sidang (String term, String ruangan, String jamSelesai, String judul, String jenisSidang, String mahasiswa, String tanggal, List<Dosen> dosens){
//        this.term = term;
//        this.ruangan = ruangan;
//        this.jamSelesai =
//    }

}
