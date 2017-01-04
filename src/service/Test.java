/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hamid
 */
public class Test {

    public static void main(String[] args) {

        EmprunteService emprunterService = new EmprunteService();

        Date curentDate = new Date();

        System.out.println(emprunterService.addDays(curentDate, 30));
    }
}
