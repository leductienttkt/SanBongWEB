<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<h3>Login Page</h3>
 
    
    <p style="color: red;">${errorString}</p>
 
    <form method="POST" action="DoLoginBO">
       <table border="0">
          <tr>
             <td>User Name</td>
             <td><input type="text" name="userName"  /> </td>
          </tr>
          <tr>
             <td>Password</td>
             <td><input type="text" name="password"  /> </td>
          </tr> 
          <tr>
             <td>
                <input type="submit" value= "Submit" />
             </td>
          </tr>
       </table>
    </form>
    (uesr = jangnara/nara, pass = 123456)
</body>
</html>