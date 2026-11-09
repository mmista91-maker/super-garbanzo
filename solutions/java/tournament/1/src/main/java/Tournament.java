import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tournament {

    private final Map<String, Team> teams = new HashMap<>();

    String printTable() {

        StringBuilder table = new StringBuilder("Team                           | MP |  W |  D |  L |  P\n");

        Comparator<Team> teamComparator = Comparator
                .comparingInt(Team::getPoints).reversed()
                .thenComparing(Team::getName);

        List<Team> sortedTeams = teams.values().stream()
                .sorted(teamComparator)
                .toList();

        for (Team team : sortedTeams) {
            table.append(team.formatRow()).append("\n");
        }

        return table.toString();
    }

    void applyResults(String resultString) {

        if (resultString != null) {
            for (String line : (resultString.split("\n"))) {
                String[] parts = line.split(";");
                String homeTeam = parts[0];
                String awayTeam = parts[1];
                String score = parts[2];

                Team home = teams.computeIfAbsent(homeTeam, Team::new);
                Team away = teams.computeIfAbsent(awayTeam, Team::new);

                switch (score) {
                    case "win" -> {
                        home.addWin();
                        away.addLoss();
                    }
                    case "loss" -> {
                        home.addLoss();
                        away.addWin();
                    }
                    case "draw" -> {
                        home.addDraw();
                        away.addDraw();
                    }
                }
            }
        }
    }

    private static class Team {

        private final String name;
        private int matchesPlayed;
        private int wins;
        private int draws;
        private int losses;
        private int points;

        private Team(String name) {
            this.name = name;
        }

        public void addWin(){
            this.matchesPlayed++;
            this.wins++;
            this.points +=3;
        }
        public void addLoss(){
            this.matchesPlayed++;
            this.losses++;
        }
        public void addDraw(){
            this.matchesPlayed++;
            this.draws++;
            this.points +=1;
        }

        public String formatRow() {
            return String.format("%-31s| %2d | %2d | %2d | %2d | %2d",
                    name, matchesPlayed, wins, draws, losses, points);
        }

        public int getPoints() {
            return points;
        }

        public String getName() {
            return name;
        }
    }
}
