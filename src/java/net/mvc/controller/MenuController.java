package net.mvc.controller;

import net.mvc.model.MenuModel;
import net.src.Menu;

public class MenuController {
    
    public String getMenus(){
        String htmlcode="";
        MenuModel mm=new MenuModel();
        for(Menu m:mm.getAllMenus()){
            if(m.isStatus()){
                htmlcode += "<div class=\"single-products\">\n"
                                + "<div class=\"productinfo\">\n"
                                    + "<p>"+m.getName()+"</p>\n"
                                    + "<img src=\"img?id_menu="+m.getId()+"\" width=400 height=200>\n"
                                    + "<h2>$"+m.getCost()+"</h2>\n"
                                    + "<a href=\"menu-details?id="+m.getId()+"\"><i class=\"fa fa-shopping-cart\"></i>Ver detalles</a>\n"
                                + "</div>\n"
                            + "</div>";
            }
        }
        return htmlcode;
    }
    
    public Menu getMenu(int id){
        return new MenuModel().getMenuByID(id);
    }
}
