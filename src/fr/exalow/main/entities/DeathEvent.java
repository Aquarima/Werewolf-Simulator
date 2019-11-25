package fr.exalow.main.entities;

public class DeathEvent {

    private Player player;
    private String day;
    private String reason;

    public DeathEvent(Player player, String day, String reason) {
        this.player = player;
        this.day = day;
        this.reason = reason;
    }

    public Player getPlayer() {
        return player;
    }

    public String getDay() {
        return day;
    }

    @Override
    public String toString() {
        return day + " " + player.getName() + " [" + player.getRole() + "] " + reason;
    }
}
