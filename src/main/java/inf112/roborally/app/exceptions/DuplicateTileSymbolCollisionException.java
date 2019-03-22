package inf112.roborally.app.exceptions;

import inf112.roborally.app.tile.IBoardTile;

/**
 * TODO: Describe class
 *
 * @author RakNoel
 * @version 1.0
 * @since 19.03.19
 */
public class DuplicateTileSymbolCollisionException extends Exception {
    private char symbol;
    private Class<? extends IBoardTile> existing;
    private Class<? extends IBoardTile> colliding;
    private String message;

    public DuplicateTileSymbolCollisionException(char symbol, Class<? extends IBoardTile> existing, Class<? extends IBoardTile> colliding, String message) {
        this.symbol = symbol;
        this.existing = existing;
        this.colliding = colliding;
        this.message = message;
    }

    public DuplicateTileSymbolCollisionException(char symbol, Class<? extends IBoardTile> existing, Class<? extends IBoardTile> colliding) {
        this.symbol = symbol;
        this.existing = existing;
        this.colliding = colliding;
        this.message = String.format(
                "Duplicate tile symbol '%s' from colliding class: %s onto existing class: %s",
                symbol,
                colliding.toString(),
                existing.toString()
        );
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Class<? extends IBoardTile> getColliding() {
        return colliding;
    }

    public Class<? extends IBoardTile> getExisting() {
        return existing;
    }

    public char getSymbol() {
        return symbol;
    }
}
