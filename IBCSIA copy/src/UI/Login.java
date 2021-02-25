package UI;

/*
 * CardLayoutDemo.java
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class Login implements ItemListener {
	// fields
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panels = new JPanel(new CardLayout());
	private JLabel error = new JLabel("*Wrong name and/or password");
	private JLabel label1 = new JLabel("First Name:");
	private JLabel label2 = new JLabel("Last Name:");
	private JLabel label3 = new JLabel("Password:");
	private JTextField firstName = new JTextField(20);
	private JTextField lastName = new JTextField(20);
	private JPasswordField pwd = new JPasswordField(20);
	private JButton btn = new JButton("Enter");

	private Map<String, String> accounts;
	
	
    JPanel cards; //a panel that uses CardLayout
    final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";
    
    public void addComponentToPane(Container pane) {
        
    	//Make Error Red
    	error.setForeground(Color.RED);
    error.setVisible(false);
    	
    	//Create HashMap
    	accounts = new HashMap<>();
        accounts.put("alinachen", "ihateben123");
        accounts.put("benzhou", "isahoe");
 
      
        //Create the "cards".
        JPanel card1 = new JPanel();
        
        card1.add(label1);
        card1.add(firstName);
        card1.add(label2);
        card1.add(lastName);
        card1.add(label3);
        card1.add(pwd);
        card1.add(btn);
        card1.add(error);
        card1.setSize(350,400);
        
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);
        
    
        pane.add(cards, BorderLayout.CENTER);
        
        btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fName = firstName.getText();
				String lName = lastName.getText();
				char[] pass_array = pwd.getPassword();
				// System.out.println(fName + lName + pass);
				
				if (!checkAccount(fName, lName, pass_array)) {
					error.setVisible(true);
				}
				if(checkAccount(fName, lName, pass_array)) {
					//System.out.print("correct");
					
					CardLayout cl = (CardLayout)(cards.getLayout());
			        cl.show(cards, TEXTPANEL);
				}
				
				
			}

		});
	}
    public boolean checkAccount(String firstName, String lastName, char[] pwd_array) {
		if (accounts.containsKey(firstName + lastName)) {
			if (Arrays.equals(accounts.get(firstName + lastName).toCharArray(), pwd_array)) {
				return true;
			}
		}
		return false;
	}
    
    
	
    
    
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        Login demo = new Login();
        
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        
        frame.setSize(350,400);
        frame.setVisible(true);
        frame.setTitle("BDST");
    }
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
//        try {
//            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//        } catch (UnsupportedLookAndFeelException ex) {
//            ex.printStackTrace();
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//        } catch (InstantiationException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        /* Turn off metal's use of bold fonts */
//        UIManager.put("swing.boldMetal", Boolean.FALSE);
//        
//        //Schedule a job for the event dispatch thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
    	createAndShowGUI();
    }






	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}