import java.io.IOException;

public class Person201Farthest {
    public static void main(String[] args) throws IOException
    {
        String file = "data/large.txt";
        Person201[] people = Person201Utilities.readFile(file);
        double max = 0;
        Person201 a = null;
        Person201 b = null;
        for(Person201 p1: people)
        {
            for(Person201 p2 : people)
            {
                if(p1.distanceFrom(p2) > max)
                {
                    a = p1;
                    b = p2;
                    max = p1.distanceFrom(p2);
                }
            }
        }

        System.out.printf("farthest distance is %3.2f between %s and %s\n",max,a.getName(),b.getName()); 

    }
}
