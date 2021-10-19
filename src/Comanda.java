import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.util.ArrayList;
public class Comanda extends JFrame implements ActionListener {
    JButton button;
    JPanel newPanel;
    JLabel codeLabel, piecesLabel, cutLabel;
    final JTextField textField1, textField2, textField3;
    public int code, pieces, cut;

    Comanda() {
        codeLabel = new JLabel();
        codeLabel.setText("Cod");
        textField1 = new JTextField(15);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        piecesLabel = new JLabel();
        piecesLabel.setText("Bucati");
        textField2 = new JTextField(15);

        cutLabel = new JLabel("Piese Taiate");
        textField3 = new JTextField(15);
        //create submit button
        button = new JButton("SUBMIT");
        //create panel to put form elements
        newPanel = new JPanel(new GridLayout(3,1));
        newPanel.add(codeLabel);
        newPanel.add(piecesLabel);
        newPanel.add(cutLabel);
        newPanel.add(textField1);
        newPanel.add(textField2);
        newPanel.add(textField3);
        newPanel.add(button);
        //set border to panel
        add(newPanel, BorderLayout.CENTER);
        button.addActionListener(this);     //add action listener to button
        setTitle("Comanda");
        setLocationRelativeTo(null);

    }
    public String toString(){
        return "Codul este " + this.code + " si sunt nevoie de " + this.pieces + " bucati si materia prima trebuie taiata in "
                + this.cut + " bucati";
    }
    public void actionPerformed(ActionEvent e)     //pass action listener as a parameter
    {   String codeValue = textField1.getText();
        String piecesValue = textField2.getText();
        String cutValue = textField3.getText();
        code = Integer.parseInt(codeValue);
        pieces = Integer.parseInt(piecesValue);
        cut = Integer.parseInt(cutValue);
        if (e.getSource() == button && code/10000<1) {
            dispose();
            JOptionPane.showMessageDialog(null,toString(),"Comanda",JOptionPane.INFORMATION_MESSAGE);
            Timp time = new Timp();
            time.setVisible(true);
        }
        else{
            dispose();
            String s = JOptionPane.showInputDialog("Codul trebuie sa fie de maxim patru cifre: ");
            code = Integer.parseInt(s);
            JOptionPane.showMessageDialog(null,toString(),"Comanda",JOptionPane.INFORMATION_MESSAGE);
            try {
                Thread.currentThread().sleep(1750);
            } catch (InterruptedException ae) {
                ae.printStackTrace();
            }
            Timp time = new Timp();
            time.setVisible(true);
        }
    }
    public int materialNeeded(int cutmaterial){
        if((this.pieces/cutmaterial)*cutmaterial<this.pieces)
            return this.pieces/cutmaterial+1;
        else
            return this.pieces/cutmaterial;
    }
}
