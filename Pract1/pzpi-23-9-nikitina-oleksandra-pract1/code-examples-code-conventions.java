package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Hello {
	
	public static void main(String[] args) {
		// Поганий приклад
		int a = 10;
		int b = 20;
		int c = a + b;
		
		// Гарний приклад
		int firstNumber = 10;
		int secondNumber = 20;
		int sum = firstNumber + secondNumber;

		List<String> names = Arrays.asList("Anna", "Bob", "Cindy", "Alex");

		// Поганий приклад (класичний цикл)
		List<String> namesWithA = new ArrayList<>();
		for (String name : names) {
		    if (name.startsWith("A")) {
		        namesWithA.add(name);
		    }
		}
		System.out.println(namesWithA); // [Anna, Alex]


		// Гарний приклад (Stream API)
		List<String> namesWithA_Stream = names.stream()
		     .filter(name -> name.startsWith("A"))
		     .collect(Collectors.toList());

		System.out.println(namesWithA_Stream); // [Anna, Alex]

	} 
	
}

//Поганий приклад
class calculator { // має бути UpperCamelCase
    final int max_val = 100; // має бути UPPER_SNAKE_CASE
    public int ADD(int x, int y) { // має бути lowerCamelCase
        return x + y;
    }
}

//Гарний приклад
class Calculator {
    private static final int MAX_VALUE = 100;

    public int add(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }
}


/**
 * Клас для виконання базових математичних операцій.
 */
class Calculator {
	
	// Поганий коментар (очевидний)
    // Метод для додавання двох чисел
    public int add(int firstOperand, int secondOperand) {
        int sum = firstOperand + secondOperand; 
        System.out.println("Sum = " + sum); // Виводимо суму
		return sum;
    }

    public int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand; // Повертаємо різницю
    }
    
    // Гарний коментар (пояснює "чому")
    /**
     * Ділить два цілих числа.
     * Використовує тип 'double' для збереження точності
     * навіть для цілочисельного ділення.
     *
     * @param a Ділене
     * @param b Дільник
     * @return Результат ділення
     */
    public double divide(int a, int b) {
        // Уникаємо ArithmeticException, повертаючи нескінченність,
        // це стандартна поведінка для ділення double на 0.
        if (b == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) a / b;
    }

    try {
        int result = divide(10, 0);
    } catch (ArithmeticException e) {
        System.out.println("Error: " + e.getMessage());
    }

    // Поганий приклад (Довгий, робить кілька кроків)
    public void processOrder(Order order) {
        // 1. Валідація замовлення (5 рядків)
        if (order.getItems().isEmpty()) { /* ... */ }

        // 2. Обчислення загальної вартості (8 рядків)
        double total = order.getItems().stream().mapToDouble(Item::getPrice).sum();

        // 3. Знижки та податки (6 рядків)
        total = applyDiscount(total, order.getCoupon());

        // 4. Збереження до бази даних (3 рядки)
        orderDAO.save(order);

        // 5. Сповіщення клієнта (4 рядки)
        notificationService.sendEmail(order);
    }

    // Гарний приклад (Розділений на приватні методи)
    public void processOrder(Order order) {
        validateOrder(order);
        double total = calculateTotal(order);
        applyTaxesAndDiscounts(total);
        saveOrder(order);
        notifyCustomer(order);
    }
    // Приватні методи, які виконують конкретні завдання...
    private void validateOrder(Order order) { /* ... */ }
    private double calculateTotal(Order order) { /* ... */ }
    // ...	
 

    // Поганий приклад: багаторазове створення об'єкта всередині циклу
    for (int i = 0; i < list.size(); i++) {
        String temp = new String(list.get(i));
        // робота з temp
    }

    // Гарний приклад: використання посилання без створення нового об'єкта
    for (String item : list) {
        // робота з item
    }
    
    // Добрий приклад:
    Set<String> users = new HashSet<>();
    users.add("Alice");
    users.add("Bob");

    // Швидкий пошук у HashSet
    if (users.contains("Alice")) {
        System.out.println("Found");
    }

}

/**
 * Поганий приклад 
 * (Поле доступне напряму, 
 * інкапсуляція порушена)
 */
class User {
    public String name; // Поле публічне
}

/**
 * Гарний приклад 
 * (Поле приватне, 
 * доступ через методи)
 */
class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}


}


/**
 * Поганий приклад 
 * (Жорстке успадкування)
 */
class Car extends Engine { // Успадкування
    // Car "є" Engine? Ні, Car "має" Engine.
}

/**
 * Гарний приклад (Композиція)
 */
class Engine {
    public void start() { /* ... */ }
}

class Car {
    private final Engine engine; 
    // Композиція: Car має Engine

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start(); // Делегування
    }
}


/**
 * Клас, що представляє працівника.
 * Містить інформацію про ім'я та зарплатню.
 */
class Employee {

    private String name;

    /**
     * Повертає повне ім'я працівника.
     *
     * @return рядок, що містить ім'я працівника
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює ім'я працівника.
     *
     * @param name ім'я для встановлення (не може бути null)
     * @throws IllegalArgumentException якщо ім'я null
     */
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }
}


//Клас для тестування 
class Calculator {
    public int add(int firstOperand, int secondOperand) {
        int sum = firstOperand + secondOperand;
		return sum;
    }
}
