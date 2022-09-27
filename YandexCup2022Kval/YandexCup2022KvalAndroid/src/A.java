class Base {
    String name = "Base";

    public void output() {
        System.out.println(name);
    }
}

class Derived extends Base {
    String name = "Derived";
}

class Main {
    public static void main(String[] args) {
        new Derived().output();

    }

}

