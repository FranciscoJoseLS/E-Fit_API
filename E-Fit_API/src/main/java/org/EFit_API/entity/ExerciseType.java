package org.EFit_API.entity;

public enum ExerciseType {
    MANCUERNAS,
    BARRA,
    MÁQUINA,
    POLEA,
    BANDA,
    LIBRE,
    TRX;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
