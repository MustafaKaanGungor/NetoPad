import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class NetoPad extends JFrame implements ActionListener, WindowListener {

    SplashPanel panel;

    NetoPad() {
        panel = new SplashPanel();
        
        this.setTitle("NetoPad - Welcome");

        this.setResizable(true);
        this.setSize(1300, 800);
        this.setLocationRelativeTo(null);

        this.setVisible(true);

        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);

        //! frame kısmında daha rahat çalışılabilsin diye Splash Panel şuan deaktif. Splash Panel hazır olunca aktif edeceğim - Mustafa

        //TODO: JMenu ile menü ekle
        //TODO: Text Area ile yazı alanı ekle
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
