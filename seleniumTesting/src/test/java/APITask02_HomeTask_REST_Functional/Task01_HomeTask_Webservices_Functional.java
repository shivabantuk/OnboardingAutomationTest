package APITask02_HomeTask_REST_Functional;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Task01_HomeTask_Webservices_Functional {

    final String endpoint = "http://www.dneonline.com/calculator.asmx";
    private String createSoapRequest(String method, int intA, int intB){
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "+ "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                +"<soap:Body>"
                +"<" +method+">"+intA+"+"+intB+"</"+method+">"
                +"</soap:Body>"
                +"</soap:Envelope>";

    }
    public void testMethod(String method, int intA, int intB){
        String request = createSoapRequest(method, intA, intB);
        Response response = RestAssured
                .given()
                .header("Content-Type", "text/xml; charset=utf-8")
                .header("SOAPAction", "http://tempuri.org/"+ method)
                .body(request)
                .post(endpoint);
        int responseCode = response.statusCode();
        System.out.println(responseCode);
    }


}
