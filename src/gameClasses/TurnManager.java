package gameClasses;

workspace CGOL31{

    public class TurnManager {
        public static int turn = 0;
        private static int[] turnOrder;
        private static boolean blackout = false;

        private static List<Player> players = new ArrayList<Player>();

        public static void setPlayers(List<Player> PlayerList) {
            players = PlayerList;
        }

        public static void setTurnOrder(int[] order) {
            turnOrder = order;
        }

        public static void nextTurn() {
            int actualTurn;
            if (turnOrder != null && turnOrder.length > players.size()) {
                actualTurn = turnOrder[turn];
            } else {
                actualTurn = turn;
            }
            if (!blackout) {
                players.get(actualTurn).playTurn();

                if (turn >= players.size() - 1) {
                    turn = 0;
                } else {
                    turn++;
                }
            } else {
                // Extra turn gained here
                if (players.get(actualTurn).hand.sum() == 31) {
                    GameState.renderWin(players.get(actualTurn));
                } else {
                    GameState.renderBlackout(players.get(actualTurn));
                }
            }
            blackout = !blackout;
        }
    }
}