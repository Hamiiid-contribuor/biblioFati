/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Ouvrage;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author hamid
 */
public class OuvrageHelper  extends AbstractHelper<Ouvrage> {
    
    
    
       private static AbstractHelperItem[] titres;

   static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem(" ISBN ","isbn"),
            new AbstractHelperItem("Titre","titre"),
            new AbstractHelperItem("Auteur ","auteur"),
            new AbstractHelperItem("Editeur ","editeur"),
            new AbstractHelperItem(" Date Edition  ","dateEdition"),
         
        
        };
    }

   

    public OuvrageHelper(JTable jTable, List<Ouvrage> list) {
        super(titres, jTable, list);
    }

    public OuvrageHelper(JTable jTable) {
        super(titres, jTable);

    }
}

