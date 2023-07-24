import javax.swing.*;
import javax.swing.JOptionPane;
public class seguridad {
    Login login= new Login();
    String res;
    public void validarUsuario(String usuarios[],String user,String pwd,int intentos){
        boolean encontrado=false;
        for(int i=0;i< usuarios.length;i++){
            if((usuarios[i].equalsIgnoreCase(user)&& usuarios[i+1].equals(pwd))){
                res="Bienvenido"+user;
                encontrado=true;
                JOptionPane.showMessageDialog(null,res,"Inicio de sesion",JOptionPane.INFORMATION_MESSAGE);
                intentos=0;
                login.setIntentos(intentos);
                break;
            }
        }//FIN DEL FOR
        if(encontrado==false){
            res="Clave y/o usuario erroneos van"+ intentos+"intentos fallidos";
            JOptionPane.showMessageDialog(null,res,"Inicio de sesion",JOptionPane.ERROR_MESSAGE);
        }
        if(intentos>2){
            JOptionPane.showMessageDialog(null,"3 intentos fallidos, esto se cerrara","Inicio de sesion",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
