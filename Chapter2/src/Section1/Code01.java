package Section1;

public class Code01 {
    public static void main(String[] args) {
        int x;
        x = 100;

        double y = 1.0023;

        Person1 first = new Person1();

        first.name = "ungk";
        first.number = "01048924990";

        System.out.println("name = " + first.name + ", Number = " + first.number);

        Person1 [] members = new Person1 [100];
        members[0] = first;
        members[1] = new Person1();
        members[1].name = "Dongku";
        members[1].number = "01067891307";

        System.out.println(members[1].number);
    }
}