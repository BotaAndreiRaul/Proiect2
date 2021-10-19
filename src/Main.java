import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String string = JOptionPane.showInputDialog("Introduceti cantitatea de materie prima: ");
        int primeMaterial = Integer.parseInt(string);
        JOptionPane.showMessageDialog(null,"In depozit sunt " + primeMaterial + " de bucati de materia prima" ,"Timp",JOptionPane.INFORMATION_MESSAGE);

        Comanda com = new Comanda();
        com.setSize(300,100);
        com.setVisible(true);
        try {
            Thread.currentThread().sleep(8750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(com.materialNeeded(com.cut)>primeMaterial)
            JOptionPane.showMessageDialog(null,"Nu este destula materie prima","Comanda",JOptionPane.ERROR_MESSAGE);
        else
            if(Timp.checkTime(com.pieces)==false)
                JOptionPane.showMessageDialog(null,"Aceasta comanda a avut intarzieri, clientul va fi nemultumit","Comanda",JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null,"Comanda a fost realizata la timp","Comanda",JOptionPane.INFORMATION_MESSAGE);
    }
}

