import java.io.File;

import org.apache.pdfbox.PDFReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.PDFTextStripperByArea;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PDFValidation {
	public static void main(String[] args) throws Exception {
		/*PDFReader pdf = new PDFReader(new File(System.getProperty("user.dir") + File.separator + "EXP.pdf"));
	    PdfTextExtractor parser = new PdfTextExtractor();
	    String output = parser.getTextFromPage(pdf, pageNumber);
	    assert output.contains("whatever you want to validate on that page");*/
	    try {
	        PDDocument document = null;
	        document = PDDocument.load(new File(System.getProperty("user.dir") + File.separator + "g.pdf"));
	      //  document.getClass();
	        if (!document.isEncrypted()) {
	            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	            stripper.setSortByPosition(true);
	            PDFTextStripper Tstripper = new PDFTextStripper();
	            String st = Tstripper.getText(document);
	            Assert.assertTrue("text mismatch",st.contains("SHREYANSH"));
	            
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	

}
