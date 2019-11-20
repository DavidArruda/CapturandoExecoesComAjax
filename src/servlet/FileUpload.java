package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoImagem;

@WebServlet("/pages/fileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoImagem daoImagem = new DaoImagem();

	public FileUpload() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		try {
			
		
		// usar variavel fileupload para salvar no banco
		String fileUpload = request.getParameter("fileUpload");
		System.out.println(fileUpload);
		
		daoImagem.gravarImagem(fileUpload);
		
		response.getWriter().write("Upload realizado com sucesso");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
