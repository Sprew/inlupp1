package inlupp1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class inlup extends JFrame{
	
	JButton showButton;
	JButton crashButton;
	JComboBox valuablesList;
	String[] allValuables = {"SELECT ONE", "Stocks", "Jewelry", "Gadget"};
	
	JButton OKButton = new JButton("OK");
	JButton CancelButton = new JButton("Cancel");
	
	JCheckBox Box = new JCheckBox();
	
	JFrame StockFrame = new JFrame();
	JPanel StockPanel = new JPanel();
	JLabel StockNameLabel = new JLabel("Name: ");
	JLabel StockNumberLabel = new JLabel("Number: ");
	JLabel StockQuotationLabel = new JLabel("Quotation: ");
	JTextField StockNameTextfield = new JTextField(15);
	JTextField StockNumberTextfield = new JTextField(15);
	JTextField StockQuotationTextfield = new JTextField(15);
	
	JFrame JewelFrame = new JFrame();
	JPanel JewelPanel = new JPanel();
	JLabel JewelNameLabel = new JLabel("Name: ");
	JLabel JewelStoneLabel = new JLabel("Stone: ");
	JLabel JewelGoldLabel = new JLabel("Made of gold");
	JTextField JewelNameTextfield = new JTextField(15);
	JTextField JewelStoneTextfield = new JTextField(15);
	
	JFrame GadgetFrame = new JFrame();
	JPanel GadgetPanel = new JPanel();
	JLabel GadgetNameLabel = new JLabel("Name: ");
	JLabel GadgetPriceLabel = new JLabel("Price: ");
	JLabel GadgetWearLabel = new JLabel("Wear: ");
	JTextField GadgetNameTextfield = new JTextField(15);
	JTextField GadgetPriceTextfield = new JTextField(15);
	JTextField GadgetWearTextfield = new JTextField(15);
	
	
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
		JTextArea textArea = new JTextArea(15,20);		
		JButton showButton = new JButton("Show");
		JButton crashButton = new JButton("Stock Market Crash");
		JLabel newLabel = new JLabel("New: ");
		valuablesList = new JComboBox(allValuables);
		valuablesList.setSelectedItem(allValuables[0]);
		
		ListenForButton lForButton = new ListenForButton();
		ListenForItem lForItem = new ListenForItem();
		showButton.addActionListener(lForButton);
		valuablesList.addItemListener(lForItem);
		
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		newLabel.setToolTipText("Add new valuables");
		showButton.setContentAreaFilled(false);
		crashButton.setContentAreaFilled(false);
		JScrollPane scrollbar1 = new JScrollPane(textArea, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		textArea.append("testar");		
		
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
					StockFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					StockPanel.add(StockNameTextfield);
					StockNameTextfield.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String StockName = StockNameTextfield.getText();
							System.out.println("StockName: " + StockName);
						}
					});
					StockPanel.add(StockNumberLabel);
					StockPanel.add(StockNumberTextfield);
					StockNumberTextfield.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String StockNumber = StockNumberTextfield.getText();
							System.out.println("StockNumber: " + StockNumber);
						}
					});
					StockPanel.add(StockQuotationLabel);
					StockPanel.add(StockQuotationTextfield);
					StockQuotationTextfield.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String StockQuotation = StockQuotationTextfield.getText();
							System.out.println("StockQuotation: " + StockQuotation);
						}
					});
					StockPanel.add(OKButton);
					StockPanel.add(CancelButton);
				}
				
				if(valuablesList.getSelectedIndex() == 2) { //Jewelry
					//System.out.println("jew");
					JewelPanel.add(JewelNameLabel);
					JewelFrame.add(JewelPanel);
					
					JewelFrame.setTitle("New Jewel");
					JewelFrame.setVisible(true);
					JewelFrame.setSize(250,300);
					JewelFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					JewelPanel.add(JewelNameTextfield);
					JewelNameTextfield.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String JewelName = JewelNameTextfield.getText();
							System.out.println("JewelName: " + JewelName);
						}
					});
					JewelPanel.add(JewelStoneLabel);
					JewelPanel.add(JewelStoneTextfield);
					JewelStoneTextfield.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String JewelStone = JewelStoneTextfield.getText();
							System.out.println("JewelStone: " + JewelStone);
						}
					});
					JewelPanel.add(Box);
					JewelPanel.add(JewelGoldLabel);
					JewelPanel.add(OKButton);
					JewelPanel.add(CancelButton);
				}
				if(valuablesList.getSelectedIndex() == 3) { //gadget
					//System.out.println("gadget");
					GadgetPanel.add(GadgetNameLabel);
					GadgetFrame.add(GadgetPanel);
					
					GadgetFrame.setTitle("New Gadget");
					GadgetFrame.setVisible(true);
					GadgetFrame.setSize(250,300);
					GadgetFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					GadgetPanel.add(GadgetNameTextfield);
					GadgetNameTextfield.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String GadgetName = GadgetNameTextfield.getText();
							System.out.println("GadgetName: " + GadgetName);
						}
					});
					GadgetPanel.add(GadgetPriceLabel);
					GadgetPanel.add(GadgetPriceTextfield);
					GadgetPriceTextfield.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String GadgetPrice = GadgetPriceTextfield.getText();
							System.out.println("GadgetPrice: " + GadgetPrice);
						}
					});
					GadgetPanel.add(GadgetWearLabel);
					GadgetPanel.add(GadgetWearTextfield);
					GadgetWearTextfield.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String GadgetQuotation = GadgetWearTextfield.getText();
							System.out.println("GadgetWear: " + GadgetQuotation);
						}
					});
					GadgetPanel.add(OKButton);
					GadgetPanel.add(CancelButton);
				}
			}		
		}
	}
}
