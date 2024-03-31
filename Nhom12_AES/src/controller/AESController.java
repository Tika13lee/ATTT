package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GUI_AES;

public class AESController implements ActionListener {
	private GUI_AES view;

	public AESController(GUI_AES view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Encrypt")) {
			view.encrypt();
		} else if (button.equals("Decrypt")) {
			view.decrypt();
		}
	}
}
