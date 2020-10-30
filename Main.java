import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel firstLabel;
  JLabel secondLabel;

  JTextField fahrenheit;
  JTextField celsius;

  JButton fToCButton;
  JButton cToFButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    // initialize the main JPanel
    mainPanel = new JPanel();
     // disable any layout helpers
    mainPanel.setLayout(null);

    // create the labels
    firstLabel = new JLabel("Degrees Fahrenheit");
    secondLabel = new JLabel("Degrees Celsius");

    // layout the labels by setting coordinate and size 
    firstLabel.setBounds(100,150,200,30);
    secondLabel.setBounds(100,200,200,30);

    // initialize the input text fields
    fahrenheit = new JTextField();
    celsius = new JTextField();

    // set the location and size 
    fahrenheit.setBounds(310,150,100,30);
    celsius.setBounds(310,200,100,30);

    // initialize the buttons
    fToCButton = new JButton("F -> C");
    cToFButton = new JButton("C -> F");

    // add an action listener to the buttons 
    fToCButton.addActionListener(this);
    cToFButton.addActionListener(this);

    // set an action command to the buttons
    fToCButton.setActionCommand("fahrenheit");
    cToFButton.setActionCommand("celsius");

    // set the location and size of the buttons
    fToCButton.setBounds(430,150,100,30);
    cToFButton.setBounds(430,200,100,30);

    // add to the main panel 
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(fahrenheit);
    mainPanel.add(celsius);
    mainPanel.add(fToCButton);
    mainPanel.add(cToFButton);

    // add the panel to the frame
    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("fahrenheit")){
      // get the numbers from the boxes
      String firstText = fahrenheit.getText();

      // change the string into an integer
      int fah = Integer.parseInt(firstText);

      // find the conversion
      int cel = (fah - 32) * 5/9;

      // tell the user the answer
      celsius.setText("" + cel);
    }

    if(command.equals("celsius")){
      // take the number from the text box 
      String secondText = celsius.getText();

      // change the string into an integer 
      int cel = Integer.parseInt(secondText);

      // find the conversion 
      int fah = (cel * 9) - 5 + 32;

      // tell the user the answer 
      fahrenheit.setText("" + fah);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
