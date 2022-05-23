<p align="center">
      <a href="https://pikabu.ru/">
        <img title="Pikabu" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/pikabu/Pikabu_Logo.png" />
    </a>
</p>

<h1>В проекте реализованы тесты для сайта Pikabu</h1>
Проект создан в рамках обучения в школе QA.GURU и представляет из себя часть выпускной работы.

<h2>Стек проекта:</h2>
<p align="center">
    <a href="#"><img title="Java" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/java.svg" width="30px"/></a>
    <a href="#"><img title="Gradle" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Gradle.svg" width="50px"/></a>
    <a href="#"><img title="JUnit5" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/JUnit5.svg" width="50px"/></a>
    <a href="#"><img title="Selenide" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Selenide.svg" width="50px"/></a>
    <a href="#"><img title="Allure_Report" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Allure_Report.svg" width="50px"/></a>
    <a href="#"><img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Jenkins.svg" width="50px"/></a>
    <a href="#"><img title="Selenoid" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Selenoid.svg" width="50px"/></a>
    <a href="#"><img title="Allure Test Ops" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/AllureTestOps.svg" width="50px"/></a>
</p>

<h2>Запуск тестов локально</h2>

Для запуска тестов локально используется команда : <b>gradle clean parallelRegress</b>

<p><b>-DforkCount</b> - количество потоков для запуска теста</p>
<p><b>-Dbrowser</b> - браузер для запуска теста</p>

Для работы тестов подразумевающих авторизацию в системе нужно дополнительно указать параметры:
<p><b>-Dlogin</b> - логин для Pikabu</p>
<p><b>-Dpassword</b> - пароль для Pikabu</p>
P.S. Либо прописать их в конфигурационном файле "resources/config/userConfig.properties"

Так же необходимо указать токен бота и чат в который должны приходить уведомление в телеграмм. Для этого нужно отредактировать файл: <b>notifications/telegram.json</b>

<h2>Запуск тестов в Jenkins</h2>
Для запуска тестов в 
<h2>Уведомления</h2>

<h2>Результаты в TMS</h2>

<h2>Видео прохождения тестов</h2>
