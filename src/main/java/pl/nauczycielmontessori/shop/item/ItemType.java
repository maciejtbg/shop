package pl.nauczycielmontessori.shop.item;

import lombok.Getter;

@Getter
public enum ItemType {
    MATHEMATICS("Matematyka"),
    LANGUAGE( "Język"),
    CULTURE( "Kultura"),
    SENSORY( "Sensoryka"),
    EVERYDAY_LIFE("Życie codzienne");

    private final String displayName;

    ItemType(String displayName) {
        this.displayName = displayName;
    }

}
