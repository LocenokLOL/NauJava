package ru.ChernomortsevEgor.NauJava.Input;

import ru.ChernomortsevEgor.NauJava.BL.DishService;
import ru.ChernomortsevEgor.NauJava.Classes.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandProcessor
{
    private final DishService dishService;

    @Autowired
    public CommandProcessor(DishService dishService)
    {
        this.dishService = dishService;
    }

    public void processCommand(String input)
    {
        String[] cmd = input.split(" ");
        switch (cmd[0])
        {
            case "create" ->
            {
                dishService.createDish(Long.valueOf(cmd[1]), Double.valueOf(cmd[2]), cmd[3]);
                System.out.println("Блюдо успешно добавлено.");
            }
            case "update" ->
            {
                dishService.updateCost(Long.valueOf(cmd[1]), Double.valueOf(cmd[2]));
                System.out.println("Стоимость успешно обновлена.");
            }
            case "delete" ->
            {
                dishService.deleteById(Long.valueOf(cmd[1]));
                System.out.println("Блюдо успешно удалено.");
            }
            case "findById" ->
            {
                Dish dish = dishService.findById(Long.valueOf(cmd[1]));
                System.out.println(dish);
            }
// …. здесь логика Обработки других команды
            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}
