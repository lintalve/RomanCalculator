import somePackage.*;  //if needed code is in package, you need to use the import statement

public class CompileTest {
    public static void main(String[] args){
        System.out.println("this is some heavy shit");
        Day day = Day.SATURDAY;
        if(day == Day.SATURDAY) System.out.println("the last day of the week");
        VisibilityCheck vizcheck = new VisibilityCheck();
        vizcheck.someDouble = 1873416.12834;
        int intishe = SomeClass.newInt;
        SomeClass someClass = new SomeClass(35);
        System.out.println(someClass.someInt);
        SomeClass.someStaticMethod();  // you just invoked static method, without initializing an instance
    }
}
