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

        produtos.add(new Comidas(CategoriaProduto.SALGADOS,"Bauru da casa",10.0f,"Pão na chapa feito com presunto," +
                " queijo e tomate em rodelas","sachê de azeite", "1 UNIDADE MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.SALGADOS,"Coxinha com cheddar", 8.20f,"coxinha feita a base de aipim rechada " +
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
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Cenoura Trad",8.0f,"Bolo de Cenoura tradicional e delicioso com " +
                "cobertura de brigadeiro","nenhum","1 FATIA MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Honey Bliss[DA CASA]",12.0f,"Bolo de massa macia e levemente úmida de mel, com pedaços crocantes de nozes. Recheado e coberto com creme de " +
                "queijo suave e toque de baunilha. Finalizado com fio de mel e farofa crocante de nozes","nenhum","1 FATIA MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Berryache",18.0f,"Bolo de massa amanteigada de pistache,recheada com ganache branca cremosa e geleia artesanal de " +
                "frutas vermelhas. Finalizado com pistaches crocantes e frutas frescas.","nenhum","1 FATIA MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Velvet u9Salgado",14.0f,"Torta de caramelo salgado,chocolate meio amargo e amendoim tostado","nenhum","1 FATIA PEQUENA"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Cherry Luxe",15.0f,"Torta de base amanteigada crocante, recheio de creme pâtissier de baunilha bourbon " +
                "e uma camada generosa de cerejas frescas mergulhadas em glaçagem espelhada de cereja. " +
                "Um clássico francês com um toque contemporâneo, perfeito para acompanhar um café especial.","nenhum","1 FATIA MÉDIA"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Apple Dream",17.0f,"Torta de massa amanteigada crocante," +
                " recheio de creme de amêndoas delicado, fatias de maçã levemente caramelizadas e " +
                "finalizada com fios de caramelo artesanal e toque de canela. Uma torta que abraça, perfuma o ambiente e combina perfeitamente com café especial ou chá.",
                "nenhum","1 FATIA MEDIA"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Cookies Belga",10.0f," Cookie Clássico de Baunilha com Chocolate Belga e Flor de Sal","nenhum","1 UNIDADE GRANDE"));
        produtos.add(new Comidas(CategoriaProduto.DOCES, "Provence", 12.0f,"Cookie amanteigado, com toque cítrico e floral (limão e lavanda) — delicioso demais","nenhum","1 UNIDADE GRANDE"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Matcha Bliss", 15.0f,"Cookie de Matcha com Chocolate Branco hype asiático que todo mundo AMA","nenhum","1 UNIDADE GRANDE"));
        produtos.add(new Comidas(CategoriaProduto.DOCES,"Red Velvet Dream",11.50f,"O Cookie Red Velvet é crocante por fora e macio por dentro. Uma massa de tom vermelho Bordeaux (Red) que disfarça o sabor de " +
                "chocolate em um saboroso recheio de brigadeiro de Cream Cheese. Irresistível, não?","nenhum","1 UNIDADE GRANDE"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES,"Espresso",7.0f,"Café espresso feito na hora!","40ml","HOT"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES,"Cappuccino com Leite",9.0f,"Bebida italiana de café que combina café expresso, leite vaporizado e uma camada de espuma de leite","90ml","HOT"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES,"Cappuccino sem Leite",7.0f,"Capuccino identico a sua versão com Leite, porém substituido com água.","90ml","HOT"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES_GELADOS,"Caramel Latte",20.0f,"Um café puro e frio misturado com xarope de caramelo cremoso","240ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES,"Mocha Gourmet",22.0f,"A versão tradicional do mocha! É uma bebida quente, com café expresso, leite aquecido e chocolate.","250ml","HOT"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES,"Espresso Doppio",5.50f," Café espresso preparado com o dobro da quantidade de café e água," +
                " resultando em uma bebida com o dobro da intensidade e volume de um expresso simples.","40ml","HOT"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES,"Flat White",10.50f,"É uma bebida de café com um sabor intenso de café, com um toque suave e aveludado. É preparado com dois shots de expresso e leite vaporizado, " +
                "mas com menos espuma do que um cappuccino.","80ml","HOT"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES,"Macchiato",11.50f," Café expresso marcado com uma pequena quantidade de leite vaporizado," +
                " geralmente com um toque de espuma.","180ml","HOT"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES,"Americano",8.50f,"Café espresso diluído em água quente, criando uma bebida suave e menos intensa do que o espresso tradicional","80ml","HOT"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES_GELADOS,"Iced Latte",13.50f,"Uma bebida refrescante e cremosa, com café espresso, leite gelado e gelo. " +
                "Perfeita para os dias quentes ou para quem prefere um café mais suave.","300ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES_GELADOS,"Iced Mocha",16.50f,"Uma combinação refrescante de café, chocolate e leite, perfeita para um dia quente. " +
                "A bebida ideal para quem busca um sabor intenso e revigorante, com um toque de doçura. Ideal para qualquer momento do dia.","320ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES_GELADOS,"Iced Vanilla",18.50f," Deliciosa combinação de café expresso, leite vaporizado, xarope de baunilha e gelo.","380ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES_GELADOS,"Iced Caramel",20.0f,"Um café expresso com leite, calda de baunilha e uma generosa camada de calda de caramelo," +
                " servido sobre gelo para uma experiência refrescante e saborosa.","400ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES_GELADOS,"Matcha Latte Coconut Milk",22.50f," Uma bebida cremosa e energizante, feita com o chá verde matcha, misturado ao sabor tropical do leite de coco.","420ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.CAFES,"Cinnamon Coffee",16.0f,"Um delicioso café com a combinação perfeita do aroma aconchegante da canela e da cremosidade de um latte." +
                " Uma opção quente e suave para os amantes de sabores especiados","300ML","HOT"));
        produtos.add(new Bebidas(CategoriaProduto.BEBIDAS_FRIAS,"Suco de Morango",6.50f,"Suco de morango feito na hora com a polpa da fruta congelada para uma bebida deliciosa e refrescante!","250ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.BEBIDAS_FRIAS,"Suco de Laranja",5.50f,"Suco de laranja espremido na hora para uma bebida deliciosa e refrescante!","250ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.BEBIDAS_FRIAS,"Suco de Pêssego",7.0f,"Suco de pêssego feito na hora com a polpa da fruta congelada para uma bebida deliciosa e refrescante!","250ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.CHAS,"Chá mate de Limão",6.50f,"Bebida refrescante e saborosa que combina o sabor tradicional do chá mate com o toque cítrico e revigorante do limão","500ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.CHAS,"Chá mate de Pêssego",6.50f,"Bebida refrescante e saborosa, com um toque suave e doce do pêssego. É uma alternativa saudável e natural ao chá-mate tradicional, " +
                "com benefícios como a capacidade de aumentar a energia e melhorar a concentração.","500ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.DRINKS_NAO_ALCOOLICOS,"Soda Italiana: LIMÃO",12.50f," É uma bebida preparada com água gaseificada, xarope natural de limão siciliano e muiito gelo!","250ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.DRINKS_NAO_ALCOOLICOS,"Soda Italiana: MORANGO",13.50f,"É uma bebida preparada com água gaseificada, xarope natural de morango e muiito gelo!","250ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.DRINKS_NAO_ALCOOLICOS,"Soda Italiana: CRANBERRY",12.50f,"É uma bebida preparada com água gaseificada, xarope natural de cranberry e muiito gelo!","250ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.DRINKS_NAO_ALCOOLICOS,"Soda Italiana: PÊSSEGO",12.00f,"É uma bebida preparada com água gaseificada, xarope natural de pêssego e muiito gelo!","250ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.DRINKS_ALCOOLICOS,"Espresso Martini",37.0f," Uma explosão de sabor com café expresso, vodka e licor de café." +
                " Um drink gelado, cremoso e energizante, perfeito para qualquer ocasião.","100ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.DRINKS_ALCOOLICOS,"Irish Coffee",32.0f," Bebida alcoólica com cafeína, composta de uísque irlandês ," +
                " café quente e açúcar , misturada e coberta com creme.","100ml","SURPRESA"));
        produtos.add(new Bebidas(CategoriaProduto.DRINKS_ALCOOLICOS,"Soju de Yakult",29.90f,"Bebida alcoólica coreana muito popular, " +
                "trata-se de uma destilado suave similar ao saquê com gostinho do famoso YAKULT mas com uma graduação alcoólica superior.","360ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.DRINKS_ALCOOLICOS,"Soju Tradicional",29.90f,"Bebida alcoólica coreana muito popular, " +
                "trata-se de uma destilado suave similar ao saquê, mas com uma graduação alcoólica superior.","360ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.DRINKS_ALCOOLICOS,"Moscow Mule",31.0f,"Coquetel clássico e refrescante, geralmente preparado com vodka, suco de limão e ginger beer ou ginger ale.","90ml","ICED"));

        produtos.add(new Bebidas(CategoriaProduto.BEBIDAS_FRIAS,"Água Mineral sem gás",4.0f,"--","520ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.BEBIDAS_FRIAS,"Água Mineral com gás",5.0f,"--","520ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.BEBIDAS_FRIAS,"Coca-Cola",5.0f,"--","300ml","ICED"));
        produtos.add(new Bebidas(CategoriaProduto.BEBIDAS_FRIAS,"Sprite",5.50f,"--","300ml","ICED"));
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}

