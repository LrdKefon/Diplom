# Дипломный проект по профессии «Инженер по тестированию»
**Ссылка на задание:** https://github.com/netology-code/qamid-diplom/blob/main/README.md

## **Процедура запуска авто-тестов:**


**2 способ (с выгрузкой Allure-results)**

1. Склонировать репозиторий https://github.com/LrdKefon/Diplom

2. Открыть проект fmh-android в Android Studio.

3. Запустить эмулятор (API 29) или подключить устройство для тестирования.

4. Во вкладке Project левым кликом мыши (или аналогичным образом) выделить каталог app.

5. Запустить тесты сочетанием клавиш Ctrl+Shift+F10 (Windows). Альтернативный запуск:во вкладке Run нажать: Run 'Tests in 'ru.iteco.fmhandroid.ui.tests" .

6. По завершению, выгрузите каталог /data/data/ru.iteco.fmhandroid/files/allure-results с эмулятора или тестового устройства (при помощи Device Explorer)  в корень директории проекта. 

7. Выполните в терминале команду allure serve, находясь на уровень выше каталога allure-results.
