
package com.mycompany.upx2;
public class UPX2 {

    public static void main(String[] args) {
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();

        // Criando um profissional
        Profissional profissional = new Profissional(
            "João Santos",
            "12345678900",
            "1234567",
            "Enfermeiro",
            "(21) 98765-4321",
            "joao.santos@email.com"
        );

        // Salvando no banco de dados
        profissionalDAO.inserirProfissional(profissional);

        // Recuperando o profissional pelo ID
        Profissional encontrado = profissionalDAO.buscarPorId(1);
        if (encontrado != null) {
            System.out.println("Profissional encontrado: " + encontrado.getNome());
        } else {
            System.out.println("Profissional não encontrado.");
        }
        System.out.println();
        
    }
}
