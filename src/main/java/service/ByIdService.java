package service;

import com.google.common.io.Resources;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ByIdService extends RequestSpec {

    public ByIdService() {
        super("https://api.spotify.com");
    }


    public Response CreatePlaylist(String userid,ResponseSpecification responseSpecification) throws IOException {
        URL file= Resources.getResource("Playlist.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject json = new JSONObject( myJson );

        return given()
                .spec(super.getRequestSpecification())
                .accept("application/json")
                .body(json.toString())
                .when()
                .post("/v1/users/{user_id}/playlists",userid)
                .then()
                .spec(responseSpecification)
                .extract().response();

    }




    public Response addItemstoPlaylist(String playlistId) throws IOException {
        URL file= Resources.getResource("AddItemtoPlaylist.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject json = new JSONObject( myJson );

        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .body(json.toString())
                .when()
                .post("/v1/playlists/{playlist_id}/tracks",playlistId)
                .then().extract().response();


    }


/////////
    public Response searchForItem(Map<String,Object> params)
    {
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .queryParams(params)
                .when()
                .get("/v1/search")
                .then().extract().response();

    }

    public Response getArtistsTopRanks(Map<String,Object> params,String id)
    {
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .queryParams(params)
                .when()
                .get("/v1/artists/{id}/top-tracks",id)
                .then().extract().response();
    }

    public Response deleteItemsFromPlaylist(String playlistid) throws IOException {
        URL file= Resources.getResource("DeleteItemFromPlaylist.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject json = new JSONObject( myJson );

        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .when()
                .delete("/v1/playlists/{playlist_id}/tracks")
                .then().extract().response();


    }


}
