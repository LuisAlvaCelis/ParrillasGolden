package net.src.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.mvc.controller.MenuController;
import net.src.ArticlesCart;
import net.src.Menu;
import net.src.UtilCode;

@WebServlet(name = "sv_cart", urlPatterns = {"/cart"})
public class sv_cart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("acjsp");
        if(action.equalsIgnoreCase("addcart")){
            int cant=Integer.parseInt(request.getParameter("txtCantMenu"));
            int id=Integer.parseInt(request.getParameter("txtIDMenu"));
            HttpSession hs=request.getSession(true);
            ArrayList<ArticlesCart> articles=hs.getAttribute("cart")==null ? new ArrayList<>() : (ArrayList)hs.getAttribute("cart");
            boolean status=false;
            if(articles.size()>0){
                for(ArticlesCart ac:articles){
                    if(id==ac.getId()){
                        ac.setCant(ac.getCant()+cant);
                        status=true;
                        break;
                    }
                }
            }
            if(!status){
                articles.add(new ArticlesCart(id, cant));
            }
            hs.setAttribute("cart", articles);
            UtilCode.openNewJSP(request, response, "cart.jsp");
        }else if(action.equalsIgnoreCase("remove-cart")){
            int id=Integer.parseInt(request.getParameter("idmenu"));
            HttpSession hs=request.getSession(true);
            ArrayList<ArticlesCart> articles=hs.getAttribute("cart")==null?null:(ArrayList)hs.getAttribute("cart");
            if(articles!=null){
                for(ArticlesCart ac:articles){
                    if(ac.getId()==id){
                        articles.remove(ac);
                        break;
                    }
                }
            }
            double total=0;
            MenuController mc=new MenuController();
            for(ArticlesCart ac:articles){
                Menu menu=mc.getMenu(ac.getId());
                total+=ac.getCant()*menu.getCost();
            }
            response.getWriter().print(Math.round((total+3)*100.0)/100.0);
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
