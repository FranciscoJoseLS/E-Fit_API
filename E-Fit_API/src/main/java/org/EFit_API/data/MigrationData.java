package org.EFit_API.data;

import org.EFit_API.entity.*;
import org.EFit_API.repository.*;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MigrationData {

    UserRepository userR;
    ExerciseRepository exerciseR;
    RoutineRepository routineR;
    ExerciseRoutineRepository exerciseRoutineR;
    ScoreRepository scoreR;

    public MigrationData(ApplicationContext context) {
        this.userR = (UserRepository) context.getBean("userRepository");
        this.exerciseR = (ExerciseRepository) context.getBean("exerciseRepository");
        this.routineR = (RoutineRepository) context.getBean("routineRepository");
        this.exerciseRoutineR = (ExerciseRoutineRepository) context.getBean("exerciseRoutineRepository");
        this.scoreR = (ScoreRepository) context.getBean("scoreRepository");

        this.loadData();
    }

    private void loadData() {
        if(userR.findAll().isEmpty())
            userR.save(new User("Fran", "López", "wiamfran@gmail.com", "1234"));
        if(exerciseR.findAll().isEmpty())
            exerciseR.saveAll(loadExercises());
        if(exerciseRoutineR.findAll().isEmpty())
            loadDemoData();
    }

    public Set<Exercise> loadExercises() {
        Set<Exercise> exercises = new HashSet<>();

        exercises.add(new Exercise("Elevaciones laterales", MuscularGroup.HOMBRO, "Con la carga ajustada a la cintura, sube el brazo alineado con el hombro y estirado."));
        exercises.add(new Exercise("Elevaciones frontales", MuscularGroup.HOMBRO, "Con la carga ajustada a la cintura, sube el brazo alineado hacia adelante con el hombro y estirado."));
        exercises.add(new Exercise("Press militar", MuscularGroup.HOMBRO, "Desde un banco, coge el peso a la altura de los hombros y levántalo por encima de la cabeza."));
        exercises.add(new Exercise("Press Arnold", MuscularGroup.HOMBRO, "Desde un banco, coge el peso a la altura de los hombros y levántalo haciendo un giro de 180º."));
        exercises.add(new Exercise("Press banca", MuscularGroup.PECHO, "Tumbado boca arriba en un banco, sube y baja el peso a la altura del pecho."));
        exercises.add(new Exercise("Press inclinado", MuscularGroup.PECHO, "Tumbado inclinado a 45º en un banco, sube y baja el peso a la altura del pecho."));
        exercises.add(new Exercise("Press declinado", MuscularGroup.PECHO, "Tumbado declinado a 20º en un banco, sube y baja el peso a la altura del pecho."));
        exercises.add(new Exercise("Aperturas", MuscularGroup.PECHO, "Tumbado boca arriba en un banco, sube los brazos y controla la bajada lateral."));
        exercises.add(new Exercise("Cables cruzados", MuscularGroup.PECHO, "De pie, lleva los brazos al centro con el pecho, manteniendo los brazos estirados."));
        exercises.add(new Exercise("Fondos", MuscularGroup.PECHO, "Con el cuerpo suspendido entre paralelas, flexiona pecho y tríceps para bajar y subir."));
        exercises.add(new Exercise("Prensa de pecho", MuscularGroup.PECHO, "Sentado en máquina con espalda recta, lleva los brazos al centro con el pecho."));
        exercises.add(new Exercise("Pullover", MuscularGroup.PECHO, "Tumbado boca arriba en un banco, sube los brazos y controla la bajada descendente."));
        exercises.add(new Exercise("Jalón", MuscularGroup.ESPALDA, "En máquina de jalón, lleva la barra al pecho retractando escápulas y bajando con los codos a 45º."));
        exercises.add(new Exercise("Dominadas", MuscularGroup.ESPALDA, "Colgado de una barra, sube hasta superar la barra con la barbilla retractando escápulas."));
        exercises.add(new Exercise("Remo", MuscularGroup.ESPALDA, "De pie, sube el peso hacia la cadera contrayendo las escápulas."));
        exercises.add(new Exercise("Remo T", MuscularGroup.ESPALDA, "De pie con la barra fijada al suelo, sube el agarre hacia el pecho contrayendo las escápulas."));
        exercises.add(new Exercise("Remo inclinado", MuscularGroup.ESPALDA, "De pie con la barra en el suelo, sube la barra hacia la cadera contrayendo las escápulas."));
        exercises.add(new Exercise("Remo unilateral", MuscularGroup.ESPALDA, "Apoyado bocabajo en un banco inclinado, sube el peso hacia la cadera contrayendo el dorsal."));
        exercises.add(new Exercise("Peso muerto", MuscularGroup.ESPALDA, "Con la barra en el suelo, sube el peso con movimiento de cadera y piernas, manteniendo la espalda fija."));
        exercises.add(new Exercise("Facepull", MuscularGroup.ESPALDA, "Frente a un cable alto, lleva los codos a la altura del hombro y sube las muñecas apretando trapecio y hombro posterior."));
        exercises.add(new Exercise("Curl de bíceps", MuscularGroup.BÍCEPS, "De pie, flexiona los codos llevando las mancuernas hacia los hombros y baja lentamente."));
        exercises.add(new Exercise("Curl concentrado", MuscularGroup.BÍCEPS, "Sentado en banco inclinado, flexiona el codo llevando la mancuerna hacia el hombro y baja lentamente."));
        exercises.add(new Exercise("Curl alterno", MuscularGroup.BÍCEPS, "De pie, flexiona un codo llevando la mancuerna hacia el hombro, alternando brazos de forma controlada."));
        exercises.add(new Exercise("Curl martillo", MuscularGroup.BÍCEPS, "De pie, flexiona los codos llevando las mancuernas hacia los hombros con las palmas mirándose."));
        exercises.add(new Exercise("Chin up", MuscularGroup.BÍCEPS, "Agarra la barra con palmas hacia ti, sube flexionando los codos y baja controladamente."));
        exercises.add(new Exercise("Curl araña", MuscularGroup.BÍCEPS, "De pie, flexiona los codos llevando las manos hacia los hombros con los codos elevados y paralelos al suelo."));
        exercises.add(new Exercise("Curl Predicador", MuscularGroup.BÍCEPS, "Sentado en banco predicador, flexiona los codos llevando la barra o mancuernas hacia los hombros."));
        exercises.add(new Exercise("Curl inclinado", MuscularGroup.BÍCEPS, "Sentado en banco predicador, flexiona los codos llevando la barra o mancuernas hacia los hombros."));
        exercises.add(new Exercise("Fondos", MuscularGroup.TRÍCEPS, "Frente a un banco, flexiona los codos para bajar y extiende los brazos para subir, manteniendo la espalda recta."));
        exercises.add(new Exercise("Press banca cerrado", MuscularGroup.TRÍCEPS, "Acuéstate en un banco, baja la barra hacia el pecho y extiende los brazos, manteniendo la espalda apoyada."));
        exercises.add(new Exercise("Flexiones de diamante", MuscularGroup.TRÍCEPS, "En posición de plancha con manos juntas, flexiona los codos hasta que el pecho casi toque el suelo y empuja hacia arriba."));
        exercises.add(new Exercise("Patada de tríceps", MuscularGroup.TRÍCEPS, "De pie, sostén una mancuerna y extiende el codo hacia atrás, bajando la mancuerna de forma controlada."));
        exercises.add(new Exercise("Press Francés", MuscularGroup.TRÍCEPS, "Acuéstate en un banco, flexiona los codos para bajar la barra hacia la frente y extiende los brazos."));
        exercises.add(new Exercise("Pushdowns de tríceps", MuscularGroup.TRÍCEPS, "De pie frente a una polea alta, empuja hacia abajo la cuerda o barra extendiendo los codos."));
        exercises.add(new Exercise("Extensión de tríceps", MuscularGroup.TRÍCEPS, "Sentado en un banco, sostén una mancuerna sobre la cabeza y extiende los brazos levantando la mancuerna."));
        exercises.add(new Exercise("Polea alta", MuscularGroup.TRÍCEPS, "De pie frente a una polea alta, extiende los codos para bajar la cuerda y flexiona los codos para volver a la posición inicial."));
        exercises.add(new Exercise("Sentadilla", MuscularGroup.PIERNAS, "De pie, flexiona las rodillas y baja el cuerpo manteniendo la espalda recta, luego impúlsate hacia arriba."));
        exercises.add(new Exercise("Prensa", MuscularGroup.PIERNAS, "Sentado en el banco, baja lentamente los pesos hacia el pecho y empuja hacia arriba."));
        exercises.add(new Exercise("Prensa inclinada", MuscularGroup.PIERNAS, "Sentado en el banco inclinado, baja lentamente los pesos hacia el pecho y empuja hacia arriba."));
        exercises.add(new Exercise("Zancadas", MuscularGroup.PIERNAS, "Da un paso hacia adelante, flexiona ambas rodillas hasta formar ángulos de 90 grados y empuja con la pierna delantera."));
        exercises.add(new Exercise("Sentadilla búlgara", MuscularGroup.PIERNAS, "Coloca un pie en un banco detrás de ti, flexiona la rodilla delantera y empuja con el pie delantero."));
        exercises.add(new Exercise("Peso muerto", MuscularGroup.PIERNAS, "Con los pies a la altura de los hombros, inclínate hacia adelante desde la cadera y levanta el torso."));
        exercises.add(new Exercise("Peso muerto rumano", MuscularGroup.PIERNAS, "Flexiona ligeramente las rodillas y mantén la espalda recta, inclínate hacia adelante desde las caderas."));
        exercises.add(new Exercise("Extensión de quádriceps", MuscularGroup.PIERNAS, "Sentado en la máquina, extiende las piernas levantando los pies hacia arriba y baja lentamente."));
        exercises.add(new Exercise("Sentadilla en Jaca", MuscularGroup.PIERNAS, "Coloca la barra en los hombros, flexiona las rodillas y baja el cuerpo, luego empuja con los talones."));
        exercises.add(new Exercise("Curl femoral", MuscularGroup.PIERNAS, "Sentado en la máquina, extiende las piernas hacia adelante y baja lentamente los pies."));
        exercises.add(new Exercise("Curl femoral tumbado", MuscularGroup.PIERNAS, "Acuéstate boca abajo, flexiona las piernas llevando los talones hacia los glúteos y baja lentamente."));
        exercises.add(new Exercise("Abductores", MuscularGroup.PIERNAS, "Sentado en la máquina, abre las piernas hacia afuera contra la resistencia y regresa lentamente."));
        exercises.add(new Exercise("Adductores", MuscularGroup.PIERNAS, "Sentado en la máquina, empuja las piernas hacia adentro contra la resistencia y regresa lentamente."));
        exercises.add(new Exercise("Gemelo de pie", MuscularGroup.PIERNAS, "De pie en la máquina, levanta los talones tan alto como puedas y baja lentamente."));
        exercises.add(new Exercise("Gemelo sentado", MuscularGroup.PIERNAS, "Sentado en la máquina, levanta los talones tan alto como puedas y baja lentamente."));
        exercises.add(new Exercise("Abdominales", MuscularGroup.ABDOMEN, "Acuéstate de espaldas, levanta la parte superior del cuerpo contrayendo los abdominales y baja lentamente."));
        exercises.add(new Exercise("Plancha", MuscularGroup.ABDOMEN, "Apóyate en los antebrazos y las puntas de los pies, manteniendo el cuerpo recto y contrae el abdomen."));
        exercises.add(new Exercise("Plancha lateral", MuscularGroup.ABDOMEN, "Acuéstate de lado, levanta las caderas para formar una línea recta y mantén la posición contrayendo el abdomen."));
        exercises.add(new Exercise("Elevación de piernas", MuscularGroup.ABDOMEN, "Cuélgate de una barra, eleva las piernas hacia el abdomen contrayendo los abdominales y baja lentamente."));
        exercises.add(new Exercise("Tijeretas", MuscularGroup.ABDOMEN, "Acuéstate de espaldas, realiza un movimiento de tijera con las piernas estiradas y mantén el abdomen contraído."));
        exercises.add(new Exercise("Sentadilla", MuscularGroup.FULLBODY, "De pie, flexiona las rodillas y baja las caderas manteniendo la espalda recta, luego impúlsate hacia arriba."));
        exercises.add(new Exercise("Burpees", MuscularGroup.FULLBODY, "Empieza de pie, baja en cuclillas, coloca las manos en el suelo, salta hacia atrás, realiza una flexión y salta de nuevo hacia arriba."));

        return exercises;
    }

    public void loadDemoData(){
        // Obtengo el usuario
        User user = userR.findAll().get(0);
        if(user!= null && routineR.findAll().isEmpty()){
            // Creo las rutinas
            Routine r1 = new Routine("Push", "1:30", 1, "Rutina de empujes", true, user);
            Routine r2 = new Routine("Pull", "1:40", 2, "Rutina de tracciones", true, user);
            Routine r3 = new Routine("Arms", "1:15", 3, "Rutina de brazo", true, user);
            Routine r4 = new Routine("Legs", "2:00", 4, "Rutina de pierna", true, user);
            routineR.save(r1);
            routineR.save(r2);
            routineR.save(r3);
            routineR.save(r4);
            // Asigno ejercicios a las rutinas
            List<Exercise> exercises = exerciseR.findAll();
            try {
                // RUTINA 1
                addExerciseRoutineAndScores(exercises, r1, 1,"Fondos", 3, ExerciseType.LIBRE, user, "[50*12/50*10/50*8]");
                addExerciseRoutineAndScores(exercises, r1, 2,"Press banca", 4, ExerciseType.BARRA, user, "[60*10/60*8/60*8/55*10]");
                addExerciseRoutineAndScores(exercises, r1, 3,"Press inclinado", 5, ExerciseType.MANCUERNAS, user, "[40*12/40*10/40*10/40*8/35*12]");
                addExerciseRoutineAndScores(exercises, r1, 4,"Cables cruzados", 5, ExerciseType.POLEA, user, "[30*15/30*12/30*12/30*10/25*15]");

                // RUTINA 2
                addExerciseRoutineAndScores(exercises, r2, 1,"Dominadas", 5, ExerciseType.LIBRE, user, "[0*10/0*8/10*4]");
                addExerciseRoutineAndScores(exercises, r2, 2,"Jalón", 5, ExerciseType.LIBRE, user, "[70*10/70*8/70*8/70*8/65*10]");
                addExerciseRoutineAndScores(exercises, r2, 3,"Remo", 5, ExerciseType.LIBRE, user, "[60*12/60*10/60*10/60*8/55*12]");
                addExerciseRoutineAndScores(exercises, r2, 4,"Remo unilateral", 5, ExerciseType.LIBRE, user, "[50*10/50*8/50*8/50*8/45*10]");
                addExerciseRoutineAndScores(exercises, r2, 5,"Pullover", 5, ExerciseType.LIBRE, user, "[40*12/40*10/40*10/40*8/35*12]");
                addExerciseRoutineAndScores(exercises, r2, 6,"Facepull", 5, ExerciseType.LIBRE, user, "[30*15/30*12/30*12/30*10/25*15]");

                // RUTINA 3
                addExerciseRoutineAndScores(exercises, r3, 1,"Curl Predicador", 4, ExerciseType.BARRA, user, "[30*12/30*10/30*10/25*12]");
                addExerciseRoutineAndScores(exercises, r3, 2,"Curl martillo", 4, ExerciseType.LIBRE, user, "[20*15/20*12/20*12/20*10]");
                addExerciseRoutineAndScores(exercises, r3, 3,"Curl inclinado", 4, ExerciseType.LIBRE, user, "[25*12/25*10/25*10/20*12]");
                addExerciseRoutineAndScores(exercises, r3, 4,"Patada de tríceps", 4, ExerciseType.LIBRE, user, "[35*10/35*8/35*8/30*10]");
                addExerciseRoutineAndScores(exercises, r3, 5,"Pushdowns de tríceps", 4, ExerciseType.POLEA, user, "[40*12/40*10/40*10/35*12]");
                addExerciseRoutineAndScores(exercises, r3, 6,"Extensión de tríceps", 4, ExerciseType.POLEA, user, "[30*15/30*12/30*12/25*15]");

                // RUTINA 4
                addExerciseRoutineAndScores(exercises, r4, 1,"Prensa inclinada", 5, ExerciseType.MÁQUINA, user, "[80*10/80*8/80*8/80*8/75*10]");
                addExerciseRoutineAndScores(exercises, r4, 2,"Extensión de quádriceps", 4, ExerciseType.MÁQUINA, user, "[70*12/70*10/70*10/65*12]");
                addExerciseRoutineAndScores(exercises, r4, 3,"Curl femoral tumbado", 4, ExerciseType.MÁQUINA, user, "[60*12/60*10/60*10/55*12]");
                addExerciseRoutineAndScores(exercises, r4, 4,"Abductores", 3, ExerciseType.MÁQUINA, user, "[50*15/50*12/50*12]");
                addExerciseRoutineAndScores(exercises, r4, 5,"Adductores", 3, ExerciseType.MÁQUINA, user, "[50*15/50*12/50*12]");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void addExerciseRoutineAndScores(List<Exercise> exercises, Routine routine, int ordered, String exerciseName, int sets, ExerciseType type, User user, String load) {
        Exercise exercise = exercises.stream()
                .filter(e -> e.getName().equals(exerciseName))
                .findFirst()
                .orElse(null);

        if (exercise != null) {
            // Generar la fecha dentro de la función
            LocalDate date = LocalDate.now();

            // Crear una lista de SetType según el número de sets
            List<SetType> setTypes = new ArrayList<>();
            for (int i = 0; i < sets - 1; i++) {
                setTypes.add(SetType.STANDARD); // Añadir sets estándar
            }
            setTypes.add(SetType.DROP);

            // Guardar el ejercicio en la rutina
            ExerciseRoutine exerciseRoutine = new ExerciseRoutine(
                    exercise,
                    routine,
                    sets,
                    100L,
                    0,
                    type,
                    ordered,
                    setTypes
            );
            exerciseRoutineR.save(exerciseRoutine);

            // Guardar la puntuación asociada
            Score score = new Score(user, exercise, routine, date, "Comentarios de prueba", load);
            scoreR.save(score);
        }
    }
}