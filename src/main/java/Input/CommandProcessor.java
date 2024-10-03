package Input;

import BL.DishService;
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
                System.out.println("Пользователь успешно добавлен...");
            }
// …. здесь логика Обработки других команды
            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}
