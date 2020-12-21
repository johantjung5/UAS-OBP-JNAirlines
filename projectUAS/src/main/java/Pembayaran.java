import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class Pembayaran extends JFrame {
    JPanel panel = new JPanel();
    JLabel TextJudul = new JLabel("PEMBAYARAN");
    JLabel TextTotalHarga = new JLabel("Total Harga");
    JLabel TextMetodePembayaran = new JLabel("Metode Pembayaran");
    static JTextField Total = new JTextField();
    JButton btnFinish = new JButton("Finish");

    String[] metode={"Debit","Kredit"};
    JComboBox ComboMetode = new JComboBox(metode);

    String[] kategori={"Jenis Tiket","Destinasi","Jumlah Penumpang","Pelayanan Tambahan","Harga"};
    DefaultTableModel dtm = new DefaultTableModel(null,kategori);
    JTable table = new JTable(dtm);
    JScrollPane tb = new JScrollPane(table);

    public Pembayaran(){
        new Database();

        setTitle("Pembayaran");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,420);
        panel.setLayout(null);
        panel.setBackground(new Color(255, 199, 94));
        panel.setBounds(0,0,500,420);

        Font fnt1 = new Font("Arial", Font.BOLD,20);
        Font fnt2 = new Font("Arial", Font.PLAIN,16);

        TextJudul.setBounds(180,10,200,40);
        TextJudul.setFont(fnt1);
        TextTotalHarga.setBounds(60,212,200,40);
        TextTotalHarga.setFont(fnt2);
        TextMetodePembayaran.setBounds(60,262,200,40);
        TextMetodePembayaran.setFont(fnt2);

        Total.setBounds(240,220,160,25);
        ComboMetode.setBounds(240,270,160,25);

        btnFinish.setBounds(190,330,100,30);
        btnFinish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        tb.setBounds(20,50,450,150);

        panel.add(TextJudul);
        panel.add(tb);
        panel.add(TextTotalHarga);
        panel.add(TextMetodePembayaran);
        panel.add(Total);
        panel.add(ComboMetode);
        panel.add(btnFinish);

        add(panel);
        setVisible(true);
        setLocationRelativeTo(null);
        showData();
    }
    public void showData(){
        try{
            String sql = "SELECT jenis,destinasi,jumlah,pelayanan,harga FROM datapesantiket";
            Statement st = Database.db.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] row = {
                        rs.getString("jenis"),
                        rs.getString("destinasi"),
                        rs.getInt("jumlah"),
                        rs.getString("pelayanan"),
                        rs.getInt("harga")
                };
                dtm.addRow(row);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
