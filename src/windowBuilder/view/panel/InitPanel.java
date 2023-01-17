package windowBuilder.view.panel;

import javax.swing.JPanel;

public class InitPanel extends JPanel {
	
	private final int WIDTH = 600; // 높이와 너비 상수로 설정
	private final int HEIGHT = 500;
	
	public InitPanel() { // 기본 셋팅
		setLayout(null);
		setBorder(null);
		setSize(WIDTH, HEIGHT);
	}
}
