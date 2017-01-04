/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Emprunter;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author hamid
 */
public class EmprunterHelper  extends AbstractHelper<Emprunter> {
    
    
    
       private static AbstractHelperItem[] titres;

   static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem(" ISBN d'Ouvrage","idOuvrage"),
            new AbstractHelperItem("Date Emprunte","datePret"),
            new AbstractHelperItem("Type  ","typeOuvrage"),
            new AbstractHelperItem("Etat  ","etatOuvrage"),
            new AbstractHelperItem("Date_Max retour   ","DateRetour"),
         
        
        };
    }

   

    public EmprunterHelper(JTable jTable, List<Emprunter> list) {
        super(titres, jTable, list);
    }

    public EmprunterHelper(JTable jTable) {
        super(titres, jTable);

    }
}

