package main.java.br.com.ana.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CARRO")
public class Carro {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro_seq")
    @SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "MODELO", length = 100, nullable = false)
    private String modelo;

    @Column(name = "TIPO", length = 20, nullable = false)
    private String tipo; //SUV, SEDAN, HAICH

    @Column(name = "COR", length = 50, nullable = false)
    private String cor;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "TB_CARRO_ACESSORIO",
        joinColumns = {@JoinColumn(name = "id_carro_fk")},
        inverseJoinColumns ={@JoinColumn(name = "id_acessorio_fk")}
    )
    private List<Acessorio> acessorios;

    @ManyToOne //só tem um objeto
    @JoinColumn(name = "id_marca_fk",
            foreignKey = @ForeignKey(name = "fk_marca_carro"),
            referencedColumnName = "id", nullable = false)
    private Marca marca;

    public Carro() {
        this.acessorios = new ArrayList<>();
    }

    public void addAcessorio(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
