package com.beat_software.javaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SayHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

    public SayHelloServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		
		System.out.println("--------name" + name);
		System.out.println("--------gender" + gender);
		System.out.println("--------hobbies" + hobbies);

		String title = "";
		if("M".equals(gender)){
			title = "Mr. ";
		}
		
		if("F".equals(gender)){
			title = "Ms. ";
		}
		
		StringBuilder hobbiesStr = new StringBuilder("");
		if(hobbies.length > 2){
			for(int i = 0; i < hobbies.length - 2; i++){
				hobbiesStr.append(hobbies[i]).append(", ");
			}
			hobbiesStr.append(hobbies[hobbies.length - 2]).append( " and ").append(hobbies[hobbies.length - 1]);
		}
		
		if(hobbies.length == 2){
			hobbiesStr.append(hobbies[0]).append(" and ").append(hobbies[1]);
		}
		
		if(hobbies.length == 1){
			hobbiesStr.append(hobbies[0]);
		}		
		
		//construct html string
		StringBuilder html = new StringBuilder("");
		html.append("<html>");
		html.append(	"<body>");
		html.append(		" <h1 align=center>Glad to know your hobbies!</h1>");
		html.append(				"Hello ").append(title).append(name).append(". <br> <br>");
		html.append(				"Glad to know you love ");
		html.append(				hobbiesStr).append(".");
		html.append(		"<br>");
		html.append(	"</body>"); 
		html.append("</html>");
		
		PrintWriter out = response.getWriter();
		out.println(html);
				
				
	}
}
