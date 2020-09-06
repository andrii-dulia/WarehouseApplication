package util;

/**
 * Preconditions for constructors
 *
 * @author ptrkukla148@gmail.com
 * @since 2019-11-24
 */
public final class Precondition {

    private Precondition() {
    }

    public static void requireNonNulls(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                throw new NullPointerException();
            }
        }
    }

    public static void checkArgument(boolean valid, String message) {
        if (!valid) {
            throw new IllegalArgumentException(message);
        }
    }
}