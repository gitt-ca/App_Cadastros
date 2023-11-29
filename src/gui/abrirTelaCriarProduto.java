package gui;
import javax.swing.*;

import dao.ProdutoDAO;
import model.Produto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class abrirTelaCriarProduto extends JFrame {

	private JTextField textFieldNome;
    private JTextField textFieldQtdeEstoque;
    private JTextField textFieldValorUnitario;
    private JButton buttonCriarProduto;

    public abrirTelaCriarProduto() {
        setTitle("Criar Produto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);

        // Criação dos componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel labelNome = new JLabel("Nome:");
        JLabel labelQtdeEstoque = new JLabel("Quantidade em Estoque:");
        JLabel labelValorUnitario = new JLabel("Valor Unitário:");

        textFieldNome = new JTextField();
        textFieldQtdeEstoque = new JTextField();
        textFieldValorUnitario = new JTextField();

        buttonCriarProduto = new JButton("Criar Produto");

        panel.add(labelNome);
        panel.add(textFieldNome);
        panel.add(labelQtdeEstoque);
        panel.add(textFieldQtdeEstoque);
        panel.add(labelValorUnitario);
        panel.add(textFieldValorUnitario);
        panel.add(buttonCriarProduto);

        // Adiciona ação ao botão
        buttonCriarProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarProduto();
            }
        });

        // Adiciona o painel ao frame
        add(panel);
    }

    private void criarProduto() {
        // Obtenha os valores dos campos
        String nome = textFieldNome.getText();
        int qtdeEstoque = Integer.parseInt(textFieldQtdeEstoque.getText());
        double valorUnitario = Double.parseDouble(textFieldValorUnitario.getText());

        // Crie uma instância de Produto com os valores fornecidos
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setQtde_estoque(qtdeEstoque);
        produto.setValor_unitario(valorUnitario);

        // Adicione a lógica para salvar o produto no banco de dados (usando seu DAO)
        ProdutoDAO produtoDAO = new ProdutoDAO();
        boolean sucesso = produtoDAO.save(produto);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Produto criado com sucesso!");
            // Adicione aqui a lógica para atualizar a interface ou realizar outras ações necessárias
            dispose(); // Fecha a tela após a criação do produto
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao criar o produto. Verifique os dados e tente novamente.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new abrirTelaCriarProduto().setVisible(true);
            }
        });
    }
}
