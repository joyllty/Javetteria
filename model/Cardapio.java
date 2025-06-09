package model;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private List<Produto> produtos;

    public Cardapio(){
        this.produtos = new ArrayList<>();
        cadastrarProdutos();
    }
public void cadastrarProdutos(){
        produtos.add(new Comidas(CategoriaProduto.SALGADOS,"Pão de Queijo", 10.0f,
                "pãozinho assado, feito à base de polvilho azedo e queijo",
                "nenhum","1 UNIDADE GRANDE"));
        produtos.add(new Comidas(CategoriaProduto.SALGADOS,"Empadão de Frango",12.50f,
                "Crocante por fora e molhadinho por dentro, este empadão de frango leva cebola, " +
                        "requeijão, milho verde, tomate, cheiro-verde e azeitonas no recheio.",
                "maionese extra","1 FATIA GRANDE"));
        produtos.add(new Comidas(CategoriaProduto.SALGADOS,"Folhado 4 Queijos",9.50f,"folhado quentinho e macio com recheio" +
                " de queijo mussarela, parmesão, provolone e gorgonzola.", "nenhum","1 UNIDADE MÉDIA"));

        produtos.add(new Comidas(CategoriaProduto.SALGADOS,"Bauru da casa",8.20f,"Pão na chapa feito com presunto," +
                " queijo e tomate em rodelas","sachê de azeite", "1 UNIDADE MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.SALGADOS,"Coxinha de cheddar", 10.0f,"coxinha feita a base de aipim rechada " +
                "com frango e catupiry", "Ketchup e Maionese","1 UNIDADE GRANDE"));
        produtos.add(new Comidas(CategoriaProduto.SALGADOS,"Empadão de Palmito[VEG]",11.50f,"Feito com uma massa crocante e recheado com palmito" +
                " picado, cebola, alho e temperos a gosto","Ketchup e Maionese","1 FATIA MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.SALGADOS,"Corn Dog", 12.50f,"De massa leve e crocante envolvendo salsichas e queijo derretido, " +
                "esse lanche é uma verdadeira explosão de sabores.","Ketchup,Maionese e Mostarda", "1 UNIDADE GRANDE"));
        produtos.add(new Comidas(CategoriaProduto.SALGADOS,"Croissant de 4 Queijos", 10.50f,"recheado com uma mistura de 4 queijos, como muçarela, provolone, parmesão e gorgonzola, " +
                "que derretem durante o cozimento, criando uma experiência de sabor única","maionese extra","1 UNIDADE MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.FRIOS,"Green Wrap",15.0f,"Deliciosa Wrap rechada com frango fatiado, mostarda," +
                "molho de alho, maionese, alface americana e tomate","molhos especiais","1 UNIDADE GRANDE"));
        produtos.add(new Comidas(CategoriaProduto.SALGADOS,"Quiche de Azeitona", 10.50f,"orta salgada de origem francesa, com uma massa folhada recheada " +
                "com um creme de ovos e leite ou creme de leite, pedaços de azeitona também","Ketchup/Maionese/Mostarda","1 FATIA MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.FRIOS,"Wrap Veggie", 15.90f,"Feito com patê de azeitonas, cenoura, alface americana, " +
                "tomate e castanhas de caju","molhos especiais","1 UNIDADE GRANDE" ));
        produtos.add(new Comidas(CategoriaProduto.FRIOS,"Caesar Salad", 20.0f,"uma salada preparada com alface-romana, frango picado e molho Caesar. " +
                    "Os temperos usados mais habitualmente " +
                    "para compor este molho são azeite de oliva, suco de limão, anchovas, queijo parmesão, " +
                    "molho inglês, sal, açúcar e pimenta-preta","nenhum","1 BOWL GRANDE"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Dark Choco",12.50f,"Delicioso Brownie feito com chocolate meio amargo 70% cacau com notas de canela",
                    "1 bola grande de gelato sabor creme","1 UNIDADE MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Choco Milk", 10.50f,"Delicioso Brownie feito com chocolate e creme de avelã","nenhum",
                "1 UNIDADE MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.DOCES, "Brownie Trad", 10.0f, "Delicioso Brownie feito de massa de baunilha com " +
                "gotas de chocolate","calda de avelã","1 UNIDADE PEQUENA"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"CHOCOcake", 7.0f," leva chocolate derretido ou em pó, " +
                "ou ainda cacau em pó em sua confecção","nenhum","1 UNIDADE MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Lemon Bomb",8.0f,"Bolo de limão com cobertura de chocolate " +
                "branco e licor de limão","nenhum","1 UNIDADE MÉDIA"));
}
    public List<Produto> getProdutos() {
        return produtos;
    }

}

