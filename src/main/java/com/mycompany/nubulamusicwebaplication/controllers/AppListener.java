/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nubulamusicwebaplication.controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 *
 * @author katia
 */
@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext app = sce.getServletContext();
        
        app.setAttribute("appname", "Nebula Music PRUEBA");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        // todo el codigo q quieras ejecutar cuando se detenga la aplicación
    }
    
}
