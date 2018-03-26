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
	JButton OKButton = new JButton("OK");
	JButton CancelButton = new JButton("Cancel");
	
	JCheckBox Box = new JCheckBox();
	
	JFrame StockFrame = new JFrame();
	JPanel StockPanel = new JPanel();
	JLabel StockNameLabel = new JLabel("Name: ");
	JLabel StockQuantityLabel = new JLabel("Quantity: ");
	JLabel StockQuotationLabel = new JLabel("Quotation: ");
	JTextField StockNameTextfield = new JTextField(15);
	JSpinner StockQuantitySpinner = new JSpinner(new SpinnerNumberModel(0,0, Integer.MAX_VALUE, 1));
	JSpinner StockQuotationSpinner = new JSpinner(new SpinnerNumberModel(0.0,0.0, 1000000000.0, 0.1));

	
	JFrame JewelFrame = new JFrame();
	JPanel JewelPanel = new JPanel();
	JLabel JewelNameLabel = new JLabel("Name: ");
	JLabel JewelStoneLabel = new JLabel("Stone: ");
	JLabel JewelGoldLabel = new JLabel("Made of gold");
	JTextField JewelNameTextfield = new JTextField(15);
	JSpinner JewelStoneSpinner = new JSpinner(new SpinnerNumberModel(0,0, Integer.MAX_VALUE, 1));
	//JTextField JewelStoneTextfield = new JTextField(15);
	
	JFrame GadgetFrame = new JFrame();
	JPanel GadgetPanel = new JPanel();
	JLabel GadgetNameLabel = new JLabel("Name: ");
	JLabel GadgetPriceLabel = new JLabel("Price: ");
	JLabel GadgetWearLabel = new JLabel("Wear: ");
	JTextField GadgetNameTextfield = new JTextField(15);
	JSpinner GadgetWearSpinner = new JSpinner(new SpinnerNumberModel(0,0, Integer.MAX_VALUE, 1));
	JSpinner GadgetPriceSpinner = new JSpinner(new SpinnerNumberModel(0.0,0.0, 1000000000.0, 0.1));
	//JTextField GadgetPriceTextfield = new JTextField(15);
	//JTextField GadgetWearTextfield = new JTextField(15);
	
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
	
	private class ListenForItem implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(valuablesList.getSelectedIndex() == 1) { //stocks
					//System.out.println("Stocks");
					StockPanel.add(StockNameLabel);
					StockFrame.add(StockPanel);
					
					StockFrame.setTitle("New Stock");
					StockFrame.setVisible(true);
					StockFrame.setSize(290,300);
					StockFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					
					StockPanel.add(StockNameTextfield);
					StockPanel.add(StockQuantityLabel);
					StockPanel.add(StockQuantitySpinner);
					StockPanel.add(StockQuotationLabel);
					StockPanel.add(StockQuotationSpinner);
					StockPanel.add(OKButton);
					StockPanel.add(CancelButton);
					OKButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							Double StockQuotation =(Double) StockQuotationSpinner.getValue();
							int StockQuantity = (Integer)StockQuantitySpinner.getValue();
							String StockName = StockNameTextfield.getText();
							
							System.out.println("StockQuotation: " + StockQuotation);
							System.out.println("StockNumber: " + StockQuantity);
							System.out.println("StockName: " + StockName);
							
							Stocks s = new Stocks(/*StockNameTextfield.getSelectedText(), Denna ger bara null*/ 
									StockName, StockQuantity, StockQuotation);
							vardesaker.add(s);
							System.out.println("Size of ArrayList: " + vardesaker.size());
							StockFrame.dispose();
						}
					});
					CancelButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							StockQuotationSpinner.setValue(0.0);
							StockQuantitySpinner.setValue(0);
							StockNameTextfield.setText("");
							StockFrame.dispose();
						}
					});
				}
				
				if(valuablesList.getSelectedIndex() == 2) { //Jewelry
					//System.out.println("jew");
					JewelPanel.add(JewelNameLabel);
					JewelFrame.add(JewelPanel);
					
					JewelFrame.setTitle("New Jewel");
					JewelFrame.setVisible(true);
					JewelFrame.setSize(250,300);
					JewelFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					JewelPanel.add(JewelNameTextfield);
					
					JewelPanel.add(JewelStoneLabel);
					JewelPanel.add(JewelStoneSpinner);
					JewelPanel.add(Box);
					JewelPanel.add(JewelGoldLabel);
					JewelPanel.add(OKButton);
					JewelPanel.add(CancelButton);
					OKButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String JewelName = JewelNameTextfield.getText();
							System.out.println("JewelName: " + JewelName);
							int JewelStone = (Integer)JewelStoneSpinner.getValue();
							System.out.println("JewelStone: " + JewelStone);
							boolean JewelGold = Box.isSelected() == true;
							boolean JewelSilver = Box.isSelected() == false;
							Jewelry j = new Jewelry(JewelName, JewelStone, JewelGold, JewelSilver);
							vardesaker.add(j);
							System.out.println("Size of ArrayList: " + vardesaker.size());
							JewelFrame.dispose();
						}
					});
					CancelButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							JewelStoneSpinner.setValue(0);
							JewelNameTextfield.setText("");
							Box.setSelected(false);
							JewelFrame.dispose();
						}
					});
				}
				
				if(valuablesList.getSelectedIndex() == 3) { //gadget
					//System.out.println("gadget");
					GadgetPanel.add(GadgetNameLabel);
					GadgetFrame.add(GadgetPanel);
					
					GadgetFrame.setTitle("New Gadget");
					GadgetFrame.setVisible(true);
					GadgetFrame.setSize(250,300);
					GadgetFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					GadgetPanel.add(GadgetNameTextfield);
					GadgetPanel.add(GadgetPriceLabel);
					GadgetPanel.add(GadgetPriceSpinner);
					GadgetPanel.add(GadgetWearLabel);
					GadgetPanel.add(GadgetWearSpinner);
					GadgetPanel.add(OKButton);
					GadgetPanel.add(CancelButton);
					OKButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String GadgetName = GadgetNameTextfield.getText();
							System.out.println("GadgetName: " + GadgetName);
							Double GadgetPrice = (Double)GadgetPriceSpinner.getValue();
							System.out.println("GadgetPrice: " + GadgetPrice);
							int GadgetQuotation = (Integer)GadgetWearSpinner.getValue();
							System.out.println("GadgetWear: " + GadgetQuotation);
							
							Gadget g = new Gadget(GadgetName, GadgetPrice, GadgetQuotation);
							vardesaker.add(g);
							System.out.println("Size of ArrayList: " + vardesaker.size());
							GadgetFrame.dispose();
							
						}
					});
					CancelButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							GadgetPriceSpinner.setValue(0.0);
							GadgetWearSpinner.setValue(0);
							GadgetNameTextfield.setText("");
							GadgetFrame.dispose();
						}
					});
				}
			}		
		}
	}
}