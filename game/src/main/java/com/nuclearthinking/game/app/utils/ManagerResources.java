package com.nuclearthinking.game.app.utils;

import com.nuclearthinking.game.utils.ResourceUtil;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public class ManagerResources
{
    private static ResourceUtil resourceUtil = new ResourceUtil();

    public static Cursor loadCursor()
    {
        return new ImageCursor(loadImage("img\\cursor.png"));
    }

    public static Image loadImage(String fileName)
    {
        Image result = null;

            try(InputStream is = resourceUtil.getResourceAsStream(fileName))
            {
                result = new Image(is);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        return result;
    }

    public static Image loadImageFile(String fileName)
    {
        Image result = null;
        try(FileInputStream fis = new FileInputStream(fileName))
        {
            result = new Image(fis);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public static int[][] loadMap(String mapFile)
    {
        //Создаем двумерный массив, для колонок картинки и столбцов
        int[][] result = null;
        //Читаем файл через буфер
        try(BufferedReader reader = new BufferedReader(new FileReader(mapFile)))
        {
            List<int[]> list = new LinkedList<int[]>();
            String line;
            //Читаем строки
            while((line = reader.readLine()) != null)
            {
                //Делим строку на цифры. Сплит возвращает массив
                String[] nums = line.split(",");
                int[] ints = new int[nums.length];
                for(int i = 0; i < nums.length; i++)
                {
                    ints[i] = Integer.parseInt(nums[i]);
                }

                list.add(ints);
            }

            result = new int[list.size()][];
            for(int i = 0; i < list.size(); i++)
            {
                result[i]=list.get(i);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
