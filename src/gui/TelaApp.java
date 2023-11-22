package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaApp frame = new TelaApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 868, 467);
		contentPane.add(tabbedPane);
		
		JPanel abaVanda = new JPanel();
		tabbedPane.addTab("Venda", null, abaVanda, null);
		abaVanda.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Código:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewJgoodiesLabel.setBounds(29, 11, 69, 47);
		abaVanda.add(lblNewJgoodiesLabel);
		
		TextField textField = new TextField();
		textField.setBounds(101, 21, 128, 28);
		abaVanda.add(textField);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Nome:");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewJgoodiesLabel_1.setBounds(29, 69, 69, 28);
		abaVanda.add(lblNewJgoodiesLabel_1);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(101, 69, 128, 28);
		abaVanda.add(textField_1);
		
		Panel panel = new Panel();
		panel.setBounds(10, 11, 10, 10);
		abaVanda.add(panel);
		
		Button newButton = new Button("Novo");
		newButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newButton.setBounds(34, 384, 88, 28);
		abaVanda.add(newButton);
		
		Button saveButton = new Button("Salvar");
		saveButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		saveButton.setBounds(165, 384, 88, 28);
		abaVanda.add(saveButton);
		
		Button delButton = new Button("Excluir");
		delButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		delButton.setBounds(304, 384, 88, 28);
		abaVanda.add(delButton);
		
		Button newButton_3 = new Button("Novo");
		newButton_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		newButton_3.setBounds(442, 384, 88, 28);
		abaVanda.add(newButton_3);
		
		JPanel abaVendProd = new JPanel();
		tabbedPane.addTab("Produtos", null, abaVendProd, null);
		abaVendProd.setLayout(null);
	}
}
