<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>22</title>

<script language="JavaScript">
	function Cadastrar() {
		
		document.manter1.action = "/BioPIDS/AtualizarTaxonomia";
		if (ValidarDados()) {
		
		document.forms.manter1.submit();
		}
	}
function ValidarDados(){
		
		if (document.manter1.nome.value=="") {
			msg = "Preencha os campo corretamente!";
			alert(msg);
			document.forms.manter_filo.nome.focus();
			return false;
		}
		return true;
	}
</script>
<%@ page
	import="java.sql.*,controle.Controle,java.util.ArrayList,itensParaPersistencia.Taxonomia"%>

<center>
	<h3>Alterar Nome</h3>

<form method=post name=manter1>


	<table>

		<tr>

			</td>
			<td></td>
			<%
			Controle ctrl = new Controle();
			%>
			<input type=hidden name="nome_tabela" value="<%= request.getParameter("nome_tabela")%>">
			<input type=hidden name="id_item" value="<%= request.getParameter("id_item")%>">
			<input type=hidden name="pai" value="<%= request.getParameter("pai")%>">
			<TD><%= request.getParameter("nome_tabela")%></TD>
			<TD><INPUT type=text name="nome">
			</TD>
			<td><input type=button onclick=Cadastrar() value=Cadastrar></input>
			</td>
		</tr>
	</table>
</form>

</center>
<!--------------------------------------------------------->
</body>
</html>
