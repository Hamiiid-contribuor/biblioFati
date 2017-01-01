/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Personne;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author hamid
 */
public class PersonneHelper  extends AbstractHelper<Personne> {
    
    
    
       private static AbstractHelperItem[] titres;

   static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("Identifiant  ","id"),
            new AbstractHelperItem("Nom ","nom"),
            new AbstractHelperItem("Prenom ","prenom"),
            new AbstractHelperItem("Telephone ","telephone"),
            new AbstractHelperItem("E-Mail ","email"),
         
        
        };
    }

   

    public PersonneHelper(JTable jTable, List<Personne> list) {
        super(titres, jTable, list);
    }

    public PersonneHelper(JTable jTable) {
        super(titres, jTable);

    }
}

