import javax.swing.*;

public class Main {
    public static int primeMaterial;
    public static void main(String[] args) {
        String string = JOptionPane.showInputDialog("Introduceti cantitatea de materie prima: ");
        primeMaterial = Integer.parseInt(string);
        JOptionPane.showMessageDialog(null,"In depozit sunt " + primeMaterial + " de bucati de materia prima" ,"Timp",JOptionPane.INFORMATION_MESSAGE);
        Comanda com = new Comanda();
        com.setSize(300,100);
        com.setVisible(true);
    }
}

