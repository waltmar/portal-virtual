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
<script language="JavaScript">
	function Excluir(id) {
		
			  
			msg = "Tem certeza que deseja apagar este registro?";  
			if(confirm(msg)){  
			location.href="ExclusaoTaxonomia?nome_tabela=SubOrdem&id_item="+id+"";  
			}else {  
				 
			}  
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
															<li><a href="Cadastro.jsp">Cadastro
																	de Espécimes</a>
															</li>
															<li><a href="TabBasicas.jsp"
																class="current">Manter Tabelas Básicas</a>
															</li>
															<li><a href="ManterUsuarios.jsp">Manter
																	Usuários</a>
															</li>
															<li><a href="Relatorios.jsp">Relatórios</a>
															</li>
															<li><a href="Configuracao.jsp">Configuração</a>
															</li>

														</ul>
									</TD>

									<td>
										<table background="gradiente.jpg" height="500" width="740"
											cellspacing="3" cellpadding="0" border="0" bgcolor="#DCDCDC">

											<tr>

												<td valign="top" bgcolor="#ffffff">
												<table>
												<tr> <td>
												<font
													face="arial, verdana, helvetica">
														<div id="demo-container">
															<ul id="simple-menu">
																<li><a href="DominioColeta.jsp"><span>Coleta</span>
																</a>
																</li>
																<li><a href="DominioGeografia.jsp"><span>Geografia</span>
																</a>
																</li>
																<li><a href="Taxonomia.jsp"
																	class="current"><span>Taxonomia</span> </a>
																</li>
															</ul>
														</div> </font> <br>
														<div id="styleone">
															<ul>
																<li><a href="DominioReino.jsp">Reino</a>
																</li>
																<li><a href="DominioFilo.jsp"
																	>Filo</a></li>
																<li><a href="DominioClasse.jsp">Classe</a>
																</li>
																<li><a href="DominioSubClasse.jsp">SubClasse</a>
																</li>
																<li><a href="DominioOrdem.jsp">Ordem</a>
																</li>
																<li><a href="DominioSubOrdem.jsp"class="current">SubOrdem</a>
																</li>
																<li><a href="DominioFamília.jsp">Família</a>
																</li>
																<li><a href="DominioSubFamilia.jsp">SubFamília</a>
																</li>
																<li><a href="DominioGenero.jsp">Gênero</a>
																</li>
																<li><a href="DominioEspecie.jsp">Espécie</a>
																</li>
																<li><a href="DominioEpiteto.jsp">Epíteto
																		Esp.</a>
																</li>

															</ul>
														</div> <br><hr />
															<center>
																<h4>Cadastro de SubOrdens</h4>
															</center> <br> <! conteúdo principal >
																<form method=post name=manter1>
																	<div id="tab" align="center">
																		
																			<table>

																				<tr>
																					<input type=hidden name="nome_tabela" value="SubOrdem">
																						<TD>Ordens</TD>
																						<td><SELECT name="pai">
																								<%
																									Controle ctrl = new Controle();
																									ArrayList<Taxonomia> ordens = new ArrayList<Taxonomia>();
																									Taxonomia ordem = new Taxonomia();
																									ordem.setNomeTabela("Reino");
																									try {
																										ordens = ctrl.todosOsItens(ordem);
																										for (int i = 0; i < ordens.size(); i++) {
																								%>
																								<OPTION VALUE="<%=ordens.get(i).Id()%>"><%=ordens.get(i).getNome()%>
																								</OPTION>
																								<%
																									}
																									} catch (Exception e) {
																									}
																								%>
																						</SELECT>
																					</td>
																						<td></td>
																						<TD>SubOrdem</TD>
																						<TD><INPUT type=text name="nome">
																					</TD>
																						<td><input type=button onclick=Cadastrar()
																							value=Cadastrar></input>
																					</td>
																				</tr>
																			</table>
																		</form>

																		<br>
																			<table 
																				class="sofT" cellspacing="0">

																				<tr>
																					<td class="helpHed">Ordem</td>
																					<td class="helpHed">SubOrdem</td>
																					<td class="helpHed">Excluir</td>
																					<td class="helpHed">Alterar</td>

																				</tr>
																			</table>
																			<form method=post name=manter2>
																			<input type="hidden" name="nome_tabela" value="SubOrdem"/>
																				<div id="tabela">

																					<table 
																					class="sofT" cellspacing="0">


																					<%
																						ArrayList<Taxonomia> subordens = new ArrayList<Taxonomia>();
																						Taxonomia subordem = new Taxonomia();
																						subordem.setNomeTabela("SubOrdem");

																						try {
																							subordens = ctrl.todosOsItens(subordem);
																							for (int i = 0; i < subordens.size(); i++) {
																					%>


																					<tr>
																						<td>
																						<%Taxonomia r = new Taxonomia();
																						r.setNomeTabela("Ordem");
																						r.setId(subordens.get(i).getPai());
																						ordem = ctrl.buscarItem(r);
																						
																						%>
																						<%=ordem.getNome()%>
																						</td>
																						<td><%=subordens.get(i).getNome()%></td>
																						<td><a href="#" onclick="Excluir('<%=subordens.get(i).Id()%>')"><img src="excluir (1).gif" /></a>
																						</td>
																						<td><a href="#" onclick="Excluir('<%=subordens.get(i).Id()%>')"><img src="edit.gif" /></a>
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
