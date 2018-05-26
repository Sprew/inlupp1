package inlupp1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;


public class inlup extends JFrame{
	
	JButton showButton;
	JButton crashButton;
	JRadioButton radioSortName;
	JRadioButton radioSortValue;
	JComboBox valuablesList;
	JTextArea textArea;
	
	String[] allValuables = {"SELECT ONE", "Stocks", "Jewelry", "Gadget"};	
	ArrayList<Vardesak> vardesaker = new ArrayList<Vardesak>();
	
	
	public static void main(String[] args) {
		
		new inlup();
	}
	
	public inlup() {
		
		super("Register");
		JPanel nedre = new JPanel();
		add(nedre, BorderLayout.SOUTH);
		
		setSize(400, 500);
		setLocation(300, 400);
		setVisible(true);
		Dimension d = new Dimension(100, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			JPanel thePanel = new JPanel();
			textArea = new JTextArea(15,20);		
			showButton = new JButton("Show");
			crashButton = new JButton("Stock Market Crash");
			JLabel newLabel = new JLabel();
			JLabel sortLabel = new JLabel("Sort: ");
			valuablesList = new JComboBox(allValuables);
			radioSortName = new JRadioButton("Name");
			radioSortValue = new JRadioButton("Value");
			
			ListenForButton lForButton = new ListenForButton();
			ListenForItem lForItem = new ListenForItem();
			showButton.addActionListener(lForButton);
			crashButton.addActionListener(lForButton);
			valuablesList.setSelectedItem(allValuables[0]);
			valuablesList.addItemListener(lForItem);
			ButtonGroup radioButtonGroup = new ButtonGroup();
			Box vertical = Box.createVerticalBox();
			radioButtonGroup.add(radioSortName);
			radioButtonGroup.add(radioSortValue);
			vertical.add(radioSortName);
			vertical.add(radioSortValue);
			radioSortName.addActionListener(lForButton);
			radioSortValue.addActionListener(lForButton);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			newLabel.setToolTipText("Add new valuables");
			showButton.setContentAreaFilled(false);
			crashButton.setContentAreaFilled(false);
			JScrollPane scrollbar1 = new JScrollPane(textArea, 
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					
			nedre.add(new JLabel("New:"));
			nedre.add(valuablesList);
			nedre.add(showButton);
			nedre.add(crashButton);
			add(thePanel);
						
			thePanel.add(scrollbar1, BorderLayout.CENTER);
			thePanel.add(textArea);
			thePanel.add(sortLabel);
			thePanel.add(vertical);
			pack();
			this.add(thePanel);		
			this.setVisible(true);	
		
	}

	private class ListenForButton implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == showButton) {
				textArea.setText("");
				for(Vardesak item: vardesaker) {
					textArea.append(item.toString() + "\n");
				}
			}
			if(e.getSource() == crashButton) {
				for(Vardesak item : vardesaker) {
					if(item instanceof Stocks) {
						((Stocks) item).setQuotation(0.0);
					}
				}
			}
			if(e.getSource() == radioSortName) {
				Collections.sort(vardesaker, new SortByName());
			}
			if(e.getSource() == radioSortValue) {
				Collections.sort(vardesaker, new SortByValue());
			}
		}	
	}
	
	private class ListenForItem implements ItemListener{ // JDialog here

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (valuablesList.getSelectedIndex() == 1) { // stocks
					JTextField Name = new JTextField();
					JTextField Quantity = new JTextField();
					JTextField Quotation = new JTextField();

					Object[] stock = { "Name:", Name, "Quantity:", Quantity, "Quotation: ", Quotation };

					int option = JOptionPane.showConfirmDialog(null, stock, "Stock", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						if (Name.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter a name!", "Error!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								String StockName = Name.getText();
								Double StockQuotation = Double.parseDouble(Quotation.getText());
								int StockQuantity = Integer.parseInt(Quantity.getText());
								Stocks s = new Stocks(StockName, StockQuantity, StockQuotation);
								vardesaker.add(s);
								System.out.println("Size of ArrayList: " + vardesaker.size());
							} catch (Exception error) {
								JOptionPane.showMessageDialog(null, "Wrong input!", "Error!",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
				if (valuablesList.getSelectedIndex() == 2) { // Jewelry
					JTextField Name = new JTextField();
					JTextField Stone = new JTextField();
					JCheckBox Box = new JCheckBox();

					Object[] jewel = { "Name:", Name, "Stone:", Stone, "Made of Gold", Box };

					int option = JOptionPane.showConfirmDialog(null, jewel, "Jewel", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						if (Name.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter a name!", "Error!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								String JewelName = Name.getText();
								int JewelStone = Integer.parseInt(Stone.getText());
								boolean JewelGold = Box.isSelected();
								Jewelry j = new Jewelry(JewelName, JewelStone, JewelGold);
								vardesaker.add(j);
								System.out.println("Size of ArrayList: " + vardesaker.size());
							} catch (Exception error) {
								JOptionPane.showMessageDialog(null, "Wrong input!", "Error!",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
				if (valuablesList.getSelectedIndex() == 3) { // gadget
					JTextField Name = new JTextField();
					JTextField Wear = new JTextField();
					JTextField Price = new JTextField();

					Object[] gadget = { "Name:", Name, "Wear:", Wear, "Price: ", Price };

					int option = JOptionPane.showConfirmDialog(null, gadget, "Gadget", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						if (Name.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter a name!", "Error!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								String GadgetName = Name.getText();
								Double GadgetPrice = Double.parseDouble(Price.getText());
								int GadgetWear = Integer.parseInt(Wear.getText());
								Gadget g = new Gadget(GadgetName, GadgetPrice, GadgetWear);
								vardesaker.add(g);
							} catch (Exception error) {
								JOptionPane.showMessageDialog(null, "Wrong input!", "Error!",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		}
	}
}