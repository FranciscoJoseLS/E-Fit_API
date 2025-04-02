package org.EFit_API.entity;

public enum MuscularGroup {
    HOMBRO,
    PECHO,
    ESPALDA,
    BÍCEPS,
    TRÍCEPS,
    PIERNAS,
    ABDOMEN,
    FULLBODY;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
