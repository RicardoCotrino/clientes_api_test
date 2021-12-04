import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class ClientsTest {

        @BeforeAll
        static void setup(){
            RestAssured.baseURI = "http://localhost:8080";
            RestAssured.basePath = "/clients";
        }

       @Test
                    void testListaClientes_TodosClientesSaoListados() {
        RestAssured.given()//Dado - Given
                .log().all()  // loga toda a request - solicitação (entrada) - mostra o cabeçalho da solicitação
                .when() //Quando - When
                .get() // Faz a solicitação em si, método/verbo GET passando como parametro a ur/uri
                .then() //Então
                .log().all()// loga toda a response
                .statusCode(200); // verifica se o resultado da request é HTTP 200 OK
           }

           @Test
           void testListaUnicoCliente_ClienteEhListadoComTodasAsInformacoes() {

            int id = 4;
               RestAssured.given()//Dado - Given
                       .log().all()  // loga toda a request - solicitação (entrada) - mostra o cabeçalho da solicitação
                       .when() //Quando - When - Request
                       .get("/"+id) // Faz a solicitação em si, método/verbo GET passando como parametro a ur/uri
                       .then() //Então - REsponse
                       .log().all()// loga toda a response
                       .statusCode(200) // verifica se o resultado da request é HTTP 200 OK
                       .body("id",is(id));

           }
    }


