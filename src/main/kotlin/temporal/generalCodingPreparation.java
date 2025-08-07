package temporal;

import java.util.*;

public class generalCodingPreparation {
    /*
     * Where the event is defined as (Method + Endpoint + HttpStatusCode).
     * Order by Count, descending:
     * Method |             Endpoint | Code || Count
     * =============================================
     *  PUT   |   /users/#/locations | 204  ||  4
     * POST   |               /rides | 202  ||  3
     *  GET   |             /users/# | 200  ||  2
     * POST   |               /users | 202  ||  2
     *  PUT   |   /users/#/locations | 500  ||  1
     *  GET   |      /prices/#/geo/# | 200  ||  1
     *  PUT   |   /users/#/locations | 404  ||  1
     *  GET   |      /rides/#/status | 200  ||  1
     *  GET   |      /users/#/ride/# | 200  ||  1
     */
    public static String parseLogs(String[] logs) {
        var rawEvents = new ArrayList<Event>();
        for (String log : logs) {
            String[] split = log.split("]");
            String pureLog = split[1].trim();
            String[] sections = pureLog.split(" ");
            String method = sections[0];
            String endpoint = sections[1];
//            String version = sections[2];
            String httpStatusCode = sections[3];
//            String device = sections[4];
            rawEvents.add(new Event(method, endpoint, httpStatusCode));
        }
        Map<String, List<Event>> countMap = new HashMap<>();
        for (Event e : rawEvents) {
            var group = countMap.getOrDefault(e.eventKey, new ArrayList<>());
            group.add(e);
            countMap.put(e.eventKey, group);
        }
        List<List<Event>> sortedEventsList = countMap.values().stream().sorted((a, b) ->
            b.size() - a.size()
        ).toList();
        StringBuilder sb = new StringBuilder("Method\t\t|\t\tEndpoint\t|\tCode\t||\tCount");
        sb.append("\n============================================================");
        for (List<Event> events: sortedEventsList) {
            var event = events.get(0);
            sb.append(String.format("\n%s\t\t|\t\t%s\t|\t%s\t||\t%d", event.method, event.endpoint, event.httpStatusCode, events.size()));
        }
        return sb.toString();
    }

    static class Event {
        String method;
        String endpoint;
        String httpStatusCode;
        String eventKey;

        public Event(String method, String endpoint, String httpStatusCode) {
            this.method = method;
            this.httpStatusCode = httpStatusCode;
            String[] paths = endpoint.substring(1).split("/");
            StringBuilder sb = new StringBuilder();
            for (String path : paths) {
                sb.append("/");
                try {
                    Long.parseLong(path);
                    sb.append("#");
                } catch (NumberFormatException e) {
                    sb.append(path);
                }
            }
            this.endpoint = sb.toString();
            this.eventKey = method + this.endpoint + httpStatusCode;
        }
    }

    public static void main(String[] args) {
        var logs = new String[]{
                "[02/Nov/2018:21:46:31 +0000] PUT /users/12345/locations HTTP/1.1 204 iphone-3",
                "[02/Nov/2018:21:46:31 +0000] PUT /users/6098/locations HTTP/1.1 204 iphone-3",
                "[02/Nov/2018:21:46:32 +0000] PUT /users/3911/locations HTTP/1.1 204 moto-x",
                "[02/Nov/2018:21:46:33 +0000] PUT /users/9933/locations HTTP/1.1 404 moto-x",
                "[02/Nov/2018:21:46:33 +0000] PUT /users/3911/locations HTTP/1.1 500 moto-x",
                "[02/Nov/2018:21:46:34 +0000] GET /rides/9943222/status HTTP/1.1 200 moto-x",
                "[02/Nov/2018:21:46:34 +0000] POST /rides HTTP/1.1 202 iphone-2",
                "[02/Nov/2018:21:46:35 +0000] POST /users HTTP/1.1 202 iphone-5",
                "[02/Nov/2018:21:46:35 +0000] POST /rides HTTP/1.1 202 iphone-5",
                "[02/Nov/2018:21:46:37 +0000] POST /rides HTTP/1.1 202 iphone-4",
                "[02/Nov/2018:21:46:38 +0000] GET /users/994/ride/16 HTTP/1.1 200 iphone-5",
                "[02/Nov/2018:21:46:39 +0000] POST /users HTTP/1.1 202 iphone-3",
                "[02/Nov/2018:21:46:40 +0000] PUT /users/8384721/locations HTTP/1.1 204 iphone-3",
                "[02/Nov/2018:21:46:41 +0000] GET /users/342111 HTTP/1.1 200 iphone-5",
                "[02/Nov/2018:21:46:42 +0000] GET /users/9933 HTTP/1.1 200 iphone-5",
                "[02/Nov/2018:21:46:43 +0000] GET /prices/20180103/geo/12 HTTP/1.1 200 iphone-5"
        };
        System.out.println(parseLogs(logs));
    }
}
