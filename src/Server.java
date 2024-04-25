import java.io.*;
import javax.crypto.NullCipher;
import javax.servlet.*;
import javax.servlet.http.*;
public class Server extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
     throws IOException {
        response.setContentType("text/html");
        String input = request.getParameter("matrix");
        String page;
        if(input.isEmpty()) {
            page = "/errorNoInput.html";
            response.sendRedirect(page);
        }
        else {
            String[] inputArr = input.split("\\s+");
            int[] convArr = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; i++) {
                convArr[i] = Integer.parseInt(inputArr[i]);
            }
            int length = (int)Math.sqrt(inputArr.length);
            if(length*length!=inputArr.length) {
                page = "errorNotSquaredMatrix.html";
                response.sendRedirect(page);
            } else {
                Matrix matrix = new Matrix(length);
                matrix.SetNumbers(convArr);
                page = "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<body bgcolor=\"#f0f0f0\" align=\"center\" >\n" +
                        "<h1 align=\"center\"> Result </h1>\n" +
                        "<h2>Original Matrix</h2>\n";
                String[] formatedMatrix = matrix.formatMatrix();
                for(int i=0; i<length; ++i) {
                    page = page + formatedMatrix[i];
                    page = page + "<br>";
                }
                String transpose = request.getParameter("Transpose");
                String isIdentity = request.getParameter("IsIdentity");
                if(transpose != null) {
                    page = page + "<h2>Transpose Matrix</h2>";
                    matrix.Transpose();
                    formatedMatrix = matrix.formatMatrix();
                    for(int i=0; i<length; ++i) {
                        page = page + formatedMatrix[i];
                        page = page + "<br>";
                    }
                    matrix.Transpose();
                }
                if(isIdentity != null) {
                    page = page + "<h2>Is Identity Matrix</h2>";
                    boolean checkIdentity = matrix.isIdentity();
                    if(checkIdentity) {
                        page = page + "<h4>True</h4>";
                    } else {
                        page = page + "<h4>False</h4>";
                    }
                }
                page += "</body>\n" + "</html>";
                PrintWriter output = response.getWriter();
                output.println(page);
            }
        }
    }
}
