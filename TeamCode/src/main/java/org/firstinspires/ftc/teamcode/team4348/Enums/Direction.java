package org.firstinspires.ftc.teamcode.team4348.Enums;

/**
 * This enumeration is to make code more legible. Do not edit.
 */
public enum Direction
{

    LEFT(-1), RIGHT(1), FORWARD(2), BACKWARD(2);

    public int v;

    Direction(int v)
    {
        this.v = v;
    }
}