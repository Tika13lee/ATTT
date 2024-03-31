package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GUI_RSA;

public class Controller_RSA implements ActionListener {
	private GUI_RSA view;

	public Controller_RSA(GUI_RSA view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		if (btn.equals("btnMaHoa")) {
			view.encrypt();
		} else if (btn.equals("btnGiaiMa")) {
			view.decrypt();
		} else if (btn.equals("btnTaoKhoa")) {
			view.taoKhoa();
		}
	}

}
