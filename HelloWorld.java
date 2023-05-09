

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int input = Integer.decode("0x0070");
        CommandDecoder commandDecoder = new CommandDecoder(input);
    }
}