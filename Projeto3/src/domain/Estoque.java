package domain;

import anotacao.ColunaTabela;
import anotacao.Tabela;
import anotacao.TipoChave;
import dao.Persistente;

import java.math.BigDecimal;

@Tabela("tb_estoque")
public class Estoque implements Persistente {
    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    //FK - id_produto_fk
    private Produto produto;

    @ColunaTabela(dbName = "qtd_original",setJavaName = "setQuantidadeOriginal")
    private Integer quantidadeOriginal;

    @ColunaTabela(dbName = "qtd_em_estoque",setJavaName = "setQuatidadeEmEstoque")
    private Integer quatidadeEmEstoque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidadeOriginal() {
        return quantidadeOriginal;
    }

    public void setQuantidadeOriginal(Integer quantidadeOriginal) {
        this.quantidadeOriginal = quantidadeOriginal;
    }

    public Integer getQuatidadeEmEstoque() {
        return quatidadeEmEstoque;
    }

    public void setQuatidadeEmEstoque(Integer quatidadeEmEstoque) {
        this.quatidadeEmEstoque = quatidadeEmEstoque;
    }

    public void adicionar(Integer quantidade) {
        quatidadeEmEstoque -= quantidade;
    }

    public void remover(Integer quantidade) {
        this.quatidadeEmEstoque += quantidade;
    }

}
