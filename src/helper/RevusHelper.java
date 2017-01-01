/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Revus;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author hamid
 */
public class RevusHelper  extends AbstractHelper<Revus> {
    
    
    
       private static AbstractHelperItem[] titres;

   static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem(" ISBN ","id"),
            new AbstractHelperItem("Titre","titre"),
            new AbstractHelperItem("Auteur ","auteur"),
            new AbstractHelperItem("Editeur ","editeur"),
            new AbstractHelperItem(" Date Edition  ","dateEdition"),
         
        
        };
    }

   

    public RevusHelper(JTable jTable, List<Revus> list) {
        super(titres, jTable, list);
    }

    public RevusHelper(JTable jTable) {
        super(titres, jTable);

    }
}

