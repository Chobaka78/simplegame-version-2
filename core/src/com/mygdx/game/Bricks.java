package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bricks {

    private int x, y, width, height;
    private int grid [][];
    public ArrayList<Sprite> bricks = new ArrayList<Sprite>();

    public Bricks(int grid [] []){

    }

    public static void load () throws IOException{
        Scanner kb = new Scanner(new BufferedReader(new FileReader("Map.txt")));
    }

}
