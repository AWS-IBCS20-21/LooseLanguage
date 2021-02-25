package UI;

import BackEnd.PasswordManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class World extends JFrame {
	
	// Frame components
	private JLabel error;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel passwordLabel;
	private JTextField firstNameField; 
	private JTextField lastNameField;
	private JPasswordField pwd;
	private JButton btn; 
	
	private final static int TEXT_FIELD_SIZE = 20;
	
	private PasswordManager passwordManager;
	
	// card layout components
    private JPanel cards; //a panel that uses CardLayout
    private CardLayout cl;
    private final static String BUTTONPANEL = "Card with JButtons";
    private final static String TEXTPANEL = "Card with JTextField";
	
	private void initComponents() {
		
		//// <temporary> create Password Manager
		passwordManager = new PasswordManager();
		// hard code some accounts
		passwordManager.addAccount("alinachen", "ilikecheese".toCharArray());
		
		
		
		//// section to setup the content pane (using card layout)
		
		cl = new CardLayout();
		cards = new JPanel(cl);
		getContentPane().add(cards, BorderLayout.CENTER);
		
		// create the components for the card panels
		firstNameLabel = new JLabel("First Name:");
		lastNameLabel = new JLabel("Last Name:");
		passwordLabel = new JLabel("Password:");
		
		firstNameField = new JTextField(TEXT_FIELD_SIZE);
		lastNameField = new JTextField(TEXT_FIELD_SIZE);
		pwd = new JPasswordField(20);
		
		error = new JLabel("*Wrong name and/or password");
		error.setForeground(Color.RED);
		error.setVisible(false);
		
		btn = new JButton("Enter");
		// ActionListener 
        btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
				String fName = firstNameField.getText();
				String lName = lastNameField.getText();
				char[] pass_array = pwd.getPassword();
				
				if (passwordManager.checkAccount(fName, lName, pass_array)) {
					cl.show(cards, TEXTPANEL);
				} else {
					error.setVisible(true);
				}
			}
		});
		
		// create cards
		JPanel loginPanel = new JPanel();
		
        loginPanel.add(firstNameLabel);
        loginPanel.add(firstNameField);
        loginPanel.add(lastNameLabel);
        loginPanel.add(lastNameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(pwd);
        loginPanel.add(btn);
        loginPanel.add(error);
        loginPanel.setSize(350,400);
        
        JPanel homePanel = new JPanel();
        homePanel.add(new JTextField("TextField", TEXT_FIELD_SIZE));
        
        // finalize content pane setup
        cards.add(loginPanel, BUTTONPANEL);
        cards.add(homePanel, TEXTPANEL);
		
	}
	
	public World() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,400);
        setVisible(true);
        setTitle("BDST");
		
		initComponents();
		
	}

	public static void main(String[] args) {
		
//        /* Use an appropriate Look and Feel */
//      try {
//          //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//          UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//      } catch (UnsupportedLookAndFeelException ex) {
//          ex.printStackTrace();
//      } catch (IllegalAccessException ex) {
//          ex.printStackTrace();
//      } catch (InstantiationException ex) {
//          ex.printStackTrace();
//      } catch (ClassNotFoundException ex) {
//          ex.printStackTrace();
//      }
//      /* Turn off metal's use of bold fonts */
//      UIManager.put("swing.boldMetal", Boolean.FALSE);
//      
//      //Schedule a job for the event dispatch thread:
//      //creating and showing this application's GUI.
//      javax.swing.SwingUtilities.invokeLater(new Runnable() {
//          public void run() {
//              new World();
//          }
//      });
		
		new World();

	}


}
