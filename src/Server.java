import java.io.*;
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
            page = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body bgcolor=\"#f0f0f0\" align=\"center\" >\n" +
                    "<h1 align=\"center\"> Matrix Operations </h1>\n" +
                    "\n" +
                    "<textarea rows=\"12\" cols=\"40\" name=\"matrix\" form=\"MatrixForm\" placeholder=\"Enter a Square Matrix ...\"></textarea>\n" +
                    "<br>\n" +
                    "<br>\n" +
                    "\n" +
                    "<form action=\"MatrixForm\" method=\"GET\" id=\"MatrixForm\">\n" +
                    "    <input type=\"checkbox\" name=\"Transpose\" /> Transpose\n" +
                    "    <input type=\"checkbox\" name=\"IsIdentity\"  /> Is Identity\n" +
                    "    <br>\n" +
                    "    <br>\n" +
                    "    <p style=\"color: red\">Please insert a square matrix</p>\n" +
                    "    <br>\n" +
                    "    <input type=\"submit\" value=\"Calculate\" />\n" +
                    "</form>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>";
        }
        else {
            String[] inputArr = input.split(" ");
            int[] convArr = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; i++) {
                convArr[i] = Integer.parseInt(inputArr[i]);
            }
            int length = (int)Math.sqrt(inputArr.length);
            Matrix matrix = new Matrix(length);
            matrix.SetNumbers(convArr);
            page = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body bgcolor=\"#f0f0f0\" align=\"center\" >\n" +
                    "<h1 align=\"center\"> Result </h1>\n" +
                    "<h2>Original Matrix</h2>\n" + input ;
            page += "</body>\n" + "</html>";
        }
        response.getWriter().println(page);
    }
}
