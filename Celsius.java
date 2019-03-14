package Temperature;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;



public class Celsius extends JFrame
{

	private static final long serialVersionUID = 1L;

  Celsius() {
    super("Converter");

    Container content = getContentPane();
    LayoutManager layout = new GridLayout(10, 10);
    content.setLayout(layout);

    _celsiusLabel = new JLabel("Celsius");
    _fahrenheitLabel = new JLabel("Fahrenheit");
    _Cels = new JTextField(7);
    _Fah = new JTextField(7);
    _convert = new JButton("Convert");
 

    Font font = new Font("SansSerif", 0, 10);
    content.setFont(font);
    _Cels.setFont(null);
    _Fah.setFont(null);
    _celsiusLabel.setFont(null);
    _fahrenheitLabel.setFont(null);
    _convert.setFont(null);
    


    Border borderCelsius = BorderFactory.createEmptyBorder(2, 5, 1, 0);
    _celsiusLabel.setBorder(borderCelsius);
    Border borderFahrenheit = BorderFactory.createEmptyBorder(1, 5, 2, 0);
    _fahrenheitLabel.setBorder(borderFahrenheit);

    ActionListener celsiusListener = new ConvertCelsiusListener();
    _convert.addActionListener(celsiusListener);
    _Cels.addActionListener(celsiusListener);


    content.add(_celsiusLabel);
    content.add(_fahrenheitLabel);
    content.add(_Cels);
    content.add(_Fah);
    content.add(_convert);

  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
	  public void run() {
	    Celsius gui = new Celsius();
	    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gui.pack();
	    gui.setVisible(true);
	  }
        }
					   );
  }

  private class ConvertCelsiusListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String celsiusText = _Cels.getText();
      double celsius = Double.parseDouble(celsiusText);
      double fahrenheit = celsius * 9 / 5 + 32; 
      String fahrenheitText = String.valueOf(fahrenheit);
      _Fah.setText(fahrenheitText);
    }
  }

 
  
  private JTextField _Cels;
  private JTextField _Fah;
  private JLabel _celsiusLabel;
  private JButton _convert;
  private JLabel _fahrenheitLabel;

}
