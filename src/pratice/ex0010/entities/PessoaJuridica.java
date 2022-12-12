package pratice.ex0010.entities;

public class PessoaJuridica extends Person {
    private Integer numerosFuncionarios;

    public PessoaJuridica(){
        super();
    }

    public PessoaJuridica(String nome, Double rendaAnual, Integer numerosFuncionarios) {
        super(nome, rendaAnual);
        this.numerosFuncionarios = numerosFuncionarios;
    }

    public Integer getNumerosFuncionarios() {
        return numerosFuncionarios;
    }

    public void setNumerosFuncionarios(Integer numerosFuncionarios) {
        this.numerosFuncionarios = numerosFuncionarios;
    }

    @Override
    public double imposto() {
        if (numerosFuncionarios > 10){
            return getRendaAnual()*0.14;
        }else {
            return getRendaAnual()*0.16;
        }
    }
}
