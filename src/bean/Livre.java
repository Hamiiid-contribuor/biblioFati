/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author hamid
 */
public class Livre extends Ouvrage {

    private String theme; //art  , histoire  , culture 

    public Livre() {
        super();
    }

    public Livre(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Livre{" + "theme=" + theme + '}';
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

}
