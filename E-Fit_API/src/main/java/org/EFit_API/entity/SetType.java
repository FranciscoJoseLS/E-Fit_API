package org.EFit_API.entity;

public enum SetType {
    STANDARD,
    CALENTAMIENTO,
    DROP,
    UNILATERAL,
    VARIANTE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
