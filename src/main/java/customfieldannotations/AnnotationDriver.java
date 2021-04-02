package customfieldannotations;

import customfieldannotations.Entity;

public class AnnotationDriver {

    public static void main(String[] args) {
        Entity e1 = new Entity("1","sh","ensh") ;
        Entity e2 = new Entity("1","sh","ensh") ;

        AnnotateImpl<Entity> annotate = new AnnotateImpl<>() ;

        annotate.save(e1);
        annotate.save(e2);
    }
}
