import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;

public class PemesananTiket extends JFrame {
    JPanel panel = new JPanel();
    JLabel TextJudul = new JLabel("Pemesanan Tiket");
    JLabel TextEkonomi = new JLabel("Ekonomi : Rp. 1.000.000");
    JLabel TextBisnis = new JLabel("Bisnis : Rp. 1.500.000");
    JLabel TextFirst = new JLabel("First : Rp. 2.000.000");
    JLabel TextJenisTiket = new JLabel("Jenis Tiket");
    JLabel TextDestinasi = new JLabel("Destinasi");
    JLabel TextJumlahPenumpang = new JLabel("Jumlah Penumpang");
    JLabel TextPelayananTambahan = new JLabel("Pelayanan Tambahan");
    JButton btnOrder = new JButton("Order");

    String[] kelas = {"Ekonomi", "Bisnis", "First"};
    String[] destin = {"Jakarta - Semarang", "Surabaya - Bali", "Medan - Jakarta"};
    String[] service = {"Antar - Jemput", "Bagasi", "Porter"};

    JComboBox ComboKelas = new JComboBox(kelas);
    JComboBox ComboDestinasi = new JComboBox(destin);
    JComboBox ComboPelayanan = new JComboBox(service);
    JSpinner jumlah = new JSpinner();

    int harga;
    int tambahan;
    int total;
    public PemesananTiket(){
        new Database();

        setTitle("Pemesanan Tiket");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480,430);
        panel.setLayout(null);
        panel.setBackground(new Color(255, 199, 94));
        panel.setSize(480,420);

        Font fnt1 = new Font("Arial", Font.BOLD,20);
        Font fnt2 = new Font("Arial", Font.PLAIN,16);

        TextJudul.setBounds(155,10,200,40);
        TextJudul.setFont(fnt1);
        TextEkonomi.setBounds(155,50,200,40);
        TextEkonomi.setFont(fnt2);
        TextBisnis.setBounds(165,70,200,40);
        TextBisnis.setFont(fnt2);
        TextFirst.setBounds(175,90,200,40);
        TextFirst.setFont(fnt2);
        TextJenisTiket.setBounds(100,125,200,40);
        TextJenisTiket.setFont(fnt2);
        TextDestinasi.setBounds(95,180,200,40);
        TextDestinasi.setFont(fnt2);
        TextJumlahPenumpang.setBounds(260,180,200,40);
        TextJumlahPenumpang.setFont(fnt2);
        TextPelayananTambahan.setBounds(162,260,200,40);
        TextPelayananTambahan.setFont(fnt2);

        ComboKelas.setBounds(200,135,160,23);
        ComboDestinasi.setBounds(50,220,170,23);
        ComboPelayanan.setBounds(155,300,170,23);
        jumlah.setBounds(280,220,100,23);

        btnOrder.setBounds(190,340,80,30);
        btnOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertDataPesan();
                Pembayaran.Total.setText(String.valueOf(total));
            }
        });
        ComboKelas.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String tiket = (String) ComboKelas.getSelectedItem();
                if("Ekonomi".equals(tiket)){
                    harga = 1000000;
                }else if("Bisnis".equals(tiket)){
                    harga = 1500000;
                }else if("First".equals(tiket)){
                    harga = 2000000;
                }
            }
        });

        ComboPelayanan.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String layanan = (String) ComboPelayanan.getSelectedItem();
                if("Antar - Jemput".equals(layanan)){
                    tambahan = 100000;
                }else if("Bagasi".equals(layanan)){
                    tambahan = 100000;
                }else if("Porter".equals(layanan)){
                    tambahan = 100000;
                }
            }
        });

        panel.add(TextJudul);
        panel.add(TextEkonomi);
        panel.add(TextBisnis);
        panel.add(TextFirst);
        panel.add(TextJenisTiket);
        panel.add(TextDestinasi);
        panel.add(TextJumlahPenumpang);
        panel.add(TextPelayananTambahan);
        panel.add(ComboKelas);
        panel.add(jumlah);
        panel.add(ComboDestinasi);
        panel.add(ComboPelayanan);
        panel.add(btnOrder);

        add(panel);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public void insertDataPesan(){
        String jenistiket = ComboKelas.getSelectedItem().toString();
        String destinasi = ComboDestinasi.getSelectedItem().toString();
        int jumlahs = Integer.parseInt(jumlah.getValue().toString());
        String pelayanan = ComboPelayanan.getSelectedItem().toString();
        total = (harga + tambahan) * jumlahs;
        try{
            String sql = "INSERT INTO datapesantiket(jenis,destinasi,jumlah,pelayanan,harga) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = Database.db.prepareStatement(sql);
            ps.setString(1, jenistiket);
            ps.setString(2, destinasi);
            ps.setInt(3, jumlahs);
            ps.setString(4, pelayanan);
            ps.setInt(5, total);
            ps.execute();
            new Pembayaran();
            dispose();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
