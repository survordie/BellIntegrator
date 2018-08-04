package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;

public interface OfficeService {

    /**
     * Получить все офисы
     */
    List<OfficeView> getOffices();

    /**
     * Получить офис по Id
     */
    OfficeView getOfficeById(OfficeView officeView);

    /**
     * Обновить офис
     */
    String updateOffice(OfficeView officeView);

    /**
     * Добавить офис
     */
    String saveOffice(OfficeView officeView);
}
