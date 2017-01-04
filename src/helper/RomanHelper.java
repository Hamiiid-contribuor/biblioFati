/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Roman;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author hamid
 */
public class RomanHelper  extends AbstractHelper<Roman> {
    
    
    
       private static AbstractHelperItem[] titres;

   static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem(" ISBN ","id"),
            new AbstractHelperItem("Titre","titre"),
            new AbstractHelperItem("Auteur ","auteur"),
            new AbstractHelperItem("Qte Stock ", "quantiteStock"),
            new AbstractHelperItem("Editeur ","editeur"),
            new AbstractHelperItem(" Date Edition  ","dateEdition"),
         
        
        };
    }

   

    public RomanHelper(JTable jTable, List<Roman> list) {
        super(titres, jTable, list);
    }

    public RomanHelper(JTable jTable) {
        super(titres, jTable);

    }
}

