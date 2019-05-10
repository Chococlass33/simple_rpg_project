package game;

/**
 * Class to keep track of which display characters have been assigned to which entity.
 */
public class DisplayCharacters {



    private DisplayCharacters() {}

    // Character displays
    public static final java.lang.Character NINJA = 'N';
    public static final java.lang.Character GRUNT = 'g';
    public static final java.lang.Character GOON = 'G';
    public static final java.lang.Character DOCTOR_MAYBE = 'D';
    public static final java.lang.Character Q = 'Q';
    public static final java.lang.Character PLAYER = '@';

    // Item display chars
    public static final java.lang.Character ROCKET_PLANS = 'P';
    public static final java.lang.Character ROCKET_BODY = 'B';
    public static final java.lang.Character ROCKET_ENGINE = 'E';
    public static final java.lang.Character KEY = 'K';
    public static final java.lang.Character WARHAMMER = 'W';

    // Ground display chars
    public static final java.lang.Character UNLOCKED_DOOR = '-';
    public static final java.lang.Character LOCKED_DOOR = '+';
    public static final java.lang.Character ROCKET_PAD = '?';

    // Colours for Keys/Doors
    public enum colour {
        RED,
        BLUE,
        GREEN;
    }
}
