package view;

import java.awt.Color;
import java.awt.Font;
import java.math.BigInteger;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.Controller_RSA;

public class GUI_RSA extends JFrame {
	private JTextArea txtOrigin;
	private JTextArea txtGiaiMa;
	private JTextArea txtMaHoa;
	private BigInteger n;
	private BigInteger e;
	private BigInteger d;
	private JTextField txtN;
	private JTextField txtE;
	private JTextField txtD;
	private JButton btnTaoKhoa;

	public GUI_RSA() {
		setTitle("RSA Encryption/Decryption");
		setSize(1000, 580);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		txtOrigin = new JTextArea();
		txtOrigin.setLineWrap(true);
		txtOrigin.setBounds(10, 282, 230, 220);
		txtOrigin.setWrapStyleWord(true);
		getContentPane().add(txtOrigin);

		txtGiaiMa = new JTextArea();
		txtGiaiMa.setLineWrap(true);
		txtGiaiMa.setBounds(375, 282, 230, 220);
		getContentPane().add(txtGiaiMa);

		txtMaHoa = new JTextArea();
		txtMaHoa.setLineWrap(true);
		txtMaHoa.setBounds(743, 282, 230, 220);
		txtMaHoa.setWrapStyleWord(true);

		getContentPane().add(txtMaHoa);

		JButton btnMaHoa = new JButton("Mã hóa >>");
		btnMaHoa.setActionCommand("btnMaHoa");
		btnMaHoa.setForeground(new Color(255, 255, 255));
		btnMaHoa.setBackground(new Color(255, 0, 0));
		btnMaHoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMaHoa.setBounds(257, 378, 107, 25);
		getContentPane().add(btnMaHoa);
		btnMaHoa.addActionListener(new Controller_RSA(this));

		JButton btnGiaiMa = new JButton("Giải mã >>");
		btnGiaiMa.setActionCommand("btnGiaiMa");
		btnGiaiMa.setForeground(new Color(255, 255, 255));
		btnGiaiMa.setBackground(new Color(0, 208, 0));
		btnGiaiMa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGiaiMa.setBounds(619, 378, 114, 25);
		getContentPane().add(btnGiaiMa);
		btnGiaiMa.addActionListener(new Controller_RSA(this));

		JLabel lblNewLabel = new JLabel("Dữ liệu ban đầu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(54, 253, 113, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblDLiuM = new JLabel("Dữ liệu mã hóa");
		lblDLiuM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDLiuM.setBounds(433, 253, 113, 15);
		getContentPane().add(lblDLiuM);

		JLabel lblDLiuGii = new JLabel("Dữ liệu giải mã");
		lblDLiuGii.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDLiuGii.setBounds(808, 253, 113, 15);
		getContentPane().add(lblDLiuGii);

		JLabel lblNewLabel_1 = new JLabel("NHÓM 12");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(431, 21, 191, 25);
		getContentPane().add(lblNewLabel_1);

		txtOrigin.setText(
				"Văn chương cũng như một khu vườn, mỗi nhà văn chọn cho mình một nhiệm vụ, có người trồng hoa hồng, người thích nhổ cỏ dại cũng có người đi bắt sâu.");

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(100, 84, 742, 122);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("n = ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(221, 25, 45, 13);
		panel_1.add(lblNewLabel_4);

		txtN = new JTextField();
		txtN.setEditable(false);
		txtN.setBounds(256, 22, 453, 19);
		panel_1.add(txtN);
		txtN.setColumns(10);

		JLabel lblNewLabel_4_1 = new JLabel("e = ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(221, 54, 45, 13);
		panel_1.add(lblNewLabel_4_1);

		txtE = new JTextField();
		txtE.setEditable(false);
		txtE.setColumns(10);
		txtE.setBounds(256, 51, 453, 19);
		panel_1.add(txtE);

		JLabel lblNewLabel_4_1_1 = new JLabel("d = ");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1_1.setBounds(221, 83, 45, 13);
		panel_1.add(lblNewLabel_4_1_1);

		txtD = new JTextField();
		txtD.setEditable(false);
		txtD.setColumns(10);
		txtD.setBounds(256, 80, 453, 19);
		panel_1.add(txtD);

		btnTaoKhoa = new JButton("Tạo khóa");
		btnTaoKhoa.setBounds(40, 50, 101, 21);
		panel_1.add(btnTaoKhoa);
		btnTaoKhoa.setForeground(new Color(255, 255, 255));
		btnTaoKhoa.setBackground(new Color(79, 167, 255));
		btnTaoKhoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaoKhoa.setActionCommand("btnTaoKhoa");

		JLabel lblNewLabel_5 = new JLabel("Tạo Khóa");
		lblNewLabel_5.setBounds(10, 10, 67, 15);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaoKhoa.addActionListener(new Controller_RSA(this));

	}

	public void taoKhoa() {
		BigInteger p = BigInteger.probablePrime(1024, new Random());
		BigInteger q = BigInteger.probablePrime(1024, new Random());

		// n = p * q
		n = p.multiply(q);
		// phi = (p - 1) * (q - 1)
		BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		// Chọn một số nguyên tố e
		e = BigInteger.valueOf(65537);
		// Tính d: d * e ≡ 1 (mod phi)
		d = e.modInverse(phi);

		txtN.setText(n + "");
		txtE.setText(e + "");
		txtD.setText(d + "");

//		System.out.println(p);
//		System.out.println(q);
	}

	public void encrypt() {
		try {
			String mesGoc = txtOrigin.getText(); // lấy tài liệu gốc từ text
			byte[] byteMes = mesGoc.getBytes(); // chuyển chuỗi thành mảng byte
			BigInteger intMes = new BigInteger(byteMes);// chuyển mảng byte thành số nguyên
			BigInteger encrypted = intMes.modPow(e, n); // mã hóa
			txtGiaiMa.setText(encrypted + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void decrypt() {
		try {
			String mesGoc = txtGiaiMa.getText();
			BigInteger intMes = new BigInteger(mesGoc);
			BigInteger decrypted = intMes.modPow(d, n); // giải mã
			byte[] byteGiaiMa = decrypted.toByteArray();// chuyển số nguyên thành mảng byte
			String strGiaiMa = new String(byteGiaiMa);
			txtMaHoa.setText(strGiaiMa); // chuyển mảng byte thành chuỗi
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
