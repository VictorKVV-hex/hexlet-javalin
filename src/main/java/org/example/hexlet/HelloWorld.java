package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/hello1/<name>", ctx -> { // the <> syntax allows slashes ('/') as part of the parameter
            ctx.result("Hello: " + ctx.pathParam("name"));
        });
        app.get("/hello", ctx -> { // the <> syntax allows slashes ('/') as part of the parameter
            ctx.result("Hello: " + ctx.queryParam("name"));
        });
        app.start(7070); // Стартуем веб-сервер
    }
}