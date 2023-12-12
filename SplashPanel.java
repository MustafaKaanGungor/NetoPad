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
    
    Timer timer = new Timer();
    int seconds = 0;
    int alpha = 250;
    
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
        g.drawImage(logo, 100,-100, this);
        g.dispose();
        
        start();
        this.updateUI();

        if(alpha == 0) {
            
        }
        
    }
    
    public void start() {
        TimerTask task;
        
        task = new TimerTask() {
            
            @Override
            public void run() {
                if(seconds < 11){
                    for(int y = 0; y < logo.getHeight(); y++)
                        for(int x = 0; x < logo.getWidth(); x++)
                            logo.setRGB(x, y, (logo.getRGB(x, y) & 0x00FFFFFF) | (alpha << 24));
                    System.out.println(alpha);
                    alpha -= 25;
                    seconds++;
                }
                else {
                    cancel();
                }
            }
        };
        
        timer.schedule(task, 2000, 500000000);
    }
}
