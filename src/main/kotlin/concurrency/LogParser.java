package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogParser {

    Pattern pattern = Pattern.compile(
            "\\[(.+?)\\] (\\w+) ([^ ]+) HTTP/[\\d.]+ (\\d{3}) (.+)"
    );

    String analyzeLogs(String[] logs) {
        if (logs == null || logs.length < 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder(
                "Method |             Endpoint | Code || Count\n" +
                        "=============================================\n"
        );
        var sorted = Arrays.stream(logs)
                .map(pattern::matcher)
                .filter(Matcher::find)
                .map(m -> new Log(
                        m.group(2),
                        m.group(3).replaceAll("\\d+", "#"),
                        m.group(4)
                ))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    var countComp = b.getValue().compareTo(a.getValue());
                    if (countComp != 0) {
                        return countComp;
                    }
                    var log1 = a.getKey();
                    var log2 = b.getKey();

                    var methodComp = log1.method.compareTo(log2.method);
                    if (methodComp != 0) {
                        return methodComp;
                    }

                    var endpointComp = log1.endpoint.compareTo(log2.endpoint);
                    if (endpointComp != 0) {
                        return endpointComp;
                    }

                    return log1.status.compareTo(log2.status);
                })
                .map(entry -> {
                    Log log = entry.getKey();
                    return String.format("%6s | %20s | %4s || %2d",
                            log.method,      // 6자리, 오른쪽 정렬
                            log.endpoint,    // 20자리, 오른쪽 정렬
                            log.status,      // 4자리, 오른쪽 정렬
                            entry.getValue() // 2자리, 오른쪽 정렬
                    );
                })
                .collect(Collectors.joining("\n"));
        sb.append(sorted);
        return sb.toString();
    }

    record Log(String method, String endpoint, String status) {
    }

    public static void main(String[] args) {
        var s = new LogParser();
        var logs = new String[]{
                "[02/Nov/2018:21:46:31 +0000] PUT /users/12345/locations HTTP/1.1 204 iphone-3",
                "[02/Nov/2018:21:46:31 +0000] PUT /users/6098/locations HTTP/1.1 204 iphone-3",
                "[02/Nov/2018:21:46:32 +0000] PUT /users/3911/locations HTTP/1.1 204 moto-x",
                "[02/Nov/2018:21:46:33 +0000] PUT /users/9933/locations HTTP/1.1 404 moto-x",
                "[02/Nov/2018:21:46:33 +0000] PUT /users/3911/locations HTTP/1.1 500 moto-x",
                "[02/Nov/2018:21:46:34 +0000] GET /rides/9943222/status HTTP/1.1 200 moto-x",
                "[02/Nov/2018:21:46:34 +0000] POST /rides HTTP/1.1 202 iphone-2",
                "[02/Nov/2018:21:46:35 +0000] POST /users HTTP/1.1 202 iphone-5",
        };

        System.out.println(s.analyzeLogs(logs));
    }
}
