<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page
		import="java.sql.*,controle.Controle,java.util.ArrayList,itensParaPersistencia.Taxonomia"%>

	<script language="JavaScript">
		function Atualizar(URL) {

			if (ValidarDados()) {

				location.href = URL;
			}
		}
		function ValidarDados() {

			if (document.manter1.nome.value == "") {
				msg = "Preencha os campo corretamente!";
				alert(msg);
				document.forms.manter_filo.nome.focus();
				return false;
			}
			return true;
		}

		function Excluir(id) {

			msg = "Tem certeza que deseja apagar este registro?";
			if (confirm(msg)) {
				location.href = "ExclusaoTaxonomia2?nome_tabela=Filo&id_item="
						+ id + "";
			} else {

			}
		}
	</script>

	<%
		Controle ctrl = new Controle();
		Taxonomia t = new Taxonomia();
		Taxonomia t1 = new Taxonomia();
		Taxonomia reino = new Taxonomia();

		t.setNome(request.getParameter("nome"));
		t.setNomeTabela(request.getParameter("nome_tabela"));
		t1 = ctrl.buscarPorNome(t);
		reino.setId(t1.getPai());
		reino = ctrl.buscarItem(reino);
	%>

	<SELECT name="pai">
		<OPTION VALUE=<%=reino.Id()%>>
			<%=reino.getNome()%></OPTION>
	</SELECT>
	<input type="text" name="nome" value="<%=t1.getNome()%>">
	<a href="#" onclick="Excluir('<%=t1.Id()%>')"><img
		src="excluir (1).gif" /> </a>



	<a href="#"
		onclick="Atualizar('AlteracaoTaxonomia?nome_tabela=<%=t1.NomeTabela()%>&id_item=<%=t1.Id()%>&pai=<%=t.getPai()%>')">
		<img src="edit.gif" />
	</a>

</body>
</html>