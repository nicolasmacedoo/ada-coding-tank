import java.util.Scanner;

public class CalculoSalario {
    public static void main(String[] args) {
        double[] salarios = pegarSalarios();

        exibirSalarios(salarios);
    }

    private static double calcularINSS(double salario) {
        if (salario <= 1212.00) {
            return salario * 0.075;
        } else if (salario <= 2427.35 ) {
            return salario * 0.09;
        } else if (salario <= 3641.03 ) {
            return salario * 0.12;
        } else {
            return salario * 0.14;
        }
    }

    private static double calcularImpostoRenda(double salario) {
        if (salario <= 1903.98) {
            return 0;
        } else if (salario <= 2826.65 ) {
            return salario * 0.075;
        } else if (salario <= 3751.05) {
            return salario * 0.15;
        } else if (salario <= 4664.68) {
            return salario * 0.225;
        } else {
            return salario * 0.275;
        }
    }

    private static void exibirSalarios(double[] salariosBrutos) {
        for (double salariosBruto : salariosBrutos) {
            System.out.println("#########################");
            System.out.printf("Salario Bruto: R$ %.2f %n", salariosBruto);
            double valorINSS = calcularINSS(salariosBruto);
            System.out.printf("Valor de INSS: R$ %.2f %n", valorINSS);
            double impostoRenda = calcularImpostoRenda(salariosBruto);
            System.out.printf("Valor de Imposto Renda: R$ %.2f %n", impostoRenda);
            double salarioLiquido = salariosBruto - valorINSS - impostoRenda;
            System.out.printf("Salario Liquido: R$ %.2f %n", salarioLiquido);
        }
    }

    private static double[] pegarSalarios() {
        Scanner sc = new Scanner(System.in);
        double[] salarios = new double[5];

        for (int i = 0; i < salarios.length; i++) {
            System.out.printf("Digite o %d° salário: ", i + 1);
            salarios[i] = sc.nextDouble();
        }

        sc.close();

        return salarios;
    }
}
