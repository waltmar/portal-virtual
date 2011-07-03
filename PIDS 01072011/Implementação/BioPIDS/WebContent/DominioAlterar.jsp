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
		document.manter_filo.action = "/BioPIDS/CadastroTaxonomia";
		document.forms.manter_filo.submit();
	}
</script>
<script language="JavaScript">
	function Excluir() {
		document.manter_filo.action = "/BioPIDS/ExclusaoTaxonomia";
		document.forms.manter_filo.submit();
	}
</script>
<body>
	<center>
		<table background="gradiente.jpg">
			<br> <img src="ueg.png" width="45" height="35" border="0">
					<h1>Sistema de Catalogação da Biodiversidade</h1>

					<table cellspacing="0" cellpadding="0" border="0">
						<form method=post name=manter_filo>
						<TR>

							<TD></TD>
							<TD></TD>
							<BR>
								<TR>

									<td valign="top"><br> <br> <br> <br> <!------------------------------------------------------->
														<ul class="vert-one">
															<li><a href="http://www.free-css.com/">Cadastro
																	de Espécimes</a></li>
															<li><a href="http://www.free-css.com/"
																class="current">Manter Tabelas Básicas</a></li>
															<li><a href="http://www.free-css.com/">Manter
																	Usuários</a></li>
															<li><a href="http://www.free-css.com/">Relatórios</a>
															</li>
															<li><a href="http://www.free-css.com/">Configuração</a>
															</li>

														</ul>
									</TD>

									<td>
										<table background="gradiente.jpg" height="500" width="740"
											cellspacing="3" cellpadding="0" border="0" bgcolor="#DCDCDC">

											<tr>

												<td valign="top" bgcolor="#ffffff"><font
													face="arial, verdana, helvetica">
														<div id="demo-container">
															<ul id="simple-menu">
																<li><a href="http://www.free-css.com/"><span>Coleta</span>
																</a></li>
																<li><a href="http://www.free-css.com/"><span>Geografia</span>
																</a></li>
																<li><a href="http://www.free-css.com/"
																	class="current"><span>Taxonomia</span> </a></li>
															</ul>
														</div> </font> <br>
														<div id="styleone">
															<ul>
																<li><a href="http://www.free-css.com/">Reino</a></li>
																<li><a href="DominioFilo.jsp"
																	>Filo</a>
																</li>
																<li><a href="http://www.free-css.com/"class="current">Classe</a></li>
																<li><a href="http://www.free-css.com/">SubClasse</a>
																</li>
																<li><a href="http://www.free-css.com/">Ordem</a></li>
																<li><a href="http://www.free-css.com/">SubOrdem</a>
																</li>
																<li><a href="http://www.free-css.com/">Família</a>
																</li>
																<li><a href="http://www.free-css.com/">SubFamília</a>
																</li>
																<li><a href="http://www.free-css.com/">Gênero</a></li>
																<li><a href="http://www.free-css.com/">Espécie</a>
																</li>
																<li><a href="http://www.free-css.com/">Epíteto
																		Esp.</a></li>

															</ul>
														</div> <br><hr />
															<center>
																<h4>Cadastro de Classes</h4>
															</center> <br> <! contecúdo principal >
																<div id="tab" align="center">

																	<table>

																		<tr>
																			<input type=hidden name="nome_tabela" value="Filo">
																				<TD>Filo</TD>
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
																				<TD>Classe</TD>
																				<TD><INPUT type=text name="nome">
																			</TD>
																				<td><input type=button onclick=Cadastrar()
																					value=Cadastrar></input></td>
																		</tr>
																	</table>

																	<br>
																		<table summary="Software or other data table"
																			class="sofT" cellspacing="0">

																			<tr>
																				<td class="helpHed">Reino</td>
																				<td class="helpHed">Filo</td>
																				<td class="helpHed">Excluir</td>
																				<td class="helpHed">Alterar</td>

																			</tr>
																		</table>
																		<div id="tabela">
																			<table summary="Software or other data table"
																				class="sofT" cellspacing="0">


																				<%
																					ArrayList<Taxonomia> filos = new ArrayList<Taxonomia>();
																					Taxonomia filo = new Taxonomia();
																					filo.setNomeTabela("Filo");

																					try {
																						filos = ctrl.todosOsItens(filo);
																						for (int i = 0; i < filos.size(); i++) {
																				%>

																				
																						<tr>
																							<td><%=filos.get(i).getPai()%></td>
																							<td><%=filos.get(i).getNome()%></td>
																							<td><input type="image"
																								src="excluir (1).gif" value="<%=filos.get(i).Id()%>" onclick=Excluir() />
																							</td>
																							<td><input type="image" src="edit.gif"
																								onclick="" value="nulo">
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

											</tr>




										</table>
									</TD>
									</form>
					</table>
					</TR>
		</table>
	</center>
	<!--------------------------------------------------------->
</body>
</html>
>