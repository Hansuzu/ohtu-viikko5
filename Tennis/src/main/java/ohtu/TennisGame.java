package ohtu;

public class TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name){
            scorePlayer1++;
        } else if (playerName == player2Name){
            scorePlayer2++;
        } else {
            // ...
        }
    }

    private String getScoreName(int score){
        switch (score){
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
        }
        return "";
    }

    private int abs(int v){
        return v>0?v:-v;
    }

    public String getScore() {
        if (scorePlayer1>=4 || scorePlayer2>=4){
            String playerWithMoreScore = (scorePlayer1 >= scorePlayer2)  ? player1Name : player2Name;
            int diff = abs(scorePlayer1-scorePlayer2);
            if (diff>=2) return "Win for "+playerWithMoreScore;
            if (diff==1) return "Advantage "+playerWithMoreScore;
            return "Deuce";
        }
        if (scorePlayer1 == scorePlayer2) return getScoreName(scorePlayer1)+"-All";
        return getScoreName(scorePlayer1)+"-"+getScoreName(scorePlayer2);
    }
}