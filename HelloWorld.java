

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String input = "9";
        CommandDecoder commandDecoder = new CommandDecoder();
        commandDecoder.CommandDecoder(input);
        int binaryInput = Integer.parseInt(input);
        System.out.println(binaryInput);
    }
}