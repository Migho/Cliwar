/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import GUI.Gcontroller;
import GUI.Gstarter;
import java.awt.EventQueue;


public class Launcher {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Gstarter guistarter = new Gstarter(controller);
        
    }
}