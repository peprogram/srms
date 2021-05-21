package SRMSProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author persi
 */
public class Main extends javax.swing.JFrame {

    File f = new File("C:\\Users\\persi\\Documents\\NetBeansProjects\\SRMS Project\\SRMSData");
    int ln;
    String Username, Password, RollNum, Name, Subject, M;

    public Main() {
        initComponents();
    }

    void createFolder() {
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    void readFile(String fileName) {
        try {
            FileReader fr = new FileReader(f + fileName);
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f + fileName);
                System.out.println("File created");
            } catch (IOException ex1) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    void addAdData(String usr, String pswd, String name, String mail, String dept) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f + "\\ADMIN.txt", "rw");
            for (int i = 0; i < ln; i++) {
                raf.readLine();
            }
            //if condition added after video to have no lines on first entry
            if (ln > 0) {
                raf.writeBytes("\r\n");
                raf.writeBytes("\r\n");
            }
            raf.writeBytes("Username:" + usr + "\r\n");
            raf.writeBytes("Password:" + pswd + "\r\n");
            raf.writeBytes("Name:" + name + "\r\n");
            raf.writeBytes("Department:" + dept + "\r\n");
            raf.writeBytes("Email:" + mail + "\r\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void addStuMark(String roll, String sub, String mid, String end, String asst, String viva) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f + "\\STUDENT" + roll + ".txt", "rw");
            for (int i = 0; i < ln; i++) {
                raf.readLine();
            }
            raf.writeBytes("SUBJECT:" + sub + "\r\n");
            raf.writeBytes("MidSem:" + mid + "/30" + "\r\n");
            raf.writeBytes("EndSem:" + end + "/50" +  "\r\n");
            raf.writeBytes("Assignment:" + asst + "/10" +  "\r\n");
            raf.writeBytes("Viva/TA:" + viva + "/20" + "\r\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void addStuData(String roll, String name, String branch, String sem) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f + "\\STUDENT" + roll + ".txt", "rw");
            for (int i = 0; i <= ln; i++) {
                raf.readLine();
            }
            raf.writeBytes("RollNo:" + roll + "\r\n");
            raf.writeBytes("Name:" + name + "\r\n");
            raf.writeBytes("Branch:" + branch + "\r\n");
            raf.writeBytes("Sem:" + sem + "\r\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void countLines(String fileName) {
        try {
            ln = 0;
            RandomAccessFile raf = new RandomAccessFile(f + fileName, "rw");
            for (int i = 0; raf.readLine() != null; i++) {
                ln++;
            }
            System.out.println("number of lines:" + ln);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        JFrame frame = new JFrame("Student Result Management System");
        frame.setSize(850, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label1 = new JLabel("STUDENT RESULT MANAGEMENT SYSTEM");
        label1.setFont(new java.awt.Font("Tahoma", 1, 18));
        label1.setBounds(300, 50, 400, 30);
        label1.setForeground(Color.blue);
        frame.add(label1);

        JTabbedPane tabPane = new JTabbedPane();
        tabPane.setBounds(50, 100, 700, 550);
        tabPane.setBackground(Color.white);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        tabPane.add("Admin", panel);
        tabPane.add("Student", panel2);

        JLabel label2 = new JLabel("WELCOME TO ADMIN PAGE");
        label2.setBounds(20, 20, 600, 30);
        label2.setForeground(Color.blue);

        panel.setLayout(null);
        panel.add(label2);

        JLabel label3 = new JLabel("Username");
        JLabel label4 = new JLabel("Password");
        JTextField text1 = new JTextField(20);
        JPasswordField text2 = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        label3.setBounds(40, 80, 145, 25);
        label4.setBounds(40, 110, 145, 25);
        text1.setBounds(120, 80, 150, 25);
        text2.setBounds(120, 110, 150, 25);
        loginButton.setBounds(100, 150, 80, 30);
        panel.add(label3);
        panel.add(text1);
        panel.add(label4);
        panel.add(text2);
        panel.add(loginButton);
        panel.setLayout(null);

        JLabel label5 = new JLabel("Create New Account");
        label5.setBounds(70, 220, 200, 30);
        JButton regButton = new JButton("Register");
        regButton.setBounds(80, 250, 100, 30);
        panel.add(label5);
        panel.add(regButton);

        JPanel panel4 = new JPanel();
        panel4.setBounds(310, 60, 400, 400);
        panel4.setVisible(false);

        String[] choices = {"B. Arch", "BME", "BOT", "CHE", "CIV", "CSE", "ECE", "ELE", "ITY", "MEC", "MIN", "MMC"};
        String[] choices1 = {"B. Arch", "BME", "BOT", "CHE", "CIV", "CSE", "ECE", "ELE", "ITY", "MEC", "MIN", "MMC", "CHEM", "PHY", "MATH"};
        String[] choices2 = {"I", "II", "III", "IV", "V", "VI", "VIII", "IX", "X"};

        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel4.setVisible(true);
                JLabel adRegL1 = new JLabel("Enter Name");
                JLabel adRegL2 = new JLabel("Department");
                JLabel adRegL3 = new JLabel("Email");
                JLabel adRegL5 = new JLabel("New Username");
                JLabel adRegL6 = new JLabel("New Password");
                JComboBox box1 = new JComboBox(choices1);

                JTextField adRegT1 = new JTextField(20);
                JTextField adRegT2 = new JTextField(30);
                JTextField adRegT3 = new JTextField(20);
                JTextField adRegT4 = new JTextField(20);
                JButton button3 = new JButton("Create Account");

                adRegL1.setBounds(20, 20, 145, 25);
                adRegL2.setBounds(20, 50, 145, 25);
                adRegL3.setBounds(20, 80, 145, 25);
                adRegL5.setBounds(20, 110, 145, 25);
                adRegL6.setBounds(20, 140, 145, 25);
                adRegT1.setBounds(120, 20, 175, 25);
                adRegT2.setBounds(120, 80, 175, 25);
                adRegT3.setBounds(120, 110, 175, 25);
                adRegT4.setBounds(120, 140, 175, 25);
                button3.setBounds(80, 210, 150, 30);
                box1.setBounds(120, 50, 175, 25);

                panel4.add(adRegL1);
                panel4.add(adRegL2);
                panel4.add(adRegL3);
                panel4.add(adRegL5);
                panel4.add(adRegL6);
                panel4.add(adRegT1);
                panel4.add(adRegT2);
                panel4.add(adRegT3);
                panel4.add(adRegT4);
                panel4.add(button3);
                panel4.add(box1);
                panel4.setLayout(null);

                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        createFolder();
                        readFile("\\ADMIN.txt");
                        countLines("\\ADMIN.txt");
                        addAdData(adRegT3.getText(), adRegT4.getText(), adRegT1.getText(), adRegT2.getText(), (String) box1.getSelectedItem());
                        panel4.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Data Registered");
                    }
                });
            }
        });

        panel.add(panel4);

        JLabel label13 = new JLabel("WELCOME TO STUDENT PAGE");
        label13.setBounds(20, 20, 600, 30);
        label13.setForeground(Color.blue);
        panel2.add(label13);
        JLabel label14 = new JLabel("Roll Number");
        label14.setBounds(40, 80, 145, 25);
        panel2.add(label14);

        JTextField text9 = new JTextField(20);
        text9.setBounds(140, 80, 150, 25);
        panel2.add(text9);

        JButton viewButton = new JButton("View Result");
        panel2.add(viewButton);
        viewButton.setBounds(350, 75, 120, 30);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readFile("\\STUDENT" + text9.getText() + ".txt");
                countLines("\\STUDENT" + text9.getText() + ".txt");
                try {
                    FileReader fr = new FileReader(f + "\\STUDENT" + text9.getText() + ".txt");
                    RandomAccessFile raf = new RandomAccessFile(f + "\\STUDENT" + text9.getText() + ".txt", "rw");
                    JTextArea display = new JTextArea();
                    panel2.add(display);
                    //display.setFont(new java.awt.Font("Tahoma", 0, 14));
                    display.setBounds(80, 150, 400, 300);
                    display.read(fr, null);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        panel2.setLayout(null);

        JDialog subFrame = new JDialog();
        subFrame.setVisible(false);
        subFrame.setBounds(10, 40, 800, 550);
        subFrame.setLayout(null);

        JLabel subAdL = new JLabel("SRMS - ADMIN");
        subAdL.setFont(new java.awt.Font("Tahoma", 1, 18));
        subAdL.setBounds(50, 10, 210, 30);
        subFrame.add(subAdL);

        JPanel subPanel1 = new JPanel();
        subPanel1.setLayout(null);

        JLabel subL1 = new JLabel("Roll No");
        JLabel subL2 = new JLabel("Name");
        JLabel subL3 = new JLabel("Branch");
        JLabel subL4 = new JLabel("Semester");

        JTextField subT1 = new JTextField(10);
        JTextField subT2 = new JTextField(30);
        JComboBox AdBox1 = new JComboBox(choices);
        JComboBox AdBox2 = new JComboBox(choices2);

        subL1.setBounds(50, 50, 80, 25);
        subL2.setBounds(50, 90, 80, 25);
        subL3.setBounds(50, 130, 80, 25);
        subL4.setBounds(50, 170, 80, 25);
        subT1.setBounds(160, 50, 120, 25);
        subT2.setBounds(160, 90, 120, 25);
        AdBox1.setBounds(160, 130, 120, 25);
        AdBox2.setBounds(160, 170, 120, 25);

        subPanel1.add(subL1);
        subPanel1.add(subL2);
        subPanel1.add(subL3);
        subPanel1.add(subL4);
        subPanel1.add(subT1);
        subPanel1.add(subT2);
        subPanel1.add(AdBox1);
        subPanel1.add(AdBox2);

        JButton addButton = new JButton("Add Student");
        subPanel1.add(addButton);
        addButton.setBounds(150, 245, 110, 30);

        JPanel subAdPanel = new JPanel();
        subAdPanel.setLayout(null);
        subPanel1.add(subAdPanel);
        subAdPanel.setBounds(350, 0, 300, 300);

        JLabel subL5 = new JLabel("Subject");
        JLabel subL7 = new JLabel("Mid-Sem");
        JLabel subL8 = new JLabel("End-Sem");
        JLabel subL9 = new JLabel("Assignment");
        JLabel subL10 = new JLabel("Viva/TA");
        JTextField subT3 = new JTextField(40);
        JTextField subT4 = new JTextField(7);
        JTextField subT5 = new JTextField(7);
        JTextField subT6 = new JTextField(7);
        JTextField subT7 = new JTextField(7);

        subT4.setText("0");
        subT5.setText("0");
        subT6.setText("0");
        subT7.setText("0");
        subL5.setBounds(50, 40, 80, 25);
        subL7.setBounds(50, 80, 80, 25);
        subL8.setBounds(50, 120, 80, 25);
        subL9.setBounds(50, 160, 80, 25);
        subL10.setBounds(50, 200, 80, 25);
        subT3.setBounds(150, 40, 120, 25);
        subT4.setBounds(150, 80, 50, 25);
        subT5.setBounds(150, 120, 50, 25);
        subT6.setBounds(150, 160, 50, 25);
        subT7.setBounds(150, 200, 50, 25);

        subAdPanel.add(subL5);
        subAdPanel.add(subL7);
        subAdPanel.add(subL8);
        subAdPanel.add(subL9);
        subAdPanel.add(subL10);
        subAdPanel.add(subT3);
        subAdPanel.add(subT4);
        subAdPanel.add(subT5);
        subAdPanel.add(subT6);
        subAdPanel.add(subT7);

        JButton submitButton = new JButton("Submit");
        subAdPanel.add(submitButton);
        submitButton.setBounds(75, 250, 100, 30);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFolder();
                readFile("\\STUDENT" + subT1.getText() + ".txt");
                countLines("\\STUDENT" + subT1.getText() + ".txt");
                addStuMark(subT1.getText(), subT3.getText(), subT4.getText(), subT5.getText(), subT6.getText(), subT7.getText());
                JOptionPane.showMessageDialog(null, "Marks Submitted");
                subT3.setText("");
                subT4.setText("0");
                subT5.setText("0");
                subT6.setText("0");
                subT7.setText("0");
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFolder();
                readFile("\\STUDENT" + subT1.getText() + ".txt");
                countLines("\\STUDENT" + subT1.getText() + ".txt");
                addStuData(subT1.getText(), subT2.getText(), (String) AdBox1.getSelectedItem(), (String) AdBox2.getSelectedItem());
                subAdPanel.setVisible(true);
            }
        });

        subFrame.add(subPanel1);
        subPanel1.setBounds(40, 60, 700, 400);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                createFolder();
                readFile("\\ADMIN.txt");
                countLines("\\ADMIN.txt");
                try {
                    RandomAccessFile raf = new RandomAccessFile(f + "\\ADMIN.txt", "rw");
                    for (int i = 0; i < ln; i += 6) {
                        System.out.println("count " + i);

                        String forUser = raf.readLine().substring(9);
                        String forPswd = raf.readLine().substring(9);
                        if (text1.getText().equals(forUser) & text2.getText().equals(forPswd)) {
                            subFrame.setVisible(true);
                        } else if (i == (ln - 5)) {
                            JOptionPane.showMessageDialog(null, "Incorrect Username/Password");
                        }
                        for (int k = 1; k <= 5; k++) {
                            raf.readLine();
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

                frame.add(subFrame);
            }
        });

        frame.add(tabPane);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
