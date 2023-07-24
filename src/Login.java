import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Login extends javax.swing.JFrame{
    private static Scanner sc;
    private static int intentos;
    private static String user,contraseña;
    private JTextField txtUser;
    private JPasswordField txtPas;
    private JLabel Usuario;
    private JLabel Contraseña;
    private JButton Cancelar;
    private JButton Ingresar;
    private JPanel Jpanel;

    public static void setIntentos(int intentos) {
        Login.intentos = intentos;
    }
    public Login() {
        initComponents();
        setLocationRelativeTo(null);//centrar pantalla
        rootPane.setDefaultButton(Ingresar);
    Ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nlineas=0;
                int i=0;
                String [] usuarios=null;
                String linea;
                try {
                    sc= new Scanner(new File("\"C:\\Users\\mayer\\Downloads\\usuario.txt\""));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                File f=new File("\"C:\\Users\\mayer\\Downloads\\usuario.txt\"");
                FileReader fr = null;
                BufferedReader br= new BufferedReader(fr);

                while(true){
                    try {
                        if (!((linea=br.readLine())!=null)) break;
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    nlineas++;
                }
                usuarios=new String[nlineas];//tamaño del arreglo
                while(sc.hasNextLine()){
                    usuarios[i++]=sc.nextLine();//almacenamos cada linea en una pocision del arreglo
                }
                intentos++;
                user = txtUser.getText();
                contraseña=txtPas.getText();

                seguridad s = new seguridad();
                s.validarUsuario(usuarios,user,contraseña,intentos);


                    try {
                        fr = new FileReader(f);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }

        });
    }

    private void initComponents() {
    }

    public static void main (String[]args){
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().Jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
