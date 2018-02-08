/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactslistapplication;

/**                     
 *
 * @author justin
 */
public class ContactsListApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ContactManager app = new ContactManager();
        
        MainForm mf = new MainForm(app);
        mf.setVisible(true);
    }
    
}
