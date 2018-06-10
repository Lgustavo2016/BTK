package Interface;

public class Carregar {
    public static void main(String[] args) {
        frm_CARREGAMENTO carregar = new frm_CARREGAMENTO();
        carregar.setVisible(true);
        
        try {
            for(int i = 0; i < 101; i++){
                Thread.sleep(75);
//                carregar.lblCarregar.setText(i+"%");
                carregar.jpbCarregar.setValue(i);
                
            }
            frm_LOGIN login = new frm_LOGIN();
            login.setVisible(true);
            carregar.dispose();
            
        } catch (Exception e) {
        }
    }
}
