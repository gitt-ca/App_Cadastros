package gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema de Vendas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Criação dos menus
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuVenda = new JMenu("Venda");
        menuBar.add(menuVenda);

        JMenuItem menuItemCriarProduto = new JMenuItem("Criar Produto");
        JMenuItem menuItemCriarVenda = new JMenuItem("Criar Venda");
        JMenuItem menuItemCriarVendedor = new JMenuItem("Criar Vendedor");

        menuVenda.add(menuItemCriarProduto);
        menuVenda.add(menuItemCriarVenda);
        menuVenda.add(menuItemCriarVendedor);

        // Adiciona ação aos itens do menu
        menuItemCriarProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaCriarProduto();
            }
        });

        menuItemCriarVenda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaCriarVenda();
            }
        });

        menuItemCriarVendedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaCriarVendedor();
            }
        });
    }

    private void abrirTelaCriarProduto() {
        // Adicione aqui a lógica para abrir a tela de criar produto
        JOptionPane.showMessageDialog(this, "Tela de Criar Produto");
    }

    private void abrirTelaCriarVenda() {
        // Adicione aqui a lógica para abrir a tela de criar venda
        JOptionPane.showMessageDialog(this, "Tela de Criar Venda");
    }

    private void abrirTelaCriarVendedor() {
        // Adicione aqui a lógica para abrir a tela de criar vendedor
        JOptionPane.showMessageDialog(this, "Tela de Criar Vendedor");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
}
