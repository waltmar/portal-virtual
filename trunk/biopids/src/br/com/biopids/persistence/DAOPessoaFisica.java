package br.com.biopids.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import br.com.biopids.domain.PessoaFisica;

@Repository("daoPessoaFisica")
public class DAOPessoaFisica extends GenericDAO<PessoaFisica, Long>{

	public List<PessoaFisica> getAll(PessoaFisica entity){
		HQL<PessoaFisica> hql = new HQL<PessoaFisica>(PessoaFisica.class);
		hql.fields("p.codigo", "p.nome", "p.cpf", "ender.endereco", "ender.complemento", "ender.numero", "ender.bairro");
		hql.froms("PessoaFisica as p", "p.endereco as ender");
		hql.orders("p.nome");
		String sql = hql.build();
		List<PessoaFisica> list = null;
		try{
			list = hql.load(executeQuery(sql));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
