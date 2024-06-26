
package Gui; //package diberi nama "mahasiswa" (package merupakan file keseluruhan pada classnya dapat menyimpan dengan packegnya yang sama dengan class yang berbeda")

import javax.swing.*; //mengimpor semua kelas yang ada dalam paket javax.swing yang digunakan untuk membuat antarmuka user (GUI) dalam Java
import javax.swing.table.DefaultTableCellRenderer; // mengimpor kelas DefaultTableCellRenderer dari paket javax.swing.table yang digunakan untuk mengatur tampilan bagian dalam tabel pada GUI
import java.awt.*; //mengimpor semua kelas yang ada dalam paket java.awt yang menyediakan komponen dan metode untuk mengatur tampilan dan aksi elemen-elemen GUI

public class CustomHeaderRenderer extends DefaultTableCellRenderer { //mendefinisikan kelas CustomHeaderRenderer yang merupakan turunan dari kelas DefaultTableCellRenderer, digunakan untuk menyesuaikan tampilan header kolom pada tabel
    @Override //memberikan penanda bahwa metode yang diikuti akan mengganti metode yang ada di superclass
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { //mendefinisikan metode getTableCellRendererComponent yang mengembalikan sebuah Component, metode akan memodifikasi tampilan komponen sel pada header kolom tabel
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //memanggil metode superclass getTableCellRendererComponent untuk mendapatkan komponen yang akan diubah tampilannya
        component.setBackground(new Color(30,20,18)); //mengatur warna latar belakang komponen menjadi warna baru yang ditentukan (RGB: 31, 88, 146)
        return component; //mengembalikan komponen yang telah diubah tampilannya
        
    }
}

