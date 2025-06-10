import controller.TestController;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Testes do Sistema de Pedidos ===");

        TestController testController = new TestController();
        testController.executarTodosTestes();

        System.out.println("\n=== Testes Concluídos ===");
    }
}