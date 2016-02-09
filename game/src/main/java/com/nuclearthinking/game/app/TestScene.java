package com.nuclearthinking.game.app;

import com.nuclearthinking.game.app.alldrow.ObjectWorld;
import com.nuclearthinking.game.app.alldrow.SpriteAnimation;
import com.nuclearthinking.game.app.controller.CreateCharacterController;
import com.nuclearthinking.game.app.controller.Input;
import com.nuclearthinking.game.app.map.MapContainer;
import com.nuclearthinking.game.app.ui.GameUi;
import com.nuclearthinking.game.app.ui.MenuLayer;
import com.nuclearthinking.game.app.ui.SystemLayer;
import com.nuclearthinking.game.player.Player;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public class TestScene extends ObjectWorld
{
    private static Pane appRoot = new Pane();
    private static Pane gameRoot = new Pane();
    private static Pane gameUiPane = new Pane();
    private static CreateCharacterController ccc = new CreateCharacterController();

    private Input input;

    /**
     * Слои указаны в порядке от самого нижнего к самому верхнему
     */
    //Слой карты
    private MapContainer mapContainer;
    //Слой с персонажем
    public Player player;
    //Слой с интерфейсом персонажа
    private GameUi gameUi = new GameUi();
    //Слой с системными сообщениями(имена, уровни, нанесенный\полученный урон)
    private SystemLayer systemLayer = new SystemLayer();
    //Слой меню
    private static MenuLayer menuLayer = new MenuLayer();

    public TestScene(int fps, String title)
    {
        super(fps, title);
    }

    @Override
    public void initialize(Stage primaryStage)
    {
        //Создаем персонажа
        createPlayer();
        //Создаем мир
        createWorld();
        //Создаем геодату
        //TODO: Сделать геодату

        gameUiPane.getChildren().add(gameUi);
        //Добавляем игрока на игровой слой
        gameRoot.getChildren().addAll(player, systemLayer);
        //Добавляем игровой слой и карту на главный слой приложения
        appRoot.getChildren().addAll(mapContainer, gameRoot, gameUiPane, menuLayer);

        //Задаем тайтл
        primaryStage.setTitle(getWindowsTitle());
        //Создаем группу нод
        setSceneNode(new Group(appRoot));
        //Создаем сцену с группой нод и указанием разрешения
        setGameSurface(new Scene(getSceneNodes(), 640, 580));
        //Объявляем инпут
        input = new Input(getGameSurface());
        //Вклчаем слушатель для инпута
        input.addListeners();
        //Добавляем сцену на оболочку
        primaryStage.setScene(getGameSurface());
        //Рисуем все что есть
        primaryStage.show();
        //Запускаем музыку
        getManagerAudio().backMusicStart("/audio/bg.mp3");

        getGameSurface().setOnKeyPressed(event ->
        {
            if (event.getCode() == KeyCode.ESCAPE)
            {
                FadeTransition ft = new FadeTransition(Duration.seconds(1), menuLayer.menuBox);
                if (!menuLayer.menuBox.isVisible())
                {
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    menuLayer.menuBox.setVisible(true);
                    getGameLoop().pause();
                    player.spriteAnimation.pause();
                    getManagerAudio().backMusicPause();
                }
                else
                {
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt -> menuLayer.menuBox.setVisible(false));
                    ft.play();
                    getGameLoop().play();
                    player.spriteAnimation.play();
                    getManagerAudio().backMusicPlay();
                }
            }
        });

    }

    private void createPlayer()
    {
        //Инициализируем игрока
        player = ccc.getPlayer();
        //Указываем его положение на карте
        player.setTranslateX(10);
        player.setTranslateY(10);
        //Добавляем в спрайт менеджер
        //TODO: После переделки с канвасов он как бы не нужен, надо подумать над актуальностью
        getSpriteManager().addSprites(player);
        //Присваиваем имя в рисовалку
        systemLayer.drawPlayerName(player.getName());
    }

    private void createWorld()
    {
        //Инициализируем мир
        mapContainer = new MapContainer();
    }

    /**
     * На каждый фрейм вызывается этот апдейтер
     */
    @Override
    protected void updateSprites()
    {
        //Чекаем нажатые клавиши каждый фрейм
        player.input(input);
        //Рисуем имя персонажа относительно координат персонажа
        systemLayer.updateNamePos(player.getTranslateX(), player.getTranslateY() + 10);
    }

    /**
     * TODO: Реализовать коллизии у объектов
     */
    @Override
    protected boolean handleCollision(SpriteAnimation spriteA, SpriteAnimation spriteB)
    {
        return false;
    }

    @Override
    protected void cleanupSprites()
    {
    }

}
