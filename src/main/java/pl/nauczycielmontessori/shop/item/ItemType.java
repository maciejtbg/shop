package pl.nauczycielmontessori.shop.item;

import lombok.Getter;

@Getter
public enum ItemType {
    MATHEMATICS("Mathematics"),
    LANGUAGE( "Language"),
    CULTURE( "Culture"),
    SENSORY( "Sensory"),
    EVERYDAY_LIFE("Everyday Life");

    private final String displayName;

    ItemType(String displayName) {
        this.displayName = displayName;
    }

}
