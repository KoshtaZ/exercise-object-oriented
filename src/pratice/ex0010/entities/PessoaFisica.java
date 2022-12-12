package pratice.ex0010.entities;

public class PessoaFisica extends Person{
    private Double gastoSaude;

    public PessoaFisica(){
        super();
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
        super(nome, rendaAnual);
        this.gastoSaude = gastoSaude;
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public double imposto() {
        if (getRendaAnual()<2000.0){
            return getRendaAnual()*0.15 - gastoSaude*0.5;

        }else {
            return getRendaAnual()*0.25 - gastoSaude*0.5;
        }
    }
}
