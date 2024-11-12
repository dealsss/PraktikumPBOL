import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tugas3 {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Tugas3 window = new Tugas3();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Tugas3() {
        frame = new JFrame();
        frame.setTitle("form login & registrasi");
        frame.setBounds(100, 100, 400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        frame.getContentPane().add(cardPanel);

        cardPanel.add(createLoginPanel(), "loginPanel");
        cardPanel.add(createRegisterPanel(), "registerPanel");

        cardLayout.show(cardPanel, "loginPanel");
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField(20);

        JButton submitLoginButton = new JButton("Login");
        JButton registerButton = new JButton("Blum ada akun? Registrasi dulu!");

        submitLoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (!email.isEmpty() && !password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Login Sukses!");
                } else {
                    JOptionPane.showMessageDialog(frame, "tolong masukkan email atau password terlebih dahulu", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "registerPanel"); // Perbaikan nama panel
            }
        });

        loginPanel.add(emailLabel);
        loginPanel.add(emailField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Adds space between fields
        loginPanel.add(submitLoginButton);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Adds space
        loginPanel.add(registerButton);

        return loginPanel;
    }

    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nameLabel = new JLabel("Nama");
        JTextField nameField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField(20);

        JButton submitRegisterButton = new JButton("registrasi");
        JButton loginButton = new JButton("Sudah Punya akun? Login!");

        submitRegisterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitRegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "registrasi sukses!");
                } else {
                    JOptionPane.showMessageDialog(frame, "form registrasi tidak boleh ada yang kosong", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "loginPanel"); // Perbaikan nama panel
            }
        });

        registerPanel.add(nameLabel);
        registerPanel.add(nameField);
        registerPanel.add(emailLabel);
        registerPanel.add(emailField);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordField);
        registerPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Adds space between fields
        registerPanel.add(submitRegisterButton);
        registerPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Adds space
        registerPanel.add(loginButton);

        return registerPanel;
    }
}
