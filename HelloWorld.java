

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String input = "1962";
        //String input = "12032";
        int binaryInput = Integer.parseInt(input);
        System.out.println(binaryInput);
        Boolean test = (binaryInput & 0x3F00) == 0x700;
        System.out.println(test);
    }
}