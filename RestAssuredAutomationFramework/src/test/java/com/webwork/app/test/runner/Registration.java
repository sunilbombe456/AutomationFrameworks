package com.webwork.app.test.runner;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.webwork.framework.helper.TestDataHelper;
import com.webwork.framework.utility.CSVFileReader;
import com.webwork.framework.utility.DataEncryptionDecryption;

class MyFrame extends JFrame implements ActionListener {

	JMenu generateKey, encryption, decryption, encryptionAndDecryption;
	JMenuItem i1, i2, i3, i4, i5;
	JMenuBar mb;
	JFrame f;

	// Components of the Form
	private Container c;
	private Container subContainer;
	private JLabel title;
	private JLabel privateKeyLabel,newPrivatekeyLabel;
	private JLabel testDataFilePathLabel;
	private JLabel selectColumnLabel;
	private JCheckBox encryotWithNewPrivateKey;

	private JTextField privateKeyTextField,newPrivateKeyTextField;
	private JTextField TestDataFilePathTextField;
	private JList theList;
	private JLabel mno;
	private JTextField tmno;
	private JLabel gender;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup gengp;
	private JLabel dob;
	private JComboBox date;
	private JComboBox month;
	private JComboBox year;
	private JLabel add;
	private JTextArea textOutputMessage;
	private JCheckBox term;
	private JButton encryptionButton,decryptionButton,generatePrivateKeyButton,addButton;
	private JButton reset;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;

