package ua.com.pogorelova;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        // Указываем путь к файлу конфигурации (applicationContext.xml) и получаем ApplicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        // Аннотация @Component автоматически создает бин класса
        // <component-scan> сканирует пакет и ищет аннотацию @Component
        // Аннотация @Autowired автоматически внедряет зависимость (может стоять на поле, сеттере, конструкторе)

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();

        // НО! ВОЗНИКАЕТ ПРОБЛЕМА МНОЖКСТВЕННОГО ВЫБОРА: КАКОЙ КОМПОНЕНТ ВНЕДРЯТЬ, ЕСЛИ ИЗ НЕСКОЛЬКО И ОНИ ВСЕ ПОДХОДЯТ В КОНСТРУКТОР?

        context.close();
    }
}
