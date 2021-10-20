import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Comanda extends JFrame implements ActionListener {
    JButton button;
    JPanel newPanel;
    JLabel codeLabel, piecesLabel, cutLabel;
    final JTextField textField1, textField2, textField3;
    public static int code;
    public static int pieces;
    public static int cut;
    public static int cuts[] = new int[10000];
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
    public String toString(int cuts){
        return "Codul este " + this.code + " si sunt nevoie de " + this.pieces + " bucati si materia prima trebuie taiata in "
                + cuts + " bucati";
    }
    public static int materialNeeded(int cutmaterial){
        if((pieces/cutmaterial)*cutmaterial<pieces)
            return pieces/cutmaterial+1;
        else
            return pieces/cutmaterial;
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
            if(cuts[code] == 0){
                cuts[code] = cut;
                JOptionPane.showMessageDialog(null,"Pentru codul " + code + " se taie " + cuts[code] + " de bucati din materia prima","",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                if(cuts[code] == cut)
                    JOptionPane.showMessageDialog(null,toString(cuts[code]),"Comanda",JOptionPane.INFORMATION_MESSAGE);
                else{
                    JOptionPane.showMessageDialog(null,"Pentru codul " + code + " se taie " + cuts[code] + " de bucati din materia prima","",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,toString(cuts[code]),"Comanda",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            Timp time = new Timp();
            time.setVisible(true);
        }
        else{
            dispose();
            String s = JOptionPane.showInputDialog("Codul trebuie sa fie de maxim patru cifre: ");
            while(s.length()>4){
                s = JOptionPane.showInputDialog("Codul trebuie sa fie de maxim patru cifre: ");
                code = Integer.parseInt(s);
            }
            cuts[code] = cut;
            if(cuts[code] == 0){
                cuts[code] = cut;
                JOptionPane.showMessageDialog(null,"Pentru codul " + code + " se taie " + cuts[code] + " de bucati din materia prima","",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                if(cuts[code] == cut)
                    JOptionPane.showMessageDialog(null,toString(cuts[code]),"Comanda",JOptionPane.INFORMATION_MESSAGE);
                else{
                    JOptionPane.showMessageDialog(null,"Pentru codul " + code + " se taie " + cuts[code] + " de bucati din materia prima","",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,toString(cuts[code]),"Comanda",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            Timp time = new Timp();
            time.setVisible(true);
        }
    }

}
