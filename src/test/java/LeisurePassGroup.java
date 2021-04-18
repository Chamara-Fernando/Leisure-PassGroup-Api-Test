import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LeisurePassGroup {

    RequestSpecification request = RestAssured.given().when();
    ResponseSpecification response = null;

    public static void main(String[] args) {

        LeisurePassGroup leisurePassGroup = new LeisurePassGroup();
        leisurePassGroup.getAllCities();
        leisurePassGroup.getAllAttractionsForACity();
        leisurePassGroup.attractionTypeMuseumOrderByDesc();
    }

    public void getAllCities() {
        //Get All Cities
        System.out.println("All Cities");
        Response response = request.get("https://my-json-server.typicode.com/leisurepassgroup/SDET-interview/citys");
        response.getBody().print();
        System.out.println(response.getStatusCode());
    }

    //Get all attractions for a city
    public void getAllAttractionsForACity() {
        System.out.println("Get attractions for New York");
        Response response = request
                .params("cityId", "1")
                .get("https://my-json-server.typicode.com/leisurepassgroup/SDET-interview/attractions");
        response.getBody().print();
        System.out.println(response.getStatusCode());

    }

    // Attraction type MUSEUM order by desc
    public void attractionTypeMuseumOrderByDesc() {
        System.out.println("Get attractions for New York where the attraction type is MUSEUM and order by rating descending");
        Response response = request
                .params("cityId", "1")
                .params("type", "MUSEUM")
                .params("_sort", "rating")
                .params("_order", "desc")
                .get("https://my-json-server.typicode.com/leisurepassgroup/SDET-interview/attractions");

        // https://my-json-server.typicode.com/leisurepassgroup/SDET-interview/attractions?cityId=1&type=MUSEUM&_sort=rating&_order=desc

        response.getBody().print();
        System.out.println(response.getStatusCode());
    }
}
