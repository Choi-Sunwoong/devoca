package devoca.voca.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import devoca.voca.model.service.VocaService;
import devoca.voca.model.vo.Word;

@WebServlet("/voca/selectWordOne")
public class SelectWordOneServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int wordNo = Integer.parseInt(req.getParameter("wordNo"));
		
		try {
			
			VocaService service = new VocaService();
			
			Word word = service.selectWordOne(wordNo);

			new Gson().toJson(word, resp.getWriter());
						
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
