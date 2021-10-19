import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Timp extends Comanda{
    int  days;
    int pieces_a_day;
    JButton button;
    JPanel newPanel;
    JLabel daysLabel, piecesLabel;
    final JTextField textField1, textField2;
    public String toString(){
        return "Comanda trebuie finalizata in " + this.days + " zile " + "si se produc " + pieces_a_day + " de bucati pe zi";
    }
    Timp(){
        daysLabel = new JLabel();
        daysLabel.setText("Zile");      //set label value for textField1
        textField1 = new JTextField(6);    //set length of the text
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        piecesLabel = new JLabel();
        piecesLabel.setText("Bucati pe zi");
        textField2 = new JTextField(15);
        button = new JButton("SUBMIT");
        newPanel = new JPanel(new GridLayout(3,1));
        add(newPanel, BorderLayout.CENTER);
        newPanel.add(daysLabel);
        newPanel.add(textField1);
        newPanel.add(piecesLabel);
        newPanel.add(textField2);
        newPanel.add(button);
        //perform action on button click
        button.addActionListener(this);     //add action listener to button
        setTitle("Timp");
        setLocationRelativeTo(null);
        pack();
    }
    public Boolean checkTime(int pieces){
        if(this.days*this.pieces_a_day < pieces)
            return false;
        else
            return  true;
    }
    public void actionPerformed(ActionEvent e)     //pass action listener as a parameter
    {   String daysValue = textField1.getText();
        String piecesValue = textField2.getText();
        days = Integer.parseInt(daysValue);
        pieces_a_day = Integer.parseInt(piecesValue);
        if (e.getSource() == button ) {
            dispose();
            JOptionPane.showMessageDialog(null,toString(),"Timp",JOptionPane.INFORMATION_MESSAGE);
            if(Comanda.materialNeeded(Comanda.cuts[code])>Main.primeMaterial)
                JOptionPane.showMessageDialog(null,"Nu este destula materie prima","Comanda",JOptionPane.ERROR_MESSAGE);
            else {
                if (checkTime(Comanda.pieces) == false)
                    JOptionPane.showMessageDialog(null, "Aceasta comanda a avut intarzieri, clientul va fi nemultumit", "Comanda", JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Comanda a fost realizata la timp", "Comanda", JOptionPane.INFORMATION_MESSAGE);
                Main.primeMaterial = Main.primeMaterial - Comanda.materialNeeded(Comanda.cuts[code]);
                JOptionPane.showMessageDialog(null, "Au mai ramas " + Main.primeMaterial + " bucati de materia prima", "Cantitate", JOptionPane.INFORMATION_MESSAGE);
                if (Main.primeMaterial > 0) {
                    Comanda com = new Comanda();
                    com.setSize(300, 100);
                    com.setVisible(true);
                }
            }
        }
    }
}
