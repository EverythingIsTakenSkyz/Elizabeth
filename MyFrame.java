package liz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements KeyListener{

JLabel label; //Laver et JLabel.
ImageIcon icon; //Laver et billede.
public Dimension dim; //Laver en variable for dimensionerne.
public JFrame jframe; //Laver en variable for JFrame.

//Sætter alle booleans som angiver retning som false.
private boolean left = false; 
private boolean up = false; 
private boolean down = false;
private boolean right = false;
 
MyFrame(){ //Laver en klasse for vores baggrund.
	dim = Toolkit.getDefaultToolkit().getScreenSize(); //Finder dimensionerne for skærmen.
	this.setResizable(false); //Gør at man ikke kan ændre størrelsen på framen.
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(500,502); //Tegner framet i dimensionerne.
	this.setLayout(null); //Sætter layoutet til dimensionerne.
	this.addKeyListener(this); //Tilføjer en keylistener.
	this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2); //Tegner framet i midten af skærmen.

	icon = new ImageIcon("Billeder/Elizabeth.png"); //Giver billedet et billede.

	label = new JLabel(); //Laver et JLabel
	label.setBounds(200, 200, 100, 100); //Giver labelet parameterne.
	label.setIcon(icon); //Sætter vores billede som labelet.
	this.getContentPane().setBackground(Color.GREEN); //Farver baggrunden grøn.
	this.add(label); //Tiføjer labelet.
	this.setVisible(true); //Gør det synligt.
}

 @Override
 public void keyTyped(KeyEvent e) {} //Tjekker om der bliver skrevet noget. 

 @Override
 public void keyPressed(KeyEvent e) { //Tjekker hvilken key bliver trykket på.
	 int i = e.getKeyCode(); //Ændrer 'i' til den tast som bliver trykket på.
	 if(i == KeyEvent.VK_A) { //Hvis 'i' er 'a', så skal koden køres.
	      label.setLocation(label.getX()-10, label.getY()); //Ændre positionen af billedet.
	      left = true; //Sætter left til true.
	      if(label.getX()<=-2) { //Tjekker om billedet flytter sig ud over borderen.
	    	  label.setLocation(label.getX()+10, label.getY()); //Hvis den gør, flyttes den tilbage ind for framet.
	      }
	 }
	  
	 if(i == KeyEvent.VK_D) {
	      label.setLocation(label.getX()+10, label.getY());
	      right = true;
	      if(label.getX()>=420) {
	    	  label.setLocation(label.getX()-10, label.getY());
	     }
	 }
	  
	 if(i == KeyEvent.VK_W) {
	      label.setLocation(label.getX(), label.getY()-10);
	      up = true;
	      if(label.getY()<=-5) {
	    	  label.setLocation(label.getX(), label.getY()+10);
	      }
	 }
	  
	 if(i == KeyEvent.VK_S) {
	      label.setLocation(label.getX(), label.getY()+10);
	      down = true;
	      if(label.getY()>=380) {
	    	  label.setLocation(label.getX(), label.getY()-10);
	      }
	 }
 }

 @Override
 public void keyReleased(KeyEvent e) { //Kaldes når en knap ikke længere bliver trykket på.
  System.out.println("You released key char: " + e.getKeyChar()); //Skriver hvilken knap man gav slip på.
  System.out.println("You released key code: " + e.getKeyCode()); //Sriver hvilken keycode man gav slip på.
  }
}