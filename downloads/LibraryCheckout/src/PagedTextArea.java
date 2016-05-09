import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.JTextArea;

/**
 * Class that extends JTextArea to print reports.  This will print multiple pages
 * whenever the PAGE_BREAK string is detected.
 * @author jasper
 * @version 0.1
 *
 */
@SuppressWarnings("serial")
public class PagedTextArea extends JTextArea implements Printable, Pageable {
    JTextArea singlePageTextArea;

    public static final String PAGE_BREAK = "     -------------------------     \n";
    
    @Override
    /**
	 * A custom print method to handle pagenation
	 *
	 * @return an int to show whether page is valid
	 */
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
                throws PrinterException {
        if (singlePageTextArea == null) {

            // Copy attributes to the singlePageTextArea:
            singlePageTextArea = new JTextArea();
            singlePageTextArea.setBounds(getBounds());
        }

        String[] pages = getText().split(PAGE_BREAK);
        if (pageIndex >= pages.length) {
            return Printable.NO_SUCH_PAGE;
        }
        //scales the text and rasterizes it for printing
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2d.scale(0.7, 0.7);
        Font font = new Font("Courier", Font.PLAIN, 12);
        singlePageTextArea.setFont(font);
        if(pageIndex>1){
        	singlePageTextArea.setText("Page: "+pageIndex+"\n----------------------------------------------------------------------------\n"+pages[pageIndex]);
        }else{
        	singlePageTextArea.setText(pages[pageIndex]);
        }
        singlePageTextArea.printAll(graphics);
        return Printable.PAGE_EXISTS;
    }


    @Override
    /**
	 *Gets the Number of Pages that the PrintJob will take
	 *
	 * @return number of pages
	 */
    public int getNumberOfPages() {
        String[] pages = getText().split(PAGE_BREAK);
        return pages.length;
    }

    @Override
    /**
	 * returns the PageFormat of the PrintJob
	 *
	 * @return the PageFormat of the PrintJob
	 */
    public PageFormat getPageFormat(int pageIndex) throws IndexOutOfBoundsException {
        return new PageFormat();
    }

    @Override
    public Printable getPrintable(int pageIndex) throws IndexOutOfBoundsException {
        return this;
    }
}