package projeto.Api.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post {
	@Test
	public void statusCodecadastro() {
		RequestSpecification request = RestAssured.given().auth().preemptive().basic("inmetrics", "automacao");
		request.header("Content-Type", "applicatino/json");
		JSONObject json = new JSONObject();
		json.put("admissao", "01/10/2010");
		json.put("cargo", "especialista de teste");
		json.put("comissao", "12.000,00");
		json.put("cpf", "228.585.898-10");
		json.put("departamento", "desenvolvimento");
		json.put("nome", "marcelo santos");
		json.put("salario", "30.000,00");
		json.put("sexo", "MAS");
		json.put("tipoContratacao", "CLT");
		request.body(json.toJSONString());
		Response response = request.post("https://inm-test-api.herokuapp.com/empregado/cadastrar");
		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
	}

	@Test
	public void validaBody() {
		RequestSpecification request = RestAssured.given().auth().preemptive().basic("inmetrics", "automacao");
		request.header("Content-Type", "applicatino/json");
		Response response = request.get("https://inm-test-api.herokuapp.com/empregado/list/1071");
		String bodyResponse = response.asString();
		System.out.println(bodyResponse);
		String name = "Teste automatizado";
		assertTrue(bodyResponse.contains(name));
	}

}