<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*, controle.Controle, java.util.ArrayList, itensParaPersistencia.Taxonomia"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script language="JavaScript">
	function Buscar(URL) {
	URL = URL+"?id=falou";
	window.open(URL , "Atualizar", "width=400,height=300,scrollbars=NO");
			
		
	}
</script>
<script language="JavaScript">
	function ValidarDados() {

		if (document.manter1.nome.value == "") {
			msg = "Preencha os campo corretamente!";
			alert(msg);
			document.forms.manter_filo.nome.focus();
			return false;
		}
		return true;

	}
</script>
<table>
<td>
<a href="#" onclick="Buscar('Buscar.jsp')">
<img src="buscar.png" /> </a>																						
</td>
</table>
</body>
</html>