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
<p>P.S. Либо прописать их в конфигурационном файле <b>resources/config/userConfig.properties</b></p>

Так же необходимо указать токен бота и чат в который должны приходить уведомление в телеграмм. Для этого нужно
отредактировать файл: <b>notifications/telegram.json</b>

<h2>Запуск тестов в Jenkins</h2>
В качестве CI для тестов используется Jenkins, запуск тестов осуществляется в контейнерах Selenoid.

Для запуска тестов нужно создать параметризированную джобу. 
<p>1. В качестве параметров были выбраны</p>
<p><b>-DforkCount</b> - количество потоков для запуска теста</p>
<p><b>-Dbrowser</b> - браузер для запуска теста</p>

<p>2. По результатам прохождения тестов формируются Allure отчет, а так же происходит интеграция результатов в TMS AllureTestOps</p>

<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/1.PNG.png" />
</p>

<h2>Архитектура проекта</h2>
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/9.png" />
</p>

<h2>Allure отчет о прохождении тестов</h2>
На освнове результатов тестов формируется красивый Allure отчет. По которому можно посмотреть как прошли тесты и быстро определить
где была ошибка в случае ее обнаружения.

<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/2.PNG" />
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/4.PNG" />
</p>

<h2>Результаты</h2>
После прохождения тестов, результаты автоматически имопртируются в TMS, где их может посмотреть любой участник команды.
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/5.PNG" />
</p>

Результаты из TMS имопртируются в задачу Jira
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/8.png" />
</p>

<h2>Сценарии тестирования в TMS</h2>
На освное написанных тестов, в системе управления тестовыми сценариями автоматически были созданы тест кейсы для пройденных тестов.
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/6.PNG" />
</p>


<h2>Уведомления</h2>
Чтобы узнавать о результатах прохождения тестов, не обязательно постоянно следить за тестпланом в TMS или джобой в Jenkins.
В проекте настроены уведомления в телеграм, при помощи библиотеки <b>https://github.com/qa-guru/allure-notifications</b>

<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/7.PNG" />
</p>

<h2>Видео прохождения тестов</h2>
