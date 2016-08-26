/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RA21503801
 */
public class ProcessarJogo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>JOGO PEDRA PAPEL TESOURA</title>");
            out.println("</head>");
            out.println("<body>");
            
            String opcaousuario =  request.getParameter("opcao");
            
            
            String[] opcoes ={"TE","PA","PE"};
            int sorteio = new Random().nextInt(3);
            String opcaoservidor = opcoes[sorteio];
            
            boolean usuariovenceu = false;
            
            if(opcaousuario.equals("TE")){
                if(opcaoservidor.equals("PA")){
                    usuariovenceu = true;
                }
            }
            
            if(opcaousuario.equals("PA")){
                if(opcaoservidor.equals("PE")){
                    usuariovenceu = true;
                }
            }
            if(opcaousuario.equals("PE")){
                if(opcaoservidor.equals("TE")){
                    usuariovenceu = true;
                }
            }
            
            out.println("<h1>Eu escolhi:" + opcaoservidor +"e você escolheu" + opcaousuario +"</h1>");
            
            if (usuariovenceu) {
                out.println("<h1>Você venceu o jogo!</h1>");
            } else {
                out.println("<h1>Você perdeu o jogo!</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
