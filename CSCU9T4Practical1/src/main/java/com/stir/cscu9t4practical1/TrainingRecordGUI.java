// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

/**
 *
 * @author Ivan Bacani
 */
public class TrainingRecordGUI extends JFrame implements ActionListener {

	/*-------------------------------------*/

	//TextField
	private JTextField name = new JTextField(30);
	private JTextField day = new JTextField(2);
	private JTextField month = new JTextField(2);
	private JTextField year = new JTextField(4);
	private JTextField hours = new JTextField(2);
	private JTextField mins = new JTextField(2);
	private JTextField secs = new JTextField(2);
	private JTextField dist = new JTextField(4);
	/* Still working on
	private JTextField repetitions = new JTextField(4);
	private JTextField recovery = new JTextField(4);
	private JTextField terrain = new JTextField(4);
	private JTextField tempo = new JTextField(4);
	*/
	
	//Labels
	private JLabel labn = new JLabel(" Name:");
	private JLabel labd = new JLabel(" Day:");
	private JLabel labm = new JLabel(" Month:");
	private JLabel laby = new JLabel(" Year:");
	private JLabel labh = new JLabel(" Hours:");
	private JLabel labmm = new JLabel(" Mins:");
	private JLabel labs = new JLabel(" Secs:");
	private JLabel labdist = new JLabel(" Distance (km):");
	/* Still working on
	private JLabel labr = new JLabel(" Rounds:");
	private JLabel labrt = new JLabel(" Recovery Time:");
	private JLabel labter = new JLabel(" Terrain:");
	private JLabel labtp = new JLabel(" Tempo:");
	*/
	//Buttons
	private JButton addR = new JButton("Add Entry");
	private JButton findAllByDate = new JButton("Find All By Date");
	private JButton lookUpByDate = new JButton("Look Up Entry");
	private JButton removeb = new JButton("Remove Entry");

	//List interface settings
	private TrainingRecord myAthletes = new TrainingRecord();
	private JTextArea outputArea = new JTextArea(10, 50);

	public static void main(String[] args) {
		TrainingRecordGUI applic = new TrainingRecordGUI();
	}

	public TrainingRecordGUI() {
		super("Training Record");
		setLayout(new FlowLayout());

		// Name
		add(labn);
		add(name);
		name.setEditable(true);

		// Day
		add(labd);
		add(day);
		day.setEditable(true);

		// Month
		add(labm);
		add(month);
		month.setEditable(true);

		// Year
		add(laby);
		add(year);
		year.setEditable(true);

		// Hours
		add(labh);
		add(hours);
		hours.setEditable(true);

		// Minutes
		add(labmm);
		add(mins);
		mins.setEditable(true);

		// Seconds
		add(labs);
		add(secs);
		secs.setEditable(true);

		// Distance
		add(labdist);
		add(dist);
		dist.setEditable(true);
		/* Still working on
		add(labr);
		add(repetitions);
		dist.setEditable(true);

		add(labrt);
		add(recovery);
		dist.setEditable(true);
		
		add(labter);
		add(terrain);
		dist.setEditable(true);
		
		add(labtp);
		add(tempo);
		dist.setEditable(true);
			
		*/
		
		// Add Function
		add(addR);
		addR.addActionListener(this);

		// Find All By Date Function
		add(findAllByDate);
		findAllByDate.addActionListener(this);

		// Look Up By Date Function
		add(lookUpByDate);
		lookUpByDate.addActionListener(this);

		// Remove Function
		add(removeb);
		removeb.addActionListener(this);

		// GUI Client/Area
		add(outputArea);
		outputArea.setEditable(false);
		setSize(785, 300);
		setVisible(true);
		blankDisplay();
	}

	public void actionPerformed(ActionEvent event) {
		String message = "";

		//Add Function
		if (event.getSource() == addR) {
			message = addEntry("generic");
		}

		//Look Up By Date Function
		if (event.getSource() == lookUpByDate) {
			message = lookupEntry();
		}

		//Find All By Date Function
		if (event.getSource() == findAllByDate) {
			message = findAllEntry();
		}

		//Remove Function
		if (event.getSource() == removeb) {
			message = removeEntry();
		}

		outputArea.setText(message);
		blankDisplay();
	}

	public String addEntry(String what) {
		String message = "Record added\n";
		System.out.println("Adding " + what + " entry to the records");
		String n = name.getText();
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		float km = java.lang.Float.parseFloat(dist.getText());
		int h = Integer.parseInt(hours.getText());
		int mm = Integer.parseInt(mins.getText());
		int s = Integer.parseInt(secs.getText());
		Entry e = new Entry(n, d, m, y, h, mm, s, km);
		myAthletes.addEntry(e);
		return message;
	}

	public String lookupEntry() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		String message = myAthletes.lookupEntry(d, m, y);
		return message;
	}

	public String findAllEntry() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		String message = myAthletes.findAllEntry(d, m, y);
		return message;
	}

	public String removeEntry() {
		String n = name.getText();
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText(n + " has been removed from the list");
		myAthletes.removeEntry(n, d, m, y);
		return n;
	}

	public void blankDisplay() {
		name.setText("");
		day.setText("");
		month.setText("");
		year.setText("");
		hours.setText("");
		mins.setText("");
		secs.setText("");
		dist.setText("");
	}

	public void fillDisplay(Entry ent) {
		name.setText(ent.getName());
		day.setText(String.valueOf(ent.getDay()));
		month.setText(String.valueOf(ent.getMonth()));
		year.setText(String.valueOf(ent.getYear()));
		hours.setText(String.valueOf(ent.getHour()));
		mins.setText(String.valueOf(ent.getMin()));
		secs.setText(String.valueOf(ent.getSec()));
		dist.setText(String.valueOf(ent.getDistance()));
	}
}
