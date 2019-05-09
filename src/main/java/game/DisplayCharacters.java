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
    public static final java.lang.Character PLAYER = '?';

    // Item display chars
    public static final java.lang.Character ROCKET_PLANS = 'P';
    public static final java.lang.Character ROCKET_BODY = '$';
    public static final java.lang.Character ROCKET_ENGINE = '^';
    public static final java.lang.Character KEY = '*';
    public static final java.lang.Character WARHAMMER = 'T';

    // Ground display chars
    public static final java.lang.Character UNLOCKED_DOOR = '-';
    public static final java.lang.Character LOCKED_DOOR = '+';
    public static final java.lang.Character ROCKET_PAD = '@';

    // Colours for Keys/Doors
    public static final java.lang.String[] COLORS = {"Red","Blue","Purple","Pink","Brown","Black","Green","Orange","Yellow","White"};
    public static int DOORCOUNT = 0;

}
