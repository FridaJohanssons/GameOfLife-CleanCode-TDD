package testtest;

 class TestTest {

    public static String greet(String name){
        if(name == null){
            return "Hello, my friend.";
        }

        if(ifUpperCase(name)){
            return "HELLO " + name;
        }
        return "Hello, " + name;
    }
    private static boolean ifUpperCase(String name) {
        return name.toUpperCase().equals(name);
    }
}
