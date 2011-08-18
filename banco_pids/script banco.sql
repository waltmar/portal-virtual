CREATE TABLE aplicacao_economica (
  id_aplicacao_economica INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_aplicacao_economica)
);

CREATE TABLE classe (
  id_classe INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  filo_id_filo INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NOT NULL,
  PRIMARY KEY(id_classe),
  INDEX Classe_FKIndex1(filo_id_filo)
);

CREATE TABLE coleta (
  id_coleta INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  estagio_desenvolvimento_id_estagio_desenvolvimento INTEGER UNSIGNED NOT NULL,
  determinador_id_determinador INTEGER UNSIGNED NOT NULL,
  metodo_id_metodo INTEGER UNSIGNED NOT NULL,
  aplicacao_economica_id_aplicacao_economica INTEGER UNSIGNED NOT NULL,
  coletor_id_coletor INTEGER UNSIGNED NOT NULL,
  tipo_montagem_id_tipo_montagem INTEGER UNSIGNED NOT NULL,
  material_tipo_id_material_tipo INTEGER UNSIGNED NOT NULL,
  fenologia_id_fenologia INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(id_coleta),
  INDEX coleta_FKIndex1(fenologia_id_fenologia),
  INDEX coleta_FKIndex2(material_tipo_id_material_tipo),
  INDEX coleta_FKIndex3(tipo_montagem_id_tipo_montagem),
  INDEX coleta_FKIndex4(coletor_id_coletor),
  INDEX coleta_FKIndex5(aplicacao_economica_id_aplicacao_economica),
  INDEX coleta_FKIndex7(metodo_id_metodo),
  INDEX coleta_FKIndex8(determinador_id_determinador),
  INDEX coleta_FKIndex9(estagio_desenvolvimento_id_estagio_desenvolvimento)
);

CREATE TABLE coletor (
  id_coletor INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_coletor)
);

CREATE TABLE datum (
  id_datum INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome INTEGER UNSIGNED NULL,
  PRIMARY KEY(id_datum)
);

CREATE TABLE determinador (
  id_determinador INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_determinador)
);

CREATE TABLE epiteto_especifico (
  id_epiteto_especifico INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  especie_id_especie INTEGER UNSIGNED NOT NULL,
  nome INTEGER UNSIGNED NULL,
  PRIMARY KEY(id_epiteto_especifico),
  INDEX epiteto_especifico_FKIndex1(especie_id_especie)
);

CREATE TABLE especie (
  id_especie INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  genero_id_genero INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_especie),
  INDEX especie_FKIndex1(genero_id_genero)
);

CREATE TABLE especime (
  id_especime INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  geografia_id_geografia INTEGER UNSIGNED NOT NULL,
  coleta_id_coleta INTEGER UNSIGNED NOT NULL,
  taxonomia_id_taxonomia INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(id_especime),
  INDEX especime_FKIndex1(taxonomia_id_taxonomia),
  INDEX especime_FKIndex2(coleta_id_coleta),
  INDEX especime_FKIndex3(geografia_id_geografia)
);

CREATE TABLE estado (
  id_estado INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pais_id_pais INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_estado),
  INDEX estado_FKIndex1(pais_id_pais)
);

CREATE TABLE estagio_desenvolvimento (
  id_estagio_desenvolvimento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_estagio_desenvolvimento)
);

CREATE TABLE familia (
  id_familia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  ordem_id_ordem INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_familia),
  INDEX Familia_FKIndex1(ordem_id_ordem)
);

CREATE TABLE fenologia (
  id_fenologia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_fenologia)
);

CREATE TABLE filo (
  id_filo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  reino_id_reino INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NOT NULL,
  PRIMARY KEY(id_filo),
  INDEX Filo_FKIndex1(reino_id_reino)
);

CREATE TABLE genero (
  id_genero INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  familia_id_familia INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_genero),
  INDEX genero_FKIndex1(familia_id_familia)
);

