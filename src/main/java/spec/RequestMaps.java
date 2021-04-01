package spec;

import java.util.HashMap;
import java.util.Map;

public class RequestMaps {



    public Map<String, Object> getSearchItemMap()
    {
        Map<String, Object> params = new HashMap<>();
        params.put("q", "Pink Floyd");
        params.put("type","artist");
        return params;
    }
    public Map<String, Object> getArtistsTopRanksMap()
    {
        Map<String, Object> params = new HashMap<>();
        params.put("market", "ES");
        return params;
    }

}
