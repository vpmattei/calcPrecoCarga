package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculadoraCarga")
public class calcCarga extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		
		PrintWriter out = response.getWriter();
		
		//Iniciando parâmetros
		double distPav;
		double distSemPav;
		double ton = 0;
		
		//Pegando parâmetros
		boolean camBau = request.getParameter("veiculo").equals("camBau");
		boolean camCac = request.getParameter("veiculo").equals("camCac");
		boolean carreta = request.getParameter("veiculo").equals("carreta");	
		
		//Distância percorrida
		//Chaves de segurança
		if(request.getParameter("kmPav") != ""){
			if(Double.parseDouble(request.getParameter("kmPav"))<0){
				out.println("A distância precisa ter um valor positivo ou igual a zero.<br>");
				return;
			} else{
				distPav = Double.parseDouble(request.getParameter("kmPav"));
			}
		} else {
			distPav = 0;
		}
		
		if(request.getParameter("kmSPav") != ""){
			if(Double.parseDouble(request.getParameter("kmSPav"))<0){
				out.println("A distância precisa ter um valor positivo ou igual a zero.<br>");
				return;
			} else{
				distSemPav = Double.parseDouble(request.getParameter("kmSPav"));
			}
		} else {
			distSemPav = 0;
		}
		
		//Carga transportada
		if(request.getParameter("ton") != ""){
			ton = Double.parseDouble(request.getParameter("ton"));
		}
		
		//Monta uma nova rota
		Rota rota = new Rota();
		rota.setDistPav(distPav);
		rota.setDistSemPav(distSemPav);
		rota.setVeiculo(camBau, camCac, carreta);
		rota.setToneladas(ton);
		
		//imprime o valor total
		out.println("<html>");
		out.println("<body>");
		out.println("O valor total da rota é de: " + rota.getValorTotal() + " R$");
		out.println("</body>");
		out.println("</html>");
		
	}
}
