package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import bean.San;
import bo.DanhSachSanBO;
import dao.DanhSachSanDAO;

/**
 * Servlet implementation class DanhSachSan
 */
@WebServlet("/DanhSachSan")
public class DanhSachSan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachSan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
		String diaChi = request.getParameter("timDiaChi");
		diaChi = diaChi.replace(" ", "&32");
        String loai = request.getParameter("timLoai");
        String gioBatDau = request.getParameter("timGioBatDau");
        String gioKetThuc = request.getParameter("timGioKetThuc");
        String ngay = request.getParameter("timNgay");
        System.out.println(diaChi);
        List <San> san = new ArrayList<San>();
        try {
			san = DanhSachSanBO.getDanhSachSan(diaChi,loai,gioBatDau,gioKetThuc,ngay);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
        request.setAttribute("danhSachSan", san);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/jsp/danhSachSanView.jsp");  
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
