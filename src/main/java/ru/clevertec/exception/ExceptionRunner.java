package ru.clevertec.exception;

import java.sql.SQLException;

public class ExceptionRunner {
    public static void main(String[] args) {

        ExceptClass aClass = new ExceptClass(1);

        try {
            aClass.showI();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

class ExceptClass {
    private final int i;

    public ExceptClass(int i) {
        this.i = i;
    }

    void showI () throws SQLException {
        System.out.println(i);
        throw new SQLException("SQLException");
    }
}
