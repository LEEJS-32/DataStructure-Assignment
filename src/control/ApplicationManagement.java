/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.ApplicationManagementUI;

/**
 *
 * @author Hong Yip
 */
public class ApplicationManagement {
    
    private ApplicationManagementUI appMgmtUI = new ApplicationManagementUI();
    
    public static void main(String[] args) {

        ApplicationManagement app = new ApplicationManagement();
        app.appMenu();
    }
 
    public void appMenu() {
        appMgmtUI.Menu();
        
    }
    
}