	public MyFrame() {
		setTitle("Data Encryption Form");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		mb = new JMenuBar();
		generateKey = new JMenu("Generate Key");
		i1 = new JMenuItem("Generate Key");
		i1.addActionListener(this);
		generateKey.add(i1);
		generateKey.addActionListener(this);
		encryption = new JMenu("Encryption");
		encryption.setSelected(true);
		encryption.addActionListener(this);
		encryptionAndDecryption = new JMenu("Decryption and Encryption");
		encryptionAndDecryption.addActionListener(this);
		decryption = new JMenu("Decryption");
		decryption.addActionListener(this);
		mb.add(encryption);
		mb.add(encryptionAndDecryption);
		mb.add(decryption);
		mb.add(generateKey);
		mb.setLocation(220, 10);
		mb.setSize(490, 50);
		c.add(mb);

		privateKeyLabel = new JLabel("Enter Private Key");
		privateKeyLabel.setSize(300, 20);
		privateKeyLabel.setLocation(200, 100);
		c.add(privateKeyLabel);

		privateKeyTextField = new JTextField();
		privateKeyTextField.setSize(200, 20);
		privateKeyTextField.setLocation(310, 100);
		c.add(privateKeyTextField);

		testDataFilePathLabel = new JLabel("File Input");
		testDataFilePathLabel.setSize(300, 20);
		testDataFilePathLabel.setLocation(200, 150);
		c.add(testDataFilePathLabel);
		

		TestDataFilePathTextField = new JTextField();
		TestDataFilePathTextField.setSize(200, 20);
		TestDataFilePathTextField.setLocation(270, 150);
		c.add(TestDataFilePathTextField);
		
		addButton = new JButton("Add");
		addButton.setSize(80, 20);
		addButton.setLocation(200, 200);
		addButton.addActionListener(this);
		c.add(addButton);
		
		selectColumnLabel = new JLabel("Select Columns:");
		selectColumnLabel.setSize(300,20);
		selectColumnLabel.setLocation(500,200);
		selectColumnLabel.setVisible(false);
		c.add(selectColumnLabel);
		
	    theList = new JList();
		theList.setSize(100,100);
		theList.setLocation(610,200);
		theList.setVisible(false);
		theList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		c.add(theList);
		
		encryotWithNewPrivateKey = new JCheckBox("Encrypt With New Private Key");
		encryotWithNewPrivateKey.setSize(220, 20);
		encryotWithNewPrivateKey.setLocation(200, 250);
		encryotWithNewPrivateKey.addActionListener(this);
		c.add(encryotWithNewPrivateKey);
		
		newPrivatekeyLabel = new JLabel("New Private key");
		newPrivatekeyLabel.setSize(220, 20);
		newPrivatekeyLabel.setLocation(200, 300);
		newPrivatekeyLabel.setVisible(false);
		c.add(newPrivatekeyLabel);
		
		newPrivateKeyTextField = new JTextField();
		newPrivateKeyTextField.setSize(200, 20);
		newPrivateKeyTextField.setLocation(310, 300);
		newPrivateKeyTextField.setVisible(false);
		c.add(newPrivateKeyTextField);

		encryptionButton = new JButton("Encrypt");
		encryptionButton.setSize(100, 20);
		encryptionButton.setLocation(200, 350);
		encryptionButton.addActionListener(this);
		c.add(encryptionButton);
		
		decryptionButton = new JButton("Decrypt");
		decryptionButton.setSize(100, 20);
		decryptionButton.setLocation(300, 350);
		decryptionButton.addActionListener(this);
		c.add(decryptionButton);
		
		generatePrivateKeyButton = new JButton("Generate Private Key");
		generatePrivateKeyButton.setSize(150, 20);
		generatePrivateKeyButton.setLocation(400, 350);
		generatePrivateKeyButton.addActionListener(this);
		c.add(generatePrivateKeyButton);
		

		textOutputMessage = new JTextArea();
		textOutputMessage.setSize(500, 150);
		textOutputMessage.setLocation(200, 400);
		textOutputMessage.setLineWrap(true);
		c.add(textOutputMessage);

		setVisible(true);
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action Listener Method calleda!");
		if (e.getSource() == encryption) {
			if (encryption.isSelected()) {
				generateKey.setSelected(false);
				encryption.setSelected(true);
				decryption.setSelected(false);
				encryptionAndDecryption.setSelected(false);
			} else {
				System.out.println("Not Selected Encryption!");
			}
		} else if (e.getSource() == generatePrivateKeyButton) {
			try {
				textOutputMessage.setText("Generated Key: "+DataEncryptionDecryption.generateKey());
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource() == encryptionButton) {
			List<String> selectedColumns = theList.getSelectedValuesList();
			String privateKey = privateKeyTextField.getText().trim();
			String filePath = TestDataFilePathTextField.getText().trim();
			List<Map<String,String>> testDataMap = CSVFileReader.encryptTestDataFile(selectedColumns, privateKey, filePath);
			System.out.println("Selected List:"+selectedColumns);
			textOutputMessage.setText("Data has been encrypted and Saved into File:\n "+testDataMap.toString());
			
			
		}else if(e.getSource() == decryptionButton) {
			List<String> selectedColumns = theList.getSelectedValuesList();
			String privateKey = privateKeyTextField.getText().trim();
			String filePath = TestDataFilePathTextField.getText().trim();
			List<Map<String,String>> testDataMap = CSVFileReader.decryptTestDataFile(selectedColumns, privateKey, filePath);
			System.out.println("Selected List:"+selectedColumns);
			textOutputMessage.setText("Data has been Decrypted and Saved into File:\n "+testDataMap.toString());
		}
		else if(e.getSource() == addButton) {
			String filePath = TestDataFilePathTextField.getText().trim();
			System.out.println("File Path:"+filePath);
			if(filePath!=null && !filePath.equals("")) {
				try {
					String[] columnList = CSVFileReader.getColumnNames(filePath);
					Arrays.asList(columnList).stream().forEach(s->System.out.println(s));
					selectColumnLabel.setVisible(true);
					theList.setListData(columnList);
					theList.setVisible(true);				  
				}catch(Exception exe) {
					textOutputMessage.setText("Invalid File Path Selected! "+filePath);
					theList.setVisible(false);
				}
			}else {
				textOutputMessage.setText("Invalid File Path Selected! "+filePath);
				theList.setVisible(false);
			}
		}else if(e.getSource() == encryotWithNewPrivateKey) {
			if(encryotWithNewPrivateKey.isSelected()) {
				newPrivatekeyLabel.setVisible(true);
				newPrivateKeyTextField.setVisible(true);
			}else {
				newPrivatekeyLabel.setVisible(false);
				newPrivateKeyTextField.setVisible(false);
				newPrivateKeyTextField.setText("");
			}
		}
	}
}

