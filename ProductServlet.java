package com.geekbrains.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products= new ArrayList<>();
        products.add(new Product(1,5284.00,"Tomatin Legacy"));
        products.add(new Product(2,16296.00,"Dalmore 12 Years Old Sherry Cask Select"));
        products.add(new Product(3,6720.00,"Benriach The Smoky Ten"));
        products.add(new Product(4,18800.00,"Lagavulin 16 Years Old"));
        products.add(new Product(5,10552.00,"Glenmorangie A Tale of Winter"));

        //отправляем клиенту пять продуктов
        resp.setContentType("text/html;charset = UTF-8");
        resp.getWriter().printf("<html><body>");

        for(Product unit:products){
            resp.getWriter().printf("<h1> "+ unit.getTitle() + " "
                    + unit.getCost() + "руб. "
                    + " id продукта: " + unit.getId() + "</h1>");
        }
        resp.getWriter().printf("</body></html>");

    }
}
