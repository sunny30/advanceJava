package customfieldannotations;

import customfieldannotations.MInfo;

public class AnnotateImpl<T> {


    public void save(T t){
        var clazz = t.getClass() ;
        var fields = clazz.getDeclaredFields() ;

        for(var field : fields){

            var afield = field.getAnnotationsByType(MInfo.class) ;

            if(afield.length>0){

                var name = afield[0];
                System.out.println(name+" "+name.value());
            }
        }


    }
}
