import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

public class NetoPad extends JFrame implements ActionListener, WindowListener {

    SplashPanel panel;
    JTextArea textArea;
    JScrollPane scrollPane;
    JSpinner fontSizeSpinner;

    NetoPad() {
        panel = new SplashPanel();
        
        this.setTitle("NetoPad - Welcome");
        try {
            this.setIconImage(ImageIO.read(new File("res/NetoPadIcon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setResizable(true);
        this.setSize(1300, 800);
        this.setLocationRelativeTo(null);


        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);

        //! frame kısmında daha rahat çalışılabilsin diye Splash Panel şuan deaktif. Splash Panel hazır olunca aktif edeceğim - Mustafa
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Calibri", Font.PLAIN,30));

        scrollPane = new JScrollPane((textArea));
        scrollPane.setPreferredSize(new Dimension(1200,750));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        /*fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setPreferredSize(new Dimension(160,20));
        fontSizeSpinner.setValue(30);
        fontSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int fontSize = (int) fontSizeSpinner.getValue();
                Font currentFont = textArea.getFont();
                textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int) fontSizeSpinner.getValue()));
                System.out.println("Font size changed to: " + fontSize);
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(fontSizeSpinner);

        this.setLayout(new BorderLayout());
        this.add(controlPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.add(fontSizeSpinner); */
        //TODO: Font size eklemesi başarısız internetten araştır.
        this.add(scrollPane);


        this.setVisible(true);
        //TODO: JMenu ile menü ekle
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    //Window Manager--------------------------------------------

    @Override
    public void windowOpened(WindowEvent e) {
        //this.add(panel);
        //panel.updateUI();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //TODO: Dosya kaydedilmiş mi diye kontrol et, kaydedilmemişse uyarı gönder.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

}
