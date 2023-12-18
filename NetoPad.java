import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class NetoPad extends JFrame implements ActionListener, WindowListener {

    SplashPanel panel;
    Timer timer;
    JTextArea textArea;
    JScrollPane scrollPane;
    JSpinner fontSizeSpinner;
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");

    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");

    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem selectall = new JMenuItem("Select All");

    JMenuItem about = new JMenuItem("About");


    int seconds = 0;

    NetoPad() {
        panel = new SplashPanel();
        timer = new Timer();

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

        this.setVisible(true);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Calibri", Font.PLAIN, 30));

        scrollPane = new JScrollPane((textArea));
        scrollPane.setPreferredSize(new Dimension(1200, 750));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(scrollPane);


/*        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setPreferredSize(new Dimension(50,25));
        fontSizeSpinner.setValue(30);
        fontSizeSpinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int) fontSizeSpinner.getValue()));
            }
        });


        this.add(fontSizeSpinner); */
        // ----------------------------------------------------MenuBar Section-------------------------------------------------
        setJMenuBar(menuBar);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(print);
        file.add(exit);

        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectall);

        help.add(about);

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        cut.addActionListener(this);
        selectall.addActionListener(this);
        about.addActionListener(this);

        //TODO: Font size eklemesi başarısız internetten araştır.(Not araştırmama rağmen çözüm getiren bir şey bulamadım. Override kısmında bir sıkıntı olabilir.)

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("New")) {

            if (textArea.getText().isEmpty()) {
                textArea.setText(null);

            } else {
                JOptionPane.showMessageDialog(null, "Bilgilerinin kaybolmasını istemiyorsan kaydet","Kaydetmeden çıkmak üzeresin", JOptionPane.ERROR_MESSAGE);
            }

        }
        // New için yaptığımız gibi ekrandakileri kaydetsin yazıcam ama çok uykum var ve biraz meşakkatli gbi
        else if (e.getActionCommand().equalsIgnoreCase("Open")) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Metin Belgeleri(*.txt)", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn;
                textArea.setText(null);
                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()){
                        while (fileIn.hasNextLine()) {
                            String line = fileIn.nextLine()+"\n";
                            textArea.append(line);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else if (e.getActionCommand().equalsIgnoreCase("Save")) {

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Metin Belgeleri(*.txt)", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);

            int action = fileChooser.showSaveDialog(null);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
                if (fileName.contains(".txt")) {
                    fileName = fileName + ".txt";
                }
                //Unhandled Expection: java.IO.Expection hatası verdi çözümü böyle yapmakta buldum
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    textArea.write(writer);
                } catch (IOException ex) {
                    ex.printStackTrace();

                }
            }
        } else if (e.getActionCommand().equalsIgnoreCase("Print")) {

        } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
            System.exit(0);

        } else if (e.getActionCommand().equalsIgnoreCase("Copy")) {

        } else if (e.getActionCommand().equalsIgnoreCase("Paste")) {

        } else if (e.getActionCommand().equalsIgnoreCase("Select All")) {

        } else if (e.getActionCommand().equalsIgnoreCase("About")) {
            JOptionPane.showMessageDialog(null,"Merhaba, burası yardım isteyebileceğin bir yer değil.","Günlerden biri", JOptionPane.DEFAULT_OPTION);

        }

    }

    //Window Manager--------------------------------------------

    @Override
    public void windowOpened(WindowEvent e) {
        this.add(panel);
        panel.updateUI();
        TimerTask task;


        task = new TimerTask() {

            @Override
            public void run() {
                if (seconds < 2) {
                    seconds++;
                } else if (seconds == 2) {
                    removePanel();
                } else {
                    cancel();
                }
            }
        };

        timer.schedule(task, 2000, 1000);
    }

    public void removePanel() {
        this.remove(panel);
        this.update(getGraphics());
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
