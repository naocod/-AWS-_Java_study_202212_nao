package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import windowBuilder.view.frame.MainFrame;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class UserManagementApplication{
	
//	private CardLayout mainCard; // 전역변수로 끌어내서 변수로 지정
//	private JPanel mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() { // 생성은 하는데 익명 클래스, Runnable이 인터페이스 이고 abstract 메소드를 포함함
			public void run() {
				try {
					
					MainFrame frame = new MainFrame(); // MainFrame 생성
					frame.setVisible(true); // setVisible(보여준다/보여주지 않는다) -> 생성만 해서는 보이지 않고 setVisible(true)가 되면 보이게 됨
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		EventQueue.invokeLater(runnable);
	}

	/**
	 * Create the frame.
	 */
//	public UserManagementApplication() { // 생성자
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 600, 500); // window가 들고있음
//		
//		mainCard = new CardLayout(); // (0, 0)을 안잡아줘도 기본이 (0, 0)
//		
//		mainPanel = new JPanel();
//		mainPanel.setLayout(mainCard);
//		mainPanel.setBorder(null);
//
//		setContentPane(mainPanel);
//		mainPanel.setLayout(new CardLayout(0, 0));
//		
//	}

}
