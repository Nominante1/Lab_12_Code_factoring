// Калькулятор с ошибками
public class Calculator {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int result = a / b;  // Ошибка: деление на ноль!
        
        int[] numbers = new int[5];
        numbers[10] = 100;    // Ошибка: выход за границы массива
        
        System.out.println(result);
        
        // Неиспользуемая переменная
        String unused = "Привет";
        
        // === ДОПОЛНЕННЫЙ КОД (без исправления ошибок) ===
        
        // Ещё одна потенциальная ошибка: преобразование типов
        double price = 19.99;
        int intPrice = (int) price;  // Потеря дробной части
        
        // Магические числа (запах кода)
        if (a > 5) {
            result = a * 3.14159 * 2;  // Что это за формула?
        }
        
        // Пустой catch (антипаттерн)
        try {
            int x = Integer.parseInt("не число");
        } catch (NumberFormatException e) {
            // Ошибка проигнорирована!
        }
        
        // Избыточная вложенность
        if (a != 0) {
            if (b >= 0) {
                if (result > 0) {
                    System.out.println("Положительный результат");
                }
            }
        }
        
        // Дублирование кода
        int temp1 = a + b;
        int temp2 = a + b;  // Зачем дважды?
        int temp3 = a + b;
        
        // Метод с побочным эффектом в условии
        if (modifyAndCheck(numbers)) {
            System.out.println("Проверка пройдена");
        }
        
        // Вызов слишком длинной функции
        Calculator calc = new Calculator();
        calc.doEverything();
        
        // Resource leak (потенциальная утечка ресурсов)
        java.io.FileReader reader = new java.io.FileReader("data.txt");
        // reader.close(); // забыли закрыть!
        
        // Сырые типы (Raw Types)
        java.util.List list = new java.util.ArrayList();
        list.add("Строка");
        list.add(123);  // Разные типы в одном списке
        
        // Неправильное сравнение строк
        String str1 = new String("test");
        String str2 = new String("test");
        if (str1 == str2) {  // Ошибка: сравнение ссылок, а не содержимого
            System.out.println("Строки равны");
        }
        
        // Бесконечный цикл (потенциальный)
        int counter = 0;
        while (counter < 10) {
            System.out.println("Итерация: " + counter);
            // counter++; // забыли инкремент!
        }
    }
    
    // Слишком длинная функция (запах кода)
    public void doEverything() {
        // много строк кода...
        int step1 = 1 + 1;
        int step2 = step1 * 2;
        String msg = "Шаг 2: " + step2;
        System.out.println(msg);
        
        // Продолжение функции...
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("Чётное: " + i);
            } else {
                System.out.println("Нечётное: " + i);
            }
        }
        
        // Ещё больше логики...
        calculateTax(1000);
        applyDiscount(500, 0.1);
        generateReport("Отчёт", true, false, 12);
    }
    
    // Метод, изменяющий массив и возвращающий значение (побочный эффект)
    public static boolean modifyAndCheck(int[] arr) {
        arr[0] = arr[0] + 1;  // Изменяем входной параметр
        return arr[0] > 5;
    }
    
    // Метод с избыточными параметрами
    public double calculateTax(double amount) {
        double tax = amount * 0.13;
        double fee = amount * 0.01;
        double surcharge = amount * 0.005;
        return tax + fee + surcharge;
    }
    
    // Метод с магическими числами
    public double applyDiscount(double price, double discount) {
        if (discount > 0.5) return price;  // Почему 0.5?
        if (price < 100) return price * 0.95;  // А это откуда?
        return price * (1 - discount);
    }
    
    // Метод с нарушенным принципом единой ответственности
    public void generateReport(String title, boolean includeHeader, 
                              boolean includeFooter, int formatCode) {
        System.out.println("=== " + title + " ===");
        if (includeHeader) System.out.println("[HEADER]");
        
        // Генерация данных
        for (int i = 0; i < 10; i++) {
            System.out.println("Данные строки " + i);
        }
        
        if (includeFooter) System.out.println("[FOOTER]");
        
        // Форматирование вывода
        if (formatCode == 1) {
            System.out.println("Формат: краткий");
        } else if (formatCode == 2) {
            System.out.println("Формат: подробный");
        }
        // И так далее...
    }
    
    // Метод, который никогда не будет вызван (мёртвый код)
    private void unusedHelper() {
        System.out.println("Этот метод нигде не используется");
        performCalculation(42, "magic");
    }
    
    private String performCalculation(int value, String mode) {
        return "Результат: " + (value * Math.random());
    }
}
