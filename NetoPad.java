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
        
        this.setResizable(true);
        this.setSize(1300, 800);
        this.setVisible(true);

        
        
        this.setTitle("NetoPad - Welcome");
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        this.addWindowListener(this);
        

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.add(panel);
        panel.updateUI();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
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
