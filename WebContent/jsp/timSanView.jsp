<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; ccharset=UTF-8">
<title>Tìm Sân</title>
</head>
<body>
		<form method="POST" action="DanhSachSan">
       <table border="0">
          <tr>
             <td>Địa Chỉ</td>
             <td><input type="text" name="timDiaChi"  /></td>
          </tr>
          <tr>
             <td>Loại</td>
             <td><input type="text" name="timLoai" /></td>
          </tr>
          <tr>
             <td>Giờ Bắt Đầu</td>
             <td><input type="text" name="timGioBatDau" /></td>
          </tr>
          <tr>
             <td>Giờ Kết Thúc</td>
             <td><input type="text" name="timGioKetThuc"  /></td>
          </tr>
          <tr>
             <td>Ngày</td>
             <td><input type="text" name="timNgay"  /></td>
          </tr>
          <tr>
             <td colspan="2">                  
                 <input type="submit" value="Submit" />
                 <a href="QuanLyNhanSu">Cancel</a>
             </td>
          </tr>
       </table>
    </form>
</body>
</html>