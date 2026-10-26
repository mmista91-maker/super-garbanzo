
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RestApi {

    private final Map<String, User> users = new HashMap<>();

    RestApi(User... initialUsers) {
        for (User user : initialUsers) {
            users.put(user.name(), user);
        }
    }

    String get(String url) {
        return get(url, null);
    }

    String get(String url, JSONObject payload) {
        if (!url.equals("/users")) {
            throw new IllegalArgumentException("Unknown URL: " + url);
        }

        List<String> names = new ArrayList<>();

        if (payload == null || !payload.has("users")) {
            names.addAll(users.keySet());
        } else {
            JSONArray requested = payload.getJSONArray("users");

            for (int i = 0; i < requested.length(); i++) {
                names.add(requested.getString(i));
            }
        }

        return usersResponse(names);
    }

    String post(String url, JSONObject payload) {

        switch (url) {

            case "/add" -> {
                String name = payload.getString("user");

                User user = User.builder()
                        .setName(name)
                        .build();

                users.put(name, user);

                return userToJson(user).toString();
            }

            case "/iou" -> {
                String lenderName = payload.getString("lender");
                String borrowerName = payload.getString("borrower");
                double amount = payload.getDouble("amount");

                User lender = users.get(lenderName);
                User borrower = users.get(borrowerName);

                // Obliczamy dotychczasowy bilans
                // pomiędzy tymi dwiema osobami.
                double net = amount;

                for (Iou iou : lender.owedBy()) {
                    if (iou.name.equals(borrowerName)) {
                        net += iou.amount;
                    }
                }

                for (Iou iou : lender.owes()) {
                    if (iou.name.equals(borrowerName)) {
                        net -= iou.amount;
                    }
                }

                // Tworzymy nowe obiekty User,
                // ponieważ istniejących nie modyfikujemy.
                User updatedLender =
                        updateDebt(lender, borrowerName, net);

                User updatedBorrower =
                        updateDebt(borrower, lenderName, -net);

                users.put(lenderName, updatedLender);
                users.put(borrowerName, updatedBorrower);

                return usersResponse(
                        List.of(lenderName, borrowerName)
                );
            }

            default -> throw new IllegalArgumentException(
                    "Unknown URL: " + url
            );
        }
    }

    // Tworzy JSON reprezentujący jednego użytkownika.
    private JSONObject userToJson(User user) {

        JSONObject owes = new JSONObject();
        JSONObject owedBy = new JSONObject();

        double balance = 0;

        for (Iou iou : user.owes()) {
            owes.put(iou.name, iou.amount);
            balance -= iou.amount;
        }

        for (Iou iou : user.owedBy()) {
            owedBy.put(iou.name, iou.amount);
            balance += iou.amount;
        }

        return new JSONObject()
                .put("name", user.name())
                .put("owes", owes)
                .put("owedBy", owedBy)
                .put("balance", balance);
    }

    // Buduje odpowiedź z wybranymi użytkownikami.
    private String usersResponse(List<String> names) {

        List<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);

        JSONArray userArray = new JSONArray();

        for (String name : sortedNames) {
            User user = users.get(name);
            userArray.put(userToJson(user));
        }

        return new JSONObject()
                .put("users", userArray)
                .toString();
    }

    // Zastępuje dług pomiędzy użytkownikiem
    // a wskazaną osobą nowym bilansem netto.
    private User updateDebt(
            User user,
            String otherName,
            double net
    ) {

        User.Builder builder = User.builder()
                .setName(user.name());

        // Zachowujemy długi wobec innych osób.
        for (Iou iou : user.owes()) {
            if (!iou.name.equals(otherName)) {
                builder.owes(iou.name, iou.amount);
            }
        }

        // Zachowujemy należności od innych osób.
        for (Iou iou : user.owedBy()) {
            if (!iou.name.equals(otherName)) {
                builder.owedBy(iou.name, iou.amount);
            }
        }

        // Zapisujemy nowe rozliczenie netto.
        if (net > 0) {
            builder.owedBy(otherName, net);
        } else if (net < 0) {
            builder.owes(otherName, -net);
        }

        return builder.build();
    }
}
