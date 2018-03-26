package inlupp1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.*;


public class inlup extends JFrame{
	
	JButton showButton;
	JButton crashButton;
	JComboBox valuablesList;
	String[] allValuables = {"SELECT ONE", "Stocks", "Jewelry", "Gadget"};
	
	
	JTextArea textArea;
	
	ArrayList<Vardesak> vardesaker = new ArrayList<Vardesak>();
	
	
	public static void main(String[] args) {
		
		new inlup();
	}
	
	public inlup() {
		
		this.setSize(800, 600);		
		this.setLocationRelativeTo(null);		
		this.setResizable(false);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Vardesaker");
		
		JPanel thePanel = new JPanel();
		textArea = new JTextArea(15,20);		
		showButton = new JButton("Show");
		JButton crashButton = new JButton("Stock Market Crash");
		JLabel newLabel = new JLabel("New: ");
		valuablesList = new JComboBox(allValuables);
		valuablesList.setSelectedItem(allValuables[0]);
		
		ListenForButton lForButton = new ListenForButton();
		ListenForItem lForItem = new ListenForItem();
		showButton.addActionListener(lForButton);
		valuablesList.addItemListener(lForItem);
		
		textArea.setLineWrap(true);
		//textArea.setEditable(false);
		newLabel.setToolTipText("Add new valuables");
		showButton.setContentAreaFilled(false);
		crashButton.setContentAreaFilled(false);
		JScrollPane scrollbar1 = new JScrollPane(textArea, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				
		
		thePanel.add(scrollbar1);
		thePanel.add(textArea);
		thePanel.add(newLabel);	
		thePanel.add(valuablesList);
		thePanel.add(showButton);
		thePanel.add(crashButton);
		this.add(thePanel);		
		this.setVisible(true);	
	}

	private class ListenForButton implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == showButton) {
				textArea.setText("");
				for(Vardesak item: vardesaker) {
					if(item instanceof Stocks) {
						Stocks s = (Stocks) item;
						textArea.append("Stock: " + s.getName() + " Quantity: " + s.getQuantity() + " Quotation: " + s.getQuotation() + " Value: " + s.getValue() + "\n");			
					}
					if(item instanceof Gadget) {
						Gadget g = (Gadget) item;
						textArea.append("Gadget: " + g.getName() + " Price: " + g.getPurchasePrice() + " Wear: " + g.getWear() + " Value: " + g.getValue() + "\n");
					}
					if(item instanceof Jewelry){
						Jewelry j = (Jewelry) item;
						textArea.append("Jewelry: " + j.getName() + " Stone: " + j.getGemstone() + " Made of gold?: " + j.isGold() + " Value: " + j.getValue() + "\n");
					}
					/** SAKNAR FÖR DEN SISTA JEWELRY, DU FÅR LÄGGA TILL DEN :) **/
					
				}
			}
			if(e.getSource() == crashButton) {
				
			}
		}	
	}
	
	private class ListenForItem implements ItemListener{ // JDialog here

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(valuablesList.getSelectedIndex() == 1) { //stocks
					//System.out.println("Stocks");
					JTextField Name = new JTextField();
					JTextField Quantity = new JTextField();
					JTextField Quotation = new JTextField();
					
					Object[] stock = {
					    "Name:", Name,
					    "Quantity:", Quantity,
					    "Quotation: ", Quotation
					};

					int option = JOptionPane.showConfirmDialog(null, stock, "Stock", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						try{
							String StockName = Name.getText();
							Double StockQuotation = Double.parseDouble(Quotation.getText());
							int StockQuantity = Integer.parseInt(Quantity.getText());
							Stocks s = new Stocks(StockName, StockQuantity, StockQuotation);
							vardesaker.add(s);
							System.out.println("Size of ArrayList: " + vardesaker.size());
						}
						catch(Exception error){
							JOptionPane.showMessageDialog(null, "Wrong input you dick!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
				if(valuablesList.getSelectedIndex() == 2) { //Jewelry
					//System.out.println("jewel");
				}
				
				if(valuablesList.getSelectedIndex() == 3) { //gadget
					//System.out.println("gadget");
					JTextField Name = new JTextField();
					JTextField Wear = new JTextField();
					JTextField Price = new JTextField();
					
					Object[] gadget = {
					    "Name:", Name,
					    "Wear:", Wear,
					    "Price: ", Price
					};

					int option = JOptionPane.showConfirmDialog(null, gadget, "Gadget", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						try{
							String GadgetName = Name.getText();
							Double GadgetPrice = Double.parseDouble(Price.getText());
							int GadgetWear = Integer.parseInt(Wear.getText());
							Gadget g = new Gadget(GadgetName, GadgetPrice, GadgetWear);
							vardesaker.add(g);
							System.out.println("Size of ArrayList: " + vardesaker.size());
						}
						catch(Exception error){
							JOptionPane.showMessageDialog(null, "Wrong input you dick!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}		
		}
	}
}