package id.ac.ui.cs.myui.model;

/**
 * Created by ekanaradhipa.d on 14/07/17.
 */

public class Dosen {
    String nama;
    String role;

    public Dosen(String nama, String role) {
        this.nama = nama;
        this.role = role;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
