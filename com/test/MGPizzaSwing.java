/*
 * Author: Daniel Potter
 * Date: 17/05/21
 * Purpose: This is the order form application for MG Pizza.
 * It should take a name and phone number, allow you to pick a size, add toppings, 
 * change delivery, and calculate the total.
 */

package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MGPizzaSwing extends JFrame implements ActionListener, ItemListener {

	// Title Components
	private JPanel pnlTitle = new JPanel();
	private JLabel lblTitle = new JLabel("MG Pizza");

	// Details Components
	private JPanel pnlDetails = new JPanel();
	private JPanel pnlDetailsOne = new JPanel();
	private JLabel lblName = new JLabel("Order Name:");
	private JTextField txtName = new JTextField(30);
	private JPanel pnlDetailsTwo = new JPanel();
	private JLabel lblPhone = new JLabel("Phone Number:");
	private JTextField txtPhone = new JTextField(20);

	// Size Components
	private JPanel pnlSize = new JPanel();
	private ButtonGroup btngrpSize = new ButtonGroup();
	private JRadioButton radSmall = new JRadioButton("Small $4");
	private JRadioButton radMedium = new JRadioButton("Medium $6");
	private JRadioButton radLarge = new JRadioButton("Large $8");

	// Toppings Components
	private JPanel pnlToppings = new JPanel();
	private JCheckBox chkHam = new JCheckBox("Ham $1.50");
	private JCheckBox chkSalami = new JCheckBox("Salami $1.50");
	private JCheckBox chkChocolate = new JCheckBox("Chocolate $1.50");
	private JCheckBox chkPrawns = new JCheckBox("Prawns $1.50");
	private JCheckBox chkPineapple = new JCheckBox("Pineapple 50c");
	private JCheckBox chkOlives = new JCheckBox("Olives 50c");
	private JCheckBox chkCapsicum = new JCheckBox("Capsicum 50c");
	private JCheckBox chkMushroom = new JCheckBox("Mushroom 50c");

	// Delivery Components
	private JPanel pnlDelivery = new JPanel();
	private JPanel pnlDeliveryOne = new JPanel();
	private ButtonGroup btngrpDelivery = new ButtonGroup();
	private JRadioButton radDelNo = new JRadioButton("No");
	private JRadioButton radDelYes = new JRadioButton("Yes $1");
	private JPanel pnlDeliveryTwo = new JPanel();
	private JLabel lblAddress = new JLabel("Address:");
	private JTextField txtAddress = new JTextField(30);

	// Output Components
	private JLabel lblOutputTitle = new JLabel("OUTPUT");
	private JLabel lblOutputName = new JLabel("Name: ");
	private JLabel lblOutputPhone = new JLabel("Phone: ");
	private JLabel lblOutputAddress = new JLabel("Address: ");
	private JTextArea lblOutputArea = new JTextArea("CURRENT ORDER \n\n");
	private JScrollPane lblOutputScroll = new JScrollPane(lblOutputArea);
	private JLabel lblOutputTotal = new JLabel("Total Cost: ");

	// Total Components
	private JPanel pnlTotal = new JPanel();
	private JButton btnAdd = new JButton("Add to order");
	private JButton btnHelp = new JButton("Help");
	private JButton btnClear = new JButton("Clear");
	private JButton btnTest = new JButton("Test Data");

	// Others
	Container pane = getContentPane();
	private JPanel pnlLeft = new JPanel();
	private JPanel pnlRight = new JPanel();
	String tempString = "";
	String displayText = "";
	double totalCost = 0;
	Boolean deliveryAdded = false;

	public MGPizzaSwing() {

		pane.setLayout(new BorderLayout());

		// Set layouts to panels
		pnlTitle.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlDetails.setLayout(new GridLayout(2, 1));
		pnlDetailsOne.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlDetailsTwo.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlSize.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlToppings.setLayout(new GridLayout(2, 4));
		pnlDelivery.setLayout(new GridLayout(2, 1));
		pnlDeliveryOne.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlDeliveryTwo.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlTotal.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlLeft.setLayout(new GridLayout(5, 1));
		pnlRight.setLayout(new BoxLayout(pnlRight, BoxLayout.PAGE_AXIS));

		// Add components to panels
		// Title
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setForeground(Color.red);
		pnlTitle.add(lblTitle);
		// Details
		pnlDetailsOne.add(lblName);
		pnlDetailsOne.add(txtName);
		pnlDetails.add(pnlDetailsOne);
		pnlDetailsTwo.add(lblPhone);
		pnlDetailsTwo.add(txtPhone);
		pnlDetails.add(pnlDetailsTwo);
		pnlDetails.setBorder(BorderFactory.createTitledBorder("Details"));
		// Size
		btngrpSize.add(radSmall);
		btngrpSize.add(radMedium);
		btngrpSize.add(radLarge);
		pnlSize.add(radSmall);
		pnlSize.add(radMedium);
		pnlSize.add(radLarge);
		pnlSize.setBorder(BorderFactory.createTitledBorder("Size"));
		// Toppings
		pnlToppings.add(chkHam);
		pnlToppings.add(chkSalami);
		pnlToppings.add(chkChocolate);
		pnlToppings.add(chkPrawns);
		pnlToppings.add(chkPineapple);
		pnlToppings.add(chkOlives);
		pnlToppings.add(chkCapsicum);
		pnlToppings.add(chkMushroom);
		pnlToppings.setBorder(BorderFactory.createTitledBorder("Toppings"));
		// Delivery
		btngrpDelivery.add(radDelNo);
		btngrpDelivery.add(radDelYes);
		pnlDeliveryOne.add(radDelNo);
		pnlDeliveryOne.add(radDelYes);
		pnlDelivery.add(pnlDeliveryOne);
		pnlDeliveryTwo.add(lblAddress);
		pnlDeliveryTwo.add(txtAddress);
		pnlDelivery.add(pnlDeliveryTwo);
		pnlDelivery.setBorder(BorderFactory.createTitledBorder("Delivery"));
		// Total
		pnlTotal.add(btnAdd);
		pnlTotal.add(btnHelp);
		pnlTotal.add(btnClear);
		pnlTotal.add(btnTest);
		pnlTotal.setBorder(BorderFactory.createTitledBorder("Total"));
		// Output
		lblOutputTitle.setFont(new Font("Arial", Font.BOLD, 14));
		pnlRight.add(lblOutputTitle);
		pnlRight.add(lblOutputName);
		pnlRight.add(lblOutputPhone);
		pnlRight.add(lblOutputAddress);
		lblOutputScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlRight.add(lblOutputScroll);
		lblOutputTotal.setFont(new Font("Arial", Font.BOLD, 16));
		pnlRight.add(lblOutputTotal);
		// Add panels to container
		pane.add(pnlTitle, BorderLayout.NORTH);
		pnlLeft.add(pnlDetails);
		pnlLeft.add(pnlSize);
		pnlLeft.add(pnlToppings);
		pnlLeft.add(pnlDelivery);
		pnlLeft.add(pnlTotal);
		pane.add(pnlLeft, BorderLayout.CENTER);
		pane.add(pnlRight, BorderLayout.EAST);

		// Other
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnAdd.addActionListener(this);
		btnHelp.addActionListener(this);
		btnClear.addActionListener(this);
		btnTest.addActionListener(this);
		radSmall.addItemListener(this);
		radMedium.addItemListener(this);
		radLarge.addItemListener(this);
		radDelNo.addItemListener(this);
		radDelYes.addItemListener(this);
		// radDelNo.setSelected(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// When add button clicked add a pizza using the options selected
		if (e.getSource() == btnAdd) {

			// Check form is correct before executing code
			if (checkDetails()) {

				// Create the temp pizza object, assign the variables, then add the pizza to the
				// output area
				Pizza temp = new Pizza("small");

				// Set size if set or display error message
				if (radSmall.isSelected()) {
					temp.setSize("small");
				} else if (radMedium.isSelected()) {
					temp.setSize("medium");
				} else if (radLarge.isSelected()) {
					temp.setSize("large");
				} else {
					JOptionPane.showMessageDialog(null, "Please select a size.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Add ingredients if set
				if (chkHam.isSelected()) {
					temp.hasHam = true;
				}
				if (chkSalami.isSelected()) {
					temp.hasSalami = true;
				}
				if (chkChocolate.isSelected()) {
					temp.hasChocolate = true;
				}
				if (chkPrawns.isSelected()) {
					temp.hasPrawns = true;
				}
				if (chkPineapple.isSelected()) {
					temp.hasPineapple = true;
				}
				if (chkOlives.isSelected()) {
					temp.hasOlives = true;
				}
				if (chkCapsicum.isSelected()) {
					temp.hasCapsicum = true;
				}
				if (chkMushroom.isSelected()) {
					temp.hasMushroom = true;
				}

				// Add pizza to order
				addPizza(temp);
				clearChoices();
			}
		}

		// Show help dialog
		if (e.getSource() == btnHelp) {
			showHelp();
		}

		// Clear all the stuff
		if (e.getSource() == btnClear) {
			clearForm();
		}

		// Add test data
		if (e.getSource() == btnTest) {
			txtName.setText("Dan");
			txtPhone.setText("0411 222 333");
			txtAddress.setText("12 Woinsogil St");
			radMedium.setSelected(true);
			radDelYes.setSelected(true);
			chkHam.setSelected(true);
			chkSalami.setSelected(true);
			chkChocolate.setSelected(true);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// Disable address field if no delivery selected and add delivery if necessary
		if (radDelNo.isSelected()) {
			txtAddress.setEnabled(false);
			if(deliveryAdded) {
				totalCost -= 1;
				deliveryAdded = false;
			}
		}
		if (radDelYes.isSelected()) {
			txtAddress.setEnabled(true);
			if(!deliveryAdded) {
				totalCost += 1;
				deliveryAdded = true;
			}
		}
	}

	// Check order details
	public boolean checkDetails() {
		// Set name text if the field is not blank otherwise show a message
		if (!txtName.getText().isBlank()) {
			tempString = "Name: " + txtName.getText();
			lblOutputName.setText(tempString);
		} else {
			JOptionPane.showMessageDialog(null, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// Set phone text if the field is not blank otherwise show a message
		if (!txtPhone.getText().isBlank()) {
			tempString = "Phone: " + txtPhone.getText();
			lblOutputPhone.setText(tempString);
		} else {
			JOptionPane.showMessageDialog(null, "Please enter a phone number.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// Set address text if delivery is checked and if the field is not blank
		// otherwise show a message
		if (radDelYes.isSelected()) {
			if (!txtAddress.getText().isBlank()) {
				tempString = "Address: " + txtAddress.getText();
				lblOutputAddress.setText(tempString);
			} else {
				JOptionPane.showMessageDialog(null, "Please enter an address.", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			// If neither delivery button is checked show a message
		} else if (!radDelNo.isSelected() && !radDelYes.isSelected()) {
			JOptionPane.showMessageDialog(null, "Please choose a delivery option.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// If everything is good return true
		return true;
	}

	// Add pizza to order
	public void addPizza(Pizza temp) {
		displayText = lblOutputArea.getText();
		// The temp variables should already be set
		tempString = temp.calculatePizza();
		totalCost += temp.cost;
		lblOutputTotal.setText("Total Cost: $" + String.format("%.2f", totalCost));
		lblOutputArea.setText(displayText.concat(tempString));
	}

	// Clear all the stuff
	public void clearForm() {
		btngrpSize.clearSelection();
		btngrpDelivery.clearSelection();
		txtName.setText(null);
		txtPhone.setText(null);
		txtAddress.setText(null);
		chkHam.setSelected(false);
		chkSalami.setSelected(false);
		chkChocolate.setSelected(false);
		chkPrawns.setSelected(false);
		chkPineapple.setSelected(false);
		chkOlives.setSelected(false);
		chkCapsicum.setSelected(false);
		chkMushroom.setSelected(false);
		lblOutputName.setText("Name: ");
		lblOutputPhone.setText("Phone: ");
		lblOutputAddress.setText("Address: ");
		lblOutputTotal.setText("Total Cost: ");
		lblOutputArea.setText("CURRENT ORDER \n\n");
		totalCost = 0;
	}

	// Clear Choices
	public void clearChoices() {
		btngrpSize.clearSelection();
		chkHam.setSelected(false);
		chkSalami.setSelected(false);
		chkChocolate.setSelected(false);
		chkPrawns.setSelected(false);
		chkPineapple.setSelected(false);
		chkOlives.setSelected(false);
		chkCapsicum.setSelected(false);
		chkMushroom.setSelected(false);
	}

	// Show help dialog
	public void showHelp() {
		JOptionPane.showMessageDialog(null, "1. Enter the customer's name.\n"
				+ "2. Enter the customer's phone number.\n" + "3. Choose the size of the pizza.\n"
				+ "4. Select the toppings.\n" + "5. Choose a delivery option.\n"
				+ "6. If delivery is needed, enter the customer's address.\n"
				+ "7. Once all necessary data is entered, click 'Add to order' to add the pizza \n to the order and the total will be calculated automatically.\n"
				+ "8. Press 'Clear' to start a new order.\n", "Help", JOptionPane.INFORMATION_MESSAGE);
	}

}
