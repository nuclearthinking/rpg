package com.nuclearthinking.game.app.utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public class ManagerAudio
{
    private static MediaPlayer mp;

    public static void backMusicStart(String path)
    {
        mp = new MediaPlayer(new Media(ManagerAudio.class.getResource(path).toString())); //Задаём песенку
        mp.setCycleCount(MediaPlayer.INDEFINITE); //Цикличность
        mp.setVolume(0.5D); //Громкость
        mp.setAutoPlay(true); //Автозапуск
        mp.play(); //Играем
    }

    public static void backMusicStop()
    {
        mp.stop(); //Останавливаем воспроизведение
        mp.dispose(); //Освобождаем все ресурсы связанные с плеером
        mp = null; //Навсякий случай зануляем ссылку
    }
}
