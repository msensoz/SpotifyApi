package spec;

import io.restassured.response.Response;
import model.GetResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.BaseServiceTest;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertNotNull;

public class SpotifyApiTest extends BaseServiceTest {



    public String shouldSearchForItem()
    {
        Map<String, Object> map =requestMaps.getSearchItemMap();

        Response response=byIdService.searchForItem(map);

        String id=response.getBody().jsonPath().getString("id");
        assertNotNull(id);
        Assert.assertEquals(response.statusCode(),200);

        return id;
    }

    public void shouldGetArtistsTopRanks(String id)
    {
        Map<String, Object> map =requestMaps.getArtistsTopRanksMap();

        Response response=byIdService.getArtistsTopRanks(map,id);
        Assert.assertEquals(response.statusCode(),200);
    }

    public String shouldCreatePlaylist() throws IOException {


        Response response=byIdService.CreatePlaylist("nimueh123",ResponseSpec.checkStatusCreated());

        String playlistid=response.getBody().jsonPath().getString("id");
        assertNotNull(playlistid);
        return playlistid;

    }

    public void shouldAddItemstoPlaylist(String playlistId) throws IOException {
        Response response=byIdService.addItemstoPlaylist(playlistId);
        Assert.assertEquals(response.statusCode(),201);

    }

    public void shouldDeleteItemsFromPlaylist(String playlistid) throws IOException {
        Response response=byIdService.deleteItemsFromPlaylist(playlistid);
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test
    public void ApiJourney() throws IOException {
        String id=shouldSearchForItem();
        shouldGetArtistsTopRanks(id);
        String playlistId=shouldCreatePlaylist();
        shouldAddItemstoPlaylist(playlistId);
        shouldDeleteItemsFromPlaylist(playlistId);

    }

}
