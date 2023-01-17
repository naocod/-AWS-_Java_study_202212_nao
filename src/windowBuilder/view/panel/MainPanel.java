package windowBuilder.view.panel;

import java.awt.CardLayout;

import lombok.Data;

@Data
public class MainPanel extends InitPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static MainPanel instance;
	
	  public static MainPanel getInstance() {
	      if(instance == null) {
	         instance = new MainPanel();
	      }
	      return instance;
	   }
	
	private CardLayout mainCard;

	
	public MainPanel() {
		mainCard = new CardLayout();
//		setSize(600, 500);
		setLayout(mainCard); // 생성자 호출되면 자기자신의 Layout과 Border 설정 (this 생략)
//		setBorder(null);
	}
	
	public void init() {
		LoginPanel loginPanel = new LoginPanel();
		add(loginPanel, "loginPanel");
		
		RegisterPanel resisterPanel = new RegisterPanel();
		add(resisterPanel, "resisterPanel");
		
	}

}
