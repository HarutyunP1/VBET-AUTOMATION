package enums;
/**
 * @author amalyahayrapetova
 */

public enum  Url {

    BASE_URL("https://www.vbet.com/"),
    SIGN_UP_URL("https://www.vbet.com/sports#?sign-up"),
    SIGN_UP_NET_URL("https://www.vbet.de/en/sport#?sign-up"),
    SIGN_IN_URL("https://www.vbet.com/sports#?sign-in"),
    SPORTS_URL("https://www.vbet.com/sports"),
    SPORTS_NET_URL("https://www.vbet.de/en/sport"),
    CASINO_URL("https://www.vbet.com/casino"),
    CASINO_NET_URL("https://www.vbet.de/en/casino#/"),
    LIVE_CASINO_URL("https://www.vbet.com/live-casino"),
    LIVE_CASINO_NET_URL("https://www.vbet.de/en/live-casino"),
    POKER_URL("https://www.vbet.com/poker"),
    GAMES_URL("https://www.vbet.com/games"),
    LOTTERY_URL("https://www.vbet.com/lottery"),
    SPORTS_LIVE_URL("https://www.vbet.com/live#/eventview"),
    SPORTS_PRE_MATCH_URL("https://www.vbet.com/pre-match"),
    SPORTS_ESPORT_URL("https://www.vbet.com/esport"),
    SPORTS_VIRTUAL_URL("https://www.vbet.com/virtual-sports"),
    SPORTS_POOLS_BETTING_URL("https://www.vbet.com/pools-betting"),
    SPORTS_FANTASY_URL("https://www.vbet.com/fantasy"),
    SPORTS_STATS_URL("https://statistics.vbet.com/"),
    SPORTS_RESULT_URL("https://www.vbet.com/results"),
    SPORTS_PROMO_URL("https://www.vbet.com/promotions#sport-promo"),
    FORGOT_PASSWORD("https://www.vbet.com/sports#?forgot-password"),
    FORGOT_PASSWORD_NET("https://www.vbet.de/en/sport#?forgot-password"),
    TOURNAMENTS("https://www.vbet.com/tournaments"),
    WELCOME_OFFER("https://www.vbet.com/promotions/sport/sport-welcome-bonus-100-free-bet-up-to-20");





    private final String url;
    public String getUrl() {
        return url;
    }

    private Url(String url){
        this.url = url;
    }
}
