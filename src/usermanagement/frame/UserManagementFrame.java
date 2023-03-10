package usermanagement.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import usermanagement.dto.RequestDto;
import usermanagement.dto.ResponseDto;
import usermanagement.service.UserService;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserManagementFrame extends JFrame {
	
	private static Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private BufferedReader reader;
	private PrintWriter writer;
	private Gson gson;
	
	private List<JTextField> loginFields;
	private List<JTextField> registerFields;
	
	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField registerUsernameField;
	private JPasswordField registerPasswordField;
	private JTextField registerNameField;
	private JTextField registerEmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					socket = new Socket("127.0.0.1", 9090);
					
					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				} catch (ConnectException e) {
					JOptionPane.showMessageDialog(null, "서버에 연결할 수 없습니다.", "접속실패", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserManagementFrame() {
		loginFields = new ArrayList<>();
		registerFields = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);
		
		JLabel logoText = new JLabel("UserManagement");
		logoText.setFont(new Font("Bodoni MT", Font.BOLD, 24));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(69, 40, 242, 31);
		loginPanel.add(logoText);
		
		JLabel loginText = new JLabel("Login");
		loginText.setFont(new Font("Bodoni MT", Font.PLAIN, 22));
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setBounds(127, 81, 116, 23);
		loginPanel.add(loginText);
		
		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBounds(33, 192, 309, 31);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(33, 251, 309, 30);
		loginPanel.add(passwordField);
		
		JLabel usernameLable = new JLabel("Username or email");
		usernameLable.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLable.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		usernameLable.setBounds(33, 174, 127, 15);
		loginPanel.add(usernameLable);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		passwordLabel.setBounds(33, 233, 102, 15);
		loginPanel.add(passwordLabel);
		
		JButton loginButton = new JButton("Login");
		
		loginButton.addMouseListener(new MouseAdapter() { // addMouseListener 객체는 Component 클래스의 하위이기에 버튼이 아니어도 이벤트 줄 수 있음
			@Override // 원하는 것만 골라서 오버라이드 가능
			// 인터페이스는 무조건 구현해야하는데 어댑터를 사용해서 원하는 것만 오버라이드
			public void mouseClicked(MouseEvent e) {
				JsonObject loginUser = new JsonObject();
				loginUser.addProperty("usernameAndEmail", usernameField.getText()); 
				loginUser.addProperty("password", passwordField.getText());
				
				UserService userService = UserService.getInsance();
				
				Map<String, String> response = userService.authorize(loginUser.toString());
				
				if(response.containsKey("error")) {
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		loginButton.setBackground(Color.LIGHT_GRAY);
		loginButton.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		loginButton.setBounds(33, 311, 309, 37);
		loginPanel.add(loginButton);
		
		JLabel signupDesc = new JLabel("Don't have an account?");
		signupDesc.setHorizontalAlignment(SwingConstants.CENTER);
		signupDesc.setFont(new Font("Bodoni MT", Font.PLAIN, 12));
		signupDesc.setBounds(86, 361, 137, 23);
		loginPanel.add(signupDesc);
		
		JLabel signupLink = new JLabel("Sign up");
		signupLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "registerPanel");
				clearFields(loginFields); // 로그인 필드 비움
			}
		});
		signupLink.setHorizontalAlignment(SwingConstants.CENTER);
		signupLink.setForeground(new Color(0, 102, 204));
		signupLink.setFont(new Font("Bodoni MT", Font.PLAIN, 12));
		signupLink.setBounds(226, 361, 47, 23);
		loginPanel.add(signupLink);
		
		JLabel forgotPasswordLink = new JLabel("Forgot yout password?");
		forgotPasswordLink.setForeground(new Color(0, 102, 204));
		forgotPasswordLink.setHorizontalAlignment(SwingConstants.CENTER);
		forgotPasswordLink.setFont(new Font("Bodoni MT", Font.PLAIN, 12));
		forgotPasswordLink.setBounds(118, 379, 137, 23);
		loginPanel.add(forgotPasswordLink);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);
		
		JLabel signinLink = new JLabel("Sign in");
		signinLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel"); // mainPanel에서 loginPanel 키값을 가진것을 찾아 보여줌
			}
		});
		signinLink.setForeground(new Color(0, 102, 204));
		signinLink.setFont(new Font("Bodoni MT", Font.PLAIN, 12));
		signinLink.setHorizontalAlignment(SwingConstants.CENTER);
		signinLink.setBounds(266, 411, 74, 22);
		registerPanel.add(signinLink);
		
		JLabel registerLogoText = new JLabel("UserManagement");
		registerLogoText.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText.setFont(new Font("Bodoni MT", Font.BOLD, 24));
		registerLogoText.setBounds(69, 40, 242, 31);
		registerPanel.add(registerLogoText);
		
		JLabel registerText = new JLabel("Register");
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setFont(new Font("Bodoni MT", Font.PLAIN, 22));
		registerText.setBounds(127, 81, 116, 23);
		registerPanel.add(registerText);
		
		JLabel registerUsernameLabel = new JLabel("Username");
		registerUsernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerUsernameLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		registerUsernameLabel.setBounds(31, 114, 127, 15);
		registerPanel.add(registerUsernameLabel);
		
		registerUsernameField = new JTextField();
		registerUsernameField.setHorizontalAlignment(SwingConstants.CENTER);
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(31, 132, 309, 31);
		registerPanel.add(registerUsernameField);
		
		JLabel registerPasswordLabel = new JLabel("Password");
		registerPasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerPasswordLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		registerPasswordLabel.setBounds(31, 173, 102, 15);
		registerPanel.add(registerPasswordLabel);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		registerPasswordField.setBounds(31, 191, 309, 30);
		registerPanel.add(registerPasswordField);
		
		JLabel registerNameLabel = new JLabel("name");
		registerNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerNameLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		registerNameLabel.setBounds(31, 231, 127, 15);
		registerPanel.add(registerNameLabel);
		
		registerNameField = new JTextField();
		registerNameField.setHorizontalAlignment(SwingConstants.CENTER);
		registerNameField.setColumns(10);
		registerNameField.setBounds(31, 249, 309, 31);
		registerPanel.add(registerNameField);
		
		JLabel registerEmailLabel = new JLabel("email");
		registerEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerEmailLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		registerEmailLabel.setBounds(31, 290, 127, 15);
		registerPanel.add(registerEmailLabel);
		
		registerEmailField = new JTextField();
		registerEmailField.setHorizontalAlignment(SwingConstants.CENTER);
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(31, 308, 309, 31);
		registerPanel.add(registerEmailField);
		
		JButton registerButton = new JButton("Register");
		
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 선언(정의)만함 -> 동작이 일어났을 때
				JsonObject userJson = new JsonObject();
				userJson.addProperty("username", registerUsernameField.getText());
				userJson.addProperty("password", registerPasswordField.getText());
				userJson.addProperty("name", registerNameField.getText());
				userJson.addProperty("email", registerEmailField.getText());
				
				RequestDto<String> requestDto = new RequestDto<String>("register", userJson.toString());
				writer.println(gson.toJson(requestDto));
				writer.flush();
				
				try {
					String response = reader.readLine();
					System.out.println("응답옴");
					ResponseDto<String> responseDto = gson.fromJson(response, ResponseDto.class);
//					System.out.println(responseDto);
					
					if(responseDto.getCode().equals("error")) {
						JOptionPane.showMessageDialog(null, responseDto.getBody(), responseDto.getCode(), JOptionPane.ERROR_MESSAGE);
						return;
					}
					JOptionPane.showMessageDialog(null, responseDto.getBody(), responseDto.getCode(), JOptionPane.ERROR_MESSAGE);
					mainCard.show(mainPanel, "loginPanel");
					clearFields(registerFields);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
//				System.out.println(userJson.toString());
				
//				UserService userService = UserService.getInsance();
//				
//				Map<String, String> response = userService.register(userJson.toString());
//				
//				if(response.containsKey("error")) { // 키값안에 들어있는지 확인
//					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
//					return; // 이벤트에 대한 리턴
//				}
//				
//				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
//				mainCard.show(mainPanel, "loginPanel");
//				clearFields(registerFields); // 회원가입 필드 비움
				
			}
		});
		registerButton.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		registerButton.setBackground(Color.LIGHT_GRAY);
		registerButton.setBounds(31, 364, 309, 37);
		registerPanel.add(registerButton);
		
		loginFields.add(usernameField);
		loginFields.add(passwordField);
		
		registerFields.add(registerUsernameField);
		registerFields.add(registerPasswordField);
		registerFields.add(registerNameField);
		registerFields.add(registerEmailField);
	} // 생성자
	
	private void clearFields(List<JTextField> textFields) {
		for(JTextField field : textFields) {
			if(field.getText().isEmpty()) { // 스페이스바도 텍스트로 인식해서 비원줌
				continue;
			}
			field.setText("");
		}
	}
}
