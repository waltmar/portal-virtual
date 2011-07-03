<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>22</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!------------------------------------------------------->
<link rel="stylesheet" href="CssDominioFilo/styles.css" type="text/css" />
<link rel="stylesheet" href="CssDominioFilo/styles3.css" type="text/css" />
<link rel="stylesheet" href="CssDominioFilo/styles4.css" type="text/css" />
<link rel="stylesheet" href="CssDominioFilo/styleTable.css"
	type="text/css" />

<%@ page
	import="java.sql.*,controle.Controle,java.util.ArrayList,itensParaPersistencia.Taxonomia"%>

</head>

<script language="JavaScript">
	function Cadastrar() {
		document.manter1.action = "/BioPIDS/CadastroTaxonomia";
		if (ValidarDados()) {
			document.forms.manter1.submit();
		}
	}
</script>
<script language="JavaScript">
	function Buscar(URL) {
	
	if (document.manter1.nome.value != ""){
	URL = URL+"?nome="+document.manter1.nome.value+"&nome_tabela="+document.manter1.nome_tabela.value;
	window.open(URL , "Atualizar", "width=400,height=300,scrollbars=NO");
	}
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
<script language="JavaScript">
	function Excluir(id) {

		msg = "Tem certeza que deseja apagar este registro?";
		if (confirm(msg)) {
			location.href = "ExclusaoTaxonomia?nome_tabela=Filo&id_item=" + id
					+ "";
		} else {

		}
	}
</script>
<script language=javascript>
	function Atualizar(URL) {
		window.open(URL, "Atualizar", "width=400,height=300,scrollbars=NO");
	}
</script>

<body>
	<center>
		<table background="gradiente.jpg">
			<br> <img src="ueg.png" width="45" height="35" border="0">
					<h1>Sistema de Catalogação da Biodiversidade</h1>

					<table cellspacing="0" cellpadding="0" border="0">

						<TR>

							<TD></TD>
							<TD></TD>
							<BR>
								<TR>

									<td valign="top"><br> <br> <br> <br> <!------------------------------------------------------->
														<ul class="vert-one">
															<li><a href="Cadastro.jsp">Cadastro de Espécimes</a>
															</li>
															<li><a href="TabBasicas.jsp" class="current">Manter
																	Tabelas Básicas</a></li>
															<li><a href="ManterUsuarios.jsp">Manter Usuários</a>
															</li>
															<li><a href="Relatorios.jsp">Relatórios</a></li>
															<li><a href="Configuracao.jsp">Configuração</a></li>

														</ul>
									</TD>

									<td>
										<table background="gradiente.jpg" height="500" width="740"
											cellspacing="3" cellpadding="0" border="0" bgcolor="#DCDCDC">

											<tr>

												<td valign="top" bgcolor="#ffffff">
													<table>
														<tr>
															<td><font face="arial, verdana, helvetica">
																	<div id="demo-container">
																		<ul id="simple-menu">
																			<li><a href="DominioColeta.jsp"><span>Coleta</span>
																			</a></li>
																			<li><a href="DominioGeografia.jsp"><span>Geografia</span>
																			</a></li>
																			<li><a href="Taxonomia.jsp" class="current"><span>Taxonomia</span>
																			</a></li>
																		</ul>
																	</div> </font> <br>
																	<div id="styleone">
																		<ul>
																			<li><a href="DominioReino.jsp">Reino</a></li>
																			<li><a href="DominioFilo.jsp" class="current">Filo</a>
																			</li>
																			<li><a href="DominioClasse.jsp">Classe</a></li>
																			<li><a href="DominioSubClasse.jsp">SubClasse</a>
																			</li>
																			<li><a href="DominioOrdem.jsp">Ordem</a></li>
																			<li><a href="DominioSubOrdem.jsp">SubOrdem</a></li>
																			<li><a href="DominioFamília.jsp">Família</a></li>
																			<li><a href="DominioSubFamilia.jsp">SubFamília</a>
																			</li>
																			<li><a href="DominioGenero.jsp">Gênero</a></li>
																			<li><a href="DominioEspecie.jsp">Espécie</a></li>
																			<li><a href="DominioEpiteto.jsp">Epíteto
																					Esp.</a></li>

																		</ul>
																	</div> <br><hr />
																		<center>
																			<h4>Cadastro de Filos</h4>
																		</center> <br> <! conteúdo principal >
																			<form method=post name=manter1>
																				<div id="tab" align="center">

																					<table>

																						<tr>
																							<input type=hidden name="nome_tabela"
																								value="Filo">
																								<TD>Reino</TD>
																								<td><SELECT name="pai">
																										<%
																											Controle ctrl = new Controle();
																											ArrayList<Taxonomia> reinos = new ArrayList<Taxonomia>();
																											Taxonomia reino = new Taxonomia();
																											reino.setNomeTabela("Reino");
																											try {
																												reinos = ctrl.todosOsItens(reino);
																												for (int i = 0; i < reinos.size(); i++) {
																										%>
																										<OPTION VALUE="<%=reinos.get(i).Id()%>"><%=reinos.get(i).getNome()%>
																										</OPTION>
																										<%
																											}
																											} catch (Exception e) {
																											}
																										%>
																								</SELECT></td>
																								<td></td>
																								<TD>Filo</TD>
																								<TD><INPUT type=text name="nome">
																							</TD>
																								<td><input type=button onclick=Cadastrar()
																									value=Cadastrar></input></td>
																								<td><a href="#"
																									onclick="Buscar('Buscar.jsp')"> <img
																										src="buscar.png" /> </a></td>
																						</tr>
																					</table>
																			</form> <br>

																				<table class="sofT" cellspacing="0">

																					<tr>
																						<td class="helpHed">Reino</td>
																						<td class="helpHed">Filo</td>
																						<td class="helpHed">Excluir</td>
																						<td class="helpHed">Alterar</td>

																					</tr>
																				</table>
																				<form method=post name=manter2>
																					<input type="hidden" name="nome_tabela"
																						value="Filo" />
																					<div id="tabela">

																						<table summary="Tabela principal" class="sofT"
																							cellspacing="0">


																							<%
																								ArrayList<Taxonomia> filos = new ArrayList<Taxonomia>();
																								Taxonomia filo = new Taxonomia();
																								filo.setNomeTabela("Filo");

																								try {
																									filos = ctrl.todosOsItens(filo);
																									for (int i = 0; i < filos.size(); i++) {
																							%>


																							<tr>
																								<td>
																									<%
																										Taxonomia r = new Taxonomia();
																												r.setNomeTabela("Reino");
																												r.setId(filos.get(i).getPai());
																												reino = ctrl.buscarItem(r);
																									%> <%=reino.getNome()%></td>
																								<td><%=filos.get(i).getNome()%></td>
																								<td><a href="#"
																									onclick="Excluir('<%=filos.get(i).Id()%>')"><img
																										src="excluir (1).gif" /> </a></td>
																								<td><a href="#"
																									onclick="Atualizar('Alterar.jsp?nome_tabela=<%=filos.get(i).NomeTabela()%>&id_item=<%=filos.get(i).Id()%>&pai=<%=filos.get(i).getPai()%>')">
																										<img src="edit.gif" /> </a>
																								</td>

																							</tr>
																							<%
																								}
																								} catch (Exception e) {
																								}
																							%>


																						</table>

																					</div>
															</td>
															</form>
													</table>
												</td>

											</tr>



										</table></TD>
					</table>
					</TR>
		</table>
	</center>
	<!--------------------------------------------------------->
</body>
</html>
