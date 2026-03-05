public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.printf("size = %d\n", stack.size());
        stack.push(1);
        System.out.printf("size = %d\n", stack.size());
        stack.push(2);
        System.out.printf("size = %d\n", stack.size());
        stack.push(3);
        System.out.printf("size = %d\n", stack.size());
        System.out.printf("pop = %d\n", stack.pop());
        System.out.printf("size = %d\n", stack.size());
        stack.addFirst(4);
        System.out.printf("size = %d\n", stack.size());
        System.out.printf("pop = %d\n", stack.pop());
        System.out.printf("pop = %d\n", stack.pop());
        System.out.printf("pop = %d\n", stack.pop());
        System.out.println();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.printf("size = %d\n", stack.size());
        stack.remove(1);
        System.out.printf("size = %d\n", stack.size());
        System.out.printf("pop = %d\n", stack.pop());
        System.out.printf("pop = %d\n", stack.pop());
        System.out.printf("pop = %d\n", stack.pop());
        System.out.printf("pop = %d\n", stack.pop());
        System.out.printf("size = %d\n", stack.size());
    }
}
