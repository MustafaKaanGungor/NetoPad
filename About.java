import javax.imageio.ImageIO;
import  javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class About extends JFrame {

    About() {
        setBounds(125,125,600,475);
        setTitle("About NetoPad");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            this.setIconImage(ImageIO.read(new File("res/NetoPadIcon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(null);
        JLabel iconLabel = new JLabel(new ImageIcon(getClass().getResource("res/NetoPadIcon.png")));
        iconLabel.setBounds(10,120,90,90);
        add(iconLabel);

        JLabel textLabel = new JLabel("<html>NetoPad adlı başyapıtı kullandığın için teşekkürler şimdilik bu kadar.<br>-Erdem");
        textLabel.setBounds(150,30,350,275);
        textLabel.setFont(new Font("Calibri", Font.PLAIN,18));
        add(textLabel);
    }

    public static void main(String[] args) {
        new About().setVisible(true);
    }
}
