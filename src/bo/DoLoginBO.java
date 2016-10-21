package bo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.NguoiDung;
import dao.DoLoginDAO;

/**
 * Servlet implementation class DoLoginBO
 */
@WebServlet("/DoLoginBO")
public class DoLoginBO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginBO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
	    String password = request.getParameter("password");
	    
	    boolean hasError = false;
	    String errorString = null;
	    NguoiDung nguoiDung = null;
	    if (userName == null || password == null || userName.length() == 0 || password.length() == 0) 
	    {
	          hasError = true;
	          errorString = "nhap chi di";
	    } 
	    else 
	    {
	         nguoiDung = DoLoginDAO.getLogin(userName,password);
	         if (nguoiDung == null)
	         {
	        	 hasError = true;
	        	 errorString = "khong ton tai";
	         }
	    }
	    
	    if (hasError) {          
	          // Ghi các thông tin vào request trước khi forward.
	          request.setAttribute("errorString", errorString);
	          
	          // Chuyển tiếp tới trang /WEB-INF/views/login.jsp
	          RequestDispatcher dispatcher //
	          = this.getServletContext().getRequestDispatcher("/jsp/loginView.jsp");
	          dispatcher.forward(request, response);
	      }  
	      else 
	      {
	    	  
	    	  if (nguoiDung.getQuyen()==1){
	    		  response.sendRedirect(request.getContextPath() + "/DanhSachThue");
	    	  }else
	    	  {
	    		  response.sendRedirect(request.getContextPath() + "/DanhSachKhuyenMai");
	    	  }
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
