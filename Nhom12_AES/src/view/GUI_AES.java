package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.AESController;

public class GUI_AES extends JFrame {
	private JButton btnMaHoa;
	private JButton btnGiaiMa;
	private JTextField txtKey;
	private JTextArea txtOutPut;
	private JTextArea txtMes;

//	String roundPrintInitial[] = new String[32];
//	String roundPrint[] = new String[80];
//	String roundPrintFinal[] = new String[64];
	private AES aes = new AES();

	public GUI_AES() {
		setTitle("AES Encryption/Decryption");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setResizable(false);
		getContentPane().setLayout(null);
		giaoDien();
	}

	private void giaoDien() {
		ActionListener ac = new AESController(this);

		JPanel pnl1 = new JPanel();
		getContentPane().add(pnl1);
		pnl1.setLayout(null);
		pnl1.setBounds(0, 59, 786, 442);

		JLabel message = new JLabel("Message");
		message.setBounds(20, 23, 222, 50);
		message.setFont(new Font("Arial", Font.BOLD, 40));

		JLabel keyLabel = new JLabel("Key");
		keyLabel.setBounds(20, 186, 222, 50);
		keyLabel.setFont(new Font("Arial", Font.BOLD, 40));

		JLabel outPut = new JLabel("Output");
		outPut.setBounds(20, 269, 222, 50);
		outPut.setFont(new Font("Arial", Font.BOLD, 40));

		txtKey = new JTextField();
		txtKey.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKey.setBounds(206, 198, 553, 40);
		pnl1.add(txtKey);
		txtKey.setColumns(10);

		pnl1.add(message);
		pnl1.add(keyLabel);
		pnl1.add(outPut);

		txtMes = new JTextArea();
		txtMes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMes.setLineWrap(true);
		txtMes.setBounds(206, 23, 553, 140);
		pnl1.add(txtMes);

		txtOutPut = new JTextArea();
		txtOutPut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtOutPut.setLineWrap(true);
		txtOutPut.setBounds(206, 269, 553, 140);
		pnl1.add(txtOutPut);

		JPanel pnl2 = new JPanel();
		getContentPane().add(pnl2);
		pnl2.setBorder(null);
		pnl2.setBounds(0, 501, 786, 52);
		pnl2.setLayout(null);

		btnMaHoa = new JButton("Encrypt");
		btnMaHoa.setForeground(new Color(255, 255, 255));
		btnMaHoa.setBackground(new Color(255, 0, 0));
		btnMaHoa.setBounds(237, 17, 90, 25);
		btnMaHoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMaHoa.addActionListener(ac);

		btnGiaiMa = new JButton("Decrypt");
		btnGiaiMa.setForeground(new Color(255, 255, 255));
		btnGiaiMa.setBackground(new Color(0, 208, 0));
		btnGiaiMa.setBounds(449, 17, 90, 25);
		btnGiaiMa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGiaiMa.addActionListener(ac);

		pnl2.add(btnMaHoa);
		pnl2.add(btnGiaiMa);

		JLabel lblTitle = new JLabel("NHÓM 12");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(339, 20, 130, 25);
		getContentPane().add(lblTitle);

//		txtMes.setText("le thi thuy kieu");
//		txtKey.setText("1zxc123hjk567890");
	}

	// mã hóa
	public void encrypt() {
		String originalText = txtMes.getText();
		String key = txtKey.getText();
		txtOutPut.setText(aes.encrypt(originalText, key));
	}

	// giải mã
	public void decrypt() {
		String encryptText = txtMes.getText();
		String key = txtKey.getText();
		String output = aes.decrypt(encryptText, key);
		txtOutPut.setText(aes.hexToASCII(output).replaceAll("\0", ""));
	}

	// sử dụng thư viện
//	public void encrypt() {
//		try {
//			String originalText = txtMes.getText();
//			String key = txtKey.getText();
//			if (key.length() == 16 || key.length() == 24 || key.length() == 32) {
//				SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
//				Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
//				cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
//				byte[] byteEncrypted = cipher.doFinal(originalText.getBytes());
//				String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);
//				txtOutPut.setText(encrypted);
//			} else {
//				JOptionPane.showMessageDialog(this, "Vui lòng nhập khóa có độ dài là 16 hoặc 24 hoặc 32");
//				txtKey.requestFocus();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	public void decrypt() {
//		try {
//			String encryptText = txtMes.getText();
//			String key = txtKey.getText();
//			if (key.length() == 16 || key.length() == 24 || key.length() == 32) {
//				SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
//				Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
//				cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//				byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptText));
//				txtOutPut.setText(new String(decrypted));
//			} else {
//				JOptionPane.showMessageDialog(this, "Vui lòng nhập khóa có độ dài là 16 hoặc 24 hoặc 32");
//				txtKey.requestFocus();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}