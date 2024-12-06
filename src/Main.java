import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение в формате: a + b (например, 3 + 5):");

        Scanner scanner = new Scanner(System.in);

        try {
            String input = scanner.nextLine();

            String result = calc(input);

            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Неверный формат. Используйте один из форматов: a + b, a - b, a * b, a / b");
        }

        int a, b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Числа должны быть целыми.");
        }

        String operator = parts[1];
        if (operator.equals("/") & b == 0) {
            throw new Exception("Делить на ноль нельзя.");
        }

        if (a < 1 | a > 10 | b < 1 | b > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10.");
        }

        int result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new Exception("Недопустимый оператор. Используйте +, -, *, /.");
        }

        return String.valueOf(result);
    }
}
