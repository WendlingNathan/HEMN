package br.com.hemn.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Ingrediente;
import br.com.hemn.backend.repository.IngredienteRepository;

/**
 * Serviço responsável pela lógica de negócio da entidade {@link Ingrediente}.
 *
 * <p>Centraliza operações de CRUD e consultas específicas realizadas pelos controllers.</p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    /**
     * Lista todos os ingredientes cadastrados.
     *
     * @return lista de ingredientes
     */
    public List<Ingrediente> listarTodos() {
        return ingredienteRepository.findAll();
    }

    /**
     * Busca um ingrediente pelo ID.
     *
     * @param id identificador do ingrediente
     * @return ingrediente encontrado
     * @throws RuntimeException caso o ingrediente não exista
     */
    public Ingrediente buscarPorId(Long id) {
        return ingredienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado: ID " + id));
    }

    /**
     * Salva ou atualiza um ingrediente.
     *
     * @param ingrediente objeto a ser salvo
     * @return ingrediente persistido
     */
    public Ingrediente salvar(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    /**
     * Exclui um ingrediente pelo ID.
     *
     * @param id identificador do ingrediente
     */
    public void deletar(Long id) {
        ingredienteRepository.deleteById(id);
    }
}