CREATE TABLE geografia (
  id_geografia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  datum_id_datum INTEGER UNSIGNED NOT NULL,
  localidade_id_localidade INTEGER UNSIGNED NOT NULL,
  municipio_id_municipio INTEGER UNSIGNED NOT NULL,
  estado_id_estado INTEGER UNSIGNED NOT NULL,
  massa_dagua_id_massa_dagua INTEGER UNSIGNED NOT NULL,
  pais_id_pais INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(id_geografia),
  INDEX geografia_FKIndex1(pais_id_pais),
  INDEX geografia_FKIndex2(massa_dagua_id_massa_dagua),
  INDEX geografia_FKIndex3(estado_id_estado),
  INDEX geografia_FKIndex4(municipio_id_municipio),
  INDEX geografia_FKIndex5(localidade_id_localidade),
  INDEX geografia_FKIndex6(datum_id_datum)
);

CREATE TABLE localidade (
  id_localidade INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  municipio_id_municipio INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_localidade),
  INDEX localidade_FKIndex1(municipio_id_municipio)
);

CREATE TABLE massa_dagua (
  id_massa_dagua INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome INTEGER UNSIGNED NULL,
  PRIMARY KEY(id_massa_dagua)
);

CREATE TABLE material_tipo (
  id_material_tipo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome INTEGER UNSIGNED NULL,
  PRIMARY KEY(id_material_tipo)
);

CREATE TABLE metodo (
  id_metodo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_metodo)
);

CREATE TABLE municipio (
  id_municipio INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  estado_id_estado INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_municipio),
  INDEX municipio_FKIndex1(estado_id_estado)
);

CREATE TABLE ordem (
  id_ordem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  classe_id_classe INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NOT NULL,
  PRIMARY KEY(id_ordem),
  INDEX Ordem_FKIndex1(classe_id_classe)
);

CREATE TABLE pais (
  id_pais INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_pais)
);

CREATE TABLE reino (
  id_reino INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  PRIMARY KEY(id_reino)
);

CREATE TABLE sub_familia (
  id_sub_familia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  familia_id_familia INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_sub_familia),
  INDEX SubFamilia_FKIndex1(familia_id_familia)
);

CREATE TABLE sub_genero (
  id_sub_genero INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  genero_id_genero INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_sub_genero),
  INDEX sub_genero_FKIndex1(genero_id_genero)
);

CREATE TABLE sub_ordem (
  id_sub_ordem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  ordem_id_ordem INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_sub_ordem),
  INDEX SubOrdem_FKIndex1(ordem_id_ordem)
);

CREATE TABLE taxonomia (
  id_taxonomia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  sub_genero_id_sub_genero INTEGER UNSIGNED NOT NULL,
  epiteto_especifico_id_epiteto_especifico INTEGER UNSIGNED NOT NULL,
  especie_id_especie INTEGER UNSIGNED NOT NULL,
  genero_id_genero INTEGER UNSIGNED NOT NULL,
  sub_familia_id_sub_familia INTEGER UNSIGNED NOT NULL,
  familia_id_familia INTEGER UNSIGNED NOT NULL,
  sub_ordem_id_sub_ordem INTEGER UNSIGNED NOT NULL,
  ordem_id_ordem INTEGER UNSIGNED NOT NULL,
  classe_id_classe INTEGER UNSIGNED NOT NULL,
  filo_id_filo INTEGER UNSIGNED NOT NULL,
  reino_id_reino INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(id_taxonomia),
  INDEX taxonomia_FKIndex1(reino_id_reino),
  INDEX taxonomia_FKIndex2(filo_id_filo),
  INDEX taxonomia_FKIndex3(classe_id_classe),
  INDEX taxonomia_FKIndex4(ordem_id_ordem),
  INDEX taxonomia_FKIndex5(sub_ordem_id_sub_ordem),
  INDEX taxonomia_FKIndex6(familia_id_familia),
  INDEX taxonomia_FKIndex7(sub_familia_id_sub_familia),
  INDEX taxonomia_FKIndex8(genero_id_genero),
  INDEX taxonomia_FKIndex9(especie_id_especie),
  INDEX taxonomia_FKIndex10(epiteto_especifico_id_epiteto_especifico),
  INDEX taxonomia_FKIndex11(sub_genero_id_sub_genero)
);

CREATE TABLE tipo_montagem (
  id_tipo_montagem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  PRIMARY KEY(id_tipo_montagem)
);


