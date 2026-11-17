import javax.swing.*;
import java.awt.*;

public class latihanWeek6 extends JFrame {
    public latihanWeek6() {
        super("Tiket Wisata");
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JRadioButton t1 = new JRadioButton("Reguler 50000", true);
        JRadioButton t2 = new JRadioButton("Premium 80000");
        JRadioButton t3 = new JRadioButton("VIP 120000");
        ButtonGroup g = new ButtonGroup(); 
        g.add(t1); g.add(t2); g.add(t3);
        
        JCheckBox guide = new JCheckBox("Tour Guide +50000");
        JCheckBox makan = new JCheckBox("Paket Makan +35000");
        JSpinner jml = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        JButton btn = new JButton("Hitung");
        
        btn.addActionListener(e -> {
            int n = (Integer) jml.getValue(); 
            
            int harga;
            if (t1.isSelected()) { harga = 50000; }
            else if (t2.isSelected()) { harga = 80000; }
            else { harga = 120000; }
            
            if (guide.isSelected()) { harga += 50000; }
            if (makan.isSelected()) { harga += 35000; }
            
            int total = harga * n;
            
            JOptionPane.showMessageDialog(this, 
                "Total Pembayaran: Rp " + total, 
                "Informasi Tagihan", 
                JOptionPane.INFORMATION_MESSAGE);
        });

        setLayout(new GridLayout(0, 1, 5, 5));
        
        add(new JLabel("Pilih Kelas Tiket:"));
        add(t1); add(t2); add(t3); 
        
        add(new JSeparator()); // Garis pemisah opsional
        add(new JLabel("Fasilitas Tambahan:"));
        add(guide); add(makan); 
        
        add(new JSeparator());
        add(new JLabel("Jumlah tiket:")); 
        add(jml); 
        add(btn); 
        
        pack(); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) { 
        SwingUtilities.invokeLater(() -> new latihanWeek6().setVisible(true)); 
    }
}


// jadi di sini saya menggunakan file code (Tiket Bus), yang kemudia saya  ubah menjadi sebuah Tiket Wisata, dan saya menambahkan sedikit materi dari PPT, seperti :
// 1. Look and Feel (Mengubah tema menjadi nimbus)
// 2. JSpinner (Menggantikan JtextField untuk mencegah error pada tipe data)
// 3. JOptionPane (Menampilkan pesan pop up)