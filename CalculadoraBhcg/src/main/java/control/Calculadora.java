package control;

public class Calculadora {

    public String interpretarBhcg(double hcg, int dum) {
        int semanas = dum / 7;

        if (hcg < 25) {
            if (dum < 28) {
                return "Resultado negativo. Pode ser falso negativo nesta fase precoce (<4 sem). Repetir exame em 1 semana";
            } else {
                return "Resultado negativo";
            }
        }

        if (semanas < 3 || semanas > 16) {
            return "Fora do intervalo de 3–16 semanas de gestação.";
        }

        // 
        double minimo, maximo;

        if (semanas == 3) {
            minimo = 5;
            maximo = 50;
        } else if (semanas == 4) {
            minimo = 10;
            maximo = 750;
        } else if (semanas == 5) {
            minimo = 200;
            maximo = 7100;
        } else if (semanas == 6) {
            minimo = 160;
            maximo = 32000;
        } else if (semanas == 7){
            minimo = 3700;
            maximo = 160000;
        } else if (semanas == 8){
            minimo = 32000;
            maximo = 210000;
        }else if (semanas == 9){
            minimo = 64000;
            maximo = 210000;
        }else if (semanas == 10){
            minimo = 47000;
            maximo = 220000;
        }else if (semanas == 11){
            minimo = 30000;
            maximo = 210000;
        }else if (semanas == 12){
            minimo = 27000;
            maximo = 190000;
        }else if (semanas == 13){
            minimo = 14000;
            maximo = 180000;
        }else if (semanas == 14){
            minimo = 11000;
            maximo = 57000;
        }else if (semanas == 15) {
            minimo = 9000;
            maximo = 56000;
        } else {
            minimo = 8000;
            maximo = 40000;
        }


        if (hcg >= minimo && hcg <= maximo) {
            return "Resultado positivo compatível com a idade gestacional";
        } else if (hcg < minimo) {
            return "Resultado positivo abaixo do esperado";
        } else {
            return "Resultado positivo acima do esperado";
        }
    }
}