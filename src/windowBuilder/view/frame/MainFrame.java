package windowBuilder.view.frame;

import javax.swing.JFrame;

import windowBuilder.view.panel.MainPanel;

public class MainFrame extends JFrame{
	
//	private CardLayout mainCard;
//	private JPanel mainPanel;
	
	private static final long serialVersionUID = 1L;

	public MainFrame() { // 생성자 호출되면서 틀 생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
//		mainCard = new CardLayout();
//		
//		mainPanel = new JPanel();
//		mainPanel.setLayout(mainCard);
//		mainPanel.setBorder(null);
		
		MainPanel mainPanel = MainPanel.getInstance();
		mainPanel.init();
		setContentPane(mainPanel);
//		mainPanel.setLayout(new CardLayout(0, 0));
	}
}
