package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println(bodyText);
        System.out.println("Players from FIN");

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

//        System.out.println("Oliot:");
        ArrayList<Player> playersList = new ArrayList<>();
        for (Player player : players) {
            if (player.isNationality("FIN")) {
                playersList.add(player);
            }
        }
        Collections.sort(playersList);
        playersList.forEach((player) -> {
            System.out.println(player);
        });
    }

}
