package app;

/**
 * Générateur d'identifiants uniques globaux (équivalent de id.c).
 */
public class IdGenerator {

    private static long globalId = 0;

    public static long getNextId() {
        return ++globalId;
    }

    public static void setId(long id) {
        globalId = id;
    }
}
