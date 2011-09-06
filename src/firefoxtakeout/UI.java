/*
 */

package firefoxtakeout;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * @author hp
 */
public class UI extends JFrame implements Runnable {

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private ButtonGroup group;

	UI() {

		/**
		 * sets look and feel for the UI
		 */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Set the icon for the UI
		 */
		try {
			Image i = ImageIO.read(getClass().getResource("../resources/images/icon.png"));
			setIconImage(i);
		} catch (IOException ex) {
		}

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		initComponents();
	}

	private void initComponents() {

		setTitle("Firefox Takeout");
		jLabel1 = new javax.swing.JLabel();
		jRadioButton1 = new javax.swing.JRadioButton("Takeout firefox data", true);
		jRadioButton2 = new javax.swing.JRadioButton("Bring in firefox data", false);
		group = new ButtonGroup();
		group.add(jRadioButton1);
		group.add(jRadioButton2);

		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Select the action -");

		jButton1.setFocusable(false);
		jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton1.setText("Submit");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					submitButtomActionPerformed(evt);
				} catch (IOException ex) {
					Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(31, 31, 31).addComponent(jLabel1))
										.addGroup(
												layout.createSequentialGroup()
														.addGap(41, 41, 41)
														.addGroup(
																layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jRadioButton2).addComponent(jRadioButton1)))
										.addGroup(layout.createSequentialGroup().addGap(127, 127, 127).addComponent(jButton1)))
						.addContainerGap(208, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(26, 26, 26).addComponent(jLabel1).addGap(18, 18, 18).addComponent(jRadioButton1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jRadioButton2).addGap(18, 18, 18)
						.addComponent(jButton1).addContainerGap(152, Short.MAX_VALUE)));

		pack();
	}

	private void submitButtomActionPerformed(ActionEvent evt) throws IOException {
		if (jRadioButton2.isSelected()) {
			TransferTo.copyFileTo();
		} else {
			TransferFrom.copyFileFrom();
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		new UI().show();
	}

	@Override
	public void run() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
