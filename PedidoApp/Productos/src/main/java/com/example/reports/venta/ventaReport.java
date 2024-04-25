package com.example.PedidoApp.reports.venta;

import com.example.PedidoApp.model.Pedido;
import com.example.PedidoApp.model.Productos;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import com.itextpdf.layout.Document;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class ventaReport {


    public void ventaReports(HttpServletResponse response, Pedido pedido)throws Exception {

        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdfDocument = new PdfDocument(writer);
        pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont(FontConstants.COURIER);
        document.setTopMargin(150f);

        Paragraph onesp = new Paragraph("\n");
        try{
            List<Productos> ped = pedido.getProductos().stream().collect(Collectors.toList());

            Productos productoPedido = null;
           /* for (Productos pr : ped) {
                productoPedido = pr;
                System.out.println(productoPedido.getIdProductos());
            } */

            Table table = new Table(4);

            // Añadir los encabezados de las columnas
            table.addCell(new Cell().add("ID"));
            table.addCell(new Cell().add("Nombre"));
            table.addCell(new Cell().add("Iva"));
            table.addCell(new Cell().add("total con el iva"));

            // Añadir los datos de los productos a la tabla
            for (Productos producto : ped) {
                table.addCell(new Cell().add(String.valueOf(producto.getIdProductos())));
                table.addCell(new Cell().add(producto.getNombre()));
                table.addCell(new Cell().add(String.valueOf(producto.getIva())));
                table.addCell(new Cell().add(String.valueOf(producto.getPrecio())));
            }
     /*       float twocol = 505f;
            float twocolumnWidth[] = {500f, 500f};
            Table tables = new Table(twocolumnWidth);
          //  document.add(new Paragraph("¡Hola mundo! Este es un PDF generado con iTextPDF en Spring Boot." + pedido.getFechaPedido()));

           Table nestedTable2 = new Table(new float[]{twocol / 2, twocol / 2});
            document.add(new Paragraph("Pedidos S.A").setTextAlignment(TextAlignment.CENTER).setBold());
            nestedTable2.addCell(new Cell().add(getInfoTextCell("id del pedido ") + ":")).setBorder(Border.NO_BORDER);
            nestedTable2.addCell(new Cell().add("" + pedido.getIdPedido()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));
            nestedTable2.addCell(new Cell().add(getInfoTextCell("Nombre del producto" + ":")).setBorder(Border.NO_BORDER));
            nestedTable2.addCell(new Cell().add("" + productoPedido.getNombre()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));
            tables.addCell(new Cell().add(nestedTable2).setBorder(Border.NO_BORDER));

            document.add(nestedTable2); */
            document.add(table);

            document.close();

        }catch (Exception e){

        }

    }
    static Cell getInfoTextCell(String textValue) {
        return new Cell().add(textValue).setFontSize(12f).setBorder(Border.NO_BORDER).setBold().setTextAlignment(TextAlignment.LEFT).setPaddingLeft(105f);
    }
}
