package Section1;

public class Code01_2 {
    public static void main(String[] args) {

        Person1 first = new Person1();

        first.name = "ungk";
        first.number = "01048924990";

        System.out.println("name = " + first.name + ", Number = " + first.number);

        Person1 second = first;
        second.name = "Tom";
        System.out.println("name = " + second.name + ", Number = " + second.number);

        Person1[] members = new Person1[100];
        members[0] = first;
        members[1] = second;
        System.out.println("Name : " + members[0].name + ", Number: " + members[0].number);
        System.out.println("Name : " + members[1].name + ", Number: " + members[1].number);

        members[2] = new Person1();
        members[2].name = "David";
        members[2].number = "2345646494";
        System.out.println("Name : " + members[2].name + ", Number: " + members[2].number);

    }
}