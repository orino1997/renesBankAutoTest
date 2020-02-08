#language: ru
Функционал: Настройка вклада
  Структура сценария:
    * перейти на страницу "https://rencredit.ru/"
    * Перейти в меню "Вклады"
    * Выбрать "Рубли"
    * Вставить в поле "На срок" значение "6 месяцев"
    * Заполняются поля:
      |Сумма вклада|<sum>|
      |Ежемесячное пополнение|<month>|
    * Отметить поле "Ежемесячная капитализация"
    * Проверить, что поля равны значениям:
     |Есть сейчас|<now>|
     |Будет      |<then>|

    Примеры:
      |sum   |  |month | |now   | |then      |
      |300 000|  |50 000 | |300 000| |561 383,43|
      |500 000|  |70 000 | |500 000| |868 082,81|










