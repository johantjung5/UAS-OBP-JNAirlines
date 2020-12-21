import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class PengisianDataDiri extends JFrame {
    JPanel panel = new JPanel();
    JLabel TextIsi = new JLabel("Silahkan isi data Anda Terlebih dahulu");
    JLabel TextNama = new JLabel("Nama Lengkap");
    JLabel TextKtp = new JLabel("No.ID(KTP/SIM)");
    JLabel TextTelp = new JLabel("No. Telp");
    JLabel TextEmail = new JLabel("E-mail");
    JTextField nama = new JTextField();
    JTextField ktp = new JTextField();
    JTextField telp = new JTextField();
    JTextField email = new JTextField();
    JButton btnNext = new JButton("Next");

    public PengisianDataDiri(){
        new Database();
        setTitle("Pengisian Data Diri");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480,350);
        panel.setLayout(null);
        panel.setBackground(new Color(255, 199, 94));
        panel.setSize(480,350);

        Font fnt1 = new Font("Arial", Font.BOLD,20);
        Font fnt2 = new Font("Arial", Font.PLAIN,16);

        TextIsi.setBounds(50,20, 400,40);
        TextIsi.setFont(fnt1);
        TextNama.setBounds(50,80, 400,40);
        TextNama.setFont(fnt2);
        TextKtp.setBounds(50,120, 400,40);
        TextKtp.setFont(fnt2);
        TextTelp.setBounds(50,160, 400,40);
        TextTelp.setFont(fnt2);
        TextEmail.setBounds(50,200, 400,40);
        TextEmail.setFont(fnt2);

        nama.setBounds(220,90,160,23);
        ktp.setBounds(220,130,160,23);
        telp.setBounds(220,170,160,23);
        email.setBounds(220,210,160,23);

        btnNext.setBounds(220,260,70,25);
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertDataDiri();
            }
        });

        panel.add(TextIsi);
        panel.add(TextNama);
        panel.add(TextKtp);
        panel.add(TextTelp);
        panel.add(TextEmail);
        panel.add(btnNext);
        panel.add(nama);
        panel.add(ktp);
        panel.add(telp);
        panel.add(email);

        add(panel);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public void insertDataDiri(){
        String name = nama.getText();
        String noID = ktp.getText();
        int noTelp = Integer.parseInt(telp.getText());
        String emails = email.getText();

        try{
            String sql = "INSERT INTO datadiri VALUES(?,?,?,?)";
            PreparedStatement ps = Database.db.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,noID);
            ps.setInt(3,noTelp);
            ps.setString(4,emails);
            ps.execute();
            new PemesananTiket();
            dispose();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
