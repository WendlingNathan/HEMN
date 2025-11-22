package br.com.hemn.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe principal da aplicação Spring Boot.
 *
 * <p>Esta classe inicializa o backend e também expõe um endpoint simples
 * de teste na rota raiz ("/"). Ela combina as anotações
 * {@link SpringBootApplication} e {@link RestController}, permitindo que a
 * aplicação seja executada e forneça respostas HTTP.</p>
 *
 * <p>O método {@code main} inicia a aplicação, enquanto o endpoint {@code index()}
 * retorna uma mensagem simples utilizada para verificar se o servidor está de pé.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@SpringBootApplication
@RestController
public class Application {

    /**
     * Ponto de entrada da aplicação.
     *
     * <p>Este método é chamado pela JVM e inicializa todo o Spring,
     * carregando os beans, configurações e inicializando o servidor.</p>
     *
     * @param args argumentos de linha de comando passados na inicialização
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Endpoint de teste acessível em {@code GET /}.
     *
     * <p>Este método é utilizado para verificar se o backend está funcionando
     * corretamente. Retorna uma mensagem simples em formato texto.</p>
     *
     * @return texto "Hello World!" indicando o funcionamento da API
     */
    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }
}
