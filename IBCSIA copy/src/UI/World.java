package UI;

import BackEnd.*;
import Objects.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class World extends JFrame {
	String FILEPATH = "BDSTTimeLogs.json";
	JsonClient js = new JsonClient(FILEPATH);
	Client client = new Client();
	
	ArrayList<Athlete> athletes = js.read();
	
	// Frame components
	//login
	private JLabel error;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel passwordLabel;
	private JTextField firstNameField; 
	private JTextField lastNameField;
	private JPasswordField pwd;
	private JButton btn; 
	
	//home
	private JButton timesButton;
	private JButton athletesButton;
	
	//times
	private JButton newLogButton;
	private JButton bestTimesButton;
	
	//best times
	private JLabel searchLabel;
	private JLabel distanceLabel;
	private JLabel strokeLabel;
	private JComboBox<String> distances;
	private String[] distanceChoices = {"25", "50", "100", "200", "400"};
	private JComboBox<String> strokes;
	private String[] strokeChoices = {"BUTTERFLY", "BACKSTROKE", "BREASTSTROKE", "FREESTYLE", "IM"};
	private JButton searchButton;
	private JButton returnHomeBtn;
	private ArrayList<JLabel> resultLabels = new ArrayList<>();
	
	//new log entry
	private JLabel newLogLabel;
	private JLabel nameLabel;
	private String[] nameChoices = new String[athletes.size()];
	private JComboBox<String> names;
	private JLabel dateLabel;
	private JTextField dateField;
	private JComboBox<Enum> stroke;
	private JLabel distanceLabel2;
	private JComboBox<String> distances2;
	private JLabel timeLabel;
	private JTextField timeField;
	private JButton add;
	private JLabel createdEntryLabel;
	private JLabel logError;
	private JButton returnHomeBtn2;
	
	//athletes
	private JButton newAthBtn;
	private JButton searchAthBtn;

	//new athlete
	private JLabel newAthLabel;
	private JLabel nameLabel2;
	private JTextField nameField;
	private JLabel genderLabel;
	private String[] genderChoices = {"Female", "Male"};
	private JComboBox<String> genders;
	private JLabel birthday;
	private JTextField birthdayField;
	private JButton createAthBtn;
	private JLabel createdAthLabel;
	private JLabel athError;
	private JButton returnHomeBtn3;
	
	//search athletes
	private JLabel searchAthsLabel;
	private JLabel nameLabel3;
	private JComboBox<String> names2;
	private JButton searchAthBtn2;
	private JButton returnHomeBtn4;
	private ArrayList<JLabel> resultLabels2 = new ArrayList<>();
	
	
	private final static int TEXT_FIELD_SIZE = 20;
	
	private PasswordManager passwordManager;
	
	// card layout components
    private JPanel cards; //a panel that uses CardLayout
    private CardLayout cl;
    private final static String LOGINPANEL = "Card with JButtons";
    private final static String HOMEPANEL = "Card with JTextField";
    private final static String TIMESPANEL = "Card with Times";
    private final static String BESTTIMESPANEL = "Card with Best Times";
    private final static String NEWLOGPANEL = "Card with New Log Entry";
    private final static String ATHLETESPANEL = "Card with Athletes";
    private final static String NEWATHLETEPANEL = "Card with New Athletes Entry";
    private final static String SEARCHATHLETESPANEL = "Card with Athlete Info";
    
    
	
	private void initComponents() {
		
		//// <temporary> create Password Manager
		passwordManager = new PasswordManager();
		// hard code some accounts
		passwordManager.addAccount("alinachen", "ilikecheese".toCharArray());
		
		
		
		//// section to setup the content pane (using card layout)
		
		cl = new CardLayout();
		cards = new JPanel(cl);
		getContentPane().add(cards, BorderLayout.CENTER);
		
		// create the components for login panel
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
		
		// ActionListener for login panel 
        btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
				String fName = firstNameField.getText();
				String lName = lastNameField.getText();
				char[] pass_array = pwd.getPassword();
				
				if (passwordManager.checkAccount(fName, lName, pass_array)) {
					cl.show(cards, HOMEPANEL);
				} else {
					error.setVisible(true);
				}
			}
		});
        
        //create components for home panel
        timesButton = new JButton("Times");
        athletesButton = new JButton("Athletes");
        timesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, TIMESPANEL);
				
			}
        	
        });
        
        athletesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, ATHLETESPANEL);
				
			}
        	
        });
        
        //create components for times panel
        newLogButton = new JButton("New Log Entry");
        bestTimesButton = new JButton("Best Times");
        
        bestTimesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, BESTTIMESPANEL);
			
			}
        });
        
        newLogButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, NEWLOGPANEL);
			
			}
        });
        
       
        
        
        //create components for bestTimes panel
        JPanel bestTimesPanel = new JPanel();
        searchLabel = new JLabel("----------------SEARCH----------------");
        distanceLabel = new JLabel("Distance:");
        distances = new JComboBox<String>(distanceChoices);
        strokeLabel = new JLabel(" Stroke:");
        strokes = new JComboBox<String>(strokeChoices);
        searchButton = new JButton("Enter");
        returnHomeBtn = new JButton("Return to Home");
        
        searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String dist = distanceChoices[distances.getSelectedIndex()];
				String stroke = strokeChoices[strokes.getSelectedIndex()];
				
		
				
				
				
				
				
				Map<String, Integer> test = client.sortedEventTimes(athletes, dist+stroke);
				
				for(Map.Entry<String, Integer> en : test.entrySet()) {
					JLabel searchResult = new JLabel("[Name: " + en.getKey() + " Time: " + client.backTimeString(en.getValue()) + "]");
					resultLabels.add(searchResult);
	
					bestTimesPanel.add(searchResult);
					bestTimesPanel.revalidate();
					bestTimesPanel.repaint();
					
				}
				
				
				
				
			
			}
        });
        
        returnHomeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				cl.show(cards, HOMEPANEL);
				
			}
        	
        });
        
        
        
        //create components for newLogEntry panel
        newLogLabel = new JLabel("---------------New Log Entry---------------");
        nameLabel = new JLabel("Name:");
        for(int i=0; i<athletes.size(); i++) {
        	nameChoices[i] = athletes.get(i).getName();
        }
        names = new JComboBox<String>(nameChoices);
        dateLabel = new JLabel("Date:");
        dateField = new JTextField("mm-dd-yyyy",12);
        stroke = new JComboBox<Enum>(Stroke.values());
        distanceLabel2 = new JLabel("Distance:");
        distances2 = new JComboBox<String>(distanceChoices);
        timeLabel = new JLabel("Time:");
        timeField = new JTextField("xx:xx:xx", 10);
        add = new JButton("Add Entry");
        createdEntryLabel = new JLabel("New Time Successfully Entered");
        createdEntryLabel.setForeground(Color.GREEN);
		createdEntryLabel.setVisible(false);
		logError = new JLabel("*Invalid date or time input");
		logError.setForeground(Color.RED);
		logError.setVisible(false);
		returnHomeBtn2 = new JButton("Return to Home");
		
        add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logError.setVisible(false);
				
				String name = nameChoices[names.getSelectedIndex()];
				String date = dateField.getText();
				Stroke selectedStroke = Stroke.values()[stroke.getSelectedIndex()];
				int dist = Integer.parseInt(distanceChoices[distances2.getSelectedIndex()]); 
				String time = timeField.getText();
				
				if(!client.validDate(date) || !client.validTime(time)) {
					logError.setVisible(true);
				}else {
					
					Event evnt = new Event(date, selectedStroke, dist, time);
					
					for (Athlete a : athletes) {
						if(a.getName().equals(name)) {
							a.insertEvents(evnt.toString(), evnt);
							break;
						}
					}
					js.write(athletes);
					createdEntryLabel.setVisible(true);
				}
				
				
			}
        });
        
        returnHomeBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createdEntryLabel.setVisible(false);
				logError.setVisible(false);
				cl.show(cards, HOMEPANEL);
				
			}
        	
        });
        
        //create components for athletes panel
        newAthBtn = new JButton("New Athlete");
        searchAthBtn = new JButton("Search Athletes");
        
        newAthBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, NEWATHLETEPANEL);
			
			}
        });
        
        searchAthBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, SEARCHATHLETESPANEL);
			
			}
        });
        
        //create components for new athlete panel
        newAthLabel = new JLabel("----------------New Athlete----------------");
        nameLabel2 = new JLabel("Name:");
        nameField = new JTextField(10);
        genderLabel = new JLabel("Gender:");
        genders = new JComboBox<String>(genderChoices);
        birthday = new JLabel("Birthday:");
        birthdayField = new JTextField("mm-dd-yyyy", 10);
        createAthBtn = new JButton("Enter");
        createdAthLabel = new JLabel("New Athlete Successfully Created");
        createdAthLabel.setForeground(Color.GREEN);
		createdAthLabel.setVisible(false);
		athError = new JLabel("*Invalid birthday input");
		athError.setForeground(Color.RED);
		athError.setVisible(false);
		returnHomeBtn3 = new JButton("Return to Home");
        
        createAthBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				athError.setVisible(false);
				
				String athName = nameField.getText();
				boolean gender;
				if(genders.getSelectedIndex()==0) {
					gender = true;
				}
				else {
					gender = false;
				}
				String birthday = birthdayField.getText();
				
				if(!client.validDate(birthday)) {
					athError.setVisible(true);
				}else {
					Athlete a = new Athlete(athName, gender, birthday);
					
					athletes.add(a);
					js.write(athletes);
					
					createdAthLabel.setVisible(true);
				}
				
			
			}
        });
        
        returnHomeBtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createdAthLabel.setVisible(false);
				athError.setVisible(false);
				cl.show(cards, HOMEPANEL);
				
			}
        	
        });
        
        //create components for search athletes panel
        JPanel searchAthsPanel = new JPanel();
        searchAthsLabel = new JLabel("----------------Search Athletes----------------");
    		nameLabel3 = new JLabel("Name:");
    		names2 = new JComboBox<String>(nameChoices);
    		searchAthBtn2 = new JButton("Search");
    		returnHomeBtn4 = new JButton("Return to Home");
        
    		
    		searchAthBtn2.addActionListener(new ActionListener() {

    				@Override
    				public void actionPerformed(ActionEvent e) {
    					String name = nameChoices[names2.getSelectedIndex()];
    					
    					for(JLabel jl : resultLabels2) {
    						jl.setVisible(false);
    					}
    					resultLabels2.clear();
    					
    					Map<String, Integer> test = client.sortedAthleteTimes(athletes, name);
    					
    					
    					
    					for(Map.Entry<String, Integer> en : test.entrySet()) {
    						JLabel searchResult = new JLabel("[Event: " + en.getKey() + "  Time: " + client.backTimeString(en.getValue()) + "]");
    						resultLabels2.add(searchResult);
    						
    						searchAthsPanel.add(searchResult);
    						searchAthsPanel.revalidate();
    						searchAthsPanel.repaint();
    					}
    					
    					
    				
    				}
    	        });
    		
    		 returnHomeBtn4.addActionListener(new ActionListener() {

    				@Override
    				public void actionPerformed(ActionEvent e) {
    					cl.show(cards, HOMEPANEL);
    					
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
        //loginPanel.setSize(4,400);
        
        // create homePanel
        JPanel homePanel = new JPanel();
        
        homePanel.add(timesButton);
        homePanel.add(athletesButton);
        
        //create timesPanel
        JPanel timesPanel = new JPanel();
        timesPanel.add(newLogButton);
        timesPanel.add(bestTimesButton);
        
        //create bestTimesPanel
        
        bestTimesPanel.add(searchLabel);
        bestTimesPanel.add(distanceLabel);
        bestTimesPanel.add(distances);
        bestTimesPanel.add(strokeLabel);
        bestTimesPanel.add(strokes);
        bestTimesPanel.add(searchButton);
        bestTimesPanel.add(returnHomeBtn);
        
        //create newLogEntryPanel
        JPanel newLogPanel = new JPanel();
        newLogPanel.add(newLogLabel);
        newLogPanel.add(nameLabel);
        newLogPanel.add(names);
        newLogPanel.add(dateLabel);
        newLogPanel.add(dateField);
        newLogPanel.add(strokeLabel);
        newLogPanel.add(stroke);
        newLogPanel.add(distanceLabel2);
        newLogPanel.add(distances2);
        newLogPanel.add(timeLabel);
        newLogPanel.add(timeField);
        newLogPanel.add(add);
        newLogPanel.add(createdEntryLabel);
        newLogPanel.add(logError);
        newLogPanel.add(returnHomeBtn2);
        
        
        //create athletesPanel
        JPanel athletesPanel = new JPanel();
        athletesPanel.add(searchAthBtn);
        athletesPanel.add(newAthBtn);
        
        //create newAthletePanel
        JPanel newAthPanel = new JPanel();
        newAthPanel.add(newAthLabel);
        newAthPanel.add(nameLabel2);
        newAthPanel.add(nameField);
        newAthPanel.add(genderLabel);
        newAthPanel.add(genders);
        newAthPanel.add(birthday);
        newAthPanel.add(birthdayField);
        newAthPanel.add(createAthBtn);
        newAthPanel.add(createdAthLabel);
        newAthPanel.add(athError);
        newAthPanel.add(returnHomeBtn3);
        
        
        //create searchAthletesPanel
        
        searchAthsPanel.add(searchAthsLabel);
        searchAthsPanel.add(nameLabel3);
        searchAthsPanel.add(names2);
        searchAthsPanel.add(searchAthBtn2);
        searchAthsPanel.add(returnHomeBtn4);
        
        
        
        // finalize content pane setup
        cards.add(loginPanel, LOGINPANEL);
        cards.add(homePanel, HOMEPANEL);
        cards.add(timesPanel, TIMESPANEL);
        cards.add(bestTimesPanel, BESTTIMESPANEL);
        cards.add(newLogPanel, NEWLOGPANEL);
        cards.add(athletesPanel, ATHLETESPANEL);
        cards.add(newAthPanel, NEWATHLETEPANEL);
        cards.add(searchAthsPanel, SEARCHATHLETESPANEL);
  
        
 
		
	}
	
	public World() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(370,400);
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
		//json
		
		
		
		
		
		
		new World();

	}


}
