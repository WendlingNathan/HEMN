package br.com.hemn.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Funcionario;
import br.com.hemn.backend.repository.FuncionarioRepository;

/**
 * Serviço responsável pela lógica de negócio da entidade {@link Funcionario}.
 *
 * <p>Fornece operações de CRUD e consultas específicas,
 * servindo de intermediário entre controllers e repositórios.</p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    /**
     * Retorna todos os funcionários cadastrados.
     *
     * @return lista de funcionários
     */
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    /**
     * Busca um funcionário pelo ID.
     *
     * @param id identificador do funcionário
     * @return funcionário encontrado
     */
    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    /**
     * Salva ou atualiza um funcionário.
     *
     * @param funcionario objeto a ser salvo
     * @return funcionário persistido
     */
    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    /**
     * Exclui um funcionário pelo ID.
     *
     * @param id identificador do funcionário
     */
    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
