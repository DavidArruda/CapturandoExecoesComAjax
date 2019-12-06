package services;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class RelatorioService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String FOLDER_RELATORIOS = "/relatorios";
	private static final String SUBREPORT_DIR = "SUBREPORT_DIR";
	private String SEPARETOR = File.separator;
	private String caminhoArquivoRelatorio = null;
	private JRExporter exporter = null;
	private String caminhoSubReport_DIR = "";
	private File arquivoGerado = null; 
	
	public String gerarRelatorio(List<?> lisDataBeanCollection, HashMap parametrosRelatorio,
			String nomeRelatorioJasper, String nomeRelatorioSaida, ServletContext servletContext) throws Exception {
		
		/*cria a lista de collectionDataSource de beans que carregam os dados para o relatorio */
		JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(lisDataBeanCollection);
		
		//Fornece caminho fisico ate a pasta que contem os relatorios .jasper
		String caminhoRelatorio = servletContext.getRealPath(FOLDER_RELATORIOS);
		
		File file = new File(caminhoRelatorio + SEPARETOR + nomeRelatorioJasper + ".jasper" );
		
		if (caminhoRelatorio == null
				|| caminhoRelatorio != null && caminhoRelatorio.isEmpty()
				|| file.exists()){
			caminhoRelatorio = this.getClass().getResource(FOLDER_RELATORIOS).getPath();
			SEPARETOR = "";
		}
		
		//caminho para imagens
		parametrosRelatorio.put("REPORT_PAREMETERS_IMG", caminhoRelatorio);
		
		//caminho completo ate o relatorio compilado indicado
		String caminhoArquivosJasper = caminhoRelatorio + SEPARETOR + nomeRelatorioJasper + ".jasper";
		
		//faz o carregamento do relatorio
		JasperReport relatorioJasper = (JasperReport)JRLoader.loadObjectFromFile(caminhoArquivosJasper);
		
		//seta parametros para SUBREPORT_DIR com o caminho fisico para o subreport
		caminhoSubReport_DIR = caminhoRelatorio + SEPARETOR;
		parametrosRelatorio.put(SUBREPORT_DIR, caminhoSubReport_DIR);
		
		//carrega o arquivo
		JasperPrint impressoraJasper = JasperFillManager.fillReport(relatorioJasper, parametrosRelatorio, jrbcds);
		
		exporter = new JRPdfExporter();
		
		//Caminho do relatorio exportado
		caminhoArquivoRelatorio = caminhoRelatorio + SEPARETOR + ".pdf";
		
		//criar novo arquivo exportado
		arquivoGerado = new File(caminhoArquivoRelatorio);
		
		//Prepara a impressao
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, impressoraJasper);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);	
		
		//Executa a exportação
		exporter.exportReport();
		
		//Remove o arquivo do servidor apos ser feito o download
		arquivoGerado.deleteOnExit();
		
		return caminhoArquivoRelatorio;
	}
	
}
