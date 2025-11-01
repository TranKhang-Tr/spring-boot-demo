package lab6;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2 {
	private JFrame frame;
	private JPanel panel;
	private JButton button;

	public void MainFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("JButton Demo");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

		panel = new JPanel();

		button = createButton();
		panel.add(button);

		frame.add(panel, BorderLayout.CENTER);

	}

	private JButton createButton() {
		// TODO Auto-generated method stub
		JButton button = new JButton();
		button.setFocusable(false);
		return null;
	}

	public  void show() {
		this.frame.setVisible(true);
	}
}
