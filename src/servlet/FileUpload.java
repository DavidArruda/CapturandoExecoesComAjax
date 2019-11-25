package servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

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
		
		try {
			
		String acao = request.getParameter("acao");
		
		if(acao.equalsIgnoreCase("carregar")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("upload.jsp");
			request.setAttribute("listaUserImagem", daoImagem.listar());
			dispatcher.forward(request, response);
			
		}else if(acao.equalsIgnoreCase("download")){
			
			String codImagem = request.getParameter("codImagem");
			String imagem = daoImagem.buscarImagem( codImagem);
			
			if (imagem != null) {
				
				//Pega a base64 sem o contentType
				String imagemPura = imagem.split(",")[1];
				
				//converte base64 em bytes
				byte[] imagemBytes = new Base64().decode(imagemPura);
				
				//coloca os bytes em um objeto de entrada para processar 
				InputStream is = new ByteArrayInputStream(imagemBytes);
				
				//inicio - escrever os dados na resposta
				int read = 0;
				byte[] bytes = new byte[1024];
				
				OutputStream os = response.getOutputStream();
				
				while((read = is.read(bytes)) != -1) {
					os.write(bytes,0, read);
				}
				
				os.flush();
				os.close();
				
				//fim escrever os dados na resposta
				
				
				
			}
		}
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
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
