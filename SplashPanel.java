import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class SplashPanel extends JPanel {

    public BufferedImage logo;

    SplashPanel() {
        
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setOpaque(true);
        this.setEnabled(true);

        try {
            logo = ImageIO.read(new File("Logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(logo, 0,0,this);
    }


    /*
    Timer timer = new Timer();
    int seconds = 0;
    int alpha = 0;

    SplashPanel() {
        
        this.setBackground(new Color(45,45,45,255));
        this.setFocusable(true);
        this.setOpaque(false);

        try {
            logo = ImageIO.read(new File("Logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        start();
    }

    public void start() {
        TimerTask task;

        task = new TimerTask() {

            @Override
            public void run() {
                if(seconds < 100){
                    transparecyChanger();
                    System.out.println(alpha);
                }
                else {
                    cancel();
                }
            }
        };

        timer.schedule(task, 0, 100);
    }

    public void transparecyChanger() {
        alpha += 1;
        this.setBackground(new Color(45,45,45,alpha));
        System.out.println("alpha update" + alpha);
        this.updateUI();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(logo, 0,0,this);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 2000, 2000);
    }

    public void actionPerformed(ActionEvent e) {

    }*/
}
