# Diplom-3
#Настройки окружения для запуска Яндекс браузера 
1. Скачайте chromeDriver версии соответствующей вашему YandexBrowser
2. Установите системные переменные

WEBDRIVERS - путь к папке с драйверами для браузеров
YANDEX_BROWSER_DRIVER_FILENAME - имя файла драйвера Яндекс браузера (Хромдрайвера нужной версии)
YANDEX_BROWSER_PATH - путь к исполняемому файлу Яндекс браузера в системе

3. Для выполнения тестов в Хроме выполните команду mvn clean test 
4. Для выполнения тестов в Yandex Browser выполните команду mvn clean test -Dbroser=yandex
5. Для запуска allure отчета выполните коменду mvn allure:serve


