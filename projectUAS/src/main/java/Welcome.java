import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame{
    JPanel panel = new JPanel();
    JLabel TextWelcome = new JLabel("Welcome to JNA Airlines");
    JLabel TextQuestion = new JLabel("Apakah anda ingin membeli tiket pesawat?");
    JButton btnYa = new JButton("Ya");
    JButton btnTidak = new JButton("Tidak");

    public Welcome(){
        setTitle("WELCOME");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,250);
        panel.setLayout(null);
        panel.setBackground(new Color(171, 147, 237));
        panel.setSize(400,250);

        Font fnt1 = new Font("Arial", Font.BOLD,24);
        Font fnt2 = new Font("Arial", Font.PLAIN,16);

        TextWelcome.setBounds(50,20, 300,40);
        TextWelcome.setFont(fnt1);
        TextQuestion.setBounds(46,80, 400,40);
        TextQuestion.setFont(fnt2);

        btnYa.setBounds(80, 150, 90,30);
        btnTidak.setBounds(210, 150, 90,30);

        btnYa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PengisianDataDiri();
                dispose();
            }
        });
        btnTidak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(TextWelcome);
        panel.add(TextQuestion);
        panel.add(btnTidak);
        panel.add(btnYa);

        add(panel);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
