package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaApp extends JFrame {
    private TelaLogin telaLogin;

    public TelaApp() {
        setTitle("Sistema de Vendas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Adiciona ação ao item do menu Login
        JMenuItem menuItemLogin = new JMenuItem("Tela de Login");
        menuItemLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaLogin();
            }
        });

        // Adiciona o item do menu Login ao menu Usuário
        JMenu menuUsuario = new JMenu("Usuário");
        menuUsuario.add(menuItemLogin);

        // Adiciona o menu Usuário à barra de menus
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuUsuario);
        setJMenuBar(menuBar);
    }

    private void abrirTelaLogin() {
        if (telaLogin == null) {
            telaLogin = new TelaLogin(this);
        }
        telaLogin.setVisible(true);
    }

    // Este método será chamado quando o login for bem-sucedido
    public void loginBemSucedido() {
        // Adicione aqui a lógica para abrir as outras telas após o login bem-sucedido
        JMenuBar menuBar = getJMenuBar();
        
        // Adicione aqui a lógica para habilitar os itens de menu de venda, produto, etc.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaApp().setVisible(true);
            }
        });
    }
}
