import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Server extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String input = request.getParameter("matrix");
        String[] inputArr = input.split(", ");
        int[] convArr = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            convArr[i] = Integer.parseInt(inputArr[i]);
        }
        int length = (int)Math.sqrt(inputArr.length);
        Matrix matrix = new Matrix(length);
        matrix.SetNumbers(convArr);
    }
}
