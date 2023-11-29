package gui;

import javax.swing.*;

import dao.UsuarioDAO;
import model.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class TelaLogin extends JFrame {
    private JPanel panel;
    private JLabel labelUsername;
    private JTextField textFieldUsername;
    private JLabel labelPassword;
    private JPasswordField passwordField;
    private JButton buttonLogin;

    private TelaApp telaApp;
    private UsuarioDAO usuarioDAO;

    public TelaLogin(TelaApp telaApp) {
        this.telaApp = telaApp;
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        // Criação dos componentes
        panel = new JPanel();
        labelUsername = new JLabel("Usuário:");
        textFieldUsername = new JTextField(15);
        labelPassword = new JLabel("Senha:");
        passwordField = new JPasswordField(15);
        buttonLogin = new JButton("Login");

        // Adiciona os componentes ao painel
        panel.add(labelUsername);
        panel.add(textFieldUsername);
        panel.add(labelPassword);
        panel.add(passwordField);
        panel.add(buttonLogin);

        // Adiciona o painel ao frame
        add(panel);

        // Criação do objeto UsuarioDAO
        usuarioDAO = new UsuarioDAO();

        // Adiciona ação ao botão de login
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
    }

    private void realizarLogin() {
        String username = textFieldUsername.getText();
        char[] passwordChars = passwordField.getPassword();
        String senha = new String(passwordChars);

        Optional<Usuario> usuarioOptional = usuarioDAO.login(username, senha);

        if (usuarioOptional.isPresent()) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido!");

            // Criar e exibir a TelaPrincipal após o login bem-sucedido
            SwingUtilities.invokeLater(() -> {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
            });

            // Fechar a tela de login
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin(null).setVisible(true); // Coloque null pois não há uma TelaApp ainda
            }
        });
    }
}
