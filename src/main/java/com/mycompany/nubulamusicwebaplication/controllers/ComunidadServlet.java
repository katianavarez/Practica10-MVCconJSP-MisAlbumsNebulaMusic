/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.nubulamusicwebaplication.controllers;

import com.mycompany.nubulamusicwebaplication.models.Usuario;
import com.mycompany.nubulamusicwebaplication.service.IUsuarioService;
import com.mycompany.nubulamusicwebaplication.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author katia
 */
@WebServlet(name = "ComunidadServlet", urlPatterns = {"/comunidad"})
public class ComunidadServlet extends HttpServlet {
    
    private final IUsuarioService usuarioService = new UsuarioService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int pagina = 1;
        int tamanioPagina = 10;
        
        String paginaParam = request.getParameter("pagina");
        
        if (paginaParam != null && !paginaParam.isBlank()){
            try{
                pagina = Integer.parseInt(paginaParam);
            } catch(Exception e){
                pagina = 1;
            }
        }
        
        List<Usuario> usuarios = usuarioService.listarPaginado(pagina, tamanioPagina);
        long totalUsuarios = usuarioService.contarUsuarios();
        
        long totalPaginas = (long) Math.ceil((double) totalUsuarios / tamanioPagina);
        
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("paginaActual", pagina);
        request.setAttribute("totalPaginas", totalPaginas);
        request.setAttribute("totalUsuarios", totalUsuarios);
        
        request.getRequestDispatcher("/views/aplication/comunidad.jsp").forward(request, response);
    }
    

}
